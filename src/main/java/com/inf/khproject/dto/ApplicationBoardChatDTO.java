package com.inf.khproject.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApplicationBoardChatDTO {

    private Long boardNo;  //게시글 번호

    private Long cno;

    private String message;

    private String senderid;

    private String sendernickname;

    private String receiver;

    private LocalDateTime regDate, modDate;
}
