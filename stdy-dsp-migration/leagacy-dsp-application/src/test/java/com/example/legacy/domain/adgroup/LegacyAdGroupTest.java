package com.example.legacy.domain.adgroup;

import com.example.legacy.domain.campaign.LegacyCampaign;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LegacyAdGroupTest {


    LegacyAdGroup legacyAdGroup = LegacyAdGroup.of("legacyAdGroup",1L,1L,"link");

    @Test
    void updateLinkUrl() throws InterruptedException {
        LocalDateTime before = LocalDateTime.now();
        Thread.sleep(10);
        legacyAdGroup.updateLinkUrl("newLinkUrl");
        Thread.sleep(10);
        LocalDateTime after = LocalDateTime.now();
        assertAll(
                () -> assertThat(legacyAdGroup.getLinkUrl()).isEqualTo("newLinkUrl"),
                () -> assertThat(legacyAdGroup.getUpdatedAt())
                        .isAfter(before)
                        .isBefore(after));

    }

}