package com.dsmanioto.persistencejparedis.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.math.BigDecimal;

@RedisHash("Product")
@Getter
@Setter
@Builder
public class Product implements Serializable {

    private String id;
    private String ean;
    private String description;
    private BigDecimal price;
    private Provider provider;

}
