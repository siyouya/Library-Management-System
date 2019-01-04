package cc.southseast.controller.change;

import cc.southseast.view.ui.manage.admin.AdminManagePanel;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import cc.southseast.view.ui.base.BasePanel;
import cc.southseast.view.ui.login.LoginPanel;

public class ToQuitLoginPanel implements EventHandler<MouseEvent> {

    private AdminManagePanel adminManagePanel;

    public ToQuitLoginPanel(AdminManagePanel adminManagePanel){
        this.adminManagePanel = adminManagePanel;
    }

    @Override
    public void handle(MouseEvent event) {

        //创建管理面板
        LoginPanel loginPanel = new LoginPanel();

        BasePanel root = (BasePanel) adminManagePanel.getParent().getParent().getParent();

        root.addLoginPanel(loginPanel);

    }
}
