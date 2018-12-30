package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import model.User;
import view.manage.ManagePanel;


public class ToLogin implements EventHandler<MouseEvent> {

    private JFXTextField id;
    private JFXPasswordField password;

    public ToLogin(JFXTextField id, JFXPasswordField password) {

        this.id = id;
        this.password = password;
    }

    @Override
    public void handle(MouseEvent event) {

        User user = ToConnect.dao.fetch(User.class,Integer.parseInt(id.getText()));
        if (user.getPassword().equals(password.getText())) {

            //创建管理面板
            ManagePanel managePanel = new ManagePanel();

            // 获取父级
            VBox root = (VBox) id.getParent().getParent().getParent();

            // 清除所有子级
            root.getChildren().clear();

            // 添加管理面板
            root.getChildren().addAll(managePanel);
        }

    }

}