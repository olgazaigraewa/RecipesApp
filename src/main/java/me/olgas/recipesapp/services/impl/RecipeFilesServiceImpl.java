package me.olgas.recipesapp.services.impl;

import me.olgas.recipesapp.services.RecipeFilesService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class RecipeFilesServiceImpl implements RecipeFilesService {
    @Value("${path.to.recipes.file}")
    private String recipesFilePath;
    @Value("${name.of.recipes.file}")
    private String recipesFileName;

    /**
     * записать файл
     */
    @Override
    public boolean saveRecipesToFile(String json) {
        try {
            cleanRecipesFile();
            Files.writeString(Path.of(recipesFilePath, recipesFileName), json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }



    /**
     * метод возвращает файл
     */
    @Override
    public File getRecipesFile() {
        return new File(recipesFilePath + "/" + recipesFileName);
    }

    /**
     * создание временных файлов
     */
    @Override
    public Path createTempFile(String suffix) {
        try {
            return Files.createTempFile(Path.of(recipesFilePath), "tempFile", suffix);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * удалить и очистить файл//шаблон для заполнения
     */

    @Override
    public boolean cleanRecipesFile() {
        try {
            Path path = Path.of(recipesFilePath, recipesFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }



}
