package com.example.migration.application.legacyad.user;

import com.example.migration.application.LegacyMigrationService;
import com.example.migration.domain.legacyad.user.LegacyUser;
import com.example.migration.domain.legacyad.user.LegacyUserRepository;
import com.example.migration.domain.recentad.user.RecentUser;
import com.example.migration.domain.recentad.user.RecentUserRepository;
import org.springframework.stereotype.Service;

@Service
public class LegacyUserMigrationService extends LegacyMigrationService<LegacyUser, RecentUser> {

    public LegacyUserMigrationService(
            LegacyUserRepository legacyRepository
            , LegacyUserConverter converter
            , RecentUserRepository recentRepository) {
        super(legacyRepository, converter, recentRepository);
    }
}
