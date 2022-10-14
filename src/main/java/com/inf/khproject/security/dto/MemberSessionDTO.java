package com.inf.khproject.security.dto;

import com.inf.khproject.dto.MemberDTO;
import com.inf.khproject.entity.Member;
import com.inf.khproject.entity.MemberRole;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class MemberSessionDTO implements Serializable {

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
    private MemberRole role;

    public MemberSessionDTO(Member entity) {
        this.id = entity.getId();
        this.nickname = entity.getNickname();
        this.username = entity.getUsername();
        this.pw = entity.getPw();
        this.phoneNum = entity.getPhoneNum();
        this.email = entity.getEmail();
        this.address = entity.getAddress();
        this.companyNo = entity.getCompanyNo();
        this.birth = entity.getBirth();
        this.name = entity.getName();
        this.auth = entity.getAuth();
        this.fileName = entity.getFileName();
        this.role = entity.getRole();

    }


}
