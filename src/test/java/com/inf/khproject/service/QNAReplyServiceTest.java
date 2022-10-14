package com.inf.khproject.service;

import com.inf.khproject.dto.QNAReplyDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class QNAReplyServiceTest {

    @Autowired
    private QNAReplyService qnaReplyService;

    @Test
    public void getList() {

        Long qnaNo = 100L;

        List<QNAReplyDTO> list = qnaReplyService.getList(qnaNo);

        list.forEach(qnaReplyDTO -> System.out.println(qnaReplyDTO));

    }
}