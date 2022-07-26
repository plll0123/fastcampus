package com.toyproject.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.toyproject.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.toyproject.entity.QBoard.board;

@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepositoryCustom{

    private final JPAQueryFactory qFactory;

    public Page<Board> findAll(Pageable pageable) {
        List<Board> results = qFactory
                .selectFrom(board)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(board.id.desc())
                .fetch();

        int size = qFactory.selectFrom(board)
                .fetch()
                .size();

        return new PageImpl<>(results, pageable, size);
    }
}
