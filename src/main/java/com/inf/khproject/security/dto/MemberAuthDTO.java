package com.inf.khproject.security.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

@Log4j2
@Getter
@Setter
@ToString
public class MemberAuthDTO extends User  implements OAuth2User{

    private String username;
    private String password;

    private String name;
    private boolean isSocial;

    private Map<String, Object> attr;

    public MemberAuthDTO(String username, String password, boolean isSocial, Collection<? extends GrantedAuthority> authorities) {

        super(username, password, authorities);
        this.username = username;
        this.password = password;
        this.isSocial = isSocial;
    }


    public MemberAuthDTO(String username, String password, boolean isSocial,
                             Collection<? extends GrantedAuthority> authorities, Map<String, Object> attr) {
        this(username, password, isSocial, authorities);
        this.attr = attr;
    }



    @Override
    public Map<String, Object> getAttributes() {
        return this.attr;
    }
}
