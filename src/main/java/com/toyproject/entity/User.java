package com.toyproject.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = PROTECTED)
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "user")
    private List<Board> boardList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = ALL)
    private List<Reply> replies = new ArrayList<>();

    @Builder
    public User(String name){
        this.name = name;
    }

    public void changeName(String newName){
        NullCheckForEntity.checkNullSafe(newName);
        this.name = newName;
    }
}
