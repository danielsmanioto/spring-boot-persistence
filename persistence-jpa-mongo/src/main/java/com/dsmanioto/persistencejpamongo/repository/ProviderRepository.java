package com.dsmanioto.persistencejpamongo.repository;

import com.dsmanioto.persistencejpamongo.model.Provider;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends MongoRepository<Provider, String> {

    Provider findByAge(int age);

    Provider findByAgeAndName(int age, String name);
}
