package com.cooksys.cookbook.controller;

import com.cooksys.cookbook.entity.Cookbook;
import com.cooksys.cookbook.entity.Recipe;
import com.cooksys.cookbook.service.CookbookService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping(value="/cookbooks")
public class CookbookController {

    private CookbookService cbService;

    public CookbookController (CookbookService cbService) {
        this.cbService = cbService;
    }

    @GetMapping
    public Collection<Cookbook> getCookbooks () {
        return this.cbService.getAllCookbooks();
    }

    @GetMapping("/{id}")
    public Cookbook getCookbook (@PathVariable(name = "id") Integer id) {
        return this.cbService.getCookbook(id);
    }

    @PostMapping
    public Integer createCookbook (@RequestBody Cookbook cookbook) {
        return this.cbService.createCookbook(cookbook);
    }

    @PatchMapping("/{id}")
    public Cookbook changeCookbookName (@PathVariable(name = "id") Integer id, @RequestBody Cookbook cookbook) {
        return this.cbService.changeCookbookName(id, cookbook);
    }

    @DeleteMapping("/{id}")
    public Cookbook deleteCookbook (@PathVariable(name = "id") Integer id) {
        return this.cbService.deleteCookbook(id);
    }

    @GetMapping("/{id}/recipes")
    public Set<Recipe> getRecipes (@PathVariable(name = "id") Integer id) {
        return this.cbService.getRecipes(id);
    }

    @PostMapping("/{cookbookId}/recipes/{recipeId}")
    public Recipe addRecipe (@PathVariable(name = "cookbookId") Integer cookbookId, @PathVariable(name = "recipeId") Integer recipeId) {
        return this.cbService.addRecipe(cookbookId, recipeId);
    }

    @DeleteMapping("/{cookbookId}/recipes/{recipeId}")
    public Recipe removeRecipe (@PathVariable(name = "cookbookId") Integer cookbookId, @PathVariable(name = "recipeId") Integer recipeId) {
        return this.cbService.removeRecipe(cookbookId, recipeId);
    }

}
