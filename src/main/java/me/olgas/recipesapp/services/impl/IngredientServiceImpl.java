package me.olgas.recipesapp.services.impl;

import me.olgas.recipesapp.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service
public class IngredientServiceImpl implements IngredientService{

    private static final Map<Long, Ingredient> ingredients = new TreeMap<>();
    private static long lastId = 0;


    @Override
    public long addIngredient(Ingredient ingredient) {
        ingredients.put(lastId, ingredient);
        return lastId++;
    }

    @Override
    public long getIngredient(Ingredient ingredient) {
       return 0;
    }

    @Override
    public Ingredient getIngredient(long id) {
        return ingredients.get(id);
    }
}
