package com.dsmanioto.persistencejparedis.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Provider")
@Getter
@Setter
@Builder
public class Provider implements Serializable {

    private String id;
    private String name;

}
