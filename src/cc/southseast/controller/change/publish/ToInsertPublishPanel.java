package cc.southseast.controller.change.publish;

import cc.southseast.view.ui.base.BasePanel;
import cc.southseast.view.ui.manage.publish.PublishInsertPanel;
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
public class ToInsertPublishPanel implements EventHandler<ActionEvent> {

    private TableView tableView = new TableView();

    public ToInsertPublishPanel(TableView tableView) {

        this.tableView = tableView;
    }

    @Override
    public void handle(ActionEvent event) {

        Stage addStage = new Stage();

        PublishInsertPanel publishInsertPanel = new PublishInsertPanel(tableView, addStage);

        BasePanel root = new BasePanel();

        root.windowsInit(addStage);

        root.addPublishInsertPanel(publishInsertPanel);

        Scene scene = new Scene(root);

        Stage stage = (Stage) tableView.getScene().getWindow();

        // 设置透明度
        scene.setFill(Color.TRANSPARENT);

        addStage.initModality(Modality.WINDOW_MODAL);
        addStage.initOwner(stage);
        addStage.setScene(scene);
        addStage.show();

    }
}
