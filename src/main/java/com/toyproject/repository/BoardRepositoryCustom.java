package com.toyproject.repository;

import com.toyproject.dto.BoardSearchCond;
import com.toyproject.dto.BoardsResponse;
import com.toyproject.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardRepositoryCustom {

    public Page<Board> findAll(Pageable pageable);
}
