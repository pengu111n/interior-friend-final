package com.inf.khproject.service;

import com.inf.khproject.dto.QNADTO;
import com.inf.khproject.dto.QNAReplyDTO;
import com.inf.khproject.entity.QNA;
import com.inf.khproject.entity.QNAReply;

import java.util.List;

public interface QNAReplyService {

    Long register(QNAReplyDTO qnaReplyDTO);

    List<QNAReplyDTO> getList(Long qnaNo);

    void modify(QNAReplyDTO qnaReplyDTO);

    void remove(Long qnaReplyNo);

    default QNAReply dtoToEntity(QNAReplyDTO qnaReplyDTO) {

        QNA qna = QNA.builder().qnaNo(qnaReplyDTO.getQnaNo()).build();

        QNAReply qnaReply = QNAReply.builder()
                .qnaReplyNo(qnaReplyDTO.getQnaReplyNo())
                .content(qnaReplyDTO.getContent())
                .qna(qna)
                .build();

        return qnaReply;

    }

    default QNAReplyDTO entityToDTO(QNAReply qnaReply) {

        QNAReplyDTO qnaReplyDTO = QNAReplyDTO.builder()
                .qnaReplyNo(qnaReply.getQnaReplyNo())
                .content(qnaReply.getContent())
                .regDate(qnaReply.getRegDate())
                .modDate(qnaReply.getModDate())
                .build();

        return qnaReplyDTO;

    }

}
