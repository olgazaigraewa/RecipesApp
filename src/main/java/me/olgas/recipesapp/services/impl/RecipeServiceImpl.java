package me.olgas.recipesapp.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.olgas.recipesapp.model.Recipe;
import me.olgas.recipesapp.services.RecipeFilesService;
import me.olgas.recipesapp.services.RecipeService;
import org.springframework.stereotype.Service;
import java.util.LinkedHashMap;
import java.util.Map;


@Service
public class RecipeServiceImpl implements RecipeService {

    final private RecipeFilesService recipeFilesService;

    private static Map<Long, Recipe> recipes = new LinkedHashMap<>();
    private static long lastId = 0;

    public RecipeServiceImpl(RecipeFilesService recipeFilesService) {
        this.recipeFilesService = recipeFilesService;
    }

    @Override
    public long addRecipe(Recipe recipe) {
        recipes.put(lastId, recipe);
        saveToFile();
        return lastId++;
    }

    @Override
    public Recipe getRecipe(long id) {
        for (Recipe recipe : recipes.values()) {
            Recipe recipe1 = recipes.get(id);
            if (recipe1 != null) {
                return recipe1;
            }
        }
        return null;
    }


    @Override
    public Recipe editRecipe(long id, Recipe recipe) {
        for (Recipe recipe1 : recipes.values()) {
            if (recipes.containsKey(id)) {
                recipes.put(id, recipe);
                saveToFile();
                return recipe;
            }
        }
        return null;
    }

    @Override
    public boolean deleteRecipe(long id) {
        for (Recipe recipe : recipes.values()) {
            if (recipes.containsKey(id)) {
                recipes.remove(id);
                return true;
            }
        }
        return false;
    }

    /**
     * запись в файл
     */
    private void saveToFile() {
        try {
            DataFile dataFile = new DataFile(lastId +1, (LinkedHashMap<Long, Recipe>) recipes);
            String json = new ObjectMapper().writeValueAsString(dataFile);
            recipeFilesService.saveRecipesToFile(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class DataFile {
        private long lastId;
        private LinkedHashMap<Long, Recipe> recipes;
    }

}

