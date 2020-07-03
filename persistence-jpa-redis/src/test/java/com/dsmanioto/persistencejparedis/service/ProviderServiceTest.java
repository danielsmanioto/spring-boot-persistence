package com.dsmanioto.persistencejparedis.service;

import com.dsmanioto.persistencejparedis.model.Provider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProviderServiceTest {

    @Autowired
    private ProviderService service;

    @Test
    public void findAll() {
        Iterable<Provider> all = service.findAll();
        Assertions.assertNotNull(all);
    }

}
