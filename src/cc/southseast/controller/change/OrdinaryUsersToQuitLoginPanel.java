package cc.southseast.controller.change;

import cc.southseast.view.ui.base.BasePanel;
import cc.southseast.view.ui.login.LoginPanel;
import cc.southseast.view.ui.manage.admin.AdminManagePanel;
import cc.southseast.view.ui.manage.ordinaryUsers.OrdinaryUsersManagePanel;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class OrdinaryUsersToQuitLoginPanel implements EventHandler<MouseEvent> {

    private OrdinaryUsersManagePanel ordinaryUsersManagePanel;

    public OrdinaryUsersToQuitLoginPanel(OrdinaryUsersManagePanel ordinaryUsersManagePanel){
        this.ordinaryUsersManagePanel = ordinaryUsersManagePanel;
    }

    @Override
    public void handle(MouseEvent event) {

        //创建管理面板
        LoginPanel loginPanel = new LoginPanel();

        BasePanel root = (BasePanel) ordinaryUsersManagePanel.getParent().getParent().getParent();

        root.addLoginPanel(loginPanel);

    }
}
