package com.toyproject.service;

import com.toyproject.dto.BoardResponse;
import com.toyproject.dto.BoardSearchCond;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(false)
class BoardServiceTest {

    @Autowired
    BoardService boardService;

    @Test
    void testSimple() {
        BoardSearchCond cond = BoardSearchCond.builder()
                .page(0)
                .build();
        Page<BoardResponse> postList = boardService.getPostList(cond);

        for (BoardResponse boardRequest : postList) {
            System.out.println("boardRequest = " + boardRequest);
        }
    }
}