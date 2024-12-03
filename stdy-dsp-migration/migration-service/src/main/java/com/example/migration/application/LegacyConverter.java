package com.example.migration.application;

import com.example.migration.domain.legacyad.DeletableEntity;
import com.example.migration.domain.recentad.MigratedEntity;

public interface LegacyConverter <Legacy extends DeletableEntity, Recent extends MigratedEntity>{

    Recent convert (Legacy legacy);

}
