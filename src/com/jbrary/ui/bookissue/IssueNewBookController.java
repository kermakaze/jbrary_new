package com.jbrary.ui.bookissue;

import com.jbrary.model.*;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.awt.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class IssueNewBookController implements Initializable {


    @FXML
    JFXComboBox<Label> memberComboBox;
    @FXML
    JFXComboBox<Label> bookComboBox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        List<Label> bookLabel = new ArrayList<>();
        BookDao.all().forEach(new Consumer<Book>() {
            @Override
            public void accept(Book book) {
                bookLabel.add(new Label(book.getTitle()));
            }
        });
        bookComboBox.getItems()
                .addAll(bookLabel);
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

        List<Label> memberLabels = new ArrayList<>();
        UserDao.all().forEach(new Consumer<User>() {
            @Override
            public void accept(User user) {
                memberLabels.add(new Label(user.getName()));
            }
        });
        memberComboBox.getItems()
                .addAll(memberLabels);

        memberComboBox.setConverter(new StringConverter<Label>() {
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

    public void onIssueBookButtonClicked(ActionEvent e){

        try {
            User user = UserDao.find(5);
            Book book = BookDao.find(1);

            LocalDate dateFromBase = LocalDate.ofEpochDay(365);
            Order order = new Order(user, book, dateFromBase,LocalDate.now());
            OrderDao.insert(order);
            Stage stage = (Stage) bookComboBox.getScene().getWindow();
            stage.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/jbrary/ui/bookissue/bookissue.fxml"));
            Parent root = (Parent) loader.load();

            //Get controller of scene2
            BookIssueController bookIssueController = loader.getController();
            //Pass whatever data you want. You can have multiple method calls here
            bookIssueController.reloadList();
            bookIssueController.orderTable=null;


        }
        catch (Exception exception){
            System.err.println("Error occurred");
            exception.printStackTrace();


        }

    }
}
