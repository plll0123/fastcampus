//package com.toyproject.service;
//
//import com.toyproject.entity.Board;
//import com.toyproject.entity.Reply;
//import com.toyproject.repository.BoardRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@Transactional
//@RequiredArgsConstructor
//public class ReplyService {
//
//    private final BoardRepository boardRepository;
//
//    public void createReply(ReplyRequest replyReq){
//
//        Board board = boardRepository.findById(replyReq.getBoardId())
//                .orElseThrow(IllegalArgumentException::new);
//
//        Reply build = getReply(board, replyReq);
//
//        board.getReplies().add(build);
//
//    }
//
//    private Reply getReply(ReplyRequest replyReq) {
//        return Reply.builder()
//                .board(board)
//                .title(replyReq.getTitle())
//                .content(replyReq.getContent())
//                .build();
//    }
//}
