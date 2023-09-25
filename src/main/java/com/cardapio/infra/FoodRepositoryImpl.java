package com.cardapio.infra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.cardapio.adapters.FoodRepository;
import com.cardapio.core.DTO.FoodRequestDTO;
import com.cardapio.core.domain.Food;
import com.cardapio.core.exception.DatabaseException;
import com.cardapio.core.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Repository
public class FoodRepositoryImpl implements FoodRepository{
	
	@Autowired
	public jpaFoodRepository repository;
	
	@Override
	public List<Food> findAll(){
		return repository.findAll();
	}

	@Override
	public Food insert(@RequestBody FoodRequestDTO data) {
		Food foodData = new Food(data);
		return repository.save(foodData);
	}

	@Override
	public void delete (Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	@Override
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
