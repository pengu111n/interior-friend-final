package com.inf.khproject.service;

import com.inf.khproject.dto.MemberDTO;
import com.inf.khproject.entity.Member;

import com.inf.khproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

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
	public void regist(MemberDTO dto, String local) {
        dto.setPw(passwordEncoder.encode(dto.getPw()));
        Member member = dto.dtoToEntity(dto);
        repository.save(member);
    }

	@Override
	public int usernameCheck(String username) throws Exception {
		int existID = repository.usernameCheck(username);
		return existID;
	}

	@Override
	public int nicknameCheck(String nickname) throws Exception {
		int existNickname = repository.nicknameCheck(nickname);
		return existNickname;
	}


}

