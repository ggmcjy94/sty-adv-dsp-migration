package com.example.legacy.application.keyword;

import com.example.legacy.domain.adgroup.LegacyAdGroup;
import com.example.legacy.domain.keyword.LegacyKeyword;

import java.time.LocalDateTime;

public record LegacyKeywordResult(
        Long id,
        String text,
        Long adGroupId,
        Long userId,
        LocalDateTime createdAt,
        LocalDateTime deletedAt) {

    public static LegacyKeywordResult from(LegacyKeyword keyword) {
        return new LegacyKeywordResult(
                keyword.getId(),
                keyword.getText(),
                keyword.getAdGroupId(),
                keyword.getUserId(),
                keyword.getCreatedAt(),
                keyword.getDeletedAt()
        );
    }
}
