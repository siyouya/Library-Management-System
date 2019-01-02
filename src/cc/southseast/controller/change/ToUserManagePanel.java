package cc.southseast.controller.change;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import cc.southseast.view.ui.manage.ManagePanel;
import cc.southseast.view.ui.manage.UserManagePanel;

public class ToUserManagePanel implements EventHandler<MouseEvent> {

    private ManagePanel managePanel;

    public ToUserManagePanel(ManagePanel managePanel){

        this.managePanel = managePanel;
    }

    @Override
    public void handle(MouseEvent event) {

        managePanel.getUserManageButton().setStyle("-fx-background-color: #2f3136");
        managePanel.getBookManageButton().setStyle("-fx-background-color: TRANSPARENT");
        managePanel.getPublishManageButton().setStyle("-fx-background-color: TRANSPARENT");
        managePanel.getBorrowManageButton().setStyle("-fx-background-color: TRANSPARENT");

        UserManagePanel userManagePanel = new UserManagePanel();
        managePanel.getManageMain().getChildren().clear();
        managePanel.getManageMain().getChildren().addAll(userManagePanel);


    }
}