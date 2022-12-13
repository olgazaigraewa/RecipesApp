package me.olgas.recipesapp.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import me.olgas.recipesapp.model.Recipe;
import me.olgas.recipesapp.services.RecipeFilesService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.TreeMap;

@NonNull
@Service
public class RecipeServiceImpl implements RecipeService {

    final private RecipeFilesService recipeFilesService;


    private static Map<Long, Recipe> recipes = new TreeMap<>();
    private static long lastId = 0;

    public RecipeServiceImpl(RecipeFilesService recipeFilesService) {
        this.recipeFilesService = recipeFilesService;
    }

    @PostConstruct
    private void init(){
        readFrommFile();
    }

    @Override
    public long addRecipe(Recipe recipe) {
        recipes.put(lastId, recipe);
        saveToFile();
        return lastId++;
    }

    @Override
    public Recipe getRecipe(long id) {
        for (Recipe r : recipes.values()) {
            Recipe recipe = recipes.get(id);
            if (recipe != null) {
                return recipe;
            }

        }
        return null;

    }

    @Override
    public Recipe editRecipe(long id, Recipe recipe) {
        for (Recipe r : recipes.values()) {
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
        for (Recipe r : recipes.values()) {
            if (recipes.containsKey(id)) {
                recipes.remove(id);
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteAllRecipe() {
        recipes = new TreeMap<>();
    }

    @Override
    public Recipe getAllRecipe() {
        return null;
    }

    /**
     * запись в файл
     */
    private void saveToFile(){

        try {
            String json = new ObjectMapper().writeValueAsString(recipes);
            recipeFilesService.saveRecipesToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * чтение из файла
     */
    private void readFrommFile(){
        try {
            String json = recipeFilesService.readRecipesFromFile();
            recipes =   new ObjectMapper().readValue(json, new TypeReference<TreeMap<Long, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}




