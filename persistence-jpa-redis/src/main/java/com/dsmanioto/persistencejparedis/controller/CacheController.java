package com.dsmanioto.persistencejparedis.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @GetMapping("/hello")
    @Cacheable("hello")
    public String findAll() {
        System.out.println("COM CACHE");
        return "Hello";
    }

    @GetMapping("/clean-cache")
    @CacheEvict("hello")
    public String cleanCache() {
        System.out.println("CACHE LIMPO!");
        return "CLEAN CACHE";
    }

}
