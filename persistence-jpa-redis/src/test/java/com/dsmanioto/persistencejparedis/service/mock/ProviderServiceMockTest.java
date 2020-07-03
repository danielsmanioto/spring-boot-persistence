package com.dsmanioto.persistencejparedis.service.mock;

import com.dsmanioto.persistencejparedis.model.Provider;
import com.dsmanioto.persistencejparedis.repository.ProviderRepository;
import com.dsmanioto.persistencejparedis.service.ProviderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProviderServiceMockTest {

    @Autowired
    private ProviderService service;

    @MockBean
    private ProviderRepository repository;

    @BeforeEach
    public void setup() {
        BDDMockito.given(repository.findAll()).willReturn(getAllProviders());
    }

    @Test
    public void findAllMock() {
        List<Provider> providers = (List<Provider>) service.findAll();

        Assertions.assertNotNull(providers);
        Assertions.assertEquals(1, providers.size());
    }

    private Iterable<Provider> getAllProviders() {
        Provider provider = Provider.builder()
                .name("Daniel")
                .build();

        List<Provider> providers = new ArrayList<>();
        providers.add(provider);
        return providers;
    }

}
