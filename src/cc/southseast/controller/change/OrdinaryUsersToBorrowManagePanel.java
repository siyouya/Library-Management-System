package cc.southseast.controller.change;

import cc.southseast.view.ui.manage.admin.AdminManagePanel;
import cc.southseast.view.ui.manage.admin.borrow.BorrowManagePanel;
import cc.southseast.view.ui.manage.ordinaryUsers.OrdinaryUsersManagePanel;
import cc.southseast.view.ui.manage.ordinaryUsers.borrow.OrdinaryUsersBorrowManagePanel;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class OrdinaryUsersToBorrowManagePanel implements EventHandler<MouseEvent> {

    private OrdinaryUsersManagePanel ordinaryUsersManagePanel;

    private OrdinaryUsersBorrowManagePanel borrowManagePanel = new OrdinaryUsersBorrowManagePanel();

    public OrdinaryUsersToBorrowManagePanel(OrdinaryUsersManagePanel ordinaryUsersManagePanel){

        this.ordinaryUsersManagePanel = ordinaryUsersManagePanel;
    }

    @Override
    public void handle(MouseEvent event) {

        ordinaryUsersManagePanel.getBookManageButton().setStyle("-fx-background-color: TRANSPARENT");
        ordinaryUsersManagePanel.getBorrowManageButton().setStyle("-fx-background-color: #2f3136");

        ordinaryUsersManagePanel.getManageMain().getChildren().clear();
        ordinaryUsersManagePanel.getManageMain().getChildren().addAll(borrowManagePanel);

//        for (int i = 0; i < 4; i++)
//            choosePanel.getChildren().get(i).setStyle("-fx-background-color: TRANSPARENT");
//        choosePanel.getChildren().get(2).setStyle("-fx-background-color: #aaaaaa");

//        UserManagePanel userManagePanel = new UserManagePanel();
//        manageMain.getChildren().clear();
//        manageMain.getChildren().addAll(userManagePanel);

    }
}
