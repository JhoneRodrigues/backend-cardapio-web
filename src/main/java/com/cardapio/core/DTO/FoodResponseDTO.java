package com.cardapio.core.DTO;

import com.cardapio.core.domain.Food;

public record FoodResponseDTO(Long id, String title, String image, Integer price) {
	public FoodResponseDTO(Food food) {
		this(food.getId(),food.getTitle(),food.getImage(),food.getPrice());
	}
}
