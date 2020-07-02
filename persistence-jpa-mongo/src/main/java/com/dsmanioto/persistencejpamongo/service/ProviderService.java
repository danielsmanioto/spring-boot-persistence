package com.dsmanioto.persistencejpamongo.service;

import com.dsmanioto.persistencejpamongo.model.Provider;
import com.dsmanioto.persistencejpamongo.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {
	
	@Autowired
	private ProviderRepository repository;
	
	public List<Provider> findAll() {
 		return repository.findAll();
	}
	
	public Provider insert(Provider providerDefault) {
		return repository.insert(providerDefault);
	}

    public void insert(List<Provider> providers) {
    	repository.insert(providers);
	}

	public void removeById(String id) {
		repository.deleteById(id);
	}

	public void remove(Provider provider) {
		repository.delete(provider);
	}

	public void remove(List<Provider> providers) {
		repository.deleteAll(providers);
	}

	public void removeAll() {
		repository.deleteAll();
	}

	public Provider findById(String id) {
		return repository.findById(id).orElse(Provider.builder().build());
	}

	public void update(Provider provider) {
		repository.save(provider);
	}

	public void update(List<Provider> providers) {
		repository.saveAll(providers);
	}

}
