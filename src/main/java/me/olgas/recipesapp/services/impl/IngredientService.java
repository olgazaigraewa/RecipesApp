package me.olgas.recipesapp.services.impl;

import me.olgas.recipesapp.model.Ingredient;

public interface IngredientService {
    long addIngredient(Ingredient ingredient);

    long getIngredient(Ingredient ingredient);

    Ingredient getIngredient(long id);
}
