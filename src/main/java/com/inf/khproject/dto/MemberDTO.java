package com.inf.khproject.dto;

import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private Integer memNo;
    private String nickname;
    private String id;
    private String pw;
    private String phoneNum;
    private String email;
    private String address;
    private String companyNo;
    private String birth;
    private String name;
    private Integer auth;
    private String fileName;

}

