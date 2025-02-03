package com.zerobase.weather.repository;


import com.zerobase.weather.domain.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// jpa형식으로 쓸수있게끔 jpa리포지토리<Diary 객체, id값 형식>
public interface DiaryRepository extends JpaRepository<Diary, Integer>{
}
