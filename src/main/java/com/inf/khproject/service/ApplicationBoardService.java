package com.inf.khproject.service;

import com.inf.khproject.dto.ApplicationBoardDTO;
import com.inf.khproject.dto.ApplicationBoardImageDTO;
import com.inf.khproject.dto.ApplicationPageRequestDTO;
import com.inf.khproject.dto.ApplicationPageResultDTO;
import com.inf.khproject.entity.ApplicationBoard;
import com.inf.khproject.entity.ApplicationBoardImage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface ApplicationBoardService {


    ApplicationPageResultDTO<ApplicationBoardDTO, Object[]> getList(ApplicationPageRequestDTO requestDTO);
    ApplicationBoardDTO read(Long boardNo);
    Long register(ApplicationBoardDTO applicationBoardDTO);
    void remove(Long boardNo);
    void modify(ApplicationBoardDTO dto);



    default ApplicationBoardDTO entitiesToDto(ApplicationBoard applicationBoard, List<ApplicationBoardImage> applicationBoardImages) {
        ApplicationBoardDTO dto = ApplicationBoardDTO.builder()
                .boardNo(applicationBoard.getBoardNo())
                .id(applicationBoard.getId())
                .nickName(applicationBoard.getNickName())
                .memNo(applicationBoard.getMemNo())
                .title(applicationBoard.getTitle())
                .category(applicationBoard.getCategory())
                .address(applicationBoard.getAddress())
                .area(applicationBoard.getArea())
                .startDate(applicationBoard.getStartDate())
                .endDate(applicationBoard.getEndDate())
                .budget(applicationBoard.getBudget())
                .part(applicationBoard.getPart())
                .required(applicationBoard.getRequired())
                .image(applicationBoard.getImage())
                .view_count(applicationBoard.getView_count())
                .regDate(applicationBoard.getRegDate())
                .modDate(applicationBoard.getModDate())
                .build();

        List<ApplicationBoardImageDTO> applicationBoardImageDTOList = applicationBoardImages.stream().map(applicationBoardImage -> {
            return ApplicationBoardImageDTO.builder()
                    .imgName(applicationBoardImage.getImgName())
                    .path(applicationBoardImage.getPath())
                    .uuid(applicationBoardImage.getUuid())
                    .build();
        }).collect(Collectors.toList());

        dto.setImageDTOList(applicationBoardImageDTOList);

        return dto;
    }

    default ApplicationBoardDTO entityToDto(ApplicationBoard applicationBoard) {
        ApplicationBoardDTO dto = ApplicationBoardDTO.builder()
                .boardNo(applicationBoard.getBoardNo())
                .id(applicationBoard.getId())
                .nickName(applicationBoard.getNickName())
                .memNo(applicationBoard.getMemNo())
                .title(applicationBoard.getTitle())
                .category(applicationBoard.getCategory())
                .address(applicationBoard.getAddress())
                .area(applicationBoard.getArea())
                .startDate(applicationBoard.getStartDate())
                .endDate(applicationBoard.getEndDate())
                .budget(applicationBoard.getBudget())
                .part(applicationBoard.getPart())
                .required(applicationBoard.getRequired())
                .image(applicationBoard.getImage())
                .view_count(applicationBoard.getView_count())
                .regDate(applicationBoard.getRegDate())
                .modDate(applicationBoard.getModDate())
                .build();



        return dto;
    }


    default Map<String, Object> dtoToEntity(ApplicationBoardDTO dto) {
        Map<String, Object> entityMap = new HashMap<>();

        ApplicationBoard applicationBoard = ApplicationBoard.builder()
                .boardNo(dto.getBoardNo())
                .id(dto.getId())
                .nickName(dto.getNickName())
               .memNo(dto.getMemNo())
                .title(dto.getTitle())
                .category(dto.getCategory())
                .address(dto.getAddress())
                .area(dto.getArea())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .budget(dto.getBudget())
                .part(dto.getPart())
                .required(dto.getRequired())
                .image(dto.getImage())
                .view_count(dto.getView_count())
                .build();

        entityMap.put("applicationBoard", applicationBoard);

        List<ApplicationBoardImageDTO> imageDTOList = dto.getImageDTOList();

        if (imageDTOList != null && imageDTOList.size() > 0) { //MovieImageDTO 처리

            List<ApplicationBoardImage> applicationBoardImagesList = imageDTOList.stream().map(applicationBoardImageDTO -> {

                ApplicationBoardImage applicationBoardImage = ApplicationBoardImage.builder()
                        .path(applicationBoardImageDTO.getPath())
                        .imgName(applicationBoardImageDTO.getImgName())
                        .uuid(applicationBoardImageDTO.getUuid())
                        .applicationBoard(applicationBoard)
                        .build();
                return applicationBoardImage;
            }).collect(Collectors.toList());

            entityMap.put("imgList", applicationBoardImagesList);


        }


        return entityMap;
    }

}
