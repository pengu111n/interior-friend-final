package com.inf.khproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public enum MemberRole {

    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_COMPANY("ROLE_COMPANY"),
    ROLE_INDIVIDUAL("ROLE_INDIVIDUAL");

    private final String value;

}
