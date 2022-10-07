package com.inf.khproject.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QNADTO {

    private Long qnaNo;
    private String category;
    private String title;
    private String content;
    private Long writerMemNo;
    private String writerNickname; //작성자 닉네임
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private int status;

}
