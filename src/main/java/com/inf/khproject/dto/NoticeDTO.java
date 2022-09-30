package com.inf.khproject.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDTO {

    private Long noticeNo;
    private String title;
    private String content;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private Long writerMemNo; //작성자 회원번호

}
