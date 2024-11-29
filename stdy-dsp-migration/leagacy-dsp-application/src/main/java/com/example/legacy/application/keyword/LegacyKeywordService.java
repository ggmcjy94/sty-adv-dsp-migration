package com.example.legacy.application.keyword;


import com.example.legacy.application.user.LegacyUserResult;
import com.example.legacy.domain.keyword.LegacyKeyword;
import com.example.legacy.domain.keyword.LegacyKeywordRepository;
import com.example.legacy.domain.user.LegacyUser;
import com.example.legacy.domain.user.LegacyUserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LegacyKeywordService {

    private final LegacyKeywordRepository legacyKeywordRepository;

    @Transactional
    public LegacyKeywordResult create(String text,
                                      Long adGroupId,
                                      Long userId) {
        LegacyKeyword legacyKeyword = LegacyKeyword.of(text,adGroupId,userId);
        return save(legacyKeyword);
    }

    private LegacyKeywordResult save(LegacyKeyword legacyKeyword) {
        LegacyKeyword save = legacyKeywordRepository.save(legacyKeyword);
        return LegacyKeywordResult.from(save);

    }

    public LegacyKeywordResult find(Long id) {
        return  LegacyKeywordResult.from(findById(id));
    }

    private LegacyKeyword findById(Long id) {
        return legacyKeywordRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public LegacyKeywordResult delete (Long id) {
        LegacyKeyword legacyKeyword = findById(id);
        legacyKeyword.delete();
        return save(legacyKeyword);
    }

}
