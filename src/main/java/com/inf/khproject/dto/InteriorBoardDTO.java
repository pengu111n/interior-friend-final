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
public class InteriorBoardDTO {

	private Long boardNo;
	private Long memNo;
	private String nickname;
	private String title;
	private String content;

	private String category;
	private String part;
	private int area;
	private int cost;
	private int period;


	private String phonenum;
	private String email;
	private String address;
	private int view_count;

	private LocalDateTime regDate;
	private LocalDateTime modDate;
	@Builder.Default
	private List<InteriorBoardImageDTO> imageDTOList = new ArrayList<>();

}
