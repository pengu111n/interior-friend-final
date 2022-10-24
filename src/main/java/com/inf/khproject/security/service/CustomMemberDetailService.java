package com.inf.khproject.security.service;

import com.inf.khproject.entity.Member;
import com.inf.khproject.repository.MemberRepository;
import com.inf.khproject.security.dto.MemberSessionDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
@Log4j2
public class CustomMemberDetailService implements UserDetailsService {

    private final MemberRepository repository;
    private final HttpSession session;


    /* username이 DB에 있는지 확인 */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("해당 사용자가 존재하지 않습니다. : " + username));

        session.setAttribute("user", new MemberSessionDTO(member));        /* 시큐리티 세션에 유저 정보 저장 */

        return new PrincipalDetails(member);
    }

}
