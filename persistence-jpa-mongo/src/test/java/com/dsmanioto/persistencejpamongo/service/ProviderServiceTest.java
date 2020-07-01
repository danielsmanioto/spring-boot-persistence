package com.dsmanioto.persistencejpamongo.service;

import com.dsmanioto.persistencejpamongo.model.Provider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProviderServiceTest {
	
	@Autowired
	private ProviderService service;
	
	@Test
	public void validaBuscarRegistrosBatendoDiretoNoMongo() {
		Provider providerDefault = Provider.builder().name("Default").build();
		List<Provider> providers = service.findAll();
		Assertions.assertNotNull(providers);
		//Assertions.assertEquals(6, providers.size());
	}
	
}
