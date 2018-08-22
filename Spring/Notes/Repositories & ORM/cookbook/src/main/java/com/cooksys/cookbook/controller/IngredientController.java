package com.cooksys.cookbook.controller;

import com.cooksys.cookbook.entity.Ingredient;
import com.cooksys.cookbook.service.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value="/ingredients")
public class IngredientController {

    private IngredientService iService;

    public IngredientController (IngredientService iService) {
        this.iService = iService;
    }

    @GetMapping
    public Collection<Ingredient> getIngredients () {
        return this.iService.getIngredients();
    }

    @GetMapping("/{id}")
    public Ingredient getIngredient (@PathVariable(name = "id") Integer id) {
        return this.iService.getIngredient(id);
    }

    @PostMapping
    public Integer createIngredient (@RequestBody Ingredient ingredient) {
        return this.iService.createIngredient(ingredient);
    }

    @PutMapping("/{id}")
    public Ingredient updateIngredient (@PathVariable(name = "id") Integer id, @RequestBody Ingredient ingredient) {
        return this.iService.updateIngredient(id, ingredient);
    }

    @DeleteMapping("/{id}")
    public Ingredient deleteIngredient (@PathVariable(name = "id") Integer id) {
        return this.iService.deleteIngredient(id);
    }
}
