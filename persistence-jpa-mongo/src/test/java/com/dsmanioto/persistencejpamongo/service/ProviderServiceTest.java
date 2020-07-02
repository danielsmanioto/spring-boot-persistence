package com.dsmanioto.persistencejpamongo.service;

import com.dsmanioto.persistencejpamongo.model.Provider;
import com.dsmanioto.persistencejpamongo.repository.ProviderRepository;
import org.aspectj.apache.bcel.classfile.Module;
import org.hibernate.criterion.Example;
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

	@Autowired
	private ProviderRepository repository;

	@Test
	public void findAllRegistersInMongoDB() {
		List<Provider> providers = service.findAll();
		Assertions.assertNotNull(providers);
	}

	@Test
	public void insertOneRegistry() {
		int qtdeBefore = service.findAll().size();

		service.insert(Provider.builder()
				.name("Eutalia R.")
				.build());

		int qtdeAfter = service.findAll().size();

		Assertions.assertEquals(qtdeBefore + 1, qtdeAfter);
	}

	@Test
	public void insertListOfProviders() {
		final int qtdeBefore = service.findAll().size();
		final int qtdeWillCreate = 200000;

		List<Provider> providers = new ArrayList<>();
		for(int i = 0; i < qtdeWillCreate; i++) {
			providers.add(Provider.builder().name("Perry" + i).build());
		}
		service.insert(providers);

		final int qtdeAfter = service.findAll().size();

		Assertions.assertEquals(qtdeBefore + qtdeWillCreate, qtdeAfter);
	}

	@Test
	public void removeOneRegistryById() {
		int qtdeBefore = service.findAll().size();
		Provider providerCreated = service.insert(Provider.builder().name("New").build());
		int qtdeAfter = service.findAll().size();

		Assertions.assertEquals(qtdeBefore + 1, qtdeAfter);

		service.removeById(providerCreated.get_id());

		qtdeAfter = service.findAll().size();
		Assertions.assertEquals(qtdeBefore, qtdeAfter);
	}

	@Test
	public void removeAllRegistryByList() {
		List<Provider> providers = service.findAll();
		service.remove(providers);

		int qtdeAfter = service.findAll().size();
		Assertions.assertEquals(0, qtdeAfter);
	}

	@Test
	public void removeAllRegistry() {
		service.removeAll();

		int qtdeAfter = service.findAll().size();
		Assertions.assertEquals(service.findAll().size(), 0);
	}

	@Test
	public void removeOneRegistryWithoutFind() {
		int qtdeBefore = service.findAll().size();

		Provider providerCreated = service.insert(Provider.builder().name("New").build());
		service.remove(providerCreated);

		int qtdeAfter = service.findAll().size();
		Assertions.assertEquals(qtdeBefore, qtdeAfter);
	}

	@Test
	public void removeOneRegistry() {
		int qtdeBefore = service.findAll().size();

		Provider providerCreated = service.insert(Provider.builder().name("New").build());
		Provider providerFinded = service.findById(providerCreated.get_id());
		service.remove(providerFinded);

		int qtdeAfter = service.findAll().size();
		Assertions.assertEquals(qtdeBefore, qtdeAfter);
	}

	@Test
	public void findById() {
		//Provider provider = service.findById("5efe40e610eb7137e54c166d");
		//Assertions.assertEquals("daniel smanioto ama carol", provider.getName());
	}

	@Test
	public void updateRegistry() {
		//Provider provider = service.findById("5efe40e610eb7137e54c166d");
		//provider.setName("CAROLINE");
		//service.update(provider);
	}

	@Test
	public void updateAllRegistry() {
		List<Provider> providers = service.findAll();
		providers.get(0).setAge(18);
		service.update(providers);

		Provider provider = service.findById(providers.get(0).get_id());
		Assertions.assertEquals(provider.getAge(), 18);
	}

	@Test
	public void updateRegistryByList() {
		service.findAll().forEach(provider -> {
			provider.setAge(33);
			service.update(provider);
		});
	}

	@Test
	public void findByAge() {
		service.insert(Provider.builder()
				.name("perry sam")
				.age(920)
				.build());
		Provider provider = repository.findByAge(920);

		Assertions.assertEquals(920, provider.getAge());
		Assertions.assertEquals("perry sam", provider.getName());
	}

	@Test
	public void findByAgeAndName() {
		service.insert(Provider.builder()
				.name("soffa")
				.age(922)
				.build());
		Provider provider = repository.findByAgeAndName(922, "soffa");

		Assertions.assertEquals(922, provider.getAge());
		Assertions.assertEquals("soffa", provider.getName());
	}

	@Test
	public void checkQuantidadeRegisters() {
		Assertions.assertEquals(service.findAll().size(), repository.count());
	}

	@Test
	public void checkIfExistsById() {
		Provider providerCreated = service.insert(Provider.builder()
				.name("Jose")
				.age(98)
				.build());

		boolean isTrue = repository.existsById(providerCreated.get_id());
		Assertions.assertTrue(isTrue);
	}

}
