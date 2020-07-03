package com.dsmanioto.persistencejparedis.controller;

import com.dsmanioto.persistencejparedis.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
    private ProviderService service;

    @GetMapping("/findAll")
    @Cacheable("findAll")
    public String findAll() {
        System.out.println("SEM CACHE");
        return "Hello";
    }

    @GetMapping("/clean-cache")
    @CacheEvict("findAll")
    public String cleanCache() {
        System.out.println("CACHE LIMPO ...");
        return "CLEAN CACHE";
    }

}
