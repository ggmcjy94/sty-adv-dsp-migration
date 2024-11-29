package com.example.legacy.application.user;

import com.example.legacy.domain.user.LegacyUser;

import java.time.LocalDateTime;

public record LegacyUserResult(
        Long id,
        String name,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime deletedAt) {

    public static LegacyUserResult from(LegacyUser user) {
        return new LegacyUserResult(user.getId(),user.getName(),user.getCreatedAt(),
                user.getUpdatedAt(),user.getDeletedAt());
    }
}
