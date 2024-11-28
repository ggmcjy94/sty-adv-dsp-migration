package com.example.legacy.domain.adgroup;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class LegacyAdGroup {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long userId;
    private Long campaignId;
    private String linkUrl;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    private LegacyAdGroup(String name, Long userId, Long campaignId, String linkUrl, LocalDateTime createdAt) {
        this.name = name;
        this.userId = userId;
        this.campaignId = campaignId;
        this.linkUrl = linkUrl;
        this.createdAt = createdAt;
        this.updatedAt = createdAt;
        this.deletedAt = null;
    }

    public  static LegacyAdGroup of(String name, Long userId,Long campaignId, String linkUrl) {
        return new LegacyAdGroup(name,userId ,campaignId , linkUrl,LocalDateTime.now());
    }

    public void updateName(String newName) {
        name = newName;
        updatedAt = LocalDateTime.now();
    }


    public void delete() {
        deletedAt = LocalDateTime.now();
    }

}