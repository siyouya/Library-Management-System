package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.base.BasePanel;
import view.login.LoginPanel;
import view.manage.ManagePanel;

public class ToQuit implements EventHandler<MouseEvent> {

    private ManagePanel managePanel;

    public ToQuit(ManagePanel managePanel){
        this.managePanel = managePanel;
    }

    @Override
    public void handle(MouseEvent event) {

        //创建管理面板
        LoginPanel loginPanel = new LoginPanel();

        BasePanel root = (BasePanel) managePanel.getParent().getParent().getParent();

        root.addLoginPanel(loginPanel);

    }
}
