package com.cardapio.core.usecases;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.cardapio.core.DTO.FoodRequestDTO;
import com.cardapio.core.domain.Food;

public interface FoodUseCases {
	List<Food> findAll();
	public Food insert(@RequestBody FoodRequestDTO data);
	public void delete (Long id);
	public Food update(Long id, FoodRequestDTO obj);
}
