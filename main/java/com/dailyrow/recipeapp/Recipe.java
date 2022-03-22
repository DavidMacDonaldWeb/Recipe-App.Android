package com.dailyrow.recipeapp;

import android.widget.ListView;

public class Recipe {

    private String name;
    private String ingredients;
    private int image;

    public Recipe(String name,String ingredients, int image){
        this.name = name;
        this.ingredients = ingredients;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getIngredients() {
        return ingredients;
    } //Create an ingredient class to utilize it as a list?

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
