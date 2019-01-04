package cc.southseast.view.ui.manage.admin.publish;

import cc.southseast.controller.function.ToClose;
import cc.southseast.controller.function.publish.ToUpdatePublish;
import cc.southseast.model.Publish;
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
public class PublishUpdatePanel extends GridPane {

//    private JFXListView
    private Label publishIdLabel = new Label("出版社号");
    private Label publishNameLabel = new Label("出版社名");
    private Label publishPhoneLabel = new Label("出版社电话");
    private JFXButton updateButton = new JFXButton("保存");
    private JFXButton quitButton = new JFXButton("取消");
    private Label publishId = new Label();
    private JFXTextField publishNameInput = new JFXTextField();
    private JFXTextField publishPhoneInput = new JFXTextField();

    public PublishUpdatePanel(TableView tableView, Stage editStage) {

        // 引入样式文件
        this.getStylesheets().add("cc/southseast/view/resources/css/EditPanel.css");
        this.setPadding(new Insets(0,20,20,20));
        this.setHgap(10);
        this.setVgap(10);

        updateButton.setId("saveButton");
        updateButton.setOnAction(new ToUpdatePublish(tableView, publishId, publishNameInput,
                publishPhoneInput, editStage));
        updateButton.setMinWidth(45);
        quitButton.setId("quitButton");
        quitButton.setOnAction(new ToClose(editStage));

        this.add(publishIdLabel, 0, 0);
        this.add(publishId, 1, 0);
        this.add(publishNameLabel, 0, 1);
        this.add(publishNameInput, 1, 1);
        this.add(publishPhoneLabel, 0, 2);
        this.add(publishPhoneInput, 1, 2);
        this.add(updateButton, 0, 4);
        this.add(quitButton, 1, 4);

    }

    public void addUserInformation(Publish publish) {
        publishId.setText(String.valueOf(publish.getPublishId()));
        publishNameInput.setText(publish.getPublishName());
        publishPhoneInput.setText(publish.getPublishPhone());
    }

}
