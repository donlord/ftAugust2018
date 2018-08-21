package com.cooksys.cookbook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

public class CookBook {

    private static int count = 1;

    private Integer id;

    private String name;

    @JsonIgnore
    private Set<Recipe> recipes;

    public CookBook () {}

    public CookBook (String name, Set<Recipe> recipes) {
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

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    public void addRecipe(Recipe recipe) {
        this.recipes.add(recipe);
    }

    public void removeRecipe(Recipe recipe) {
        this.recipes.remove(recipe);
    }
}
