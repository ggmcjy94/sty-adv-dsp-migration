package com.example.legacy.api.campaign;


import com.example.legacy.application.campaign.LegacyCampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/campaign/v1")
public class LegacyCampaignController {

    private final LegacyCampaignService service;


    @PostMapping("")
    public LegacyCampaignResp create(@RequestBody LegacyCampaignCreateRequest req) {
        return LegacyCampaignResp.from(service.create(req.name(),req.userId(),req.budget()));
    }

    @GetMapping("/{id}")
    public LegacyCampaignResp find(@PathVariable("id") Long id) {
        return LegacyCampaignResp.from(service.find(id));
    }

    @PatchMapping("/name")
    public LegacyCampaignResp updateName(@RequestBody LegacyCampaignUpdateNameRequest req) {
        return LegacyCampaignResp.from(service.updateName(req.id(), req.name()));
    }

    @PatchMapping("/budget")
    public LegacyCampaignResp updateName(@RequestBody LegacyCampaignUpdateBudgetRequest req) {
        return LegacyCampaignResp.from(service.updateBudget(req.id(), req.budget()));
    }

    @DeleteMapping("/{id}")
    public LegacyCampaignResp delete(@PathVariable("id") Long id) {
        return LegacyCampaignResp.from(service.delete(id));
    }

}
