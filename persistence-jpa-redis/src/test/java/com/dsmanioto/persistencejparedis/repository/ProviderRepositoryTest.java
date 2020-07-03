package com.dsmanioto.persistencejparedis.repository;

import com.dsmanioto.persistencejparedis.model.Provider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProviderRepositoryTest {

    @Autowired
    private ProviderRepository repository;

    @Test
    public void creteNewProvider() {
        Provider providerCreated = repository.save(Provider.builder()
                .id("1")
                .name("Caroline")
                .build());

        Assertions.assertNotNull(providerCreated);
        Assertions.assertEquals("1", providerCreated.getId());
        Assertions.assertEquals("Caroline", providerCreated.getName());
    }

    @Test
    public void findById() {
        Provider providerCreated = repository.save(Provider.builder()
                .id("1")
                .name("Caroline")
                .build());
        Assertions.assertNotNull(providerCreated);

        Provider provider = repository.findById("1");

        Assertions.assertNotNull(provider);
        Assertions.assertEquals("1", provider.getId());
        Assertions.assertEquals("Caroline", provider.getName());
    }

}
