package com.cooksys.cookbook.service;

import com.cooksys.cookbook.entity.Ingredient;
import com.cooksys.cookbook.entity.MeasurementUnit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientService {

    private List<Ingredient> ingredients;

    public IngredientService () {
        ingredients = new ArrayList<Ingredient>();
        Ingredient cheese = new Ingredient("Cheese", 1, MeasurementUnit.UNIT);
        ingredients.add(cheese);
    }

    public Ingredient get(Integer id) {
        return this.ingredients.get(id - 1);
    }

}
