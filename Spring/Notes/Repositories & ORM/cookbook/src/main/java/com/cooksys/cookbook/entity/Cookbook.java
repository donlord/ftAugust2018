package com.cooksys.cookbook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Cookbook {

    private static int counter = 1;

    private Integer id;

    private String name;

    @JsonIgnore
    private Set<Recipe> recipes;

    public Cookbook() {}

    public Cookbook(String name) {
        this.id = this.counter;
        this.name = name;
        this.recipes = new HashSet<Recipe>();
        this.counter++;
    }

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Set<Recipe> getRecipes () {
        return recipes;
    }

    public boolean addRecipe (Recipe recipe) {
        return this.recipes.add(recipe);
    }

    public boolean removeRecipe (Recipe recipe) {
        return this.recipes.remove(recipe);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cookbook cookbook = (Cookbook) o;
        return Objects.equals(id, cookbook.id) &&
                Objects.equals(name, cookbook.name) &&
                Objects.equals(recipes, cookbook.recipes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, recipes);
    }
}
