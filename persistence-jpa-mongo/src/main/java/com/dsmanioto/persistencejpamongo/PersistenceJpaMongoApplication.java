package com.dsmanioto.persistencejpamongo;

import com.dsmanioto.persistencejpamongo.configuration.MongoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableConfigurationProperties(MongoConfig.class)
@EnableMongoRepositories
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@SpringBootApplication
public class PersistenceJpaMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersistenceJpaMongoApplication.class, args);
	}

}
