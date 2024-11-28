package com.example.legacy.domain.keyword;


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
public class LegacyKeyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    private LegacyKeyword(String name, LocalDateTime createdAt) {
        this.text = name;
        this.createdAt = createdAt;
        this.updatedAt = createdAt;
        this.deletedAt = null;
    }
    public  static LegacyKeyword of(String text) {
        return new LegacyKeyword(text,LocalDateTime.now());
    }
    public void updateName(String newName) {
        text = newName;
        updatedAt = LocalDateTime.now();
    }

    public void delete() {
        deletedAt = LocalDateTime.now();
    }

}
