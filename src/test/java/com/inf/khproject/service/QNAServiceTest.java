package com.inf.khproject.service;

import com.inf.khproject.dto.PageRequestDTO;
import com.inf.khproject.dto.PageResultDTO;
import com.inf.khproject.dto.QNADTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class QNAServiceTest {

    @Autowired
    private QNAService qnaService;

    @Test
    public void testRegister() {

        QNADTO dto = QNADTO.builder()
                .category("Category...")
                .title("Title...")
                .content("Content...")
                .writerMemNo(1L)
                .build();

        Long qnaNo = qnaService.register(dto);

    }

//    @Test
//    public void testList() {
//
//        PageRequestDTO pageRequestDTO = new PageRequestDTO();
//
//        PageResultDTO<QNADTO, Object[]> result = qnaService.getList(pageRequestDTO);
//
//        for (QNADTO qnaDTO : result.getDtoList()) {
//            System.out.println("qnaDTO = " + qnaDTO);
//        }
//
//    }

    @Test
    public void testGet() {

        Long qnaNo = 100L;

        QNADTO qnaDTO = qnaService.get(qnaNo);

        System.out.println("qnaDTO = " + qnaDTO);

    }

    @Test
    public void testRemove() {

        Long qnaNo = 1L;

        qnaService.removeWithReplies(qnaNo);

    }

    @Test
    public void testModify() {

        QNADTO qnaDTO = QNADTO.builder()
                .qnaNo(2L)
                .title("제목을 변경합니다.")
                .content("내용을 변경합니다.")
                .build();

        qnaService.modify(qnaDTO);

    }

}