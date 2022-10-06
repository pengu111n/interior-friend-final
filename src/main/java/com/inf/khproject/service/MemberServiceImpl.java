package com.inf.khproject.service;

import com.inf.khproject.dto.MemberDTO;
import com.inf.khproject.entity.Member;

import com.inf.khproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService{

	private final MemberRepository repository;

	private final PasswordEncoder passwordEncoder;

	@Override
	public void regist(MemberDTO dto, String local)throws Exception{
		log.info("DTO----------------");
		log.info(dto);
		log.info(dto.getPw());
		String encodePW = passwordEncoder.encode(dto.getPw());
		log.info(encodePW);
		dto.setPw(encodePW);
		log.info(dto.getPw());
		Member entity = dtoToEntity(dto);
		repository.save(entity);
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

