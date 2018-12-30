package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import view.login.LoginPanel;
//import view.manage.ChoosePanel;

public class ToQuit implements EventHandler<MouseEvent> {

    private HBox managePanel;

    public ToQuit(HBox managePanel){
        this.managePanel = managePanel;
    }

    @Override
    public void handle(MouseEvent event) {


//        System.out.println(choosePanel.getParent());
//        System.out.println(choosePanel.getParent().getParent());
//        System.out.println(choosePanel.getParent().getParent().getChildrenUnmodifiable());
//
//        System.out.println(choosePanel.getParent().getParent().getParent());
//        System.out.println(choosePanel.getParent().getParent().getParent().getChildrenUnmodifiable().get(0));

        //创建管理面板
        LoginPanel loginPanel = new LoginPanel();

        // 获取父级
        VBox root = (VBox) managePanel.getParent();

        // 清除所有子级
        root.getChildren().clear();

        // 添加管理面板
        root.getChildren().addAll(loginPanel);



//        HBox manageMain = (HBox) choosePanel.getParent().getParent();
//        UserManagePanel userManagePanel = new UserManagePanel();
//        manageMain.getChildren().clear();
//        manageMain.getChildren().addAll(userManagePanel);
    }
}
