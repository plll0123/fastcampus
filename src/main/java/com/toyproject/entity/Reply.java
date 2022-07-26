package com.toyproject.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

/**
 * post, user 양방향 참조
 * field - title, content;
 */
@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Reply extends TimeEntity {

    @Id @GeneratedValue
    @Column(name = "reply_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "post_id")
    private Board board;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String title;
    private String content;

    @Builder
    public Reply(Board board, String title, String content) {
        addRelation(board);
        this.title = title;
        this.content = content;
    }

    private void addRelation(Board board){
        checkNullSafe(board);
        user.getReplies().add(this);
        this.board = board;
        board.getReplies().add(this);
    }

    private void checkNullSafe(Board board) {
        NullCheckForEntity.checkNullSafe(board);
    }

}