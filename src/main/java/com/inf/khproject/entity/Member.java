package com.inf.khproject.entity;

import com.inf.khproject.dto.MemberDTO;
import com.inf.khproject.security.dto.MemberSessionDTO;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
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
    @Column(unique = true)
    private String email;
    private String roadAddress;
    private String detailAddress;
    private String companyNo;
    private String birth;
    private String name;
    private String auth;
    private String fileName;
    private boolean isSocial;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private MemberRole role;


    @Builder
    public Member(String username, String password, MemberRole role) {
        this.username = username;
        this.pw = password;
        this.role = role;
    }

    @Builder
    public Member(String nickname, String email, String fileName) {
        this.username = username;
        this.email = email;
        this.fileName = fileName;
    }

    public String getRoleValue(){
        return this.role.getValue();
    }

    public Member update(String email, String fileName, String nickname){
        this.email = email;
        this.fileName = fileName;
        this.nickname = nickname;
        this.isSocial = true;
        return this;
    }

    public Member admin(String username, String pw, String email){
        this.username = username;
        this.nickname = "admin";
        this.pw = pw;
        this.email = email;
        this.role = MemberRole.ROLE_ADMIN;
        return this;
    }


    public Member dtoToEntity(MemberDTO dto){
        if(dto.getRank() ==  1) {
            this.nickname = dto.getNickname();
            this.username = dto.getUsername();
            this.pw = dto.getPw();
            this.phoneNum = dto.getPhoneNum();
            this.email = dto.getEmail();
            this.roadAddress = dto.getRoadAddress();
            this.detailAddress = dto.getDetailAddress();
            this.companyNo = dto.getCompanyNo();
            this.birth = dto.getBirth();
            this.name = dto.getName();
            this.auth = dto.getAuth();
            this.role = MemberRole.ROLE_INDIVIDUAL;
        }else if(dto.getRank() == 2){
            this.nickname = dto.getNickname();
            this.username = dto.getUsername();
            this.pw = dto.getPw();
            this.phoneNum = dto.getPhoneNum();
            this.email = dto.getEmail();
            this.roadAddress = dto.getRoadAddress();
            this.detailAddress = dto.getDetailAddress();
            this.companyNo = dto.getCompanyNo();
            this.birth = dto.getBirth();
            this.name = dto.getName();
            this.auth = dto.getAuth();
            this.role = MemberRole.ROLE_COMPANY;
        }

        return this;
    }

}


