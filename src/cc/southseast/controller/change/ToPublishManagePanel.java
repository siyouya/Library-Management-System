package cc.southseast.controller.change;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import cc.southseast.view.ui.manage.ManagePanel;

public class ToPublishManagePanel implements EventHandler<MouseEvent> {

    private ManagePanel managePanel;

    public ToPublishManagePanel(ManagePanel managePanel){

        this.managePanel = managePanel;
    }

    @Override
    public void handle(MouseEvent event) {

        managePanel.getPublishManageButton().setStyle("-fx-background-color: #2f3136");
        managePanel.getBookManageButton().setStyle("-fx-background-color: TRANSPARENT");
        managePanel.getBorrowManageButton().setStyle("-fx-background-color: TRANSPARENT");
        managePanel.getUserManageButton().setStyle("-fx-background-color: TRANSPARENT");

    }
}
