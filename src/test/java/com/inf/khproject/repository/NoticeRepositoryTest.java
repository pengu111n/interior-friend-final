package com.inf.khproject.repository;

import com.inf.khproject.entity.Member;
import com.inf.khproject.entity.Notice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NoticeRepositoryTest {

    @Autowired
    private NoticeRepository noticeRepository;

    @Test
    public void insertNotice() {

        IntStream.rangeClosed(1, 100).forEach(i -> {

            Member member = Member.builder().memNo((long) i).build();

            Notice notice = Notice.builder()
                    .title("Title..." + i)
                    .content("Content..." + i)
                    .writer(member)
                    .build();

            noticeRepository.save(notice);

        });

    }

}