package com.example.legacy.domain.campaign.event;

import com.example.legacy.domain.campaign.LegacyCampaign;

import java.time.LocalDateTime;

public class LegacyCampaignDeletedEvent extends LegacyCampaignEvent {


    public LegacyCampaignDeletedEvent(LegacyCampaign legacyCampaign) {
        super(legacyCampaign);
    }

    @Override
    public LocalDateTime occurredOn() {
        return legacyCampaign.getDeletedAt();
    }
}
