package cc.southseast.controller.change;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import cc.southseast.view.ui.manage.ManagePanel;

//import cc.southseast.view.ui.manage.ChoosePanel;

public class ToBorrowManagePanel implements EventHandler<MouseEvent> {

    private ManagePanel managePanel;
//    private BorderPane choosePanel;

    public ToBorrowManagePanel(ManagePanel managePanel){

        this.managePanel = managePanel;
//        this.choosePanel = choosePanel;
    }

    @Override
    public void handle(MouseEvent event) {

        managePanel.getUserManageButton().setStyle("-fx-background-color: TRANSPARENT");
        managePanel.getBookManageButton().setStyle("-fx-background-color: TRANSPARENT");
        managePanel.getPublishManageButton().setStyle("-fx-background-color: TRANSPARENT");
        managePanel.getBorrowManageButton().setStyle("-fx-background-color: #2f3136");
        System.out.println("1");

//        for (int i = 0; i < 4; i++)
//            choosePanel.getChildren().get(i).setStyle("-fx-background-color: TRANSPARENT");
//        choosePanel.getChildren().get(2).setStyle("-fx-background-color: #aaaaaa");

//        UserManagePanel userManagePanel = new UserManagePanel();
//        manageMain.getChildren().clear();
//        manageMain.getChildren().addAll(userManagePanel);

    }
}
