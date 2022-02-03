package com.danielsoo.blog_daniel.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자"),
    FAMILY("ROLE_FAMILY", "가족");

    private final String key;
    private final String title;
}