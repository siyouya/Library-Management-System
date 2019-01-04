package cc.southseast.controller.change.user;

import cc.southseast.model.User;
import cc.southseast.view.ui.base.BasePanel;
import cc.southseast.view.ui.manage.admin.user.UpdatePanel;
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
public class ToUpdateUserPanel implements EventHandler<ActionEvent> {

    private TableView tableView = new TableView();

    private User user = new User();

    public ToUpdateUserPanel(User user, TableView tableView) {

        this.tableView = tableView;
        this.user = user;
    }

    @Override
    public void handle(ActionEvent event) {

        Stage editStage = new Stage();

        BasePanel root = new BasePanel();

        UpdatePanel updatePanel = new UpdatePanel(tableView, editStage);

        Scene scene = new Scene(root);

        Stage stage = (Stage) tableView.getScene().getWindow();

        root.windowsInit(editStage);

        root.addUpdatePanel(updatePanel);
        updatePanel.addUserInformation(user);
        // 设置透明度
        scene.setFill(Color.TRANSPARENT);

        editStage.initModality(Modality.WINDOW_MODAL);
        editStage.initOwner(stage);
        editStage.setScene(scene);
        editStage.show();

    }
}