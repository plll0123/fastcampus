package com.toyproject.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardEditor {

    private Long id;
    private String title;
    private String content;

    @Builder
    public BoardEditor(String title, String content){
        this.title = title;
        this.content = content;
    }
}
