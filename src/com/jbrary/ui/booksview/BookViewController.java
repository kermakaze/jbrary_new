
package com.jbrary.ui.booksview;

import com.jbrary.model.Book;
import com.jbrary.model.BookDao;
import com.jbrary.ui.util.DialogUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import sun.misc.BASE64Decoder;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class BookViewController {
    private static final int NO_INDEX = 0;
    private static final int TITLE_INDEX = 1;
    private static final int AUTHOR_INDEX = 2;
    private static final int STATE_INDEX = 3;
    private static final int USER_INDEX = 4;
    private static final int RT_DAY_INDEX_INDEX = 5;

    @FXML
    AnchorPane root;
    @FXML
    GridPane booksGrid;
    @FXML
    ScrollPane scrollPane;

    public void onNewBookButtonClicked(ActionEvent e) throws  Exception{

        DialogUtil.openModalWindow(root,this.getClass(),
                "/com/jbrary/ui/booksview/addbook.fxml", "Add New Book");
    }

    public void initialize() {





        int row=0, col=0;

        for (int i = 0; i <  BookDao.all().size(); i++) {
            Book book = BookDao.all().get(i);
            VBox vBox = new VBox();
            Image bookImage = new Image("com/jbrary/image/demo_book.jpg", 160, 200, true, false);
            vBox.getChildren().add(new ImageView(bookImage));
            vBox.getChildren().add(new Label(book.getTitle()));
            vBox.getChildren().add(new Label(book.getAuthor()));

            vBox.setPadding(new Insets(10,10,10,10));
            booksGrid.add(vBox,col,row);
            col++;
            if (col == 4) {
                col=0;
             row++;}


        }






    }
    private Image getImageFromBase64String(String newValue) throws IOException {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(base64Decoder.decodeBuffer(newValue));
        Image img = new Image(inputStream);
        return img;
    }
    private ObservableList<Book> getBookList() {



        Book book1 = new Book();
        book1.setAuthor("Charles Darwin");
        ObservableList<Book> list = FXCollections.observableArrayList(BookDao.all());
        return list;
    }
}

