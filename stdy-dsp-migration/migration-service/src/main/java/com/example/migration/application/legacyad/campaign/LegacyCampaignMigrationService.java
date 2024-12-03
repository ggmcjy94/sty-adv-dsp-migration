package com.example.migration.application.legacyad.campaign;

import com.example.migration.application.LegacyMigrationService;
import com.example.migration.application.legacyad.adgroup.LegacyAdGroupMigrationService;
import com.example.migration.domain.legacyad.adgroup.LegacyAdGroup;
import com.example.migration.domain.legacyad.adgroup.LegacyAdGroupRepository;
import com.example.migration.domain.legacyad.campaign.LegacyCampaign;
import com.example.migration.domain.recentad.campaign.RecentCampaign;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class LegacyCampaignMigrationService extends LegacyMigrationService<LegacyCampaign, RecentCampaign> {

    private final LegacyAdGroupRepository legacyAdGroupRepository;
    private final LegacyAdGroupMigrationService legacyAdGroupMigrationService;

    public LegacyCampaignMigrationService(
            CrudRepository<LegacyCampaign, Long> legacyRepository
            , CrudRepository<RecentCampaign, Long> recentRepository, LegacyAdGroupRepository legacyAdGroupRepository, LegacyAdGroupMigrationService legacyAdGroupMigrationService) {
        super(legacyRepository, null, recentRepository);
        this.legacyAdGroupRepository = legacyAdGroupRepository;
        this.legacyAdGroupMigrationService = legacyAdGroupMigrationService;
    }

    @Override
    protected void migrate(LegacyCampaign legacyCampaign) {
        for (LegacyAdGroup legacyAdGroup: legacyAdGroupRepository.findAllByCampaignIdAndDeletedAtIsNull(legacyCampaign.getId())) {
            legacyAdGroupMigrationService.migrate(legacyAdGroup.getId());
        }
    }
}
