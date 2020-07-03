package com.dsmanioto.persistencejparedis.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
@Getter
@Setter
@Builder
public class Provider {

    private String id;
    private String name;

}
