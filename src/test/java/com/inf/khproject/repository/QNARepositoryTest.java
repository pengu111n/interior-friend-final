package com.inf.khproject.repository;

import com.inf.khproject.entity.Member;
import com.inf.khproject.entity.QNA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class QNARepositoryTest {

    @Autowired
    private QNARepository qnaRepository;

    @Test
    public void insertQNA() {

        IntStream.rangeClosed(1, 100).forEach(i -> {

            Member member = Member.builder().id((long) i).build();

            QNA qna = QNA.builder()
                    .category("Category")
                    .title("Title..." + i)
                    .content("Content..." + i)
                    .status(i)
                    .writer(member)
                    .build();

            qnaRepository.save(qna);

        });

    }

    @Transactional
    @Test
    public void testRead1() {

        Optional<QNA> result = qnaRepository.findById(100L);

        QNA qna = result.get();

        System.out.println(qna);
        System.out.println(qna.getWriter());

    }

    @Test
    public void testReadWithWriter() {

        Object result = qnaRepository.getQnaWithWriter(100L);

        Object[] arr = (Object[]) result;

        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));

    }
    
    @Test
    public void testGetQNAWithReply() {

        List<Object[]> result = qnaRepository.getQNAWithReply(100L);

        for (Object[] arr : result) {
            System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        }
        
    }

//    @Test
//    public void testGetQNAWithReply2() {
//
//        Pageable pageable = PageRequest.of(0, 10, Sort.by("qnaNo").descending());
//
//        Page<Object[]> result = qnaRepository.getQNAWithReply2(pageable);
//
//        result.get().forEach(row -> {
//
//            Object[] arr = row;
//
//            System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
//
//        });
//
//    }

    @Test
    public void testRead2() {

        Object result = qnaRepository.getQNAByQnaNo(100L);

        Object[] arr = (Object[]) result;

        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));

    }

}