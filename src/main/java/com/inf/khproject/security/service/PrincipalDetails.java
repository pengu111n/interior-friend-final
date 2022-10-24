package com.inf.khproject.security.service;

import com.inf.khproject.entity.Member;
import com.inf.khproject.entity.MemberRole;
import com.inf.khproject.repository.MemberRepository;
import com.inf.khproject.security.dto.MemberSessionDTO;
import com.inf.khproject.security.dto.OAuthDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;

@Data
@RequiredArgsConstructor
@Service
public class PrincipalDetails implements OAuth2User, UserDetails {


    private Member member;

    private Map<String, Object> attributes;

    public PrincipalDetails(Member member){
        this.member = member;
    }

    public PrincipalDetails(Member member, Map<String, Object> attributes){
        this.member = member;
        this.attributes = attributes;
    }


    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities= new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(member.getRole().getValue()));
        return authorities;

    }

    @Override
    public String getPassword() {
        return member.getPw();
    }

    @Override
    public String getUsername() {
        return member.getUsername();
    }



    public String getNickname() {return member.getNickname();}

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



    @Override
    public String getName() {
        return (String)attributes.get("name");
    }
}
