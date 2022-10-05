package com.inf.khproject.service;

import com.inf.khproject.dto.PageRequestDTO;
import com.inf.khproject.dto.PageResultDTO;
import com.inf.khproject.dto.QNADTO;
import com.inf.khproject.entity.Member;
import com.inf.khproject.entity.QNA;

public interface QNAService {

    Long register(QNADTO dto);

    PageResultDTO<QNADTO, Object[]> getList(PageRequestDTO pageRequestDTO);

    QNADTO get(Long qnaNo);

    void removeWithReplies(Long qnaNo);

    void modify(QNADTO qnaDTO);

    default QNA dtoToEntity(QNADTO dto) {

        Member member = Member.builder().memNo(dto.getWriterMemNo()).build();

        QNA qna = QNA.builder()
                .qnaNo(dto.getQnaNo())
                .category(dto.getCategory())
                .title(dto.getTitle())
                .content(dto.getContent())
                .status(dto.getStatus())
                .writer(member)
                .build();

        return qna;

    }

    default QNADTO entityToDTO(QNA qna, Member member) {

        QNADTO qnaDTO = QNADTO.builder()
                .qnaNo(qna.getQnaNo())
                .category(qna.getCategory())
                .title(qna.getTitle())
                .content(qna.getContent())
                .writerMemNo(member.getMemNo())
                .writerNickname(member.getNickname())
                .regDate(qna.getRegDate())
                .modDate(qna.getModDate())
                .status(qna.getStatus())
                .build();

        return qnaDTO;

    }

}
