package com.inf.khproject.service;

import com.inf.khproject.dto.InteriorBoardDTO;
import com.inf.khproject.dto.InteriorBoardImageDTO;
import com.inf.khproject.dto.InteriorPageRequestDTO;
import com.inf.khproject.dto.InteriorPageResultDTO;
import com.inf.khproject.entity.InteriorBoard;
import com.inf.khproject.entity.InteriorBoardImage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface InteriorBoardService {


    InteriorPageResultDTO<InteriorBoardDTO, Object[]> getList(InteriorPageRequestDTO requestDTO);

    InteriorPageResultDTO<InteriorBoardDTO, Object[]> getMypageList(InteriorPageRequestDTO requestDTO, Long id);

    InteriorBoardDTO read(Long boardNo);
    Long register(InteriorBoardDTO interiorBoardDTO);
    void remove(Long boardNo);
    void modify(InteriorBoardDTO dto);

    default InteriorBoardDTO entitiesToDto(InteriorBoard interiorBoard, List<InteriorBoardImage> interiorBoardImages) {
        InteriorBoardDTO dto = InteriorBoardDTO.builder()
                .boardNo(interiorBoard.getBoardNo())
                .id(interiorBoard.getId())
                .nickname(interiorBoard.getNickname())
                .title(interiorBoard.getTitle())
                .content(interiorBoard.getContent())
                .category(interiorBoard.getCategory())
                .part(interiorBoard.getPart())
                .area(interiorBoard.getArea())
                .cost(interiorBoard.getCost())
                .period(interiorBoard.getPeriod())
                .regDate(interiorBoard.getRegDate())
                .modDate(interiorBoard.getModDate())
                .phoneNum(interiorBoard.getPhoneNum())
                .email(interiorBoard.getEmail())
                .address(interiorBoard.getAddress())
                .view_count(interiorBoard.getView_count())
                .build();

        List<InteriorBoardImageDTO> interiorBoardImageDTOList = interiorBoardImages.stream().map(interiorBoardImage -> {
            return InteriorBoardImageDTO.builder()
                    .imgName(interiorBoardImage.getImgName())
                    .path(interiorBoardImage.getPath())
                    .uuid(interiorBoardImage.getUuid())
                    .build();
        }).collect(Collectors.toList());

        dto.setImageDTOList(interiorBoardImageDTOList);

        return dto;
    }

    default InteriorBoardDTO entityToDto(InteriorBoard interiorBoard) {
        InteriorBoardDTO dto = InteriorBoardDTO.builder()
                .boardNo(interiorBoard.getBoardNo())
                .id(interiorBoard.getId())
                .nickname(interiorBoard.getNickname())
                .title(interiorBoard.getTitle())
                .content(interiorBoard.getContent())
                .category(interiorBoard.getCategory())
                .part(interiorBoard.getPart())
                .area(interiorBoard.getArea())
                .cost(interiorBoard.getCost())
                .period(interiorBoard.getPeriod())
                .regDate(interiorBoard.getRegDate())
                .modDate(interiorBoard.getModDate())
                .phoneNum(interiorBoard.getPhoneNum())
                .email(interiorBoard.getEmail())
                .address(interiorBoard.getAddress())
                .view_count(interiorBoard.getView_count())
                .build();

        return dto;
    }


    default Map<String, Object> dtoToEntity(InteriorBoardDTO dto) {
        Map<String, Object> entityMap = new HashMap<>();

        InteriorBoard interiorBoard = InteriorBoard.builder()
                .boardNo(dto.getBoardNo())
                .id(dto.getId())
                .nickname(dto.getNickname())
                .title(dto.getTitle())
                .content(dto.getContent())
                .category(dto.getCategory())
                .part(dto.getPart())
                .area(dto.getArea())
                .cost(dto.getCost())
                .period(dto.getPeriod())
                .phoneNum(dto.getPhoneNum())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .view_count(dto.getView_count())
                .build();

        entityMap.put("interiorBoard", interiorBoard);

        List<InteriorBoardImageDTO> imageDTOList = dto.getImageDTOList();

        if (imageDTOList != null && imageDTOList.size() > 0) { //MovieImageDTO 처리

            List<InteriorBoardImage> interiorBoardImagesList = imageDTOList.stream().map(interiorBoardImageDTO -> {

                InteriorBoardImage interiorBoardImage = InteriorBoardImage.builder()
                        .path(interiorBoardImageDTO.getPath())
                        .imgName(interiorBoardImageDTO.getImgName())
                        .uuid(interiorBoardImageDTO.getUuid())
                        .interiorBoard(interiorBoard)
                        .build();
                return interiorBoardImage;
            }).collect(Collectors.toList());

            entityMap.put("imgList", interiorBoardImagesList);


        }


        return entityMap;
    }

}
