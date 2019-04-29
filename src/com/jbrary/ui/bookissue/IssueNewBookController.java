package com.jbrary.ui.bookissue;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.util.StringConverter;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class IssueNewBookController implements Initializable {


    @FXML
    JFXComboBox<Label> memberComboBox;
    @FXML
    JFXComboBox<Label> bookComboBox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        bookComboBox.getItems()
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
        bookComboBox.setConverter(new StringConverter<Label>() {
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
