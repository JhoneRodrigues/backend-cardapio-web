package com.cardapio.adapters;

import java.util.List;

import com.cardapio.core.DTO.FoodRequestDTO;
import com.cardapio.core.domain.Food;

public interface FoodRepository {
	List<Food> findAll();
	Food insert(FoodRequestDTO data);
	void delete (Long id);
	Food update(Long id, FoodRequestDTO obj);
}
