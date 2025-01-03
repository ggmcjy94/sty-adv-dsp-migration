package com.example.legacy.domain.adgroup.event;

import com.example.legacy.domain.adgroup.LegacyAdGroup;
import com.example.legacy.domain.campaign.LegacyCampaign;
import com.example.legacy.domain.campaign.event.LegacyCampaignEvent;

import java.time.LocalDateTime;

public class LegacyAdGroupNameUpdatedEvent extends LegacyAdGroupEvent {



    public LegacyAdGroupNameUpdatedEvent(LegacyAdGroup legacyAdGroup) {
        super(legacyAdGroup);
    }

    @Override
    public LocalDateTime occurredOn() {
        return legacyAdGroup.getUpdatedAt();
    }
}
