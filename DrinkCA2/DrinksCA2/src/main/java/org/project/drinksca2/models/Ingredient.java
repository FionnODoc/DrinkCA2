package org.project.drinksca2.models;

public class Ingredient {
    private String ingredientName;
    private String ingredientQuantity;
    private String ingredientDescription;
    private Double ABV;

    public Ingredient(String ingredientName, String ingredientDescription, Double ABV) {
        this.ingredientName = ingredientName;
        this.ingredientDescription = ingredientDescription;
        this.ABV = ABV;
    }

    public String getIngredientName() {return ingredientName;}

    public String getIngredientQuantity() {return ingredientQuantity;}

    public String getIngredientDescription() {return ingredientDescription;}

    public Double getABV() {return ABV;}

    public void setABV(Double ABV) {this.ABV = ABV;}

    public void setIngredientName(String ingredientName) {this.ingredientName = ingredientName;}

    public void setIngredientQuantity(String ingredientQuantity) {this.ingredientQuantity = ingredientQuantity;}

    public void setIngredientDescription(String ingredientDescription) {this.ingredientDescription = ingredientDescription;}

    @Override
    public String toString() {
        return "Ingredient: " + ingredientName  + ", Description: " + ingredientDescription + ", ABV: " + ABV;
    }
}

