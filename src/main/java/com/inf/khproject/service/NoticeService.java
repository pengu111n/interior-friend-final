package com.inf.khproject.service;

import com.inf.khproject.dto.NoticeDTO;
import com.inf.khproject.dto.PageRequestDTO;
import com.inf.khproject.dto.PageResultDTO;
import com.inf.khproject.entity.Member;
import com.inf.khproject.entity.Notice;

public interface NoticeService {

    Long register(NoticeDTO dto);

    NoticeDTO read(Long noticeNo);

    void modify(NoticeDTO dto);

    void remove(Long noticeNo);

    PageResultDTO<NoticeDTO, Notice> getList(PageRequestDTO pageRequestDTO);

    default Notice dtoToEntity(NoticeDTO dto) {

        Member member = Member.builder().memNo(dto.getWriterMemNo()).build();

        Notice notice = Notice.builder()
                .noticeNo(dto.getNoticeNo())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();

        return notice;

    }

    default NoticeDTO entityToDTO(Notice entity) {

        NoticeDTO noticeDTO = NoticeDTO.builder()
                .noticeNo(entity.getNoticeNo())
                .title(entity.getTitle())
                .content(entity.getContent())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .writerMemNo(entity.getWriter().getMemNo())
                .build();

        return noticeDTO;

    }

}
