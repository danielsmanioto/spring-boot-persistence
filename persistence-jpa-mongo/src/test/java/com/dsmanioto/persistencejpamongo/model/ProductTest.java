package com.dsmanioto.persistencejpamongo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ProductTest {
	
	@Test
	public void validaModel() {
		Product coca = new Product.ProductBuilder()
				.ean("0000001")
				.description("Coca cola")
				.price(BigDecimal.valueOf(2.90))
				.provider(getProviderDefault())
				.build();
		
		Assertions.assertEquals("0000001", coca.getEan());
		Assertions.assertEquals("Coca cola", coca.getDescription());
		Assertions.assertEquals(BigDecimal.valueOf(2.90), coca.getPrice());
		Assertions.assertNotNull(coca.getProvider());
	}
	
	private Provider getProviderDefault() {
		return Provider.builder()
					.name("Provider default")
					.build();
	}
	
}
