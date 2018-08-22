package com.cooksys.cookbook.controller;

import com.cooksys.cookbook.entity.Ingredient;
import com.cooksys.cookbook.entity.Recipe;
import com.cooksys.cookbook.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping(value="/recipes")
public class RecipeController {

    private RecipeService rService;

    public RecipeController (RecipeService rService) {
        this.rService = rService;
    }

    @GetMapping
    public Collection<Recipe> getRecipes () {
        return this.rService.getRecipes();
    }

    @GetMapping("/{id}")
    public Recipe getCookbook (@PathVariable(name = "id") Integer id) {
        return this.rService.getRecipe(id);
    }

    @PostMapping
    public Integer createRecipe (@RequestBody Recipe recipe) {
        return this.rService.createRecipe(recipe);
    }

    @PatchMapping("/{id}")
    public Recipe changeRecipeName (@PathVariable(name = "id") Integer id, @RequestBody Recipe recipe) {
        return this.rService.changeRecipeName(id, recipe);
    }

    @DeleteMapping("/{id}")
    public Recipe deleteRecipe (@PathVariable(name = "id") Integer id) {
        return this.rService.deleteRecipe(id);
    }

    @GetMapping("/{id}/ingredients")
    public Set<Ingredient> getIngredients (@PathVariable(name = "id") Integer id) {
        return this.rService.getIngredients(id);
    }

    @PostMapping("/{recipeId}/ingredients/{ingredientId}")
    public Ingredient addIngredient (@PathVariable(name = "recipeId") Integer recipeId, @PathVariable(name = "ingredientId") Integer ingredientId) {
        return this.rService.addIngredient(recipeId, ingredientId);
    }

    @DeleteMapping("/{recipeId}/ingredients/{ingredientId}")
    public Ingredient removeIngredient (@PathVariable(name = "recipeId") Integer recipeId, @PathVariable(name = "ingredientId") Integer ingredientId) {
        return this.rService.removeIngredient(recipeId, ingredientId);
    }

}
