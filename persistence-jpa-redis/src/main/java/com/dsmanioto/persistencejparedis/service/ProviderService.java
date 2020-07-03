package com.dsmanioto.persistencejparedis.service;

import com.dsmanioto.persistencejparedis.model.Provider;
import com.dsmanioto.persistencejparedis.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository repository;

    public Iterable<Provider> findAll() {
        return repository.findAll();
    }

}
