package com.example.food_service.service;

import com.example.food_service.entity.Food;
import com.example.food_service.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    private final FoodRepository repo;

    public FoodService(FoodRepository repo) {
        this.repo = repo;
    }

    public List<Food> getAll() {
        return repo.findAll();
    }

    public Food create(Food food) {
        return repo.save(food);
    }

    public Food update(Long id, Food food) {
        Food existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found"));

        existing.setName(food.getName());
        existing.setPrice(food.getPrice());
        existing.setDescription(food.getDescription());

        return repo.save(existing);
    }

    public Food getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found with id: " + id));
    }


    public void delete(Long id) {
        repo.deleteById(id);
    }
}