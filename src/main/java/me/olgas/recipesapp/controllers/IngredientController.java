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
    public ResponseEntity<Long> addIngredient(@RequestBody Ingredient ingredient){
        long id =  ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok(id);
    }

    /**
     * Получение ингредиента
     */
    @GetMapping("/{id}")
    public ResponseEntity<Ingredient>getIngredientById(@PathVariable long id){
        Ingredient ingredient = ingredientService.getIngredient(id);
        if (ingredient==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }


}
