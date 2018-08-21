package com.cooksys.cookbook.service;

import com.cooksys.cookbook.entity.Ingredient;
import com.cooksys.cookbook.entity.Recipe;
import com.cooksys.cookbook.exceptions.RecipeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    private IngredientService iService;

    private List<Recipe> recipes;

    public RecipeService (IngredientService iService) {
        recipes = new ArrayList<Recipe>();
        Recipe r1 = new Recipe("Grilled Cheese");
        recipes.add(r1);

        this.iService = iService;
    }

    public List<Recipe> getAll() {
        return this.recipes;
    }

    public Integer createRecipe (Recipe r) {
        Recipe newRecipe = new Recipe(r.getName());
        this.recipes.add(newRecipe);
        return newRecipe.getId();
    }

    public Recipe getRecipe (Integer id) {
        return this.recipes.get(id - 1);
    }

    public Recipe updateRecipe (Integer id, Recipe r) {
        Recipe updatedRecipe = this.recipes.get(id - 1);
        updatedRecipe.setName(r.getName());
        return updatedRecipe;
    }

    public Recipe addIngredient (Integer recipeId, Integer ingredientId) {
        if (recipeId > this.recipes.size()) {
            throw new RecipeNotFoundException(recipeId);
        }
        Ingredient i = this.iService.get(ingredientId);
        Recipe r = this.recipes.get(recipeId - 1);
        r.addIngredient(i);
        return r;
    }

    public List<Ingredient> getIngredients(Integer id) {
        return this.recipes.get(id - 1).getIngredients();
    }
}
