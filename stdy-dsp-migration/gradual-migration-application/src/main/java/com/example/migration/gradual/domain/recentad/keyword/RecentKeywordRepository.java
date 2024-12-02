package com.example.migration.gradual.domain.recentad.keyword;

import com.example.migration.gradual.domain.legacyad.keyword.LegacyKeyword;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecentKeywordRepository extends CrudRepository<RecentKeyword, Long> {
}
