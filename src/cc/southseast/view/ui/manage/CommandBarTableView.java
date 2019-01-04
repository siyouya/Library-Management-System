package cc.southseast.view.ui.manage;

import com.jfoenix.controls.JFXButton;
import javafx.scene.layout.HBox;

public class CommandBarTableView extends HBox {

    private JFXButton userEdit = new JFXButton("编辑");

    private JFXButton userDelete = new JFXButton("删除");

    public CommandBarTableView() {

        // 引入样式文件
        this.getStylesheets().add("cc/southseast/view/resources/css/CommandBarTableView.css");

        this.setSpacing(10);

        userEdit.setId("userEdit");
        userDelete.setId("userDelete");


        this.getChildren().addAll(userEdit, userDelete);
    }

    public JFXButton getUserEdit() {
        return userEdit;
    }

    public JFXButton getUserDelete() {
        return userDelete;
    }
}