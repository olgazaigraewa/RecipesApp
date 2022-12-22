package me.olgas.recipesapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.olgas.recipesapp.model.Recipe;
import me.olgas.recipesapp.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipes")
@Tag(name = "Рецепты", description = "CRUD-операции для работы с рецептами")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    /**
     * Добавление нового рецепта
     */
    @PostMapping
    @Operation(summary = "Добавление рецепта")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепт был добавлен",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Recipe.class))
                            )
                    }

            )
    })
    public ResponseEntity<Long> addRecipe(@RequestBody Recipe recipe){
      long id = recipeService.addRecipe(recipe);
      return ResponseEntity.ok(id);
    }

    /**
     * Получение рецепта по id
     */
    @GetMapping("/{id}")
    @Operation(
            summary = "Поиск рецепта по id",
            description = "Для получения рецепта введите его id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепт был найден",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Recipe.class))
                            )
                    }

            )
    })
    public ResponseEntity<Recipe> getRecipeById(@PathVariable long id) {
        Recipe recipe = recipeService.getRecipe(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }
    /**
     * Редактирование рецепта по id
     */
    @PutMapping("/{id}")
    @Operation(
            summary = "Редактирование рецепта",
            description = "Для редактирования рецепта введите его id"
    )
     @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепт был изменен",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Recipe.class))
                            )
                    }

            )
    })
    public ResponseEntity<Recipe>editRecipe(@PathVariable long id, @RequestBody Recipe recipe){
        Recipe recipe1 = recipeService.editRecipe(id, recipe);
        if (recipe==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    /**
     * Удаление рецепта по id
     */
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Удаление рецепта по id",
            description = "Для удаления рецепта введите его id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепт был удален",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Recipe.class))
                            )
                    }

            )
    })
    public ResponseEntity<Void>deleteRecipe(@PathVariable long id){
        if (recipeService.deleteRecipe(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }



}
