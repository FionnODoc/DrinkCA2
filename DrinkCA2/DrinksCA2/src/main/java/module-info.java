module org.project.drinksca2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires xstream;
    requires java.desktop;

    exports org.project.drinksca2;
    exports org.project.drinksca2.models;
    exports org.project.drinksca2.utils;
    exports org.project.drinksca2.controllers to javafx.fxml;

    opens org.project.drinksca2.controllers to javafx.fxml;
}