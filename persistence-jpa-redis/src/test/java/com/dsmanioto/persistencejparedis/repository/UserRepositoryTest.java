package com.dsmanioto.persistencejparedis.repository;

import com.dsmanioto.persistencejparedis.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void createOneUser() {
        User user = User.builder()
                .userId(1)
                .name("Daniel")
                .build();
        User userCreated = repository.save(user);

        Assertions.assertEquals(1, userCreated.getUserId());
        Assertions.assertEquals("Daniel", userCreated.getName());
    }

    @Test
    public void findUserById() {
        User userCreated = repository.save(User.builder()
                .userId(1)
                .name("Daniel")
                .build());
        Assertions.assertNotNull(userCreated);

        User user = repository.findUserById(1);

        Assertions.assertNotNull(user);
        Assertions.assertEquals(1, user.getUserId());
        Assertions.assertEquals("Daniel", user.getName());
    }

}
