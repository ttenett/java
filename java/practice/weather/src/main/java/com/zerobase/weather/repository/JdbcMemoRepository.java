package com.zerobase.weather.repository;

import com.zerobase.weather.domain.Memo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

// 이 클래스가 레포지토리라는걸 어노테이션으로 지정
@Repository
public class JdbcMemoRepository {
    private final JdbcTemplate jdbcTemplate;

    // 자동으로 application.properties
    @Autowired
    public JdbcMemoRepository(DataSource dataSource) {
        // application.properties의 datasource에 지정한 데이터들이 dataSource에 담김.
        // 그걸 활용해서 jdbc템플릿 객체를 만들고 변수에 넣어주게 됨.
        jdbcTemplate = new JdbcTemplate(dataSource);

    }

    // CRUD 함수 생성
    // jdbc의 특징 - 쿼리문을 직접 써야 한다.
    public Memo save(Memo memo){
        String sql = "insert into  memo values(?,?)";
        jdbcTemplate.update(sql, memo.getId(), memo.getText());
        return memo;
    }

    // 전체 메모들을 다 찾아 올것이니 형식은 리스트
    public List<Memo> findAll(){
        String sql = "select * from memo";
        // 조회할때는 query 함수를 사용 ( sql, 데이터값을 어떻게 반환할건지)
        //jdbc템플릿이 mysql로 가서 위의 쿼리를 던지고, 반환값은 ResultSet으로 갖고있음.
        // 이 ResultSet 형태의 데이터를 memoRowMapper 함수를 이용해서 메모 객체로 가져왔다.
        return jdbcTemplate.query(sql, memoRowMapper());
    }

    public Optional<Memo> findById(int id){
        String sql = "select * from memo where id = ?";
        // sql문 담아주고, memoRowMapper로 반환값을 변환해올거다, 물음표에 들어갈 id값
        return jdbcTemplate.query(sql, memoRowMapper(), id).stream().findFirst();
        // findFirst() > 옵셔널 객체로 변환해줌. findById 함수로 메모객체를 찾았을때,
        // id = 3 -> 객체가 없을 때 옵셔널이라는 객체로 매핑. 혹시모를 null 값을 처리하기 쉽게 해주는 자바함수.
    }

    private RowMapper<Memo> memoRowMapper() {
        // jdbc에서 가져온 데이터값은 ResultSet이라는 데이터형식이 됨.
        // {id = 1, text = 'this is memo~'}
        // 스프링 메모 클래스형식에 매핑시켜 주는게 RowMapper
        // Memo객체의 AllArgsConstructor를 활용한 부분 - Memo, id, text 전체 컬럼들을 명시
        return(rs, rowNum) -> new Memo(
                // rs와 rowNum을 가지고 Memo 객체를 반환해줄 것.
                // database에서 가져온 resultSet을 스프링부트에 메모 클래스로 반환
                rs.getInt("id"),
                rs.getString("text")
        );
    }
}
