package com.inf.khproject.service;



import com.inf.khproject.dto.MemberDTO;
import com.inf.khproject.entity.Member;

public interface MemberService{




	public void regist(MemberDTO dto, String local) throws Exception;

	public int usernameCheck(String username) throws Exception;

	public int nicknameCheck(String nickname) throws Exception;


	default Member dtoToEntity(MemberDTO dto){
		Member entity = Member.builder()
				.id(dto.getId())
				.nickname(dto.getNickname())
				.username(dto.getUsername())
				.pw(dto.getPw())
				.phoneNum(dto.getPhoneNum())
				.email(dto.getEmail())
				.address(dto.getAddress())
				.companyNo(dto.getCompanyNo())
				.birth(dto.getBirth())
				.name(dto.getName())
				.auth(dto.getAuth())
				.fileName(dto.getFileName())
				.build();
		return entity;
	}

	default MemberDTO entityToDTO(Member entity){
		MemberDTO dto = MemberDTO.builder()
				.id(entity.getId())
				.nickname(entity.getNickname())
				.username(entity.getUsername())
				.pw(entity.getPw())
				.phoneNum(entity.getPhoneNum())
				.email(entity.getEmail())
				.address(entity.getAddress())
				.companyNo(entity.getCompanyNo())
				.birth(entity.getBirth())
				.name(entity.getName())
				.auth(entity.getAuth())
				.fileName(entity.getFileName())
				.build();
		return dto;
	}


}

