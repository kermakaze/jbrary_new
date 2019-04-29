package com.jbrary.ui.members;

import com.jbrary.model.Book;
import com.jbrary.model.User;
import com.jbrary.model.UserDao;
import com.jbrary.ui.util.DialogUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MembersController  implements Initializable {

    private static final int NO_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int DOB_INDEX = 2;
    private static final int GENDER_INDEX = 3;
    private static final int LEVEL_INDEX = 4;
    private static final int PROGRAM_INDEX = 5;
    private static final int RESIDENCE_INDEX = 6;

@FXML
    JFXButton addMemberButton;

@FXML
    TableView<User> membersTable;
@FXML AnchorPane root;



    public void onAddMemberButtonClicked(ActionEvent e) throws  Exception{

        DialogUtil.openModalWindow(root,this.getClass(),"/com/jbrary/ui/members/addmember.fxml",
                "Add new Member");

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        membersTable.getColumns().get(NO_INDEX).setCellValueFactory(new PropertyValueFactory<>("id"));
        membersTable.getColumns().get(NAME_INDEX).setCellValueFactory(new PropertyValueFactory<>("name"));
        membersTable.getColumns().get(DOB_INDEX).setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        membersTable.getColumns().get(GENDER_INDEX).setCellValueFactory(new PropertyValueFactory<>("gender"));
        membersTable.getColumns().get(LEVEL_INDEX).setCellValueFactory(new PropertyValueFactory<>("level"));
        membersTable.getColumns().get(PROGRAM_INDEX).setCellValueFactory(new PropertyValueFactory<>("program"));
        membersTable.getColumns().get(RESIDENCE_INDEX).setCellValueFactory(new PropertyValueFactory<>("residence"));

        ObservableList<User> list = getMemberList();
        membersTable.setItems(list);
    }


    private ObservableList<User> getMemberList() {


        ObservableList<User> list = FXCollections.observableArrayList(UserDao.all());
        return list;
    }
}
