package cc.southseast.controller.change.borrow;

import cc.southseast.view.ui.base.BasePanel;
import cc.southseast.view.ui.manage.admin.borrow.BorrowInsertPanel;
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
public class ToInsertBorrowPanel implements EventHandler<ActionEvent> {

    private TableView tableView = new TableView();

    public ToInsertBorrowPanel(TableView tableView) {

        this.tableView = tableView;
    }

    @Override
    public void handle(ActionEvent event) {

        Stage addStage = new Stage();

        BorrowInsertPanel borrowInsertPanel = new BorrowInsertPanel(tableView, addStage);

        BasePanel root = new BasePanel();

        root.windowsInit(addStage);

        root.addBorrowInsertPanel(borrowInsertPanel);

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
