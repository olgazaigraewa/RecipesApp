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
    public ResponseEntity<Long> addRecipe(@RequestBody Recipe recipe) {
        long id = recipeService.addRecipe(recipe);
        return ResponseEntity.ok(id);
    }

    /**
     * Получение рецепта по id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable long id) {
        Recipe recipe = recipeService.getRecipe(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    /**
     * Получение списка всех рецептов
     */
    @GetMapping
    public ResponseEntity<Recipe> getAllRecipe() {
        recipeService.getAllRecipe();
        return ResponseEntity.ok().build();
    }

    /**
     * Редактирование рецепта по id
     */
    @PutMapping("/{id}")
    public ResponseEntity<Recipe> editRecipe(@PathVariable long id, @RequestBody Recipe recipe) {
        Recipe r = recipeService.editRecipe(id, recipe);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    /**
     * Удаление рецепта по id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable long id) {
        if (recipeService.deleteRecipe(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Удаление всех рецептов
     */
    @DeleteMapping
    public ResponseEntity<Void> deleteAllRecipe() {
        recipeService.deleteAllRecipe();
        return ResponseEntity.ok().build();
    }

}

