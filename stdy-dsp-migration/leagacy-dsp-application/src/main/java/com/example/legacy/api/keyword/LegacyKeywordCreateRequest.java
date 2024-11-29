package com.example.legacy.api.keyword;

public record LegacyKeywordCreateRequest ( String text,
                                           Long adGroupId,
                                           Long userId){
}
