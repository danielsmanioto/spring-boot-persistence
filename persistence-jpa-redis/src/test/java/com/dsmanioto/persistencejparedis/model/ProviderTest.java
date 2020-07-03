package com.dsmanioto.persistencejparedis.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProviderTest {

    @Test
    public void createProvider() {
        Provider provider = Provider.builder()
                .id("1")
                .name("Default")
                .build();

        Assertions.assertNotNull(provider);
        Assertions.assertEquals("1", provider.getId());
        Assertions.assertEquals("Default", provider.getName());
    }

}
