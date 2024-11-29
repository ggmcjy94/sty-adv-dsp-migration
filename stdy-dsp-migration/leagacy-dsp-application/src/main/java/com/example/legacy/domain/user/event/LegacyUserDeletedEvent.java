package com.example.legacy.domain.user.event;

import com.example.legacy.domain.user.LegacyUser;

import java.time.LocalDateTime;

public class LegacyUserDeletedEvent extends LegacyUserEvent{

    public LegacyUserDeletedEvent(LegacyUser legacyUser) {
        super(legacyUser);
    }

    @Override
    public LocalDateTime occurredOn() {
        return legacyUser.getDeletedAt();
    }
}
