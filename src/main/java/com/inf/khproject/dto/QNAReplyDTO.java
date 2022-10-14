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
public class QNAReplyDTO {

    private Long qnaReplyNo;

    private String content;

    private Long qnaNo;

    private LocalDateTime regDate, modDate;

}
