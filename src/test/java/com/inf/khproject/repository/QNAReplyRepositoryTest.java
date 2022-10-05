package com.inf.khproject.repository;

import com.inf.khproject.entity.QNA;
import com.inf.khproject.entity.QNAReply;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class QNAReplyRepositoryTest {

    @Autowired
    private QNAReplyRepository qnaReplyRepository;

    @Test
    public void insertQNAReply() {

        IntStream.rangeClosed(1, 300).forEach(i -> {

            long qnaNo = (long) (Math.random() * 100) + 1;

            QNA qna = QNA.builder().qnaNo(qnaNo).build();

            QNAReply qnaReply = QNAReply.builder()
                    .content("Reply......" + i)
                    .qna(qna)
                    .build();

            qnaReplyRepository.save(qnaReply);

        });

    }

    @Test
    public void readReply1() {

        Optional<QNAReply> result = qnaReplyRepository.findById(1L);

        QNAReply qnaReply = result.get();

        System.out.println(qnaReply);
        System.out.println(qnaReply.getQna());

    }

}