package cc.southseast.view.ui.manage.admin.publish;

import cc.southseast.controller.function.ToClose;
import cc.southseast.controller.function.publish.ToInsertPublish;
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
public class PublishInsertPanel extends GridPane {

//    private JFXListView
private Label publishIdLabel = new Label("出版社号");
    private Label publishNameLabel = new Label("出版社名");
    private Label publishPhoneLabel = new Label("出版社电话");
    private JFXTextField publishIdInput = new JFXTextField();
    private JFXTextField publishNameInput = new JFXTextField();
    private JFXTextField publishPhoneInput = new JFXTextField();
    private JFXButton addButton = new JFXButton("添加");
    private JFXButton quitButton = new JFXButton("取消");

    public PublishInsertPanel(TableView tableView, Stage addStage) {

        // 引入样式文件
        this.getStylesheets().add("cc/southseast/view/resources/css/EditPanel.css");
        this.setPadding(new Insets(0,20,20,20));
        this.setHgap(10);
        this.setVgap(10);

        addButton.setId("saveButton");
        addButton.setOnAction(new ToInsertPublish(tableView, publishIdInput, publishNameInput,
                publishPhoneInput, addStage));
        addButton.setMinWidth(45);
        quitButton.setId("quitButton");
        quitButton.setOnAction(new ToClose(addStage));

        this.add(publishIdLabel, 0, 0);
        this.add(publishIdInput, 1, 0);
        this.add(publishNameLabel, 0, 1);
        this.add(publishNameInput, 1, 1);
        this.add(publishPhoneLabel, 0, 2);
        this.add(publishPhoneInput, 1, 2);
        this.add(addButton, 0, 4);
        this.add(quitButton, 1, 4);

    }
}
