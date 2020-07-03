package com.dsmanioto.persistencejparedis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
public class PersistenceJpaRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersistenceJpaRedisApplication.class, args);
	}

}
