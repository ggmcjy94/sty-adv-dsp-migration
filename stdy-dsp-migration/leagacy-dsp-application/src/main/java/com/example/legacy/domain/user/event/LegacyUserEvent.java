package com.example.legacy.domain.user.event;

import com.example.legacy.domain.AggregateType;
import com.example.legacy.domain.DomainEvent;
import com.example.legacy.domain.user.LegacyUser;

import java.time.LocalDateTime;

public abstract class LegacyUserEvent  implements DomainEvent {

    protected LegacyUser legacyUser;

    public LegacyUserEvent(LegacyUser legacyUser) {
        this.legacyUser = legacyUser;
    }

    @Override
    public AggregateType aggregateType() {
        return AggregateType.USER;
    }

    @Override
    public Long aggregateId() {
        return legacyUser.getId();
    }

    @Override
    public abstract LocalDateTime occurredOn();

    @Override
    public Long ownerId() {
        return legacyUser.getId();
    }
}
