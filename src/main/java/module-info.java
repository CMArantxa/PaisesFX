module com.ceica.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens com.ceica.CountryJavaFX to javafx.fxml;
    exports com.ceica.CountryJavaFX;
    exports com.ceica.CountryJavaFX.Models;
    exports com.ceica.CountryJavaFX.Models.Extras;
}