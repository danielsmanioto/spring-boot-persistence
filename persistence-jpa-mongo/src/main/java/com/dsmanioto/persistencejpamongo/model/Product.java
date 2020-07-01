package com.dsmanioto.persistencejpamongo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Builder
@Setter
@Getter
@Document
public class Product {
	
	@Id
	private String id;
	
	private String description;
	
	private String ean;
	
	private BigDecimal price;
	
	@ManyToOne
	private Provider provider;
	
}
