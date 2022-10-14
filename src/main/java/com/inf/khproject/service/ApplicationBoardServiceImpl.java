package com.inf.khproject.service;

import com.inf.khproject.dto.ApplicationBoardDTO;
import com.inf.khproject.dto.ApplicationPageRequestDTO;
import com.inf.khproject.dto.ApplicationPageResultDTO;
import com.inf.khproject.entity.ApplicationBoard;
import com.inf.khproject.entity.ApplicationBoardImage;
import com.inf.khproject.repository.ApplicationBoardImageRepository;
import com.inf.khproject.repository.ApplicationBoardRepository;
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
public class ApplicationBoardServiceImpl implements ApplicationBoardService {

    @Autowired
    private final ApplicationBoardRepository applicationBoardRepository;

    @Autowired
    private final ApplicationBoardImageRepository imageRepository; //final

    @Transactional
    @Override
    public Long register(ApplicationBoardDTO applicationBoardDTO) {
        Map<String, Object> entityMap = dtoToEntity(applicationBoardDTO);
        ApplicationBoard applicationBoard = (ApplicationBoard) entityMap.get("applicationBoard");

        System.out.println("applicationBoard = " + applicationBoard);


        List<ApplicationBoardImage> applicationBoardImageList = (List<ApplicationBoardImage>) entityMap.get("imgList");

        applicationBoardRepository.save(applicationBoard);

        if(applicationBoardImageList != null) {
            applicationBoardImageList.forEach(applicationBoardImage -> {
                imageRepository.save(applicationBoardImage);
            });

        }


        return applicationBoard.getBoardNo();
    }
    @Transactional
    @Override
    public ApplicationPageResultDTO<ApplicationBoardDTO, Object[]> getList(ApplicationPageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageable(Sort.by("boardNo").descending());


        Page<Object[]> result = applicationBoardRepository.getListPage(pageable);

        result.getContent().forEach(arr -> {
            log.info(Arrays.toString(arr));
        });



            Function<Object[], ApplicationBoardDTO> fn = (arr -> entitiesToDto(
                    (ApplicationBoard) arr[0]
                    ,(List<ApplicationBoardImage>) (Arrays.asList((ApplicationBoardImage) arr[1]))
            ));
          /*
        Function<Object[], ApplicationBoardDTO> fn = (arr -> entityToDto(
                (ApplicationBoard) arr[0]
        ));
        */


        return new ApplicationPageResultDTO<>(result, fn);


    }

    @Override
    public ApplicationBoardDTO read(Long boardNo) {

        applicationBoardRepository.updateview_count(boardNo);
        List<Object[]> result = applicationBoardRepository.getApplicationboardWithAll(boardNo);

        ApplicationBoard applicationBoard = (ApplicationBoard) result.get(0)[0];

        List<ApplicationBoardImage> applicationBoardImageList = new ArrayList<>();

        result.forEach(arr -> {
            ApplicationBoardImage  applicationBoardImage = (ApplicationBoardImage)arr[1];
            applicationBoardImageList.add(applicationBoardImage);
        });
        //return entityToDto(applicationBoard);
        return entitiesToDto(applicationBoard, applicationBoardImageList);
    }

    @Transactional
    @Override
    public void remove(Long boardNo) {

        imageRepository.deleteByApplicationBoard(boardNo);

        applicationBoardRepository.deleteById(boardNo);
    }
    @Transactional
    @Override
    public void modify(ApplicationBoardDTO dto) {

        log.info("dto.getBoardNo: " + dto.getBoardNo());
        Optional<ApplicationBoard> result = applicationBoardRepository.findById(dto.getBoardNo());

        if (result.isPresent()) {

            ApplicationBoard entity = result.get();

            entity.setTitle(dto.getTitle());
            entity.setCategory(dto.getCategory());
            entity.setAddress(dto.getAddress());
            entity.setArea(dto.getArea());
            entity.setStartDate(dto.getStartDate());
            entity.setEndDate(dto.getEndDate());
            entity.setBudget(dto.getBudget());
            entity.setPart(dto.getPart());
            entity.setRequired(dto.getRequired());

            applicationBoardRepository.save(entity);

            imageRepository.deleteByApplicationBoard(dto.getBoardNo());


            Map<String, Object> entityMap = dtoToEntity(dto);

            List<ApplicationBoardImage> applicationBoardImageList = (List<ApplicationBoardImage>) entityMap.get("imgList");

            applicationBoardImageList.forEach(applicationBoardImage -> {
                imageRepository.save(applicationBoardImage);
            });

        }
    }

}
