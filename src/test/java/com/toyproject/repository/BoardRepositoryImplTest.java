package com.toyproject.repository;

import com.toyproject.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(false)
class BoardRepositoryImplTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BoardRepository boardRepository;

    @Test
    void paging() {
        //given

        List<Board> pageOf1 = boardRepository
                .findAll(getPageable(0, 10))
                .getContent();

        assertThat(pageOf1.size()).isEqualTo(10);

        List<Board> firstAndLastIndex1 = getBoardsElement(pageOf1);
        assertThat(firstAndLastIndex1)
                .extracting("content")
                .containsExactly("content..30", "content..21");


        //page num 2
        List<Board> pageOf2 = boardRepository
                .findAll(getPageable(1, 10))
                .getContent();

        assertThat(pageOf2.size()).isEqualTo(10);

        List<Board> firstAndListIndex2 = getBoardsElement(pageOf2);
        assertThat(firstAndListIndex2)
                .extracting("content")
                .containsExactly("content..20", "content..11");
    }

    private List<Board> getBoardsElement(List<Board> board) {
        return List.of(board.get(0), board.get(9));
    }

    private PageRequest getPageable(int page, int size) {
        return PageRequest.of(page, size);
    }

}