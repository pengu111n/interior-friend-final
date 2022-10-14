package com.inf.khproject.service;

import com.inf.khproject.dto.ApplicationBoardReplyDTO;
import com.inf.khproject.entity.ApplicationBoard;
import com.inf.khproject.entity.ApplicationBoardReply;

import java.util.List;

public interface ApplicationBoardReplyService {

    Long register(ApplicationBoardReplyDTO applicationBoardReplyDTO); //댓글의 등록

    List<ApplicationBoardReplyDTO> getList(Long boardNo); //특정 게시물의 댓글 목록

    void modify(ApplicationBoardReplyDTO applicationBoardReplyDTO); //댓글 수정

    void remove(Long rno); //댓글 삭제

    //ReplyDTO를 Reply객체로 변환 Board객체의 처리가 수반됨
    default ApplicationBoardReply dtoToEntity(ApplicationBoardReplyDTO replyDTO) {

        ApplicationBoard applicationBoard = ApplicationBoard.builder().boardNo(replyDTO.getBoardNo()).build();

        ApplicationBoardReply reply = ApplicationBoardReply.builder()
                .rno(replyDTO.getRno())
                .replycontent(replyDTO.getReplycontent())
                .replyer(replyDTO.getReplyer())
                .applicationBoard(applicationBoard)
                .build();

        return reply;
    }

    //Reply객체를 ReplyDTO로 변환 Board 객체가 필요하지 않으므로 게시물 번호만
    default ApplicationBoardReplyDTO entityToDTO(ApplicationBoardReply reply) {

        ApplicationBoardReplyDTO dto = ApplicationBoardReplyDTO.builder()
                .rno(reply.getRno())
                .replycontent(reply.getReplycontent())
                .replyer(reply.getReplyer())
                .regDate(reply.getRegDate())
                .modDate(reply.getModDate())
                .build();

        return dto;

    }

}
