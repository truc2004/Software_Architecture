package com.example.food_service.controller;

import com.example.food_service.entity.Food;
import com.example.food_service.service.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {

    private final FoodService service;

    public FoodController(FoodService service) {
        this.service = service;
    }

    @GetMapping
    public List<Food> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Food create(@RequestBody Food food) {
        return service.create(food);
    }

    @PutMapping("/{id}")
    public Food update(@PathVariable Long id, @RequestBody Food food) {
        return service.update(id, food);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Food getById(@PathVariable Long id) {
        return service.getById(id);
    }
}