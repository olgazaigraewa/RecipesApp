package me.olgas.recipesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс- сущность, описывает рецепты.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private String name;
    private int cookingTimeMinutes;
    private ArrayList<Ingredient> ingredientsList;
    private LinkedList<String> steps;




}
