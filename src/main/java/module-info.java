module com.example.tap2024b {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tap2024b to javafx.fxml;
    exports com.example.tap2024b;
    requires org.kordamp.bootstrapfx.core;
    requires mysql.connector.j;
    requires  java.sql;
    opens com.example.tap2024b.models;

}