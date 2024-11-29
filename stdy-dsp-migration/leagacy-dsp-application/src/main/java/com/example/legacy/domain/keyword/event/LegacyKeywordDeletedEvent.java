package com.example.legacy.domain.keyword.event;

import com.example.legacy.domain.campaign.LegacyCampaign;
import com.example.legacy.domain.campaign.event.LegacyCampaignEvent;
import com.example.legacy.domain.keyword.LegacyKeyword;

import java.time.LocalDateTime;

public class LegacyKeywordDeletedEvent extends LegacyKeywordEvent {


    public LegacyKeywordDeletedEvent(LegacyKeyword legacyKeyword) {
        super(legacyKeyword);
    }

    @Override
    public LocalDateTime occurredOn() {
        return legacyKeyword.getDeletedAt();
    }
}
