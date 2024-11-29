package com.example.legacy.application.adgroup;


import com.example.legacy.domain.adgroup.LegacyAdGroup;
import com.example.legacy.domain.adgroup.LegacyAdGroupRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LegacyAdGroupService {

    private final LegacyAdGroupRepository legacyAdGroupRepository;

    @Transactional
    public LegacyAdGroupResult create(String name, Long userId, Long campaignId, String linkUrl) {
        LegacyAdGroup legacyAdGroup = LegacyAdGroup.of(name, userId, campaignId, linkUrl);
        return save(legacyAdGroup);
    }

    private LegacyAdGroupResult save(LegacyAdGroup legacyAdGroup) {
        LegacyAdGroup save = legacyAdGroupRepository.save(legacyAdGroup);
        return LegacyAdGroupResult.from(save);

    }


    public LegacyAdGroupResult find(Long id) {
        return  LegacyAdGroupResult.from(findById(id));
    }

    private LegacyAdGroup findById(Long id) {
        return legacyAdGroupRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public LegacyAdGroupResult updateName(Long id, String name) {
        LegacyAdGroup adGroup = findById(id);
        adGroup.updateName(name);
        return save(adGroup);
    }

    @Transactional
    public LegacyAdGroupResult updateLinkUrl(Long id, String linkUrl) {
        LegacyAdGroup adGroup = findById(id);
        adGroup.updateLinkUrl(linkUrl);
        return save(adGroup);
    }

    @Transactional
    public LegacyAdGroupResult delete(Long id) {
        LegacyAdGroup adGroup = findById(id);
        adGroup.delete();
        return save(adGroup);
    }

}
