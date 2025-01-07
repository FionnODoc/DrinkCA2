package org.project.drinksca2.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.project.drinksca2.models.Drink;
import org.project.drinksca2.models.Ingredient;
import com.thoughtworks.xstream.XStream;
import org.project.drinksca2.models.Recipe;
import org.project.drinksca2.utils.HashMap;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;

public class MainController {

    @FXML
    private TextField ingredientName;
    @FXML
    private TextField ingredientQuantity;
    @FXML
    private TextField ingredientDescription;
    @FXML
    private TextField alcoholPercentage;
    @FXML
    private Button ingredientAdd;
    @FXML
    private Button ingredientDelete;
    @FXML
    private Button ingredientSave;
    @FXML
    private Button ingredientLoad;
    @FXML
    private Button ingredientReset;
    @FXML
    private Button searchIngredientByName;
    @FXML
    private Button searchIngredientsByDescription;
    @FXML
    private ListView<Ingredient> ingredientList;

    @FXML
    private Button searchByDescription;
    @FXML
    private Button searchByQuantity;
    @FXML
    private Button searchByIngredients;
    @FXML
    private Button ingredientUpdate;

    private XStream xstream;
    private HashMap<String, Ingredient> ingredientsHash = new HashMap<>();
    @FXML
    private ListView<String> searchListView;

    public MainController() {
        xstream = new XStream();
        xstream.alias("ingredient", Ingredient.class);
        xstream.alias("recipe", Recipe.class);
        xstream.alias("drink", Drink.class);
    }

    @FXML
    public void ingredientAdd(ActionEvent event) {
        Ingredient ingredient = new Ingredient(ingredientName.getText(), ingredientDescription.getText(), Double.parseDouble(alcoholPercentage.getText()));
        ingredientList.getItems().add(ingredient);
        ingredientsHash.put(ingredientName.getText(), ingredient);
    }

    @FXML
    public void ingredientDelete(ActionEvent event) {
        Ingredient ingredient = ingredientList.getSelectionModel().getSelectedItem();
        if (ingredient != null) {
            ingredientList.getItems().remove(ingredient);
            ingredientsHash.remove(ingredient.getIngredientName());
        }
    }

    @FXML
    public void ingredientUpdate(ActionEvent event) {
        Ingredient selectedIngredient = ingredientList.getSelectionModel().getSelectedItem();
        if (selectedIngredient != null) {
            ingredientsHash.remove(selectedIngredient.getIngredientName());
            selectedIngredient.setIngredientName(ingredientName.getText());
            selectedIngredient.setIngredientDescription(ingredientDescription.getText());
            selectedIngredient.setABV(Double.parseDouble(alcoholPercentage.getText()));
            ingredientsHash.put(selectedIngredient.getIngredientName(), selectedIngredient);
            ingredientList.refresh();
        }
    }

    @FXML
    public void ingredientSave(ActionEvent event) {
        try {
            FileWriter writer = new FileWriter("ingredients.xml");
            xstream.toXML(ingredientList.getItems(), writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void ingredientLoad(ActionEvent event) {
        try {
            FileReader reader = new FileReader("ingredients.xml");
            ingredientList.getItems().setAll((Ingredient[]) xstream.fromXML(reader));
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void ingredientReset(ActionEvent event) {
        ingredientList.getItems().clear();
        ingredientsHash.clear();
    }

    @FXML
    public void searchIngredientByName(ActionEvent event) {
        String name = ingredientName.getText();
        searchListView.getItems().clear();
        for (Ingredient ingredient : ingredientsHash.values()) {
            if (ingredient.getIngredientName().contains(name)) {
                searchListView.getItems().add(ingredient.toString());
            }
        }
    }

    @FXML
    public void searchIngredientsByDescription(ActionEvent event) {
        String name = ingredientDescription.getText();
        searchListView.getItems().clear();
        for (Ingredient ingredient : ingredientsHash.values()) {
            if (ingredient.getIngredientDescription().contains(name)) {
                searchListView.getItems().add(ingredient.toString());
            }
        }
    }

    @FXML
    private Button sortByAlphabetically;
    @FXML
    private Button sortByAlcohol;

    @FXML
    public void sortByAlcohol(ActionEvent event) {
        ingredientList.getItems().sort(Comparator.comparing(Ingredient::getABV));
        searchListView.getItems().clear();
        for (Ingredient ingredient : ingredientList.getItems()) {
            searchListView.getItems().add(ingredient.toString());
        }
    }

    @FXML
    public void sortByAlphabetically() {
        drinkList.getItems().sort(Comparator.comparing(Drink::getDrinkName));
        searchListView.getItems().clear();
        for (Drink drink : drinkList.getItems()) {
            searchListView.getItems().add(drink.toString());
        }
    }

    @FXML
    public void searchByDescription(ActionEvent event) {
        String searchDescription = ingredientDescription.getText();
        if (ingredientsHash.containsKey(searchDescription)) {
            Ingredient ingredient = ingredientsHash.get(searchDescription);
            ingredientName.setText(ingredient.getIngredientName());
            ingredientQuantity.setText(ingredient.getIngredientQuantity());
            ingredientDescription.setText(ingredient.getIngredientDescription());
            alcoholPercentage.setText(ingredient.getABV().toString());

            ingredientList.getItems().clear();
            ingredientList.getItems().add(ingredient);
        }
    }

    @FXML
    public void searchByQuantity(ActionEvent event) {
        String name = ingredientQuantity.getText();
        searchListView.getItems().clear();
        for (Ingredient ingredient : ingredientsHash.values()) {
            if (ingredient.getIngredientQuantity().contains(name)) {
                searchListView.getItems().add(ingredient.toString());
            }
        }
    }

    @FXML
    public void searchByIngredients(ActionEvent event) {
        String name = ingredientName.getText();
        searchListView.getItems().clear();
        for (Ingredient ingredient : ingredientsHash.values()) {
            if (ingredient.getIngredientName().contains(name)) {
                searchListView.getItems().add(ingredient.toString());
            }
        }
    }

    @FXML
    private TextField recipeName;
    @FXML
    private TextField recipeDescription;
    @FXML
    private ChoiceBox recipeIngredients;
    @FXML
    private TextField recipeQuantity;
    @FXML
    private Button recipeAdd;
    @FXML
    private Button recipeDelete;
    @FXML
    private Button recipeSave;
    @FXML
    private Button recipeLoad;
    @FXML
    private Button recipeReset;
    @FXML
    private Button recipeUpdate;
    @FXML
    private Button searchRecipeByName;
    @FXML
    private Button searchRecipeByDescription;
    @FXML
    private ListView<Recipe> recipeList;
    private HashMap<String, Recipe> recipesHash = new HashMap<>();

    @FXML
    public void recipeAdd(ActionEvent event) {
        Recipe recipe = new Recipe(recipeName.getText(), recipeDescription.getText(), recipeIngredients.getItems().toString(), recipeQuantity.getText());
        recipeList.getItems().add(recipe);
        recipesHash.put(recipeName.getText(), recipe);
    }

    @FXML
    public void recipeDelete(ActionEvent event) {
        Recipe recipe = recipeList.getSelectionModel().getSelectedItem();
        if (recipe != null) {
            recipeList.getItems().remove(recipe);
            recipesHash.remove(recipe.getRecipeName());
        }
    }

    @FXML
    public void recipeSave(ActionEvent event) {
        try {
            FileWriter writer = new FileWriter("recipes.xml");
            xstream.toXML(recipeList.getItems(), writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void recipeLoad(ActionEvent event) {
        try {
            FileReader reader = new FileReader("recipes.xml");
            recipeList.getItems().setAll((Recipe[]) xstream.fromXML(reader));
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void recipeUpdate(ActionEvent event) {
        Recipe selectedRecipe = recipeList.getSelectionModel().getSelectedItem();
        if (selectedRecipe != null) {
            recipesHash.remove(selectedRecipe.getRecipeName());
            selectedRecipe.setRecipeName(recipeName.getText());
            selectedRecipe.setRecipeInstructions(recipeDescription.getText());
            selectedRecipe.setRecipeIngredients(recipeIngredients.getItems().toString());
            selectedRecipe.setIngredientQuantity(recipeQuantity.getText());
            recipesHash.put(selectedRecipe.getRecipeName(), selectedRecipe);
            recipeList.refresh();
        }
    }

    @FXML
    public void recipeReset(ActionEvent event) {
        recipeList.getItems().clear();
        recipesHash.clear();
    }

    @FXML
    public void searchRecipeByName(ActionEvent event) {
        String name = recipeName.getText();
        searchListView.getItems().clear();
        for (Recipe recipe : recipesHash.values()) {
            if (recipe.getRecipeName().contains(name)) {
                searchListView.getItems().add(recipe.toString());
            }
        }
    }

    @FXML
    public void searchRecipeByDescription(ActionEvent event) {
        String name = recipeDescription.getText();
        searchListView.getItems().clear();
        for (Recipe recipe : recipesHash.values()) {
            if (recipe.getRecipeDescription().contains(name)) {
                searchListView.getItems().add(recipe.toString());
            }
        }
    }

    @FXML
    private void searchByName(ActionEvent event) {
        String name = recipeName.getText();
        searchListView.getItems().clear();
        for (Recipe recipe : recipesHash.values()) {
            if (recipe.getRecipeName().contains(name)) {
                searchListView.getItems().add(recipe.toString());
            }
        }
    }

    @FXML
    private TextField drinkName;
    @FXML
    private TextField countryOfOrigin;
    @FXML
    private TextField drinkDescription;
    @FXML
    private TextField imageURL;

    @FXML
    private Button drinkAdd;
    @FXML
    private Button drinkDelete;
    @FXML
    private Button drinkSave;
    @FXML
    private Button drinkLoad;
    @FXML
    private Button drinkReset;
    @FXML
    private Button drinkUpdate;
    @FXML
    private Button searchDrinkByName;
    @FXML
    private Button searchDrinkByDescription;
    @FXML
    private ListView<Drink> drinkList;

    private HashMap<String, Drink> drinksHash = new HashMap<>();

    @FXML
    public void drinkAdd(ActionEvent event) {
        Drink drink = new Drink(drinkName.getText(), drinkDescription.getText(), countryOfOrigin.getText(), imageURL.getText());
        drinkList.getItems().add(drink);
        drinksHash.put(drinkName.getText(), drink);
    }

    @FXML
    public void drinkDelete(ActionEvent event) {
        Drink drink = drinkList.getSelectionModel().getSelectedItem();
        if (drink != null) {
            drinkList.getItems().remove(drink);
            drinksHash.remove(drink.getDrinkName());
        }
    }

    @FXML
    public void drinkSave(ActionEvent event) {
        try {
            FileWriter writer = new FileWriter("drinks.xml");
            xstream.toXML(drinkList.getItems(), writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void drinkLoad(ActionEvent event) {
        try {
            FileReader reader = new FileReader("drinks.xml");
            drinkList.getItems().setAll((Drink[]) xstream.fromXML(reader));
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void drinkUpdate(ActionEvent event) {
        Drink selectedDrink = drinkList.getSelectionModel().getSelectedItem();
        if (selectedDrink != null) {
            drinksHash.remove(selectedDrink.getDrinkName());
            selectedDrink.setDrinkName(drinkName.getText());
            selectedDrink.setDrinkDescription(drinkDescription.getText());
            selectedDrink.setCountryOfOrigin(countryOfOrigin.getText());
            selectedDrink.setImageURL(imageURL.getText());
            drinksHash.put(selectedDrink.getDrinkName(), selectedDrink);
            drinkList.refresh();
        }
    }

    @FXML
    public void drinkReset(ActionEvent event) {
        drinkList.getItems().clear();
        drinksHash.clear();
    }

    @FXML
    public void searchDrinkByName(ActionEvent event) {
        String name = drinkName.getText();
        searchListView.getItems().clear();
        for (Drink drink : drinksHash.values()) {
            if (drink.getDrinkName().contains(name)) {
                searchListView.getItems().add(drink.toString());
            }
        }
    }

    @FXML
    public void searchDrinkByDescription(ActionEvent event) {
        String name = drinkDescription.getText();
        searchListView.getItems().clear();
        for (Drink drink : drinksHash.values()) {
            if (drink.getDrinkDescription().contains(name)) {
                searchListView.getItems().add(drink.toString());
            }
        }
    }

}