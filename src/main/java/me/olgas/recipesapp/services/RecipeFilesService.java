package me.olgas.recipesapp.services;

public interface RecipeFilesService {

     boolean saveRecipesToFile(String json);



    String readRecipesFromFile();



}

