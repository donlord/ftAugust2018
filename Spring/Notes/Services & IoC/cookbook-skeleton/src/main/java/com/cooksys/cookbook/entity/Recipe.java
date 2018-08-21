package com.cooksys.cookbook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private static int count = 1;

    private Integer id;

    private String name;

    @JsonIgnore
    private List<Ingredient> ingredients = new ArrayList<Ingredient>();

    public Recipe () {}

    public Recipe (String name) {
        this.id = count;
        this.name = name;
        count++;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient i) {
        this.ingredients.add(i);
    }

    public void removeIngredient(Ingredient i) {
        this.ingredients.remove(i);
    }
}
