package com.inf.khproject.entity;

import lombok.*;

import javax.persistence.*;
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


    @ElementCollection(fetch = FetchType.LAZY)
    private Set<MemberRole> roleSet;

    public void addMemberRole(MemberRole memberRole){
        roleSet.add(memberRole);
    }
}

