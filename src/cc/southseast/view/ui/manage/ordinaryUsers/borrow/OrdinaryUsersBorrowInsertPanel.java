package cc.southseast.view.ui.manage.ordinaryUsers.borrow;

import cc.southseast.controller.function.ToClose;
import cc.southseast.controller.function.borrow.ToInsertBorrow;
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
public class OrdinaryUsersBorrowInsertPanel extends GridPane {

//    private JFXListView
    private Label idLabel = new Label("借阅人账号");
    private Label bookIdLabel = new Label("书号");
    private JFXTextField idInput = new JFXTextField();
    private JFXTextField bookIdInput = new JFXTextField();
    private JFXButton addButton = new JFXButton("添加");
    private JFXButton quitButton = new JFXButton("取消");

    public OrdinaryUsersBorrowInsertPanel(TableView tableView, Stage addStage) {

        // 引入样式文件
        this.getStylesheets().add("cc/southseast/view/resources/css/EditPanel.css");
        this.setPadding(new Insets(0,20,20,20));
        this.setHgap(10);
        this.setVgap(10);

        addButton.setId("saveButton");
        addButton.setOnAction(new ToInsertBorrow(tableView, idInput, bookIdInput, addStage));
        addButton.setMinWidth(45);
        quitButton.setId("quitButton");
        quitButton.setOnAction(new ToClose(addStage));

        this.add(idLabel, 0, 0);
        this.add(idInput, 1, 0);
        this.add(bookIdLabel, 0, 1);
        this.add(bookIdInput, 1, 1);
        this.add(addButton, 0, 3);
        this.add(quitButton, 1, 3);

    }
}
