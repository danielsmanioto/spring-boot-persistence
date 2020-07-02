package com.dsmanioto.persistencejpamongo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Setter
@Getter
@Document
public class Provider {
	
	private String _id;
	
	private String name;

	private Integer age;

}
