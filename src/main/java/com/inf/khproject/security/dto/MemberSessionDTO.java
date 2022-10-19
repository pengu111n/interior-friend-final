package com.inf.khproject.security.dto;

import com.inf.khproject.dto.MemberDTO;
import com.inf.khproject.entity.Member;
import com.inf.khproject.entity.MemberRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@Setter
public class MemberSessionDTO implements Serializable {

    private String nickname;
    private String email;
    private String fileName;

    public MemberSessionDTO(Member entity) {
        this.nickname = entity.getNickname();
        this.email = entity.getEmail();
        this.fileName = entity.getFileName();
    }


}
