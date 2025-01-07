package org.project.drinksca2.models;
public class Drink {
    private String drinkName;
    private String drinkDescription;
    private String countryOfOrigin;
    private String imageURL;

    public Drink(String drinkName, String drinkDescription, String countryOfOrigin, String imageURL) {
        this.drinkName = drinkName;
        this.drinkDescription = drinkDescription;
        this.countryOfOrigin = countryOfOrigin;
        this.imageURL = imageURL;

    }
    public String getDrinkName() {return drinkName;}

    public String getDrinkDescription() {return drinkDescription;}

    public String getCountryOfOrigin() {return countryOfOrigin;}

    public String getImageURL() {return imageURL;}

    public void setDrinkName(String drinkName) {this.drinkName = drinkName;}

    public void setDrinkDescription(String drinkDescription) {this.drinkDescription = drinkDescription;}

    public void setCountryOfOrigin(String countryOfOrigin) {this.countryOfOrigin = countryOfOrigin;}

    public void setImageURL(String imageURL) {this.imageURL = imageURL;}

    @Override
    public String toString() {
        return "Drink: " + drinkName + ", Description: " + drinkDescription + ", Country of Origin: " + countryOfOrigin + ", Image: " + imageURL;
    }}
