package com.inf.khproject.service;

import com.inf.khproject.dto.MemberDTO;
import com.inf.khproject.entity.Member;

import com.inf.khproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberRepository repository;

	@Override
	public void regist(MemberDTO dto, String local)throws Exception{
		log.info("DTO----------------");
		log.info(dto);

		Member entity = dtoToEntity(dto);
		log.info(entity);
	}

	@Override
	public int idCheck(String id) throws Exception {
		int existID = repository.idCheck(id);
		return existID;
	}

	@Override
	public int nicknameCheck(String nickname) throws Exception {
		int existNickname = repository.nicknameCheck(nickname);
		return existNickname;
	}


}

