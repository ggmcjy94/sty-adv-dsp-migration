package com.example.migration.gradual.domain.legacyad.keyword;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class LegacyKeyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Long adGroupId;
    private Long userId;

    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;



}
