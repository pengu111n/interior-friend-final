package com.inf.khproject.security.service;


import com.inf.khproject.dto.MemberDTO;
import com.inf.khproject.entity.Member;
import com.inf.khproject.entity.MemberRole;
import com.inf.khproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberService  {


    private final MemberRepository repository;
    private final PasswordEncoder passwordEncoder;

    public Member register(MemberDTO dto){
        dto.setPw(passwordEncoder.encode(dto.getPw()));
        MemberRole role = dto.getRole();
        Member member = dto.dtoToEntity(dto);
        repository.save(member);
        return member;
    }


    public int usernameCheck(String username) throws Exception {
        int existID = repository.usernameCheck(username);
        return existID;
    }


    public int nicknameCheck(String nickname) throws Exception {
        int existNickname = repository.nicknameCheck(nickname);
        return existNickname;
    }

}
