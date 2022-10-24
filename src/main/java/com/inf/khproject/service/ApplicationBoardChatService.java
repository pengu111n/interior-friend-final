package com.inf.khproject.service;

import com.inf.khproject.dto.ApplicationBoardChatDTO;
import com.inf.khproject.dto.ApplicationBoardChatDTO;
import com.inf.khproject.entity.ApplicationBoard;
import com.inf.khproject.entity.ApplicationBoardChat;

import java.util.List;

public interface ApplicationBoardChatService {

    Long register(ApplicationBoardChatDTO applicationBoardChatDTODTO); //댓글의 등록

    List<ApplicationBoardChatDTO> getList(Long boardNo); //특정 게시물의 댓글 목록

    //ChatDTO를 Chat객체로 변환 Board객체의 처리가 수반됨
    default ApplicationBoardChat dtoToEntity(ApplicationBoardChatDTO chatDTO) {

        ApplicationBoard applicationBoard = ApplicationBoard.builder().boardNo(chatDTO.getBoardNo()).build();

        ApplicationBoardChat chat = ApplicationBoardChat.builder()
                .cno(chatDTO.getCno())
                .message(chatDTO.getMessage())
                .senderid(chatDTO.getSenderid())
                .sendernickname(chatDTO.getSendernickname())
                .receiver(chatDTO.getReceiver())
                .applicationBoard(applicationBoard)
                .build();

        return chat;
    }

    //Chat객체를 ChatDTO로 변환 Board 객체가 필요하지 않으므로 게시물 번호만
    default ApplicationBoardChatDTO entityToDTO(ApplicationBoardChat chat) {

        ApplicationBoardChatDTO dto = ApplicationBoardChatDTO.builder()
                .cno(chat.getCno())
                .message(chat.getMessage())
                .senderid(chat.getSenderid())
                .sendernickname(chat.getSendernickname())
                .receiver(chat.getReceiver())
                .regDate(chat.getRegDate())
                .modDate(chat.getModDate())
                .build();

        return dto;

    }

}
