package com.example.migration.gradual.domain.recentad.campaign;

import com.example.migration.gradual.domain.legacyad.campaign.LegacyCampaign;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecentCampaignRepository extends CrudRepository<RecentCampaign, Long> {
}
