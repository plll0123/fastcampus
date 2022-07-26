package com.toyproject.repository;

import com.toyproject.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

//    Page<Board> findAll
}
