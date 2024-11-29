package com.example.legacy.application.adgroup;

import com.example.legacy.domain.adgroup.LegacyAdGroup;
import com.example.legacy.domain.campaign.LegacyCampaign;

import java.time.LocalDateTime;

public record LegacyAdGroupResult(
        Long id,
        String name,
        Long userId,
        Long campaignId,
        String linkUrl,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime deletedAt) {

    public static LegacyAdGroupResult from(LegacyAdGroup adGroup) {
        return new LegacyAdGroupResult(
                adGroup.getId(),
                adGroup.getName(),
                adGroup.getUserId(),
                adGroup.getCampaignId(),
                adGroup.getLinkUrl(),
                adGroup.getCreatedAt(),
                adGroup.getUpdatedAt(),
                adGroup.getDeletedAt()
        );
    }
}
