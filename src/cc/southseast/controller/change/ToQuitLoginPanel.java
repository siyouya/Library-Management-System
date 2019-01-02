package cc.southseast.controller.change;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import cc.southseast.view.ui.base.BasePanel;
import cc.southseast.view.ui.login.LoginPanel;
import cc.southseast.view.ui.manage.ManagePanel;

public class ToQuitLoginPanel implements EventHandler<MouseEvent> {

    private ManagePanel managePanel;

    public ToQuitLoginPanel(ManagePanel managePanel){
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
