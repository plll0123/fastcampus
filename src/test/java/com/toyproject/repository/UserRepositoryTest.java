package com.toyproject.repository;

import com.toyproject.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;
    @PersistenceContext
    EntityManager em;

    @Test
    void createAndFindUser() {
        //given
        User user = getUser("test");

        userRepository.save(user);
        System.out.println("user.getId() = " + user.getId());


        User user1 = userRepository.findById(user.getId()).get();
        assertThat(user1).isEqualTo(user);
    }

    @Test
    void updateUser(){
        User test1 = getUser("test1");

        User saveMember = userRepository.save(test1);
        saveMember.changeName("1234");

    }

    private User getUser(String name) {
        return User.builder()
                .name(name)
                .build();
    }
}