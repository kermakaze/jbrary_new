package com.jbrary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static com.sun.org.apache.xerces.internal.utils.SecuritySupport.getResourceAsStream;

public class Main extends Application {

    public static void main(String[] args) {
	// write your code here


        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Font.loadFont(getClass().getResource("/com/jbrary/fonts/HelveticaNeuBold.ttf").toExternalForm(), 10);

        Parent root = FXMLLoader.load(getClass().getResource("/com/jbrary/ui/home/home.fxml"));
        primaryStage.setTitle("JBrary");
        primaryStage.setResizable(false);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.getIcons().add(
                new Image(Main.class.getResourceAsStream( "/com/jbrary/image/logo.png" )));
        primaryStage.show();

    }
}
