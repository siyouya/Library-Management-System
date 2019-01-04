package cc.southseast.controller.change;

import cc.southseast.view.ui.manage.admin.AdminManagePanel;
import cc.southseast.view.ui.manage.admin.publish.PublishManagePanel;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ToPublishManagePanel implements EventHandler<MouseEvent> {

    private AdminManagePanel adminManagePanel;

    private PublishManagePanel publishManagePanel = new PublishManagePanel();

    public ToPublishManagePanel(AdminManagePanel adminManagePanel){

        this.adminManagePanel = adminManagePanel;
    }

    @Override
    public void handle(MouseEvent event) {

        adminManagePanel.getPublishManageButton().setStyle("-fx-background-color: #2f3136");
        adminManagePanel.getBookManageButton().setStyle("-fx-background-color: TRANSPARENT");
        adminManagePanel.getBorrowManageButton().setStyle("-fx-background-color: TRANSPARENT");
        adminManagePanel.getUserManageButton().setStyle("-fx-background-color: TRANSPARENT");
        adminManagePanel.getManageMain().getChildren().clear();
        adminManagePanel.getManageMain().getChildren().addAll(publishManagePanel);

    }
}
