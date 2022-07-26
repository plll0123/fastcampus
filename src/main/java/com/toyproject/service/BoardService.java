package com.toyproject.service;

import com.toyproject.dto.BoardResponse;
import com.toyproject.dto.BoardSearchCond;
import com.toyproject.entity.Board;
import com.toyproject.entity.Reply;
import com.toyproject.repository.BoardRepository;
import com.toyproject.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final ReplyRepository replyRepository;

    public Page<BoardResponse> getPostList(BoardSearchCond searchCond) {
        Pageable pageRequest = getPageRequest(searchCond);

        return boardRepository.findAll(pageRequest)
                .map(BoardResponse::new);
    }

    public void createReply(ReplyRequest replyReq){
        Board board = boardRepository.findById(replyReq.getBoardId())
                .orElseThrow(IllegalArgumentException::new);

        Reply reply = Reply.builder()
                .board(board)
                .content(replyReq.getContent())
                .title(replyReq.getTitle())
                .build();

        board.setReplies(reply);
    }

    private Pageable getPageRequest(BoardSearchCond searchCond) {
        return PageRequest.of(searchCond.getPage(), searchCond.getSize());
    }
}
