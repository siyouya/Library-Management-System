package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.manage.ManagePanel;

public class ToPublishManagePanel implements EventHandler<MouseEvent> {

    private ManagePanel managePanel;

    public ToPublishManagePanel(ManagePanel managePanel){

        this.managePanel = managePanel;
    }

    @Override
    public void handle(MouseEvent event) {

        managePanel.getPublishManageButton().setStyle("-fx-background-color: #aaaaaa");
        managePanel.getBookManageButton().setStyle("-fx-background-color: TRANSPARENT");
        managePanel.getBorrowManageButton().setStyle("-fx-background-color: TRANSPARENT");
        managePanel.getUserManageButton().setStyle("-fx-background-color: TRANSPARENT");

    }
}
