package me.olgas.recipesapp.services;

import me.olgas.recipesapp.model.Ingredient;


public interface IngredientService {

    Ingredient addIngredient(Ingredient ingredient);

    Ingredient getIngredient(long id);

    Ingredient editIngredient(long id, Ingredient ingredient);
    boolean deleteIngredient(long id);

}

