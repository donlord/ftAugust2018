package com.cooksys.cookbook.service;

import com.cooksys.cookbook.entity.Ingredient;
import com.cooksys.cookbook.entity.Recipe;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class RecipeService {
    private Map<Integer, Recipe> recipes;

    private IngredientService iService;

    public RecipeService (IngredientService iService) {
        this.iService = iService;

        recipes = new HashMap<Integer, Recipe>();
        Recipe grilledCheese = new Recipe("Grilled Cheese");
        recipes.put(grilledCheese.getId(), grilledCheese);
    }

    public Collection<Recipe> getRecipes() {
        return this.recipes.values();
    }

    public Recipe getRecipe(Integer id) {
        return this.recipes.get(id);
    }

    public Integer createRecipe(Recipe recipe) {
        Recipe recipeCreated= new Recipe(recipe.getName());
        this.recipes.put(recipeCreated.getId(), recipeCreated);
        return recipeCreated.getId();
    }

    public Recipe changeRecipeName(Integer id, Recipe recipe) {
        Recipe recipeToUpdate = this.recipes.get(id);
        recipeToUpdate.setName(recipe.getName());
        return recipeToUpdate;
    }

    public Recipe deleteRecipe(Integer id) {
        Recipe recipeToDelete = this.recipes.get(id);
        this.recipes.remove(id);
        return recipeToDelete;
    }

    public Set<Ingredient> getIngredients(Integer id) {
        return this.recipes.get(id).getIngredients();
    }

    public Ingredient addIngredient(Integer recipeId, Integer ingredientId) {
        Ingredient ingredientToAdd = this.iService.getIngredient(ingredientId);
        Recipe recipeToUpdate = this.recipes.get(recipeId);
        recipeToUpdate.addIngredient(ingredientToAdd);
        return ingredientToAdd;
    }

    public Ingredient removeIngredient(Integer recipeId, Integer ingredientId) {
        Ingredient ingredientToRemove = this.iService.getIngredient(ingredientId);
        Recipe recipeToUpdate = this.recipes.get(recipeId);
        recipeToUpdate.removeIngredient(ingredientToRemove);
        return ingredientToRemove;
    }
}
