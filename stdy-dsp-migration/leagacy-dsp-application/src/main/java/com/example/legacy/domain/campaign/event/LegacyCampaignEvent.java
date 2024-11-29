package com.example.legacy.domain.campaign.event;

import com.example.legacy.domain.AggregateType;
import com.example.legacy.domain.DomainEvent;
import com.example.legacy.domain.campaign.LegacyCampaign;
import com.example.legacy.domain.user.LegacyUser;

import java.time.LocalDateTime;

public abstract class LegacyCampaignEvent implements DomainEvent {

    protected LegacyCampaign legacyCampaign;

    public LegacyCampaignEvent(LegacyCampaign legacyCampaign) {
        this.legacyCampaign = legacyCampaign;
    }

    @Override
    public AggregateType aggregateType() {
        return AggregateType.CAMPAIGN;
    }

    @Override
    public Long aggregateId() {
        return legacyCampaign.getId();
    }

    @Override
    public abstract LocalDateTime occurredOn();

    @Override
    public Long ownerId() {
        return legacyCampaign.getId();
    }
}
