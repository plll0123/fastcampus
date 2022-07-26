package com.toyproject.service;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReplyRequest {

    private Long userId;
    private Long boardId;
    private String title;
    private String content;

    @Builder
    public ReplyRequest(Long boardId, String title, String content) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
    }
}
