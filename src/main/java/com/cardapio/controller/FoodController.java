package com.cardapio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cardapio.DTO.FoodRequestDTO;
import com.cardapio.DTO.FoodResponseDTO;
import com.cardapio.service.FoodService;

@RestController
@RequestMapping(value="foods")
public class FoodController {
	
	@Autowired
	private FoodService service;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	public ResponseEntity<List<FoodResponseDTO>> getAll() {
		List<FoodResponseDTO> foodList = service.findAll().stream().map(FoodResponseDTO::new).toList();
		return ResponseEntity.ok().body(foodList);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	public void insert(@RequestBody FoodRequestDTO data){
		service.insert(data);
	}
}
