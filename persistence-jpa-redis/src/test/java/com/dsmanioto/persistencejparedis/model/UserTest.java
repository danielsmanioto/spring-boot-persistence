package com.dsmanioto.persistencejparedis.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void createUser() {
        User user = User.builder()
                .userId(1)
                .name("Daniel Smanioto")
                .build();

        Assertions.assertEquals("Daniel Smanioto", user.getName());
        Assertions.assertEquals(1, user.getUserId());
    }

}
