package com.example.migration.application.legacyad.adgroup;

import com.example.migration.application.LegacyConverter;
import com.example.migration.domain.legacyad.adgroup.LegacyAdGroup;
import com.example.migration.domain.legacyad.campaign.LegacyCampaign;
import com.example.migration.domain.legacyad.campaign.LegacyCampaignRepository;
import com.example.migration.domain.recentad.campaign.RecentCampaign;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LegacyAdGroupConverter implements LegacyConverter<LegacyAdGroup, RecentCampaign> {

    private final LegacyCampaignRepository legacyCampaignRepository;

    @Override
    public RecentCampaign convert(LegacyAdGroup legacyAdGroup) {
        LegacyCampaign campaign = legacyCampaignRepository.findById(legacyAdGroup.getCampaignId()).orElseThrow(EntityNotFoundException::new);

        return RecentCampaign.migrated(legacyAdGroup.getId(),
                campaign.getName()+"_"+legacyAdGroup.getName()
                ,legacyAdGroup.getUserId()
                ,campaign.getBudget()
                ,legacyAdGroup.getLinkUrl()
                ,legacyAdGroup.getCreatedAt()
                ,legacyAdGroup.getUpdatedAt()
                ,legacyAdGroup.getDeletedAt()
        );
    }
}
