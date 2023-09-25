package com.cardapio.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardapio.core.domain.Food;

public interface jpaFoodRepository extends JpaRepository<Food, Long>{

}
