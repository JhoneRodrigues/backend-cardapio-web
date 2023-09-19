package com.cardapio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cardapio.entities.Food;
import com.cardapio.services.FoodService;

@RestController
@RequestMapping(value="foods")
public class FoodController {
	
	@Autowired
	private FoodService service;
	
	@GetMapping
	public ResponseEntity<List<Food>> getAll() {
		List<Food> foodList = service.findAll();
		return ResponseEntity.ok().body(foodList);
	}
}
