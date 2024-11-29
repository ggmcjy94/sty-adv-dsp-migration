package com.example.legacy.domain.adgroup.event;

import com.example.legacy.domain.AggregateType;
import com.example.legacy.domain.DomainEvent;
import com.example.legacy.domain.adgroup.LegacyAdGroup;

import java.time.LocalDateTime;

public abstract class LegacyAdGroupEvent implements DomainEvent {

    protected LegacyAdGroup legacyAdGroup;

    public LegacyAdGroupEvent(LegacyAdGroup legacyAdGroup) {
        this.legacyAdGroup = legacyAdGroup;
    }

    @Override
    public AggregateType aggregateType() {
        return AggregateType.ADGROUP;
    }

    @Override
    public Long aggregateId() {
        return legacyAdGroup.getId();
    }

    @Override
    public abstract LocalDateTime occurredOn();

    @Override
    public Long ownerId() {
        return legacyAdGroup.getId();
    }
}
