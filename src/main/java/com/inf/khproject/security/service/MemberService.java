package com.inf.khproject.security.service;

import com.inf.khproject.entity.Member;
import com.inf.khproject.repository.MemberRepository;
import com.inf.khproject.security.dto.MemberAuthDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {


    private final MemberRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("ClubUserDetailsService loadUserByUsername " + username);


        Optional<Member> result = repository.findByUsername(username, false);

        if(result.isEmpty()){
            throw new UsernameNotFoundException("Check User Email or from Social ");
        }

        Member member = result.get();

        log.info("-----------------------------");
        log.info(member);

        MemberAuthDTO authDTO = new MemberAuthDTO(
                member.getUsername(),
                member.getPw(),
                member.isSocial(),
                member.getRoleSet().stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_"+role.name()))
                        .collect(Collectors.toSet())
        );

        authDTO.setName(member.getName());
        authDTO.setSocial(member.isSocial());

        return authDTO;
    }
}
