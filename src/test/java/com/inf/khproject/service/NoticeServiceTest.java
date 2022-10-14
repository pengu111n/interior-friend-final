package com.inf.khproject.service;

import com.inf.khproject.dto.NoticeDTO;
import com.inf.khproject.dto.PageRequestDTO;
import com.inf.khproject.dto.PageResultDTO;
import com.inf.khproject.entity.Notice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NoticeServiceTest {

    @Autowired
    private NoticeService noticeService;

    @Test
    public void testRegister() {

        NoticeDTO dto = NoticeDTO.builder()
                .title("Test title...")
                .content("Test content...")
                .writerMemNo(1L)
                .build();

        Long noticeNo = noticeService.register(dto);

    }

    @Test
    public void testList() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();

        PageResultDTO<NoticeDTO, Notice> resultDTO = noticeService.getList(pageRequestDTO);

        for (NoticeDTO noticeDTO : resultDTO.getDtoList()) {
            System.out.println(noticeDTO);
        }

    }

    @Test
    public void testList2() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();

        PageResultDTO<NoticeDTO, Notice> resultDTO = noticeService.getList(pageRequestDTO);

        System.out.println("PREV: " + resultDTO.isPrev());
        System.out.println("NEXT: " + resultDTO.isNext());
        System.out.println("TOTAL: " + resultDTO.getTotalPage());

        System.out.println("---------------------------------------");
        for (NoticeDTO noticeDTO : resultDTO.getDtoList()) {
            System.out.println(noticeDTO);
        }

        System.out.println("---------------------------------------");
        resultDTO.getPageList().forEach(i -> System.out.println(i));

    }

}