package com.inf.khproject.entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Member")
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private boolean isSocial;

    @ElementCollection(fetch  = FetchType.LAZY)
    @Builder.Default
    private Set<MemberRole> roleSet = new HashSet<>();

    public void addMemberRole(MemberRole role){
        roleSet.add(role);
    }
}

