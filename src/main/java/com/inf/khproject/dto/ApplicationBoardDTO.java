package com.inf.khproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationBoardDTO {

	private Long boardNo;
	private String username;
	private String nickName;
	private Long id;
	private String title;


	private String category;
	private String address;
	private int area;
	private String startDate;
	private String endDate;

	private int budget;
	private String part;
	private String required;
	private int view_count;
	private int status;

	private LocalDateTime regDate;
	private LocalDateTime modDate;

	@Builder.Default
	private List<ApplicationBoardImageDTO> imageDTOList = new ArrayList<>();



}
