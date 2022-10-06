package com.inf.khproject.service;

import com.inf.khproject.dto.InteriorBoardDTO;
import com.inf.khproject.dto.InteriorPageRequestDTO;
import com.inf.khproject.dto.InteriorPageResultDTO;
import com.inf.khproject.entity.InteriorBoard;
import com.inf.khproject.entity.InteriorBoardImage;
import com.inf.khproject.repository.InteriorBoardImageRepository;
import com.inf.khproject.repository.InteriorBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class InteriorBoardServiceImpl implements InteriorBoardService {

    @Autowired
    private final InteriorBoardRepository interiorBoardRepository;

    @Autowired
    private final InteriorBoardImageRepository imageRepository; //final


    @Transactional
    @Override
    public InteriorPageResultDTO<InteriorBoardDTO, Object[]> getList(InteriorPageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageable(Sort.by("boardNo").descending());


        Page<Object[]> result = interiorBoardRepository.getListPage(pageable);

        result.getContent().forEach(arr -> {
            log.info(Arrays.toString(arr));
        });



            Function<Object[], InteriorBoardDTO> fn = (arr -> entitiesToDto(
                    (InteriorBoard) arr[0]
                    ,(List<InteriorBoardImage>) (Arrays.asList((InteriorBoardImage) arr[1]))
            ));
          /*
        Function<Object[], ApplicationBoardDTO> fn = (arr -> entityToDto(
                (ApplicationBoard) arr[0]
        ));
        */


        return new InteriorPageResultDTO<>(result, fn);


    }



}
