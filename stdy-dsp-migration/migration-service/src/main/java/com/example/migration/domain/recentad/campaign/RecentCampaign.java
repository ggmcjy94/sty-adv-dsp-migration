package com.example.migration.gradual.domain.recentad.campaign;


import com.example.migration.gradual.domain.recentad.MigratedEntity;
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
public class RecentCampaign implements MigratedEntity {


    @Id
    private Long id;

    private String name;
    private Long userId;
    private Long budget;
    private String linkUrl;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    private LocalDateTime migratedAt;


    private RecentCampaign(Long id, String name,
                          Long userId, Long budget,
                          String linkUrl, LocalDateTime createdAt, LocalDateTime updatedAt,
                          LocalDateTime deletedAt, LocalDateTime migratedAt) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.budget = budget;
        this.linkUrl = linkUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.migratedAt = migratedAt;
    }



    public static RecentCampaign migrated(Long id, String name,
                                          Long userId, Long budget,
                                          String linkUrl, LocalDateTime createdAt, LocalDateTime updatedAt,
                                          LocalDateTime deletedAt) {


        return new RecentCampaign(id,name,userId,budget,linkUrl,createdAt,updatedAt,deletedAt,LocalDateTime.now());
    }
}
