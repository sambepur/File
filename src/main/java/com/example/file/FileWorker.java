package com.example.file;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FileWorker extends Application {
    public static Button newFile = new Button("New file");
    public Button ViewFiles = new Button("View Files");
    @Override
    public void start(Stage primaryStage) throws Exception {
        //FileWorker.setMain();
        FileCreator.cover();
    }
    static void setMain(){
        AnchorPane main = new AnchorPane(newFile);
        newFile.setPrefHeight(10);
        newFile.setPrefWidth(100);
        AnchorPane.setTopAnchor(newFile,10.0);
        AnchorPane.setLeftAnchor(newFile,30.0);
        Scene scene = new Scene(main,800,800);
        newFile.setOnAction(actionEvent -> FileGetter.setFileGetter());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("FileWriter");
        stage.show();

    }
}
