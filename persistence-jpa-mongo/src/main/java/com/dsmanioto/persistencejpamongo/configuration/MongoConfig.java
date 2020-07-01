package com.dsmanioto.persistencejpamongo.configuration;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collections;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {
	
	@Override
	protected String getDatabaseName() {
		return "mongo-api";
	}
	
	@Override
	protected void configureClientSettings(MongoClientSettings.Builder builder) {
		builder.credential(
				MongoCredential.createCredential("smanioto", "admin", "smanioto".toCharArray())).applyToClusterSettings(settings -> {
			settings.hosts(Collections.singletonList(new ServerAddress("127.0.0.1", 27017)));
		});
	}
	
}
