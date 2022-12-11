package me.olgas.recipesapp.services.impl;
import me.olgas.recipesapp.model.Recipe;

public interface RecipeService {

    long addRecipe(Recipe recipe);

    Recipe getRecipe(long id);

    Recipe editRecipe(long id, Recipe recipe);

    boolean deleteRecipe(long id);

    void deleteAllRecipe();

    Recipe getAllRecipe();
}
