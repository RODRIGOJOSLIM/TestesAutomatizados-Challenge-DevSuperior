package com.devsuperior.bds02.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.services.EventServices;

@RestController
@RequestMapping(value = "/events")
public class EventController {
	
	@Autowired
	EventServices eventServices;
	
	@GetMapping
	public ResponseEntity<List<EventDTO>> listEvent() {
		List<EventDTO> list = eventServices.listEvent();
		
		return ResponseEntity.ok(list);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<EventDTO> update (@PathVariable Long id, @RequestBody EventDTO dto) {
		dto = eventServices.update(id, dto);
		
		return ResponseEntity.ok(dto);
	}

}
