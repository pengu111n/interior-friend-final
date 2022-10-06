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

    @Transactional
    @Override
    public void remove(Long boardNo) {

        imageRepository.deleteByInteriorBoard(boardNo);

        interiorBoardRepository.deleteById(boardNo);
    }

    @Transactional
    @Override
    public void modify(InteriorBoardDTO dto) {

        Optional<InteriorBoard> result = interiorBoardRepository.findById(dto.getBoardNo());

        if (result.isPresent()) {

            InteriorBoard entity = result.get();

            entity.setTitle(dto.getTitle());
            entity.setCategory(dto.getCategory());
            entity.setAddress(dto.getAddress());
            entity.setArea(dto.getArea());
            entity.setPeriod(dto.getPeriod());
            entity.setCost(dto.getCost());
            entity.setPart(dto.getPart());
            entity.setContent(dto.getContent());


            interiorBoardRepository.save(entity);

            imageRepository.deleteByInteriorBoard(dto.getBoardNo());

            Map<String, Object> entityMap = dtoToEntity(dto);

            List<InteriorBoardImage> interiorBoardImageList = (List<InteriorBoardImage>) entityMap.get("imgList");

            interiorBoardImageList.forEach(interiorBoardImage -> {
                imageRepository.save(interiorBoardImage);
            });

        }
    }
}
