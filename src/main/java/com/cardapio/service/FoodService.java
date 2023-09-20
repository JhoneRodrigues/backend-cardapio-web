package com.cardapio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cardapio.DTO.FoodRequestDTO;
import com.cardapio.entity.Food;
import com.cardapio.repository.FoodRepository;

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
}
