package com.zerobase.weather.service;

import com.zerobase.weather.domain.DateWeather;
import com.zerobase.weather.domain.Diary;
import com.zerobase.weather.repository.DateWeatherRepository;
import com.zerobase.weather.repository.DiaryRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
// 각각 메소드들이 트랜잭션 동작하도록. (read only 만 가능하도록)
@Transactional(readOnly = true)
public class DiaryService {

    @Value("${openweathermap-key}")
    private String apiKey;

    // 객체가 생김
    private final DiaryRepository diaryRepository;
    private final DateWeatherRepository dateWeatherRepository;

    // 다이어리서비스 라는 빈이 생성될 때, 리포지토리를 가져옴 -> 이제 이 안에서 다이어리 리포지토리 사용가능
    public DiaryService(DiaryRepository diaryRepository, DateWeatherRepository dateWeatherRepository) {
        this.diaryRepository = diaryRepository;
        this.dateWeatherRepository = dateWeatherRepository;
    }

    @Transactional
    // 매일 새벽1시마다 동작 (0/5 *****) 매분매시 5초간격으로 테스트
    @Scheduled(cron = "0 0 1 * * *")
    public void saveWeatherDate(){
        dateWeatherRepository.save(getWeatherFromApi());
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void createDiary(LocalDate date,String text) {
        // 매번 날씨데이터 가져와서 유저일기와 함께 저장하는 작업 했었음. 매번 날씨api 호출할필요 X
//        // 세부기능 3가지 1. open weather map에서 날씨 데이터 가져오기
//        // 아래에서 반환된 값 출력
//        //System.out.println(getWeaterString());
//        String weatherData = getWeaterString();
//
//        // 받아온 날씨 json 파싱하기 / 리턴값 = 만든 함수(위에서 만든 변수)
//        Map<String, Object> parsedWeather = parseWeather(weatherData);

        // 날씨 데이터 가져오기(API에서 가져오기 or DB에서 가져오기)
        DateWeather dateWeather = getDateWeather(date);


        // 파싱된 데이터 + 일기 값 우리 db에 넣기
        // Diary 클래스에 @NoArgsConstructor 롬복 붙여줘서 생성자를 사용가능
        Diary nowDiary = new Diary();
        nowDiary.setDateWeather(dateWeather);
        nowDiary.setText(text);
        nowDiary.setDate(date);

        // 다이어리 리포지토리 임포트하고나서
        diaryRepository.save(nowDiary);

    }

    private DateWeather getWeatherFromApi(){
        // 날씨는 매일 1번, 파싱도 매일1번 작업

        // open weather map에서 날씨 데이터 가져오기
        String weatherData = getWeaterString();

        // 날씨 json 파싱하기
        Map<String, Object> parsedWeather = parseWeather(weatherData);
        DateWeather dateWeather = new DateWeather();
        // 알아서 로컬데이트 시간을 가져옴
        dateWeather.setDate(LocalDate.now());
        dateWeather.setWeather(parsedWeather.get("main").toString());
        dateWeather.setIcon(parsedWeather.get("icon").toString());
        dateWeather.setTemperature((Double) parsedWeather.get("temp"));
        return dateWeather;
    }

    private DateWeather getDateWeather(LocalDate date){
        // 그날의 날씨가 DB에 존재하는지 확인
        List<DateWeather> dateWeatherListFromDB = dateWeatherRepository.findAllByDate(date);
        if(dateWeatherListFromDB.size() == 0){
            // 새로 api에서 날씨 정보를 가져와야 한다
            // 정책상 (채택) 현재 날씨를 가져오도록 하거나 날씨없이 일기를 쓰도록.
            return getWeatherFromApi();
        }else {
            return dateWeatherListFromDB.get(0);
        }
    }

    @Transactional(readOnly = true)

    public List<Diary> readDiary(LocalDate date){
        return diaryRepository.findAllByDate(date);
    }

    public List<Diary> readDiaries(LocalDate startDate, LocalDate endDate) {
        // db값을 가져오려면 리포지토리에서 가져와야 한다.
        return diaryRepository.findAllByDateBetween(startDate, endDate);
    }

    public void updateDiary(LocalDate date, String text) {
        Diary nowDiary = diaryRepository.getFirstByDate(date);
        // nowDiary.getText(); 다이어리에 이미 쓰여있는 텍스트값 반환
        // 일기값만 수정
        nowDiary.setText(text);
        // 수정값 반영 - table에 row하나를 무조건 추가가 아니라, id값은 그대로 둔 채로 텍스트만 바꾼상태로 save - 덮어씌기 됨
        diaryRepository.save(nowDiary);
    }

    public void deleteDiary(LocalDate date) {
        diaryRepository.deleteAllByDate(date);
    }

    private String getWeaterString() {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=seoul&appid=" + apiKey;

        // url 호출하고 결과값 받아오는 과정에서 오류 발생할 수 있으므로 try catch문 사용
        try {

            URL url = new URL(apiUrl);
            // apiUrl을 http 형식으로 연결시키는 커넥션으 만들어서 열었음.
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // get 요청 보냄
            connection.setRequestMethod("GET");
            // 요청을 보낸다음에 응답결과의 코드 받아오기 (http 상태코드)
            int responseCode = connection.getResponseCode();
            // 응답코드에 따라 오류메시지 or 실제 메시지/응답객체를 받아옴
            // br에 넣어서 (속도와 성능 향상)
            BufferedReader br;
            // 만약 200이면 정상,
            if (responseCode == 200) {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            }else { // 오류가 나면 오류 결과 호출
                br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }
            String inputLine;
            // response라는 스트링 빌더에 결과값을 쌓는다.
            StringBuilder response = new StringBuilder();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();

            // response를 string화 해서 클래스에서 반환
            return response.toString();
        }catch (Exception e) {
            return "failed to get response";
        }
    }
    // 함수 생성시 void로 만들어두고 추후 변경하기
    private Map<String, Object> parseWeather(String jsonString){
        // 가져온 string값을 jsonperser로 파싱
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject;

        // json 파싱 작업 -> 중괄호 안닫혀잇거나 유효하지 않은 문자열 시 작업이 어렵다.
        // 정상적으로 동작하지 않을 경우를 대비해 try catch문 사용
        try{ // (타입 변경)
            jsonObject = (JSONObject) jsonParser.parse(jsonString);
        }catch (ParseException e){
            throw new RuntimeException(e);
        }
        // temp, main, icon값을 hashing한 형태로 꾸려서 반환한 함수.
        Map<String, Object> resultMap = new HashMap<>();

        // (괄호로 넣어주어야 해당 형태로 인식)
        JSONObject mainData = (JSONObject) jsonObject.get("main");
        // jsonObject에서 data 가져올때는 put을 사용
        resultMap.put("temp", mainData.get("temp"));
        // 파싱문제로 아래 두줄로 수정 JSONObject weatherData = (JSONObject) jsonObject.get("weather");
        JSONArray weatherArray = (JSONArray) jsonObject.get("weather");
        JSONObject weatherData = (JSONObject) weatherArray.get(0);
        // reusltMap -> HashMap , main 키 안의 밸류는 weatherData.get("main") 결과값이 됨.
        resultMap.put("main", weatherData.get("main"));
        resultMap.put("icon", weatherData.get("icon"));
        // 여기까지 작성하고 함수 void를 Map<String, Object>형식으로 반환하도록 변경
        return resultMap;

    }
}
