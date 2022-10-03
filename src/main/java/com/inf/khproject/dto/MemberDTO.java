package com.inf.khproject.dto;

import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private Integer memNo;
    private String nickName;
    private String id;
    private String pw;
    private String phoneNum;
    private String email;
    private String address;
    private String companyNo;
    private String birth;
    private Integer rank;
    private String name;
    private Integer auth;
    private String fileName;

}

