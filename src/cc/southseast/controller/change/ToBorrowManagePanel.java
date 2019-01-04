package cc.southseast.controller.change;

import cc.southseast.view.ui.manage.admin.borrow.BorrowManagePanel;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import cc.southseast.view.ui.manage.admin.AdminManagePanel;


public class ToBorrowManagePanel implements EventHandler<MouseEvent> {

    private AdminManagePanel adminManagePanel;

    private BorrowManagePanel borrowManagePanel = new BorrowManagePanel();

    public ToBorrowManagePanel(AdminManagePanel adminManagePanel){

        this.adminManagePanel = adminManagePanel;
    }

    @Override
    public void handle(MouseEvent event) {

        adminManagePanel.getUserManageButton().setStyle("-fx-background-color: TRANSPARENT");
        adminManagePanel.getBookManageButton().setStyle("-fx-background-color: TRANSPARENT");
        adminManagePanel.getPublishManageButton().setStyle("-fx-background-color: TRANSPARENT");
        adminManagePanel.getBorrowManageButton().setStyle("-fx-background-color: #2f3136");

        adminManagePanel.getManageMain().getChildren().clear();
        adminManagePanel.getManageMain().getChildren().addAll(borrowManagePanel);

//        for (int i = 0; i < 4; i++)
//            choosePanel.getChildren().get(i).setStyle("-fx-background-color: TRANSPARENT");
//        choosePanel.getChildren().get(2).setStyle("-fx-background-color: #aaaaaa");

//        UserManagePanel userManagePanel = new UserManagePanel();
//        manageMain.getChildren().clear();
//        manageMain.getChildren().addAll(userManagePanel);

    }
}
