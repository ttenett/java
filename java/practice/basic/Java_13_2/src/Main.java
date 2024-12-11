// Java 프로그래밍 - 입출력_2

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
//      1. 파일 쓰기 - 완료되면 항상 닫아줘야 함.
//      FileWriter - 어떤 파일을 쓸건지 남겨줌.(./현재 폴더에 메모라는 이름으 텍스트파일 생성)
        FileWriter fw = new FileWriter("./memo.txt");
        String memo = "헤드 라인\n";
        fw.write(memo);

        memo = "1월 1일 날씨 맑음\n";
        fw.write(memo);

        fw.close();

//      PrintWriter
        PrintWriter pw = new PrintWriter("./memo.txt");
        memo = "헤드 라인";
        pw.println();   // println이 포함되어 있어 FileWriter처럼 마지막에 \n을 추가안해도 됨.

        memo = "1월 1일 날씨 맑음";
        pw.println();

        pw.close();

//      파일 이어 쓰기 - 오른쪽에 true쓰기. appen :이어쓰겠다
        FileWriter fw2 = new FileWriter("./memo.txt", true);

        memo = "1월 2일 날씨 완전 맑음\n";
        fw2.write(memo);
        fw2.close();

        // PrintWriter는 매개변수 안에 FileWriter를 만들어서 넣어줘야 함.
        PrintWriter pw2 = new PrintWriter(new FileWriter("./memo.txt", true));

        memo = "1월 3일 날씨 또 맑음!";
        pw2.println(memo);
        pw2.close();


//      2. 파일 입력
        BufferedReader br = new BufferedReader(new FileReader("./memo.txt"));

        // 여러 줄 전부 읽어오기
        while (true) {
            String line = br.readLine();

            // 더이상 읽을 줄이 없으면 멈추기.
            if (line == null) {
                break;
            }

            System.out.println(line);
        }
        // 읽을때도 파일 항상 닫아주기.
        br.close();

        // 파일로부터 데이터를 한줄씩 읽어들임.
//        String line = br.readLine();
    }
}
