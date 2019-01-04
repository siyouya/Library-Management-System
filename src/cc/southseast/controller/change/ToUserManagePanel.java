package cc.southseast.controller.change;

import cc.southseast.view.ui.manage.admin.AdminManagePanel;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import cc.southseast.view.ui.manage.admin.user.UserManagePanel;

public class ToUserManagePanel implements EventHandler<MouseEvent> {

    private AdminManagePanel adminManagePanel;

    public ToUserManagePanel(AdminManagePanel adminManagePanel){

        this.adminManagePanel = adminManagePanel;
    }

    @Override
    public void handle(MouseEvent event) {

        adminManagePanel.getUserManageButton().setStyle("-fx-background-color: #2f3136");
        adminManagePanel.getBookManageButton().setStyle("-fx-background-color: TRANSPARENT");
        adminManagePanel.getPublishManageButton().setStyle("-fx-background-color: TRANSPARENT");
        adminManagePanel.getBorrowManageButton().setStyle("-fx-background-color: TRANSPARENT");

        UserManagePanel userManagePanel = new UserManagePanel();
        adminManagePanel.getManageMain().getChildren().clear();
        adminManagePanel.getManageMain().getChildren().addAll(userManagePanel);


    }
}
