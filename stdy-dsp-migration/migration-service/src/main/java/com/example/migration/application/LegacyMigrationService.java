package com.example.migration.application;

import com.example.migration.domain.legacyad.DeletableEntity;
import com.example.migration.domain.recentad.MigratedEntity;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;

@Slf4j
public abstract class LegacyMigrationService<Legacy extends DeletableEntity, Recent extends MigratedEntity> implements MigrationService{

    protected CrudRepository<Legacy, Long> legacyRepository;
    protected LegacyConverter<Legacy ,Recent> converter;
    protected CrudRepository<Recent, Long> recentRepository;


    public LegacyMigrationService(CrudRepository<Legacy, Long> legacyRepository, LegacyConverter<Legacy, Recent> converter, CrudRepository<Recent, Long> recentRepository) {
        this.legacyRepository = legacyRepository;
        this.converter = converter;
        this.recentRepository = recentRepository;
    }

    @Override
    public boolean migrate(Long id) {
        try {
            Legacy legacy = findLegacy(id);
            migrate(legacy);

            return true;
        } catch (RuntimeException e) {
            log.error("migration error",e);
            return false;
        }

    }

    protected void migrate(Legacy legacy) {
        if (legacy.isDeleted()) {
            deleteRecent(legacy.getId());
        } else {
            saveRecent(convert(legacy));
        }
    }

    private void deleteRecent(Long id) {
        recentRepository.findById(id)
                .ifPresent(recent -> recentRepository.delete(recent));
    }

    private Legacy findLegacy(Long id) {
        return legacyRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    private Recent convert(Legacy legacy) {
        return converter.convert(legacy);
    }

    private void saveRecent(Recent convert) {
        recentRepository.save(convert);
    }
}
