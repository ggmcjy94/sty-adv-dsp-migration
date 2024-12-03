package com.example.migration.application.dispatcher;


import com.example.migration.application.MigrationService;
import com.example.migration.application.legacyad.adgroup.LegacyAdGroupMigrationService;
import com.example.migration.application.legacyad.campaign.LegacyCampaignMigrationService;
import com.example.migration.application.legacyad.keyword.LegacyKeywordMigrationService;
import com.example.migration.application.legacyad.user.LegacyUserMigrationService;
import com.example.migration.domain.AggregateType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MigrationDispatcher {


    private final LegacyUserMigrationService userMigrationService;
    private final LegacyCampaignMigrationService campaignMigrationService;
    private final LegacyAdGroupMigrationService adGroupMigrationService;
    private final LegacyKeywordMigrationService keywordMigrationService;


    public boolean dispatch(Long aggregateId, AggregateType aggregateType) {
        return migrate(aggregateId, aggregateType);
    }

    private boolean migrate(Long aggregateId, AggregateType aggregateType) {
        MigrationService service = switch (aggregateType) {
            case USER -> userMigrationService;
            case CAMPAIGN ->  campaignMigrationService;
            case ADGROUP ->  adGroupMigrationService;
            case KEYWORD -> keywordMigrationService;
        };
        boolean result = service.migrate(aggregateId);
        logMigrationResult(aggregateId, aggregateType, result);
        return result;
    }

    private void logMigrationResult(Long aggregateId, AggregateType aggregateType, boolean result) {
        if (result) {
            log.info("{}", LegacyMigrationLog.success(aggregateType, aggregateId));
        } else {
           log.error("{}", LegacyMigrationLog.fail(aggregateType, aggregateId));
        }
    }

}
