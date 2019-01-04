package cc.southseast.view.ui.manage.book;

import cc.southseast.controller.function.ToClose;
import cc.southseast.controller.function.book.ToUpdateBook;
import cc.southseast.controller.function.user.ToUpdateUser;
import cc.southseast.model.Book;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @Author: Southseast
 * @Date: 2019/1/1 7:21 PM
 * @Version 1.0
 */
public class BookUpdatePanel extends GridPane {

//    private JFXListView
    private Label idLabel = new Label("书号");
    private Label nameLabel = new Label("书名");
    private Label writerLabel = new Label("作者");
    private Label priceLabel = new Label("价格");
    private Label publishLabel = new Label("出版社号");
    private JFXButton updateButton = new JFXButton("保存");
    private JFXButton quitButton = new JFXButton("取消");
    private Label id = new Label();
    private JFXTextField nameInput = new JFXTextField();
    private JFXTextField writerInput = new JFXTextField();
    private JFXTextField priceInput = new JFXTextField();
    private JFXTextField publishInput = new JFXTextField();

    public BookUpdatePanel(TableView tableView, Stage editStage) {

        // 引入样式文件
        this.getStylesheets().add("cc/southseast/view/resources/css/EditPanel.css");
        this.setPadding(new Insets(0,20,20,20));
        this.setHgap(10);
        this.setVgap(10);

        updateButton.setId("saveButton");
        updateButton.setOnAction(new ToUpdateBook(tableView, id, nameInput,
                writerInput, priceInput, publishInput, editStage));
        updateButton.setMinWidth(45);
        quitButton.setId("quitButton");
        quitButton.setOnAction(new ToClose(editStage));

        this.add(idLabel, 0, 0);
        this.add(id, 1, 0);
        this.add(nameLabel, 0, 1);
        this.add(nameInput, 1, 1);
        this.add(writerLabel, 0, 2);
        this.add(writerInput, 1, 2);
        this.add(priceLabel, 0, 3);
        this.add(priceInput, 1, 3);
        this.add(publishLabel, 0, 4);
        this.add(publishInput, 1, 4);
        this.add(updateButton, 0, 6);
        this.add(quitButton, 1, 6);

    }

    public void addUserInformation(Book book) {
        id.setText(String.valueOf(book.getBookId()));
        nameInput.setText(book.getBookName());
        writerInput.setText(book.getWriter());
        priceInput.setText(""+book.getBookPrice());
        publishInput.setText(""+book.getPublishId());
    }

}
