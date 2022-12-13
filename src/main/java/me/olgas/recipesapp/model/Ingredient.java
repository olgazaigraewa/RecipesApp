package me.olgas.recipesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Класс- сущность, описывает ингредиенты.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    private String name;
    private int count;
    private String measureUnit;
}
