package com.inf.khproject.service;



import com.inf.khproject.dto.MemberDTO;
import com.inf.khproject.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.List;

public interface MemberService{




	public void regist(MemberDTO dto, String local) throws Exception;

	public int idCheck(String id) throws Exception;

	public int nicknameCheck(String nickname) throws Exception;


	default Member dtoToEntity(MemberDTO dto){
		Member entity = Member.builder()
				.memNo(dto.getMemNo())
				.nickname(dto.getNickname())
				.id(dto.getId())
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
				.memNo(entity.getMemNo())
				.nickname(entity.getNickname())
				.id(entity.getId())
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

