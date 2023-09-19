package com.cardapio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardapio.entities.Food;

public interface FoodRepository extends JpaRepository<Food, Long>{

}
