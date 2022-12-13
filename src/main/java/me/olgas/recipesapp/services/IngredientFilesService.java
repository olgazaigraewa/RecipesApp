package me.olgas.recipesapp.services;

public interface IngredientFilesService {

    boolean saveIngredientsToFile(String json);

    String readIngredientsFromFile();
}
