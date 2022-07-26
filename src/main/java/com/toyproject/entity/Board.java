package com.toyproject.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.ToString.Exclude;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

/**
 * String == immutable
 */
@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@ToString
public class Board extends TimeEntity {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    @Exclude
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String title;
    private String content;


    @Exclude
    @BatchSize(size = 100)
    @OneToMany(mappedBy = "board", cascade = ALL)
    private List<Reply> replies = new ArrayList<>();

    public void setReplies(Reply reply) {
        replies.add(reply);
        reply.
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Builder
    public Board(User user, String title, String content){
        relationWithUser(user);
        this.title = title;
        this.content = content;
    }

    private void relationWithUser(User user) {
        user.getBoardList().add(this);
        this.user = user;
    }

}
