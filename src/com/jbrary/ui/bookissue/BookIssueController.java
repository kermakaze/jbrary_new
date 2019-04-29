package com.jbrary.ui.bookissue;

import com.jbrary.ui.util.DialogUtil;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BookIssueController {

    @FXML
    AnchorPane root;



    public void onIssueNewBookButtonClicked(ActionEvent e) throws  Exception{

        DialogUtil.openModalWindow(root,this.getClass(),
                "/com/jbrary/ui/bookissue/issuenewbook.fxml", "Issue New Book");
    }



}
