package com.jbrary.ui.bookissue;

import com.jbrary.model.Order;
import com.jbrary.model.OrderDao;
import com.jbrary.model.User;
import com.jbrary.model.UserDao;
import com.jbrary.ui.util.DialogUtil;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class BookIssueController  implements Initializable {

    @FXML
    TableView<Order> orderTable;
    @FXML
    AnchorPane root;



    public void onIssueNewBookButtonClicked(ActionEvent e) throws  Exception{

        DialogUtil.openModalWindow(root,this.getClass(),
                "/com/jbrary/ui/bookissue/issuenewbook.fxml", "Issue New Book");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        orderTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        orderTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("orderDate"));

        orderTable.setItems(getOrderList());
    }
    private ObservableList<Order> getOrderList() {


        ObservableList<Order> list = FXCollections.observableArrayList(OrderDao.all());
        return list;
    }
}
