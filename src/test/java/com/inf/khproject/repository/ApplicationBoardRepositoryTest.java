package com.inf.khproject.repository;

import com.inf.khproject.entity.ApplicationBoard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class ApplicationBoardRepositoryTest {

    @Autowired
    private ApplicationBoardRepository applicationBoardRepository;
    @Autowired
    private  ApplicationBoardImageRepository applicationBoardImageRepository;


    @Test
    public void testListPage(){

        PageRequest pageRequest = PageRequest.of(0,10, Sort.by(Sort.Direction.DESC, "boardNo"));

        Page<Object[]> result = applicationBoardRepository.getListPage(pageRequest);

        for (Object[] objects : result.getContent()) {
            System.out.println(Arrays.toString(objects));
        }
    }



}
