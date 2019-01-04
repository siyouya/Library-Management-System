package cc.southseast.view.ui.manage.admin.book;

import cc.southseast.controller.function.ToClose;
import cc.southseast.controller.function.book.ToInsertBook;
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
public class BookInsertPanel extends GridPane {

//    private JFXListView
    private Label idLabel = new Label("书号");
    private Label nameLabel = new Label("书名");
    private Label writerLabel = new Label("作者");
    private Label priceLabel = new Label("价格");
    private Label publishLabel = new Label("出版社号");
    private JFXTextField idInput = new JFXTextField();
    private JFXTextField nameInput = new JFXTextField();
    private JFXTextField writerInput = new JFXTextField();
    private JFXTextField priceInput = new JFXTextField();
    private JFXTextField publishInput = new JFXTextField();
    private JFXButton addButton = new JFXButton("添加");
    private JFXButton quitButton = new JFXButton("取消");

    public BookInsertPanel(TableView tableView, Stage addStage) {

        // 引入样式文件
        this.getStylesheets().add("cc/southseast/view/resources/css/EditPanel.css");
        this.setPadding(new Insets(0,20,20,20));
        this.setHgap(10);
        this.setVgap(10);

        addButton.setId("saveButton");
        addButton.setOnAction(new ToInsertBook(tableView, idInput, nameInput,
                writerInput, priceInput, publishInput, addStage));
        addButton.setMinWidth(45);
        quitButton.setId("quitButton");
        quitButton.setOnAction(new ToClose(addStage));

        this.add(idLabel, 0, 0);
        this.add(idInput, 1, 0);
        this.add(nameLabel, 0, 1);
        this.add(nameInput, 1, 1);
        this.add(writerLabel, 0, 2);
        this.add(writerInput, 1, 2);
        this.add(priceLabel, 0, 3);
        this.add(priceInput, 1, 3);
        this.add(publishLabel, 0, 4);
        this.add(publishInput, 1, 4);
        this.add(addButton, 0, 6);
        this.add(quitButton, 1, 6);

    }
}
