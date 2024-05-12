package com.example.file;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import static com.example.file.FileGetter.DirName;
import static com.example.file.FileGetter.NewDirName;

public class FileCreator {
    static String Path = DirName.getText().trim()+"://"+NewDirName.getText().trim();
    static File dir = new File(Path);



    static Label OS = new Label("Осмотр:");
    static TextArea os = new TextArea();

    static Label FIO = new Label("Ф.И.О Пациента:");
    static TextArea fio = new TextArea();

    static Label DR = new Label("Дата рождения:");
    static ObservableList<String> typesDT = FXCollections.observableArrayList("01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31");
    static ObservableList<String> typesY = getYears();
    static ObservableList<String> typesM = FXCollections.observableArrayList("01","02","03","04","05","06","07","08","09","10","11","12");

    static ObservableList<String> getYears(){
        ObservableList<String> Years = FXCollections.observableArrayList();
        for(int i = 1960; i<2031; i++){
            Years.add(""+i);
        }
        return Years;
    }

    static ChoiceBox<String> DRDays = new ChoiceBox<>(typesDT);
    static ChoiceBox<String> DRMonths = new ChoiceBox<>(typesM);
    static ChoiceBox<String> DRYears = new ChoiceBox<>(typesY);
    static Label DT =new Label("Дата: "+ LocalDate.now());

    static Label J = new Label("Жалобы: ");
    static TextArea j = new TextArea();
    static ObservableList<String> typesJ = FXCollections.observableArrayList("Есть", "Нет");
    static ChoiceBox<String> jcheck = new ChoiceBox<>(typesJ);


    static Label AN = new Label("Анамнез: травма ");
    static Label D = new Label("Дата: ");
    static ChoiceBox<String> DRDaysCopy = new ChoiceBox<>(typesDT);
    static ChoiceBox<String> DRMonthsCopy = new ChoiceBox<>(typesM);
    static ChoiceBox<String> DRYearsCopyCopy = new ChoiceBox<>(typesY);
    static TextArea an = new TextArea();
    static ObservableList<String> TraumaTypes = FXCollections.observableArrayList("домашняя", "получена вне дома");
    static ChoiceBox<String> trauma = new ChoiceBox<>(TraumaTypes);


    static Label OBS = new Label("Общее состояние: ");
    static ObservableList<String> typesOBS = FXCollections.observableArrayList("Умеренное", "Плохое","Удовлетворительное");
    static ChoiceBox<String> obs = new ChoiceBox<>(typesOBS);


    static Label OAD = new Label("Объём активных движений: ");
    static ObservableList<String> typesOAD = FXCollections.observableArrayList("полный","Не полный");
    static ChoiceBox<String> oad = new ChoiceBox<>(typesOAD);


    static Label Bones = new Label("Костная система");

    static Label PK = new Label("Положение конечностей: ");
    static ObservableList<String> typesPK = FXCollections.observableArrayList("Активное","Не активное");
    static ChoiceBox<String> pk = new ChoiceBox<>(typesPK);


    static Label OVK = new Label("Оси верхних конечностей: ");
    static ObservableList<String> typesNO = FXCollections.observableArrayList("Нормальное","Не нормальное");
    static ChoiceBox<String> ovk = new ChoiceBox<>(typesNO);


    static Label S = new Label("Стопы: ");
    static ChoiceBox<String> s = new ChoiceBox<>(typesNO);

    static Label ODSVK = new Label("Объем движений суставов верхних конечностей: ");
    static TextArea odsvk = new TextArea();
    static ChoiceBox<String> Odsvk = new ChoiceBox<>(typesOAD);
    static Label COPY = ODSVK;

    static Label DIA = new Label("Диагноз: ");
    static TextArea dia = new TextArea();

    static Label FORM = new Label("Форма: ");
    static ObservableList<String> typesForm = FXCollections.observableArrayList("острая","подострая","хроническая");
    static ChoiceBox<String> form = new ChoiceBox<>(typesForm);

    static Label NS = new Label("Назначения");
    static TextArea ns = new TextArea();


    static void Create(String FileName){
        File file = new File("C://"+DirName.getText().trim()+"://"+NewDirName.getText().trim(), FileName.trim()+".txt");
        try(FileWriter writer = new FileWriter(file, false)){
            writer.write("Осмотр: "+os.getText());
            writer.write("\n\nФ.И.О "+fio.getText()+" "+DRDays.getValue()+"."+DRMonths.getValue()+"."+DRYears.getValue());
            if (jcheck.getValue().equals("Нет"))
                writer.write("\n\nДата "+DT.getText()+" "+"Жалобы: "+jcheck.getValue()+"\n");
            else
                writer.write("\n\nДата "+DT.getText()+" "+"Жалобы: "+jcheck.getValue()+", "+j.getText());
            writer.write("\n\n"+AN.getText()+DRDaysCopy.getValue()+"."+DRMonthsCopy.getValue()+"."+DRYearsCopyCopy.getValue()+" "+trauma.getValue()+" "+an.getText());
            writer.write("\n\n"+OBS.getText()+obs.getValue());
            writer.write("\n\n"+OAD.getText()+oad.getValue());
            writer.write("\n\nКОСТНАЯ СИСТЕМА\n");
            writer.write("\n\n"+PK.getText()+pk.getValue());
            writer.write("\n\n"+OVK.getText()+ovk.getValue());
            writer.write("\n\n"+S.getText()+s.getValue());
            writer.write("\n\n"+ODSVK.getText()+odsvk.getText());
            writer.write("\n\n"+ODSVK.getText()+Odsvk.getValue());
            writer.write("\n\n"+DIA.getText()+dia.getText());
            writer.write("\n\n"+FORM.getText()+form.getValue());
            writer.write("\n\n"+NS.getText()+ns.getText()+"\n\nЯвка при жалобах");
            writer.flush();
        }
        catch (IOException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Указан неверный файл или путь");
            alert.show();
        }
    }
    static void cover(){
        AnchorPane pane = new AnchorPane(OS,os,FIO,fio,DR,DRDays,DRMonths,
                DRYears,DT,J,j,jcheck,AN,
                DRDaysCopy,DRMonthsCopy,DRYearsCopyCopy
                ,trauma,an,OBS,obs,OAD,oad,Bones,PK,pk);
        Scene scene = new Scene(pane, 800,800);
        Stage stage = new Stage();

        AnchorPane.setLeftAnchor(OS,8.0);
        AnchorPane.setTopAnchor(OS,12.0);
        os.setPrefWidth(120);
        os.setPrefHeight(10);
        AnchorPane.setLeftAnchor(os,60.0);
        AnchorPane.setTopAnchor(os,7.0);

        AnchorPane.setLeftAnchor(FIO, 8.0);
        AnchorPane.setTopAnchor(FIO,62.0);
        fio.setPrefWidth(150);
        fio.setPrefHeight(10);
        AnchorPane.setLeftAnchor(fio, 110.0);
        AnchorPane.setTopAnchor(fio,52.0);

        AnchorPane.setLeftAnchor(DR, 270.0);
        AnchorPane.setTopAnchor(DR, 62.0);

        DRDays.setPrefWidth(30);
        DRDays.setPrefHeight(10);
        AnchorPane.setLeftAnchor(DRDays,380.0);
        AnchorPane.setTopAnchor(DRDays,56.0);

        DRMonths.setPrefWidth(30);
        DRMonths.setPrefHeight(10);
        AnchorPane.setLeftAnchor(DRMonths,415.0);
        AnchorPane.setTopAnchor(DRMonths,56.0);

        DRYears.setPrefWidth(60);
        DRYears.setPrefHeight(10);
        AnchorPane.setLeftAnchor(DRYears,450.0);
        AnchorPane.setTopAnchor(DRYears,56.0);


        AnchorPane.setLeftAnchor(DT,8.0);
        AnchorPane.setTopAnchor(DT,115.0);

        AnchorPane.setLeftAnchor(J,125.0);
        AnchorPane.setTopAnchor(J,115.0);
        j.setPrefWidth(550);
        j.setPrefHeight(10);
        AnchorPane.setLeftAnchor(j,260.0);
        AnchorPane.setTopAnchor(j,110.0);

        jcheck.setPrefWidth(70);
        jcheck.setPrefHeight(10);
        AnchorPane.setLeftAnchor(jcheck, 185.0);
        AnchorPane.setTopAnchor(jcheck,114.0);

        AnchorPane.setLeftAnchor(AN,8.0);
        AnchorPane.setTopAnchor(AN,160.0);

        DRDaysCopy.setPrefWidth(30);
        DRDaysCopy.setPrefHeight(10);
        AnchorPane.setLeftAnchor(DRDaysCopy,110.0);
        AnchorPane.setTopAnchor(DRDaysCopy,160.0);

        DRMonthsCopy.setPrefWidth(30);
        DRMonthsCopy.setPrefHeight(10);
        AnchorPane.setLeftAnchor(DRMonthsCopy, 145.0);
        AnchorPane.setTopAnchor(DRMonthsCopy,160.0);

        DRYearsCopyCopy.setPrefWidth(60);
        DRYearsCopyCopy.setPrefHeight(10);
        AnchorPane.setLeftAnchor(DRYearsCopyCopy, 180.0);
        AnchorPane.setTopAnchor(DRYearsCopyCopy,160.0);


        trauma.setPrefWidth(140);
        trauma.setPrefHeight(10);
        AnchorPane.setLeftAnchor(trauma,250.0);
        AnchorPane.setTopAnchor(trauma, 160.0);

        an.setPrefWidth(400);
        an.setPrefHeight(120);
        AnchorPane.setLeftAnchor(an,393.0);
        AnchorPane.setTopAnchor(an,160.0);

        AnchorPane.setLeftAnchor(OBS, 8.0);
        AnchorPane.setTopAnchor(OBS, 210.0);

        obs.setPrefWidth(140);
        obs.setPrefHeight(10);
        AnchorPane.setLeftAnchor(obs, 120.0);
        AnchorPane.setTopAnchor(obs, 207.0);

        OAD.setPrefWidth(160);
        OAD.setPrefHeight(10);
        AnchorPane.setLeftAnchor(OAD,8.0);
        AnchorPane.setTopAnchor(OAD, 270.0);

        oad.setPrefWidth(120);
        oad.setPrefHeight(10);
        AnchorPane.setLeftAnchor(oad,170.0);
        AnchorPane.setTopAnchor(oad,267.0);

        AnchorPane.setLeftAnchor(Bones,30.0);
        AnchorPane.setTopAnchor(Bones, 313.0);

        AnchorPane.setLeftAnchor(PK, 8.0);
        AnchorPane.setTopAnchor(PK, 360.0);

        pk.setPrefWidth(120);
        pk.setPrefHeight(10);
        AnchorPane.setLeftAnchor(pk,160.0);
        AnchorPane.setTopAnchor(pk,357.0);



        obs.setValue("Умеренное");
        oad.setValue("Полный");
        pk.setValue("Активное");
        ovk.setValue("Нормальное");
        jcheck.setOnAction(event -> {if (jcheck.getValue().equals("Нет")) j.setText("Записи из этого поля не будут добавлены в файл"); else j.setText("");});
        stage.setScene(scene);
        stage.setTitle("File Creator");
        stage.show();
    }
    static void Check(){

    }
}




