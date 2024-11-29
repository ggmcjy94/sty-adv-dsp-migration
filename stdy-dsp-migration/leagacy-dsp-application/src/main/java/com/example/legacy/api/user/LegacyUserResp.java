package com.example.legacy.api.user;

import com.example.legacy.application.user.LegacyUserResult;
import com.example.legacy.domain.user.LegacyUser;

import java.time.LocalDateTime;

public record LegacyUserResp(
        Long id,
        String name,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime deletedAt) {

    public static LegacyUserResp from(LegacyUserResult user) {
        return new LegacyUserResp(user.id(),user.name(),user.createdAt(),
                user.updatedAt(),user.deletedAt());
    }
}
