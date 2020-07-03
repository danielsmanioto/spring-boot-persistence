package com.dsmanioto.persistencejparedis.controller;

import com.dsmanioto.persistencejparedis.model.User;
import com.dsmanioto.persistencejparedis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping
    public User createUser() {
        User user = User.builder()
                .userId(2)
                .name("Caroline")
                .build();
        User userCreated = repository.save(user);

        return userCreated;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return repository.findUserById(Integer.valueOf(id));
    }

}
