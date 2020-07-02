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

}
