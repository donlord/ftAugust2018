package com.cooksys.cookbook.service;

import com.cooksys.cookbook.entity.Ingredient;
import com.cooksys.cookbook.entity.MeasurementUnit;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientService {
    private Map<Integer, Ingredient> ingredients;

    public IngredientService () {
        ingredients = new HashMap<Integer, Ingredient>();
        Ingredient cheese = new Ingredient("Cheese", 1, MeasurementUnit.SLICE);
        ingredients.put(cheese.getId(), cheese);
    }
    public Collection<Ingredient> getIngredients() {
        return this.ingredients.values();
    }

    public Ingredient getIngredient(Integer id) {
        return this.ingredients.get(id);
    }

    public Integer createIngredient(Ingredient ingredient) {
        Ingredient ingredientCreated = new Ingredient(ingredient.getName(), ingredient.getQuantity(), ingredient.getUnit());
        this.ingredients.put(ingredientCreated.getId(), ingredientCreated);
        return ingredientCreated.getId();
    }

    public Ingredient updateIngredient(Integer id, Ingredient ingredient) {
        this.ingredients.put(id, ingredient);
        return ingredient;
    }

    public Ingredient deleteIngredient(Integer id) {
        Ingredient ingredientRemoved = this.ingredients.get(id);
        this.ingredients.remove(id);
        return ingredientRemoved;
    }
}
