package com.cardapio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cardapio.DTO.FoodRequestDTO;
import com.cardapio.entity.Food;
import com.cardapio.exception.DatabaseException;
import com.cardapio.exception.ResourceNotFoundException;
import com.cardapio.repository.FoodRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FoodService {
	
	@Autowired
	private FoodRepository repository;
	
	public List<Food> findAll(){
		return repository.findAll();
	}
	
	public void insert(@RequestBody FoodRequestDTO data) {
		Food foodData = new Food(data);
		repository.save(foodData);
	}
	
	public void delete (Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Food update(Long id, FoodRequestDTO obj) {
		try {
			Food entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void updateData(Food entity, FoodRequestDTO obj){
		entity.setImage(obj.image());
		entity.setPrice(obj.price());
		entity.setTitle(obj.title());
	}
}
