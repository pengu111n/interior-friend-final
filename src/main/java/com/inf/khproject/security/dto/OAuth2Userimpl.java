package com.inf.khproject.security.dto;

import com.inf.khproject.entity.Member;
import com.inf.khproject.entity.MemberRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;


@RequiredArgsConstructor
@Data
public class OAuth2Userimpl implements OAuth2User {
    private final Map<String, Object> attributes;
    private final Member member;

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(member.getRoleValue()));
    }

    @Override
    public String getName() {
        return member.getNickname();
    }

    public Member getMember(){
        return member;
    }
}
