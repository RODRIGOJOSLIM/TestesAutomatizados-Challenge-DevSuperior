package com.devsuperior.bds02.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.services.CityServices;

@RestController
@RequestMapping(value = "/cities")
public class CityControllers {
	
	
	@Autowired
	CityServices cityServices;
	
	@GetMapping()
	public ResponseEntity<List<CityDTO>> findAll(){
		List<CityDTO> list = cityServices.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		
		cityServices.delete(id);
		
		return ResponseEntity.noContent().build();
		
	}

}
