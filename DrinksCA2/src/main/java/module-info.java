module org.project.drinksca2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.project.drinksca2 to javafx.fxml;
    exports org.project.drinksca2;
}