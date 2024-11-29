package com.example.legacy.domain.keyword.event;

import com.example.legacy.domain.AggregateType;
import com.example.legacy.domain.DomainEvent;
import com.example.legacy.domain.campaign.LegacyCampaign;
import com.example.legacy.domain.keyword.LegacyKeyword;

import java.time.LocalDateTime;

public abstract class LegacyKeywordEvent implements DomainEvent {

    protected LegacyKeyword legacyKeyword;

    public LegacyKeywordEvent(LegacyKeyword legacyKeyword) {
        this.legacyKeyword = legacyKeyword;
    }

    @Override
    public AggregateType aggregateType() {
        return AggregateType.KEYWORD;
    }

    @Override
    public Long aggregateId() {
        return legacyKeyword.getId();
    }

    @Override
    public abstract LocalDateTime occurredOn();

    @Override
    public Long ownerId() {
        return legacyKeyword.getId();
    }
}
