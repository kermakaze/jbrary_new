package com.jbrary.ui.members;

import com.jbrary.ui.util.DialogUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MembersController {

@FXML
    JFXButton addMemberButton;
@FXML AnchorPane root;


    public void onAddMemberButtonClicked(ActionEvent e) throws  Exception{

        DialogUtil.openModalWindow(root,this.getClass(),"/com/jbrary/ui/members/addmember.fxml", "Add new Member");

    }

/*
    private void openModalWindow(AnchorPane root, Class context, String layoutFilePath, String title) throws IOException {
        Parent win = FXMLLoader.load(context.getClass().getResource(layoutFilePath));
        Stage newWindow = new Stage();



        newWindow.setTitle(title);
        // Specifies the modality for new window.
        newWindow.initModality(Modality.WINDOW_MODAL);
        newWindow.setResizable(false);
        newWindow.setX(root.getScene().getWindow().getX() + 200);
        newWindow.setY(root.getScene().getWindow().getY() - 50);
        newWindow.setMinWidth(500);
        newWindow.setScene(new Scene(win));

        // Specifies the owner Window (parent) for new window
        newWindow.initOwner(root.getScene().getWindow());
        newWindow.show();
    }
*/


}
