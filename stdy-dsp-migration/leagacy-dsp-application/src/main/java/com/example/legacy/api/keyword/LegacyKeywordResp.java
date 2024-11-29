package com.example.legacy.api.keyword;

import com.example.legacy.application.keyword.LegacyKeywordResult;
import com.example.legacy.domain.keyword.LegacyKeyword;

import java.time.LocalDateTime;

public record LegacyKeywordResp(
        Long id,
        String text,
        Long adGroupId,
        Long userId,
        LocalDateTime createdAt,
        LocalDateTime deletedAt) {

    public static LegacyKeywordResp from(LegacyKeywordResult keyword) {
        return new LegacyKeywordResp(
                keyword.id(),
                keyword.text(),
                keyword.adGroupId(),
                keyword.userId(),
                keyword.createdAt(),
                keyword.deletedAt()
        );
    }
}
