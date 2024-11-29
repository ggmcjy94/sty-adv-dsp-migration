package com.example.legacy.api.adgroup;

import com.example.legacy.application.adgroup.LegacyAdGroupService;
import com.example.legacy.application.user.LegacyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/adgroup/v1")
public class LegacyAdGroupController {

    private final LegacyAdGroupService service;


}
