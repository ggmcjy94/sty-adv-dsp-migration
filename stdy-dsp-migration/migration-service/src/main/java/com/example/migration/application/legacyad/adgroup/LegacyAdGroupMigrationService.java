package com.example.migration.application.legacyad.adgroup;

import com.example.migration.application.LegacyMigrationService;
import com.example.migration.domain.legacyad.adgroup.LegacyAdGroup;
import com.example.migration.domain.legacyad.adgroup.LegacyAdGroupRepository;
import com.example.migration.domain.recentad.campaign.RecentCampaign;
import com.example.migration.domain.recentad.campaign.RecentCampaignRepository;
import org.springframework.stereotype.Service;

@Service
public class LegacyAdGroupMigrationService extends LegacyMigrationService<LegacyAdGroup,RecentCampaign> {

    public LegacyAdGroupMigrationService(LegacyAdGroupRepository legacyRepository
            , LegacyAdGroupConverter converter
            , RecentCampaignRepository recentRepository) {
        super(legacyRepository, converter, recentRepository);
    }
}
