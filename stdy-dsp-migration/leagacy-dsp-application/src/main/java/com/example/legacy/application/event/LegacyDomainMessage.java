package com.example.legacy.application.event;

import com.example.legacy.domain.AggregateType;
import com.example.legacy.domain.DomainEvent;

import java.time.LocalDateTime;

public record LegacyDomainMessage(AggregateType aggregateType, Long aggregateId,Long ownerId, LocalDateTime occurredOn) {

    public static LegacyDomainMessage from(DomainEvent domainEvent) {
        return new LegacyDomainMessage(domainEvent.aggregateType()
        ,domainEvent.aggregateId(),domainEvent.ownerId(),domainEvent.occurredOn());
    }
}
