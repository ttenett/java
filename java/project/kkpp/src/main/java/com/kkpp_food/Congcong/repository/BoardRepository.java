package com.kkpp_food.kkpp.repository;


import com.kkpp_food.kkpp.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
}
