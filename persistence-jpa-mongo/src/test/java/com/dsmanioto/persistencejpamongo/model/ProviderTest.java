package com.dsmanioto.persistencejpamongo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProviderTest {
	
	@Test
	public void validaModel() {
		Provider providerDefault = Provider.builder()
				.name("Default")
				.build();
		
		Assertions.assertEquals("Default", providerDefault.getName());
	}
	
}
