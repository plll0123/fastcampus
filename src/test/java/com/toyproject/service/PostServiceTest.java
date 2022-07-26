package com.toyproject.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class PostServiceTest {

    @Autowired
    BoardService postService;

    @Test
    @DisplayName("댓글 수정 테스트")
    void updateReply() {
        //given

        //when

        //then
    }

}