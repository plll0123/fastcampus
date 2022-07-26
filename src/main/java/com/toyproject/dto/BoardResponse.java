package com.toyproject.dto;

import com.toyproject.entity.Board;
import lombok.Builder;
import lombok.Data;

@Data
public class BoardResponse {

    private Long boardId;
    private Long writerId;
    private String title;
    private String content;
    private int replyCnt;

    @Builder
    public BoardResponse(Board board) {
        this.boardId = board.getId();
        this.writerId = board.getUser().getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.replyCnt = board.getReplies().size();
    }
}
