package com.dsmanioto.persistencejparedis.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ProductTest {

    @Test
    public void createProduct() {
        Product product = Product.builder()
                .id("1")
                .ean("00001")
                .description("Coca Cola 200ml")
                .price(BigDecimal.valueOf(2.38))
                .provider(Provider.builder().id("1").name("Default").build())
                .build();

        Assertions.assertNotNull(product);
        Assertions.assertEquals("1", product.getId());
        Assertions.assertEquals("00001", product.getEan());
        Assertions.assertEquals("Coca Cola 200ml", product.getDescription());
        Assertions.assertEquals(BigDecimal.valueOf(2.38), product.getPrice());

        Assertions.assertNotNull(product.getProvider());
        Assertions.assertEquals("1", product.getProvider().getId());
        Assertions.assertEquals("Default", product.getProvider().getName());
    }

}
