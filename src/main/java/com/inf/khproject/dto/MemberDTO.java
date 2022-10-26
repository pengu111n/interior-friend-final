package com.inf.khproject.dto;

import com.inf.khproject.entity.Member;
import com.inf.khproject.entity.MemberRole;
import lombok.*;

import java.util.Objects;


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
    private String roadAddress;
    private String detailAddress;
    private String companyNo;
    private String birth;
    private String name;
    private String auth;
    private String fileName;
    private MemberRole role;
    private int rank;

    public Member dtoToEntity(MemberDTO dto){
        Member entity = null;
        if(dto.getRank() ==  1) {
            entity = Member.builder()
                    .id(dto.getId())
                    .nickname(dto.getNickname())
                    .username(dto.getUsername())
                    .pw(dto.getPw())
                    .phoneNum(dto.getPhoneNum())
                    .email(dto.getEmail())
                    .roadAddress(dto.getRoadAddress())
                    .detailAddress(dto.getDetailAddress())
                    .companyNo(dto.getCompanyNo())
                    .birth(dto.getBirth())
                    .name(dto.getName())
                    .auth(dto.getAuth())
                    .fileName(dto.getFileName())
                    .role(role.ROLE_INDIVIDUAL)
                    .build();
        }else if(dto.getRank() == 2){
            entity = Member.builder()
                    .id(dto.getId())
                    .nickname(dto.getNickname())
                    .username(dto.getUsername())
                    .pw(dto.getPw())
                    .phoneNum(dto.getPhoneNum())
                    .email(dto.getEmail())
                    .roadAddress(dto.getRoadAddress())
                    .detailAddress(dto.getDetailAddress())
                    .companyNo(dto.getCompanyNo())
                    .birth(dto.getBirth())
                    .name(dto.getName())
                    .auth(dto.getAuth())
                    .fileName(dto.getFileName())
                    .role(role.ROLE_COMPANY)
                    .build();
        }

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
                .roadAddress(entity.getRoadAddress())
                .detailAddress(entity.getDetailAddress())
                .companyNo(entity.getCompanyNo())
                .birth(entity.getBirth())
                .name(entity.getName())
                .auth(entity.getAuth())
                .fileName(entity.getFileName())
                .role(entity.getRole())
                .build();
        return dto;
    }


}

