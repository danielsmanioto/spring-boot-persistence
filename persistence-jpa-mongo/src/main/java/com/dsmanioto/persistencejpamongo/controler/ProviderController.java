package com.dsmanioto.persistencejpamongo.controler;

import com.dsmanioto.persistencejpamongo.model.Provider;
import com.dsmanioto.persistencejpamongo.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/provider")
public class ProviderController {
	
	@Autowired
	private ProviderService service;
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		List<Provider> providers = service.findAll();
		
		return ResponseEntity.ok(providers);
	}
	
}
