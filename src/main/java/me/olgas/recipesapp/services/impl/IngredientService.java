package me.olgas.recipesapp.services.impl;

import me.olgas.recipesapp.model.Ingredient;


public interface IngredientService {

    long addIngredient(Ingredient ingredient);

    default Ingredient getIngredient(long id) {
        return null;
    }

    Ingredient getAllIngredient();

    Ingredient editIngredient(long id, Ingredient ingredient);

    boolean deleteIngredient(long id);

    void deleteAllIngredient();
}
