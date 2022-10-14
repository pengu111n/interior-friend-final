package com.inf.khproject.entity;

import lombok.*;

import javax.persistence.*;



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


}
