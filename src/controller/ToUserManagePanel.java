package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
//import view.manage.ChoosePanel;
import view.manage.UserManagePanel;

public class ToUserManagePanel implements EventHandler<MouseEvent> {

    private HBox manageMain;

    public ToUserManagePanel(HBox manageMain){
        this.manageMain = manageMain;
    }

    @Override
    public void handle(MouseEvent event) {

        UserManagePanel userManagePanel = new UserManagePanel();
        manageMain.getChildren().clear();
        manageMain.getChildren().addAll(userManagePanel);
    }
}
