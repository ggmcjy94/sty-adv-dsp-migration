package com.example.migration.application.legacyad.user;

import com.example.migration.application.LegacyConverter;
import com.example.migration.domain.legacyad.user.LegacyUser;
import com.example.migration.domain.recentad.user.RecentUser;
import org.springframework.stereotype.Component;

@Component
public class LegacyUserConverter implements LegacyConverter<LegacyUser, RecentUser> {

    @Override
    public RecentUser convert(LegacyUser legacyUser) {
        return RecentUser.migrated(
                 legacyUser.getId()
                ,legacyUser.getName()
                ,legacyUser.getCreatedAt()
                ,legacyUser.getUpdatedAt()
                ,legacyUser.getDeletedAt()
        );
    }
}
