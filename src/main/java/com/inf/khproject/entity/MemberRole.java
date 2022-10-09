package com.inf.khproject.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberRole {

    ADMIN("ROLE_ADMIN"),
    COMPANY("ROLE_COMPANY"),
    INDIVIDUAL("ROLE_INDIVIDUAL");

    private final String value;

}
