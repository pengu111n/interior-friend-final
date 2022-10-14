package com.inf.khproject.entity;

import com.inf.khproject.security.dto.MemberSessionDTO;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Member")
@ToString
public class Member{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;
    private String username;
    private String pw;
    private String phoneNum;
    private String email;
    private String address;
    private String companyNo;
    private String birth;
    private String name;
    private String auth;
    private String fileName;
    private boolean isSocial;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MemberRole role;


    @Builder
    public Member(String username, String password, MemberRole role) {
        this.username = username;
        this.pw = password;
        this.role = role;
    }

//    @ElementCollection(fetch = FetchType.LAZY)
//    private Set<MemberRole> roleSet;
//
//    public void addMemberRole(MemberRole memberRole){
//        roleSet.add(memberRole);
//    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Set<GrantedAuthority> roles = new HashSet<>();
//        roles.add(new SimpleGrantedAuthority(role.getValue()));
//        return roles;
//    }
//
//    @Override
//    public String getUsername() {
//        return this.username;
//    }
//
//    @Override
//    public String getPassword() {
//        return this.pw;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}

