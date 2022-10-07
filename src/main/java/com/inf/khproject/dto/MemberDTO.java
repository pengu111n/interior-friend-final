package com.inf.khproject.dto;

import com.inf.khproject.entity.Member;
import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
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

    public Member dtoToEntity(MemberDTO dto){
        Member entity = Member.builder()
                .id(dto.getId())
                .nickname(dto.getNickname())
                .username(dto.getUsername())
                .pw(dto.getPw())
                .phoneNum(dto.getPhoneNum())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .companyNo(dto.getCompanyNo())
                .birth(dto.getBirth())
                .name(dto.getName())
                .auth(dto.getAuth())
                .fileName(dto.getFileName())
                .build();
        return entity;
    }

    public MemberDTO entityToDTO(Member entity){
        MemberDTO dto = MemberDTO.builder()
                .id(entity.getId())
                .nickname(entity.getNickname())
                .username(entity.getUsername())
                .pw(entity.getPw())
                .phoneNum(entity.getPhoneNum())
                .email(entity.getEmail())
                .address(entity.getAddress())
                .companyNo(entity.getCompanyNo())
                .birth(entity.getBirth())
                .name(entity.getName())
                .auth(entity.getAuth())
                .fileName(entity.getFileName())
                .build();
        return dto;
    }


}

