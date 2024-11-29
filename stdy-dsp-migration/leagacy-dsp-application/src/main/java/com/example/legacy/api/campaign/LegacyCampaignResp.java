package com.example.legacy.api.campaign;

import com.example.legacy.application.campaign.LegacyCampaignResult;
import com.example.legacy.domain.campaign.LegacyCampaign;

import java.time.LocalDateTime;

public record LegacyCampaignResp(
        Long id,
        String name,
        Long userId,
        Long budget,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime deletedAt) {

    public static LegacyCampaignResp from(LegacyCampaignResult campaign) {
        return new LegacyCampaignResp(
                campaign.id(),
                campaign.name(),
                campaign.userId(),
                campaign.budget(),
                campaign.createdAt(),
                campaign.updatedAt(),
                campaign.deletedAt()
        );
    }
}
