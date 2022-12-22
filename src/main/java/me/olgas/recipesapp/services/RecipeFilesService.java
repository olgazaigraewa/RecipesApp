package me.olgas.recipesapp.services;

import java.io.File;
import java.nio.file.Path;

public interface RecipeFilesService {

    boolean saveRecipesToFile(String json);

    File getRecipesFile();

    Path createTempFile(String suffix);

    boolean cleanRecipesFile();

}
