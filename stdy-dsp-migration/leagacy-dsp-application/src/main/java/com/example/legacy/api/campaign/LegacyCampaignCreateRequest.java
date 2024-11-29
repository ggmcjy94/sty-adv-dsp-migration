package com.example.legacy.api.campaign;

public record LegacyCampaignCreateRequest(String name,
                                          Long userId,
                                          Long budget) {
}
