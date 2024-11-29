package com.example.legacy.api.keyword;


import com.example.legacy.application.keyword.LegacyKeywordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/keyword/v1")
public class LegacyKeywordController {

    private final LegacyKeywordService service;

    @PostMapping("")
    public LegacyKeywordResp create(@RequestBody LegacyKeywordCreateRequest req) {
        return LegacyKeywordResp.from(service.create(req.text(), req.adGroupId(), req.userId()));
    }

    @GetMapping("/{id}")
    public LegacyKeywordResp find(@PathVariable("id") Long id) {
        return LegacyKeywordResp.from(service.find(id));
    }
    

    @DeleteMapping("/{id}")
    public LegacyKeywordResp delete(@PathVariable("id") Long id) {
        return LegacyKeywordResp.from(service.delete(id));
    }
}
