package com.cooksys.cookbook.controller;

import com.cooksys.cookbook.entity.Ingredient;
import com.cooksys.cookbook.entity.Recipe;
import com.cooksys.cookbook.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/recipes")
public class RecipeController {

    private RecipeService rService;

    public RecipeController (RecipeService rService) {
        this.rService = rService;
    }

    @GetMapping
    public List<Recipe> getAll () {
        return this.rService.getAll();
    }

    @GetMapping(path="/{id}")
    public Recipe getRecipe (@PathVariable(name="id") Integer id) {
        return this.rService.getRecipe(id);
    }

    @PostMapping
    public Integer createRecipe (@RequestBody Recipe r) {
        return this.rService.createRecipe(r);
    }

    @PatchMapping(path="/{id}")
    public Recipe updateRecipe (@PathVariable(name="id") Integer id, @RequestBody Recipe r) {
        return this.rService.updateRecipe(id, r);
    }

    @GetMapping(path="/{id}/ingredients")
    public List<Ingredient> getRecipeIngredients (@PathVariable(name="id") Integer id) {
        return this.rService.getIngredients(id);
    }

    @PostMapping(path="/{recipeId}/ingredients/{ingredientId}")
    public Recipe addIngredient (@PathVariable(name="recipeId") Integer recipeId, @PathVariable(name="ingredientId") Integer ingredientId) {
        return this.rService.addIngredient(recipeId, ingredientId);
    }
}
