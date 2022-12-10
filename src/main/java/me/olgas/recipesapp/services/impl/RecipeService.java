package me.olgas.recipesapp.services.impl;
import me.olgas.recipesapp.model.Recipe;

public interface RecipeService {
    long addRecipe(Recipe recipe);

    long getRecipe(Recipe recipe);
    Recipe getRecipe(long id);
}
