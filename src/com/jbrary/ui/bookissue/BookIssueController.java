package com.jbrary.ui.bookissue;

import com.jbrary.model.Order;
import com.jbrary.model.OrderDao;
import com.jbrary.model.User;
import com.jbrary.model.UserDao;
import com.jbrary.ui.util.DialogUtil;
import com.jfoenix.controls.JFXButton;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class BookIssueController  implements Initializable {

    @FXML
    TableView<Order> orderTable;
    @FXML
    AnchorPane root;
    @FXML TableColumn<Order, String> titleColumn,
    authorColumn,stateColumn, userColumn, returnColumn, finesColumn;



    public void onIssueNewBookButtonClicked(ActionEvent e) throws  Exception{

        DialogUtil.openModalWindow(root,this.getClass(),
                "/com/jbrary/ui/bookissue/issuenewbook.fxml", "Issue New Book");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        loadDataIntoTable();
    }

    public void loadDataIntoTable() {
        orderTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));

        /*TableColumn<Order, String> titleColumn = new TableColumn<>();*/


        titleColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Order, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Order, String> data) {
                StringProperty sp = new SimpleStringProperty();
                sp.setValue(String.valueOf(data.getValue().getBook().getTitle()));
                return sp;
            }
        });

        authorColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Order, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Order, String> param) {
                StringProperty sp = new SimpleStringProperty();
                sp.setValue(String.valueOf(param.getValue().getBook().getAuthor()));
                return sp;
            }
        });

        userColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Order, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Order, String> param) {
                StringProperty sp = new SimpleStringProperty();
                sp.setValue(String.valueOf(param.getValue().getUser().getName()));
                return sp;
            }
        });

        returnColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Order, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Order, String> param) {
                StringProperty sp = new SimpleStringProperty();
                sp.setValue(String.valueOf(param.getValue().getDueDateString()));
                return sp;
            }
        });
        finesColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Order, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Order, String> param) {
                StringProperty sp = new SimpleStringProperty();
                sp.setValue(String.valueOf(param.getValue().getFine()));
                return sp;
            }
        });


        orderTable.setItems(getOrderList());
    }

    private ObservableList<Order> getOrderList() {


        ObservableList<Order> list = FXCollections.observableArrayList(OrderDao.all());
        return list;
    }

    @FXML
    void reloadList(){
        orderTable.getColumns().get(0).setVisible(false);
        orderTable.getColumns().get(0).setVisible(true);
        orderTable.getItems().removeAll(orderTable.getItems());
        orderTable.setItems(getOrderList());
        titleColumn.setText("Hey");
        root.setVisible(false);

    }

}
