package com.example.file;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FileGetter {
    public static TextArea NewDirName = new TextArea();
    private static final Label DN = new Label("Имя директории для сохранения:");
    private static final Label NDN = new Label("Имя Новой директории:");
    public static TextArea DirName = new TextArea();
    static Button save = new Button("Сохранить");
    static Button Keeper = new Button("Продолжить в существующей директории");

    public static void setFileGetter(){
        AnchorPane getter = new AnchorPane(NDN,NewDirName,DirName,DN,save,Keeper);
        Scene Getter = new Scene(getter, 570,150);
        Stage stage = new Stage();
        stage.setScene(Getter);
        stage.setTitle("File getter");
        AnchorPane.setLeftAnchor(NDN, 300.0);
        AnchorPane.setTopAnchor(NDN, 11.0);
        NewDirName.setPrefWidth(100);
        NewDirName.setPrefHeight(7);
        AnchorPane.setLeftAnchor(NewDirName, 445.0);
        AnchorPane.setTopAnchor(NewDirName,11.0);
        DirName.setPrefWidth(100);
        DirName.setPrefHeight(7);
        AnchorPane.setLeftAnchor(DirName, 195.0);
        AnchorPane.setTopAnchor(DirName,11.0);
        AnchorPane.setLeftAnchor(DN, 8.0);
        AnchorPane.setTopAnchor(DN, 11.0);
        save.setPrefWidth(100);
        save.setPrefHeight(10);
        AnchorPane.setLeftAnchor(save,225.0);
        AnchorPane.setTopAnchor(save, 55.0);
        Keeper.setPrefWidth(270);
        Keeper.setPrefHeight(10);
        AnchorPane.setLeftAnchor(Keeper, 155.0);
        AnchorPane.setTopAnchor(Keeper, 85.0);
        //Keeper.setOnAction(actionEvent -> );
        stage.show();
    }
}
