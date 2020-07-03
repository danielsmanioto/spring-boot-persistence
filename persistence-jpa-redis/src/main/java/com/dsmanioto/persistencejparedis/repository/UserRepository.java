
package com.dsmanioto.persistencejparedis.repository;

import com.dsmanioto.persistencejparedis.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class UserRepository {

    private static final String KEY = "user";

    @Autowired
    private RedisTemplate redisTemplate;

    public User save(User user) {
        HashOperations hashOperations = getHashOperations();
        hashOperations.put(KEY, user.getUserId(), user);
        return user;
    }

    public User findUserById(int id) {
        HashOperations hashOperations = getHashOperations();
        return (User) hashOperations.get(KEY, id);
    }

    private HashOperations getHashOperations() {
        return redisTemplate.opsForHash();
    }

}