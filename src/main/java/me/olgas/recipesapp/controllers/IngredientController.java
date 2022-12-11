package me.olgas.recipesapp.controllers;

import me.olgas.recipesapp.model.Ingredient;
import me.olgas.recipesapp.services.impl.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredients")

public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    /**
     * Добавление нового ингредиента
     */
    @PostMapping
    public ResponseEntity<Long> addIngredient(@RequestBody Ingredient ingredient) {
        long id = ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok(id);
    }

    /**
     * Получение ингредиента по id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable long id) {
        Ingredient ingredient = ingredientService.getIngredient(id);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    /**
     * Получение списка всех ингредиентов
     */
    @GetMapping
    public ResponseEntity<Ingredient> getAllIngredient() {
        ingredientService.getAllIngredient();
        return ResponseEntity.ok().build();
    }

    /**
     * Редактирование ингредиента по id
     */
    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> editIngredient(@PathVariable long id, @RequestBody Ingredient ingredient) {
        Ingredient n = ingredientService.editIngredient(id, ingredient);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    /**
     * Удаление ингредиента по id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable long id) {
        if (ingredientService.deleteIngredient(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Удаление всех ингредиента
     */
    @DeleteMapping
    public ResponseEntity<Void> deleteAllIngredient() {
        ingredientService.deleteAllIngredient();
        return ResponseEntity.ok().build();
    }

}
