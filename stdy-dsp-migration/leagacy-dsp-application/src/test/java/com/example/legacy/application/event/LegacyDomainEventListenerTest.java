package com.example.legacy.application.event;

import com.example.legacy.application.adgroup.LegacyAdGroupResult;
import com.example.legacy.application.adgroup.LegacyAdGroupService;
import com.example.legacy.application.campaign.LegacyCampaignResult;
import com.example.legacy.application.campaign.LegacyCampaignService;
import com.example.legacy.application.keyword.LegacyKeywordResult;
import com.example.legacy.application.keyword.LegacyKeywordService;
import com.example.legacy.application.user.LegacyUserResult;
import com.example.legacy.application.user.LegacyUserService;
import com.example.legacy.domain.DomainEvent;
import com.example.legacy.domain.adgroup.event.*;
import com.example.legacy.domain.campaign.event.*;
import com.example.legacy.domain.keyword.LegacyKeyword;
import com.example.legacy.domain.keyword.event.LegacyKeywordCreatedEvent;
import com.example.legacy.domain.keyword.event.LegacyKeywordDeletedEvent;
import com.example.legacy.domain.keyword.event.LegacyKeywordEvent;
import com.example.legacy.domain.user.event.LegacyUserCreatedEvent;
import com.example.legacy.domain.user.event.LegacyUserDeletedEvent;
import com.example.legacy.domain.user.event.LegacyUserEvent;
import com.example.legacy.domain.user.event.LegacyUserNameUpdatedEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class LegacyDomainEventListenerTest {


    @Autowired
    LegacyUserService userService;
    @Autowired
    LegacyCampaignService campaignService;
    @Autowired
    LegacyAdGroupService adGroupService;
    @Autowired
    LegacyKeywordService keywordService;

    @MockBean
    LegacyDomainEventListener eventListener;


    @Test
    void userEvent() {
        LegacyUserResult result = userService.create("사용자");
        userService.updateName(result.id(), "사용자2");
        userService.delete(result.id());

        assertAll(
                () -> verify(eventListener, times(3)).handleEvent(any(DomainEvent.class)),
                () -> verify(eventListener, times(3)).handleEvent(any(LegacyUserEvent.class)),
                () -> verify(eventListener, times(1)).handleEvent(any(LegacyUserCreatedEvent.class)),
                () -> verify(eventListener, times(1)).handleEvent(any(LegacyUserNameUpdatedEvent.class)),
                () -> verify(eventListener, times(1)).handleEvent(any(LegacyUserDeletedEvent.class))
        );

    }


    @Test
    void userCampaign() {
        LegacyCampaignResult result = campaignService.create("사용자1", 1L, 100L);
        campaignService.updateName(result.id(), "사용자2");
        campaignService.updateBudget(result.id(), 123L);
        campaignService.delete(result.id());


        assertAll(
                () -> verify(eventListener, times(4)).handleEvent(any(DomainEvent.class)),
                () -> verify(eventListener, times(4)).handleEvent(any(LegacyCampaignEvent.class)),
                () -> verify(eventListener, times(1)).handleEvent(any(LegacyCampaignCreatedEvent.class)),
                () -> verify(eventListener, times(1)).handleEvent(any(LegacyCampaignNameUpdatedEvent.class)),
                () -> verify(eventListener, times(1)).handleEvent(any(LegacyCampaignBudgetUpdatedEvent.class)),
                () -> verify(eventListener, times(1)).handleEvent(any(LegacyCampaignDeletedEvent.class))
        );

    }

    @Test
    void adGroupEvent() {
        LegacyAdGroupResult result = adGroupService.create("사용자1", 1L, 1L, "http:ssss");
        adGroupService.updateName(result.id(), "사용자2");
        adGroupService.updateLinkUrl(result.id(), "http:qqqq");
        adGroupService.delete(result.id());

        assertAll(
                () -> verify(eventListener, times(4)).handleEvent(any(DomainEvent.class)),
                () -> verify(eventListener, times(4)).handleEvent(any(LegacyAdGroupEvent.class)),
                () -> verify(eventListener, times(1)).handleEvent(any(LegacyAdGroupCreatedEvent.class)),
                () -> verify(eventListener, times(1)).handleEvent(any(LegacyAdGroupNameUpdatedEvent.class)),
                () -> verify(eventListener, times(1)).handleEvent(any(LegacyAdGroupLinkUrlUpdatedEvent.class)),
                () -> verify(eventListener, times(1)).handleEvent(any(LegacyAdGroupDeletedEvent.class))
        );

    }

    @Test
    void keywordEvent() {
        LegacyKeywordResult result = keywordService.create("text", 1L, 1L);
        keywordService.delete(result.id());

        assertAll(
                () -> verify(eventListener, times(2)).handleEvent(any(DomainEvent.class)),
                () -> verify(eventListener, times(2)).handleEvent(any(LegacyKeywordEvent.class)),
                () -> verify(eventListener, times(1)).handleEvent(any(LegacyKeywordCreatedEvent.class)),
                () -> verify(eventListener, times(1)).handleEvent(any(LegacyKeywordDeletedEvent.class))
        );

    }


}