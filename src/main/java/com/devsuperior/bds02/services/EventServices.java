package com.devsuperior.bds02.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.repositories.EventRepository;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;

@Service
public class EventServices {
	
	@Autowired
	EventRepository eventRepository;

	@Transactional
	public EventDTO update(Long id, EventDTO dto) {
		
		try {
			Event entity = eventRepository.getOne(id); 
			entity.setName(dto.getName());
			entity.setDate(dto.getDate());
			entity.setUrl(dto.getUrl());
			entity.setCity(new City(dto.getCityId(), dto.getName()));			
			entity = eventRepository.save(entity);
			return new EventDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
		
	}

	public List<EventDTO> listEvent() {
		List<Event> list = eventRepository.findAll();
		return list.stream().map(x -> new EventDTO(x)).collect(Collectors.toList());
	}

}
