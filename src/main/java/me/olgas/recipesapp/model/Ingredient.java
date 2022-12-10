package me.olgas.recipesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Класс- сущность, описывает ингредиенты.
 */
@Data
@AllArgsConstructor
public class Ingredient {
    private String name;
    private int count;
    private int measureUnit;
}
