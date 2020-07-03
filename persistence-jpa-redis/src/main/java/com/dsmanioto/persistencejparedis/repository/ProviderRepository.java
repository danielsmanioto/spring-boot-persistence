package com.dsmanioto.persistencejparedis.repository;

import com.dsmanioto.persistencejparedis.model.Provider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends CrudRepository<Provider, String> {

}
