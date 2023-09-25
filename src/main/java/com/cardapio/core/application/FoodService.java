package com.cardapio.core.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cardapio.adapters.FoodRepository;
import com.cardapio.core.DTO.FoodRequestDTO;
import com.cardapio.core.domain.Food;
import com.cardapio.core.usecases.FoodUseCases;

@Service
public class FoodService implements FoodUseCases{
	
	@Autowired
	private FoodRepository repository;
	
	@Override
	public List<Food> findAll(){
		return repository.findAll();
	}
	
	@Override
	public Food insert(@RequestBody FoodRequestDTO data) {
		return repository.insert(data);
	}
	
	@Override
	public void delete (Long id) {
		repository.delete(id);
	}
	
	@Override
	public Food update(Long id, FoodRequestDTO obj) {
		return repository.update(id, obj);
	}	
}
