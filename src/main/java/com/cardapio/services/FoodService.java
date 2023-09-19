package com.cardapio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardapio.entities.Food;
import com.cardapio.repository.FoodRepository;

@Service
public class FoodService {
	
	@Autowired
	private FoodRepository repository;
	
	public List<Food> findAll(){
		return repository.findAll();
	}
}
