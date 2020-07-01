package com.dsmanioto.persistencejpamongo.service.mock;

import com.dsmanioto.persistencejpamongo.model.Provider;
import com.dsmanioto.persistencejpamongo.repository.ProviderRepository;
import com.dsmanioto.persistencejpamongo.service.ProviderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class ProviderServiceMockTest {
	
	@Autowired
	private ProviderService service;
	
	@MockBean
	private ProviderRepository repository;
	
	@Test
	public void validaBuscarProviders() {
		BDDMockito.given(repository.findAll()).willReturn(providers());
		
		List<Provider> providers = service.findAll();
		
		Assertions.assertNotNull(providers);
		Assertions.assertEquals("Default", providers.get(0).getName());
	}
	
	private List<Provider> providers() {
		Provider providerDefault = Provider.builder()
				.name("Default")
				.build();
		
		return Arrays.asList(providerDefault);
	}
	
}
