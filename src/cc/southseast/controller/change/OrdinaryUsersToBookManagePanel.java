package cc.southseast.controller.change;

import cc.southseast.view.ui.manage.ordinaryUsers.OrdinaryUsersManagePanel;
import cc.southseast.view.ui.manage.ordinaryUsers.book.OrdinaryUsersBookManagePanel;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

//import cc.southseast.view.ui.manage.ChoosePanel;

public class OrdinaryUsersToBookManagePanel implements EventHandler<MouseEvent> {

    private OrdinaryUsersManagePanel ordinaryUsersManagePanel;

    private OrdinaryUsersBookManagePanel bookManagePanel = new OrdinaryUsersBookManagePanel();

    public OrdinaryUsersToBookManagePanel(OrdinaryUsersManagePanel ordinaryUsersManagePanel){

        this.ordinaryUsersManagePanel = ordinaryUsersManagePanel;
    }

    @Override
    public void handle(MouseEvent event) {

        ordinaryUsersManagePanel.getBookManageButton().setStyle("-fx-background-color: #2f3136");
        ordinaryUsersManagePanel.getBorrowManageButton().setStyle("-fx-background-color: TRANSPARENT");
        ordinaryUsersManagePanel.getManageMain().getChildren().clear();
        ordinaryUsersManagePanel.getManageMain().getChildren().addAll(bookManagePanel);


//        for (int i = 0; i < 4; i++)
//            choosePanel.getChildren().get(i).setStyle("-fx-background-color: TRANSPARENT");
//        choosePanel.getChildren().get(1).setStyle("-fx-background-color: #aaaaaa");

//        UserManagePanel userManagePanel = new UserManagePanel();
//        manageMain.getChildren().clear();
//        manageMain.getChildren().addAll(userManagePanel);

    }
}
