package com.dsmanioto.persistencejparedis.repository;

import com.dsmanioto.persistencejparedis.model.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProviderRepository {

    private static final String KEY = "provider";

    @Autowired
    private RedisTemplate redisTemplate;

    private HashOperations hashOperations;

    public Provider save(Provider provider) {
        getHashOperations().put(KEY, provider.getId(), provider);
        return provider;
    }

    public Provider findById(String id) {
        HashOperations hashOperations = getHashOperations();
        return (Provider) hashOperations.get(KEY, id);
    }

    private HashOperations getHashOperations() {
        hashOperations = redisTemplate.opsForHash();
        return hashOperations;
    }

}
