package com.inf.khproject.service;



import com.inf.khproject.dto.MemberDTO;
import com.inf.khproject.entity.Member;

import java.util.Date;
import java.util.List;

public interface MemberService {


	public void regist(MemberDTO dto, String local) throws Exception;

	default Member dtoToEntity(MemberDTO dto){
		Member entity = Member.builder()
				.memNo(dto.getMemNo())
				.nickName(dto.getNickName())
				.id(dto.getId())
				.pw(dto.getPw())
				.phoneNum(dto.getPhoneNum())
				.email(dto.getEmail())
				.address(dto.getAddress())
				.companyNo(dto.getCompanyNo())
				.birth(dto.getBirth())
				.rank(dto.getRank())
				.name(dto.getName())
				.auth(dto.getAuth())
				.fileName(dto.getFileName())
				.build();
		return entity;
	}

	default MemberDTO entityToDTO(Member entity){
		MemberDTO dto = MemberDTO.builder()
				.memNo(entity.getMemNo())
				.nickName(entity.getNickName())
				.id(entity.getId())
				.pw(entity.getPw())
				.phoneNum(entity.getPhoneNum())
				.email(entity.getEmail())
				.address(entity.getAddress())
				.companyNo(entity.getCompanyNo())
				.birth(entity.getBirth())
				.rank(entity.getRank())
				.name(entity.getName())
				.auth(entity.getAuth())
				.fileName(entity.getFileName())
				.build();
		return dto;
	}


}

