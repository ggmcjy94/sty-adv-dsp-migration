package com.example.migration.application.legacyad.keyword;

import com.example.migration.application.LegacyMigrationService;
import com.example.migration.domain.legacyad.keyword.LegacyKeyword;
import com.example.migration.domain.legacyad.keyword.LegacyKeywordRepository;
import com.example.migration.domain.recentad.keyword.RecentKeyword;
import com.example.migration.domain.recentad.keyword.RecentKeywordRepository;
import org.springframework.stereotype.Service;

@Service
public class LegacyKeywordMigrationService extends LegacyMigrationService<LegacyKeyword, RecentKeyword> {

    public LegacyKeywordMigrationService(
            LegacyKeywordRepository legacyRepository
            , LegacyKeywordConverter converter
            , RecentKeywordRepository recentRepository) {
        super(legacyRepository, converter, recentRepository);
    }
}
