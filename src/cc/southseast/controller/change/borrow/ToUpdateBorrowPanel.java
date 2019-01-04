package cc.southseast.controller.change.borrow;

import cc.southseast.model.Borrow;
import cc.southseast.view.ui.base.BasePanel;
import cc.southseast.view.ui.manage.admin.borrow.BorrowUpdatePanel;
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
public class ToUpdateBorrowPanel implements EventHandler<ActionEvent> {

    private TableView tableView = new TableView();

    private Borrow borrow = new Borrow();

    public ToUpdateBorrowPanel(Borrow borrow, TableView tableView) {

        this.tableView = tableView;
        this.borrow = borrow;
    }

    @Override
    public void handle(ActionEvent event) {

        Stage editStage = new Stage();

        BasePanel root = new BasePanel();

        BorrowUpdatePanel borrowUpdatePanel = new BorrowUpdatePanel(tableView, editStage);

        Scene scene = new Scene(root);

        Stage stage = (Stage) tableView.getScene().getWindow();

        root.windowsInit(editStage);

        root.addBorrowUpdatePanel(borrowUpdatePanel);
        borrowUpdatePanel.addUserInformation(borrow);
        // 设置透明度
        scene.setFill(Color.TRANSPARENT);

        editStage.initModality(Modality.WINDOW_MODAL);
        editStage.initOwner(stage);
        editStage.setScene(scene);
        editStage.show();

    }
}