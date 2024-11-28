package com.example.legacy.domain.user;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LegacyUserTest {

    LegacyUser user = LegacyUser.of("name");

    @Test
    void updateName () throws InterruptedException {
        LocalDateTime before = LocalDateTime.now();
        Thread.sleep(10);
        user.updateName("newName");
        Thread.sleep(10);
        LocalDateTime after = LocalDateTime.now();
        assertAll(
                () -> assertThat(user.getName()).isEqualTo("newName"),
                () -> assertThat(user.getUpdatedAt())
                        .isAfter(before)
                        .isBefore(after));
    }



    @Test
    void delete () throws InterruptedException {
        LocalDateTime before = LocalDateTime.now();
        Thread.sleep(10);
        user.delete();
        Thread.sleep(10);
        LocalDateTime after = LocalDateTime.now();

        assertThat(user.getDeletedAt())
                .isAfter(before)
                .isBefore(after);
    }

}