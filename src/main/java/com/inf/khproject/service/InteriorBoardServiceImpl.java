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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
    public Long register(InteriorBoardDTO interiorBoardDTO) {
        Map<String, Object> entityMap = dtoToEntity(interiorBoardDTO);
        InteriorBoard interiorBoard = (InteriorBoard) entityMap.get("interiorBoard");


        List<InteriorBoardImage> interiorBoardImageList = (List<InteriorBoardImage>) entityMap.get("imgList");

        interiorBoardRepository.save(interiorBoard);
        interiorBoardImageList.forEach(interiorBoardImage -> {
            imageRepository.save(interiorBoardImage);
        });


        return interiorBoard.getBoardNo();
    }

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
                , (List<InteriorBoardImage>) (Arrays.asList((InteriorBoardImage) arr[1]))
        ));
          /*
        Function<Object[], InteriorBoardDTO> fn = (arr -> entityToDto(
                (InteriorBoard) arr[0]
        ));
        */


        return new InteriorPageResultDTO<>(result, fn);


    }
    @Override
    public InteriorBoardDTO read(Long boardNo) {
        interiorBoardRepository.updateView_count(boardNo);
        List<Object[]> result = interiorBoardRepository.getInteriorBoardWithAll(boardNo);

        InteriorBoard interiorBoard = (InteriorBoard) result.get(0)[0];

        List<InteriorBoardImage> interiorBoardImageList = new ArrayList<>();

        result.forEach(arr -> {
            InteriorBoardImage interiorBoardImage = (InteriorBoardImage) arr[1];
            interiorBoardImageList.add(interiorBoardImage);
        });
        //return entityToDto(applicationBoard);
        return entitiesToDto(interiorBoard, interiorBoardImageList);
    }

}
