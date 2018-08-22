package com.cooksys.cookbook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Recipe {

    private static int counter = 1;

    private Integer id;

    private String name;

    @JsonIgnore
    private Set<Ingredient> ingredients;

    public Recipe () {}

    public Recipe (String name) {
        this.id = this.counter;
        this.name = name;
        this.ingredients = new HashSet<Ingredient>();
        this.counter++;
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

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public boolean addIngredient (Ingredient ingredient) {
        return this.ingredients.add(ingredient);
    }

    public boolean removeIngredient (Ingredient ingredient) {
        return this.ingredients.remove(ingredient);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(id, recipe.id) &&
                Objects.equals(name, recipe.name) &&
                Objects.equals(ingredients, recipe.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ingredients);
    }
}
