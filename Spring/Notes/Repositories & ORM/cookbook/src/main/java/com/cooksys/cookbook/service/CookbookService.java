package com.cooksys.cookbook.service;

import com.cooksys.cookbook.entity.Cookbook;
import com.cooksys.cookbook.entity.Recipe;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class CookbookService {
    private Map<Integer, Cookbook> cookbooks;

    private RecipeService rService;

    public CookbookService (RecipeService rService) {
        this.rService = rService;

        cookbooks = new HashMap<Integer, Cookbook>();
        Cookbook cookbook = new Cookbook("Cooksys Cookbook");
        cookbooks.put(cookbook.getId(), cookbook);
    }

    public Collection<Cookbook> getAllCookbooks() {
        return this.cookbooks.values();
    }

    public Cookbook getCookbook(Integer id) {
        return this.cookbooks.get(id);
    }

    public Integer createCookbook(Cookbook cookbook) {
        Cookbook cookbookCreated = new Cookbook(cookbook.getName());
        this.cookbooks.put(cookbookCreated.getId(), cookbookCreated);
        return cookbookCreated.getId();
    }

    public Cookbook changeCookbookName(Integer id, Cookbook cookbook) {
        Cookbook cookbookToUpdate = this.cookbooks.get(id);
        cookbookToUpdate.setName(cookbook.getName());
        return cookbookToUpdate;
    }

    public Cookbook deleteCookbook(Integer id) {
        Cookbook removedCookbook = this.cookbooks.get(id);
        this.cookbooks.remove(id);
        return removedCookbook;
    }

    public Set<Recipe> getRecipes(Integer id) {
        return this.cookbooks.get(id).getRecipes();
    }

    public Recipe addRecipe(Integer cookbookId, Integer recipeId) {
        Recipe recipeToAdd = rService.getRecipe(recipeId);
        Cookbook cookbookToUpdate = this.cookbooks.get(cookbookId);
        cookbookToUpdate.addRecipe(recipeToAdd);
        return recipeToAdd;
    }

    public Recipe removeRecipe(Integer cookbookId, Integer recipeId) {
        Recipe recipeToRemove = rService.getRecipe(recipeId);
        Cookbook cookbookToUpdate = this.cookbooks.get(cookbookId);
        cookbookToUpdate.removeRecipe(recipeToRemove);
        return recipeToRemove;
    }
}
