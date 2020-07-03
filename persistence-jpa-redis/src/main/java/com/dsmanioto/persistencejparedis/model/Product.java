package com.dsmanioto.persistencejparedis.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.math.BigDecimal;

@RedisHash
@Getter
@Setter
@Builder
public class Product {

    private String id;
    private String ean;
    private String description;
    private BigDecimal price;
    private Provider provider;

}
