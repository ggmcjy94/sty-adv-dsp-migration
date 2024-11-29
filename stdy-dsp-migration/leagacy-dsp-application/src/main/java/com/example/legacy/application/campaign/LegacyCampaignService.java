package com.example.legacy.application.campaign;


import com.example.legacy.domain.campaign.LegacyCampaign;
import com.example.legacy.domain.campaign.LegacyCampaignRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LegacyCampaignService {

    private final LegacyCampaignRepository legacyCampaignRepository;


    @Transactional
    public LegacyCampaignResult create(String name, Long userId, Long budget ) {
        LegacyCampaign legacyCampaign = LegacyCampaign.of(name, userId, budget);
        return save(legacyCampaign);
    }

    private LegacyCampaignResult save(LegacyCampaign legacyCampaign) {
        LegacyCampaign save = legacyCampaignRepository.save(legacyCampaign);
        return LegacyCampaignResult.from(save);

    }


    public LegacyCampaignResult find(Long id) {
        return  LegacyCampaignResult.from(findById(id));
    }

    private LegacyCampaign findById(Long id) {
        return legacyCampaignRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public LegacyCampaignResult updateName(Long id, String name) {
        LegacyCampaign Campaign = findById(id);
        Campaign.updateName(name);
        return save(Campaign);
    }
    @Transactional
    public LegacyCampaignResult updateBudget(Long id, Long budget) {
        LegacyCampaign Campaign = findById(id);
        Campaign.updateBudget(budget);
        return save(Campaign);
    }



    @Transactional
    public LegacyCampaignResult delete (Long id) {
        LegacyCampaign Campaign = findById(id);
        Campaign.delete();
        return save(Campaign);
    }

}
