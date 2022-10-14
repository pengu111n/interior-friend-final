//package com.inf.khproject.service;
//
//import com.inf.khproject.dto.MemberDTO;
//import com.inf.khproject.entity.Member;
//
//import com.inf.khproject.entity.MemberRole;
//import com.inf.khproject.repository.MemberRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@Log4j2
//@RequiredArgsConstructor
//@Transactional
//public class MemberServiceImpl implements MemberService{
//
//	private final MemberRepository repository;
//
//	private final PasswordEncoder passwordEncoder;
//
//    @Override
//	public Member regist(MemberDTO dto, String local) {
//        dto.setPw(passwordEncoder.encode(dto.getPw()));
//
//		if(repository.findByUsername(dto.getUsername(), false) != null){
//			return null;
//		}
//		// 가입한 성공한 모든 유저는  "USER" 권한 부여
//
//		if()
//
//		return dto.builder()
//				.id(user.getId())
//				.email(user.getEmail())
//				.password(user.getPassword())
//				.role(user.getRole())
//				.build();
//	}
//
//	private Member inBuilder(MemberDTO dto){
//		Member member = repository.save(Member.builder()
//				.pw(passwordEncoder.encode(dto.getPw()))
//				.email(dto.getEmail())
//				.role(MemberRole.INDIVIDUAL)
//				.build());
//		return member;
//	}
//
//	private Member comBuilder(MemberDTO dto){
//		Member member = repository.save(Member.builder()
//				.pw(passwordEncoder.encode(dto.getPw()))
//				.email(dto.getEmail())
//				.role(MemberRole.COMPANY)
//				.build());
//		return member;
//	}
//
//	@Override
//	public int usernameCheck(String username) throws Exception {
//		int existID = repository.usernameCheck(username);
//		return existID;
//	}
//
//	@Override
//	public int nicknameCheck(String nickname) throws Exception {
//		int existNickname = repository.nicknameCheck(nickname);
//		return existNickname;
//	}
//
//
//}
//
