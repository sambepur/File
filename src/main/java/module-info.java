module com.example.file {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.file to javafx.fxml;
    exports com.example.file;
}