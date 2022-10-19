package com.inf.khproject.security.dto;

import com.inf.khproject.entity.Member;
import com.inf.khproject.entity.MemberRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@Getter
@Builder
public class OAuthDTO {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String nickname;
    private String email;
    private String fileName;

    public OAuthDTO(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String picture) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.nickname = name;
        this.email = email;
        this.fileName = picture;
    }

    public static OAuthDTO of(String registrationId,
                                     String userNameAttributeName,
                                     Map<String, Object> attributes) {
        if (registrationId.equals("kakao")) {
            return ofKakao(userNameAttributeName, attributes);
        } else if (registrationId.equals("naver")) {
            return ofNaver(userNameAttributeName,attributes);
        }

        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthDTO ofGoogle(String userNameAttributeName,
                                            Map<String, Object> attributes) {
        return new OAuthDTO(attributes,
                userNameAttributeName,
                (String) attributes.get("name"),
                (String) attributes.get("email"),
                (String) attributes.get("picture"));
    }

    private static OAuthDTO ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> kakao_account = (Map<String, Object>) attributes.get("kakao_account");  // 카카오로 받은 데이터에서 계정 정보가 담긴 kakao_account 값을 꺼낸다.
        Map<String, Object> profile = (Map<String, Object>) kakao_account.get("profile");   // 마찬가지로 profile(nickname, image_url.. 등) 정보가 담긴 값을 꺼낸다.

        return new OAuthDTO(attributes,
                userNameAttributeName,
                (String) profile.get("nickname"),
                (String) kakao_account.get("email"),
                (String) profile.get("profile_image_url"));
    }

    private static OAuthDTO ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");    // 네이버에서 받은 데이터에서 프로필 정보다 담긴 response 값을 꺼낸다.

        return new OAuthDTO(attributes,
                userNameAttributeName,
                (String) response.get("name"),
                (String) response.get("email"),
                (String) response.get("profile_image"));
    }

    public Member toEntity() {
        return Member.builder()
                .nickname(nickname)
                .email(email)
                .fileName(fileName)
                .role(MemberRole.ROLE_INDIVIDUAL)
                .isSocial(true)
                .build();
    }



}
