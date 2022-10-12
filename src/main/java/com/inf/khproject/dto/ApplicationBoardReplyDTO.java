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
public class ApplicationBoardReplyDTO {

    private Long rno;

    private String replycontent;

    private String replyer;

    private Long boardNo;  //게시글 번호

    private LocalDateTime regDate, modDate;
}
