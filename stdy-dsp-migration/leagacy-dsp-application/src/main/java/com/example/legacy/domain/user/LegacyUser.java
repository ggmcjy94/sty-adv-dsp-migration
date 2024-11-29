package com.example.legacy.domain.user;


import com.example.legacy.domain.user.event.LegacyUserCreateEvent;
import com.example.legacy.domain.user.event.LegacyUserDeleteEvent;
import com.example.legacy.domain.user.event.LegacyUserNameUpdateEvent;
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
public class LegacyUser extends AbstractAggregateRoot<LegacyUser> {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    private LegacyUser(String name, LocalDateTime createdAt) {
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = createdAt;
        this.deletedAt = null;
        registerEvent(new LegacyUserCreateEvent(this));
    }

    public  static LegacyUser of(String name) {
        return new LegacyUser(name, LocalDateTime.now());
    }

    public void updateName(String newName) {
        name = newName;
        updatedAt = LocalDateTime.now();
        registerEvent(new LegacyUserNameUpdateEvent(this));
    }

    public void delete() {
        deletedAt = LocalDateTime.now();
        registerEvent(new LegacyUserDeleteEvent(this));
    }
}
