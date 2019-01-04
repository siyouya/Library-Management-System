package cc.southseast.controller.change.publish;

import cc.southseast.model.Publish;
import cc.southseast.view.ui.base.BasePanel;
import cc.southseast.view.ui.manage.publish.PublishUpdatePanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @Author: Southseast
 * @Date: 2019/1/1 7:09 PM
 * @Version 1.0
 */
public class ToUpdatePublishPanel implements EventHandler<ActionEvent> {

    private TableView tableView = new TableView();

    private Publish publish = new Publish();

    public ToUpdatePublishPanel(Publish publish, TableView tableView) {

        this.tableView = tableView;
        this.publish = publish;
    }

    @Override
    public void handle(ActionEvent event) {

        Stage editStage = new Stage();

        BasePanel root = new BasePanel();

        PublishUpdatePanel publishUpdatePanel = new PublishUpdatePanel(tableView, editStage);

        Scene scene = new Scene(root);

        Stage stage = (Stage) tableView.getScene().getWindow();

        root.windowsInit(editStage);

        root.addPublishUpdatePanel(publishUpdatePanel);
        publishUpdatePanel.addUserInformation(publish);
        // 设置透明度
        scene.setFill(Color.TRANSPARENT);

        editStage.initModality(Modality.WINDOW_MODAL);
        editStage.initOwner(stage);
        editStage.setScene(scene);
        editStage.show();

    }
}