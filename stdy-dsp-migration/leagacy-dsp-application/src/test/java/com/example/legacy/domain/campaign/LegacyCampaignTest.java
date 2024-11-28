package com.example.legacy.domain.campaign;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LegacyCampaignTest {

    LegacyCampaign campaign = LegacyCampaign.of("campaign",1L,100L);



    @Test
    void updateBudget() throws InterruptedException {
        LocalDateTime before = LocalDateTime.now();
        Thread.sleep(10);
        campaign.updateBudget(200L);
        Thread.sleep(10);
        LocalDateTime after = LocalDateTime.now();
        assertAll(
                () -> assertThat(campaign.getBudget()).isEqualTo(200L),
                () -> assertThat(campaign.getUpdatedAt())
                        .isAfter(before)
                        .isBefore(after));

    }

}