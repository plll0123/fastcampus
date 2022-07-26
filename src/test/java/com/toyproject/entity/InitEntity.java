package com.toyproject.entity;

import com.toyproject.repository.BoardRepository;
import com.toyproject.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

@SpringBootTest
@Transactional
@Rollback(false)
public class InitEntity {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BoardRepository boardRepository;
    @Test
    void initFixture() {
        //given
        IntStream.rangeClosed(1, 30)
                .forEach(i -> {
                    User user = User.builder()
                            .name("test" + i)
                            .build();

                    userRepository.save(user);
                });
        IntStream.rangeClosed(1, 30)
                .forEach(i -> {
                    User user = userRepository.findById((long) i).get();
                    Board board = Board.builder()
                            .user(user)
                            .content("content.." + i)
                            .title("title.." + i)
                            .build();

                    boardRepository.save(board);
                });
        IntStream.rangeClosed(1, 50)
                .forEach( i -> {
                    Reply.builder()
                            .title("reply's title.." + i)
                            .content("reply's content.." + i)
//                            .board()
                            .build();
                });
        //when

        //then
    }
}
