package com.cardapio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardapio.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long>{

}
