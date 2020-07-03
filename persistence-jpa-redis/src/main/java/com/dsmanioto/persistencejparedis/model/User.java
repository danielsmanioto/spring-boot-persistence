package com.dsmanioto.persistencejparedis.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
@Builder
@RedisHash("User")
public class User implements Serializable {

    private Integer userId;
    private String name;

}
