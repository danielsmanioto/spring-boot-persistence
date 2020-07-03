package com.dsmanioto.persistencejparedis.controller;

import com.dsmanioto.persistencejparedis.model.Provider;
import com.dsmanioto.persistencejparedis.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
    private ProviderRepository repository;

    @GetMapping("/{id}")
    public Provider findById(@PathVariable String id) {
        return repository.findById(id);
    }

}
