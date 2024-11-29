package com.example.legacy.api.user;

import com.example.legacy.application.user.LegacyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/v1")
public class LegacyUserController {

    private final LegacyUserService service;


    @PostMapping("")
    public LegacyUserResp create(@RequestBody LegacyUserCreateRequest req) {
        return LegacyUserResp.from(service.create(req.name()));
    }

    @GetMapping("/{id}")
    public LegacyUserResp find(@PathVariable("id") Long id) {
        return LegacyUserResp.from(service.find(id));
    }

    @PatchMapping("/name")
    public LegacyUserResp updateName(@RequestBody LegacyUserUpdateNameRequest req) {
        return LegacyUserResp.from(service.updateName(req.id(), req.name()));
    }

    @DeleteMapping("/{id}")
    public LegacyUserResp delete(@PathVariable("id") Long id) {
        return LegacyUserResp.from(service.delete(id));
    }

}
