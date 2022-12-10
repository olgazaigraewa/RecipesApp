package me.olgas.recipesapp.controllers;

import me.olgas.recipesapp.model.Recipe;
import me.olgas.recipesapp.services.impl.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    /**
     * Добавление нового рецепта
     */

    @PostMapping
    public ResponseEntity<Long>addRecipe(@RequestBody Recipe recipe){
        long id =  recipeService.addRecipe(recipe);
        return ResponseEntity.ok(id);
    }

    /**
     * Получение рецепта
     */
    @GetMapping("/{id}")
    public ResponseEntity<Recipe>getRecipeById(@PathVariable long id){
       Recipe recipe = recipeService.getRecipe(id);
       if (recipe==null){
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(recipe);
    }




}

