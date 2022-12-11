package me.olgas.recipesapp.services.impl;

import me.olgas.recipesapp.model.Ingredient;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.TreeMap;

@Service
public class IngredientServiceImpl implements IngredientService {

    private static Map<Long, Ingredient> ingredients = new TreeMap<>();
    private static long lastId = 0;


    @Override
    public long addIngredient(Ingredient ingredient) {
        ingredients.put(lastId, ingredient);
        return lastId++;
    }

    @Override
    public Ingredient getIngredient(long id) {
        for (Ingredient n : ingredients.values()) {
            Ingredient ingredient = ingredients.get(id);
            if (ingredient != null) {
                return ingredient;
            }

        }
        return null;
    }

    @Override
    public Ingredient getAllIngredient() {
        return null;
    }

    @Override
    public Ingredient editIngredient(long id, Ingredient ingredient) {
        for (Ingredient n : ingredients.values()) {
            if (ingredients.containsKey(id)) {
                ingredients.put(id, ingredient);
                return ingredient;
            }
        }
        return null;
    }

    @Override
    public boolean deleteIngredient(long id) {
        for (Ingredient n : ingredients.values()) {
            if (ingredients.containsKey(id)) {
                ingredients.remove(id);
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteAllIngredient() {
        ingredients = new TreeMap<>();
    }
}
