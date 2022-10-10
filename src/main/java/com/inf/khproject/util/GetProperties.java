package com.inf.khproject.util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter

public class GetProperties {
    @Value("${google.id}")
    private String id;

    @Value("${google.pw}")
    private String pw;
}
