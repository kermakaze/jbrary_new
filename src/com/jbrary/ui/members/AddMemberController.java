package com.jbrary.ui.members;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AddMemberController implements Initializable {


    @FXML
    JFXComboBox<Label> levelComboBox;
    @FXML
    JFXComboBox<Label> hallComboBox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        levelComboBox.getItems()
                .addAll(new Label("Level 100"),
                        new Label("Level 200"),
                        new Label("Level 300"),
                        new Label("Level 400"));
        levelComboBox.setConverter(new StringConverter<Label>() {
            @Override
            public String toString(Label object) {
                return object==null? "" : object.getText();
            }

            @Override
            public Label fromString(String string) {
                return new Label(string);
            }
        });

        hallComboBox.getItems()
                .addAll(new Label("Jean Nelson Aka Hall"),
                        new Label("Elizabeth Frances Sey Hall"),
                        new Label("Alexander Adum Kwapong Hall"),
                        new Label("Dr. Hilla Limann Hall"),
                        new Label("Jubilee Hall"),
                        new Label("Mensah Sarbah Hall"),
                        new Label("Akuafo Hall"),
                        new Label("Legon Hall"),
                        new Label("Volta Hall"),
                        new Label("Commonwealth Hall"),
                        new Label("Pentagon Hostel"),
                        new Label("International Students Hostel(ISH)"),
                        new Label("Valco Graduate Hostel"),
                        new Label("Bani Hostel"),
                        new Label("James Top Nelson Yankah Hall"));
        hallComboBox.setConverter(new StringConverter<Label>() {
            @Override
            public String toString(Label object) {
                return object==null? "" : object.getText();
            }

            @Override
            public Label fromString(String string) {
                return new Label(string);
            }
        });
    }
}
