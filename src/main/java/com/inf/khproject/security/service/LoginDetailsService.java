package com.inf.khproject.security.service;

import com.inf.khproject.entity.Member;
import com.inf.khproject.entity.MemberRole;
import com.inf.khproject.repository.MemberRepository;
import com.inf.khproject.security.dto.MemberAuthDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class LoginDetailsService implements UserDetailsService {


    private final MemberRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("username: " + username);

        Optional<Member> result = repository.findById(username, false);

        if(result.isPresent()){
            throw new UsernameNotFoundException(username);
        }

        Member member = result.get();

        MemberAuthDTO authMember = new MemberAuthDTO(
                member.getId(),
                member.getPw(),
                member.isSocial(),
                member.getRoleSet().stream()
                        .map(role ->new SimpleGrantedAuthority("ROLE_" + role.name())).collect(Collectors.toSet())
        );

        authMember.setId(member.getId());
        authMember.setSocial(member.isSocial());

        return authMember;
    }
}
