package org.project.drinksca2.models;

public class Recipe {

    private String ingredientQuantity;
    private String recipeName;
    private String recipeDescription;
    private String recipeIngredients;

    public Recipe(String recipeName, String recipeDescription, String recipeIngredients, String ingredientQuantity) {
        this.recipeName = recipeName;
        this.recipeDescription = recipeDescription;
        this.recipeIngredients = recipeIngredients;
        this.ingredientQuantity = ingredientQuantity;

    }
    public String getRecipeName() {return recipeName;}

    public String getIngredientQuantity() {
        return ingredientQuantity;
    }

    public void setIngredientQuantity(String ingredientQuantity) {
        this.ingredientQuantity = ingredientQuantity;
    }

    public void setRecipeDescription(String recipeDescription) {
        this.recipeDescription = recipeDescription;
    }

    public String getRecipeDescription() {return recipeDescription;}

    public String getRecipeIngredients() {return recipeIngredients;}

    public void setRecipeName(String recipeName) {this.recipeName = recipeName;}
    public void setRecipeInstructions(String recipeInstructions) {this.recipeDescription = recipeInstructions;}
    public void setRecipeIngredients(String recipeIngredients) {this.recipeIngredients = recipeIngredients;}

    @Override
    public String toString() {
        return "Recipe: " + recipeName + ", Description: " + recipeDescription + ", Ingredients: " + recipeIngredients + ", Quantity: " + ingredientQuantity;
    }
}
