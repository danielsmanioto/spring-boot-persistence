package com.dsmanioto.persistencejpamongo.service;

import com.dsmanioto.persistencejpamongo.model.Provider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProviderServiceTest {
	
	@Autowired
	private ProviderService service;
	
	@Test
	public void validaBuscarRegistrosBatendoDiretoNoMongo() {
		List<Provider> providers = service.findAll();
		Assertions.assertNotNull(providers);
		Assertions.assertEquals(1, providers.size());
	}

	@Test
	public void validaInserirUmRegistroNovo() {
		int qtdeBefore = service.findAll().size();

		service.insert(Provider.builder()
				.name("Eutalia")
				.build());

		int qtdeAfter = service.findAll().size();

		Assertions.assertEquals(qtdeBefore + 1, qtdeAfter);
	}

	@Test
	public void validaInseriUmaListaDeNovosProviders() {
		final int qtdeBefore = service.findAll().size();
		final int qtdeWillCreate = 200;

		List<Provider> providers = new ArrayList<>();
		for(int i = 0; i < qtdeWillCreate; i++) {
			providers.add(Provider.builder().name("Perry" + i).build());
		}
		service.insert(providers);

		final int qtdeAfter = service.findAll().size();

		Assertions.assertEquals(qtdeBefore + qtdeWillCreate, qtdeAfter);
	}

	@Test
	public void validaInserirRemover1Registro() {
		int qtdeBefore = service.findAll().size();
		Provider providerCreated = service.insert(Provider.builder().name("New").build());
		int qtdeAfter = service.findAll().size();

		Assertions.assertEquals(qtdeBefore + 1, qtdeAfter);

		service.removeById(providerCreated.get_id());

		qtdeAfter = service.findAll().size();
		Assertions.assertEquals(qtdeBefore, qtdeAfter);
	}

	@Test
	public void validaRemoverUmaListaDeUsuarios() {
		final int qtdeBefore = service.findAll().size();
		final int qtdeWillRemove = 0;

		List
		service.remove();

		final int qtdeAfter = service.findAll().size();
		Assertions.assertEquals(qtdeBefore + qtdeWillRemove, qtdeAfter);
	}

}
