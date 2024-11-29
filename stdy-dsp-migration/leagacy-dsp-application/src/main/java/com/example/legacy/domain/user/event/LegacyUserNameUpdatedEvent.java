package com.example.legacy.domain.user.event;

import com.example.legacy.domain.user.LegacyUser;

import java.time.LocalDateTime;

public class LegacyUserNameUpdatedEvent extends LegacyUserEvent{

    public LegacyUserNameUpdatedEvent(LegacyUser legacyUser) {
        super(legacyUser);
    }

    @Override
    public LocalDateTime occurredOn() {
        return legacyUser.getUpdatedAt();
    }
}
