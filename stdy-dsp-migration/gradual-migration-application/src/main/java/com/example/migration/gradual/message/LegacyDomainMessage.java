package com.example.migration.gradual.message;



import com.example.migration.domain.AggregateType;

import java.time.LocalDateTime;

public record LegacyDomainMessage(AggregateType aggregateType, Long aggregateId, Long ownerId, LocalDateTime occurredOn) {


}
