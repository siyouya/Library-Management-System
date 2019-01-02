package cc.southseast.controller.change;

import cc.southseast.controller.sm.SM3Digest;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import cc.southseast.controller.function.ToConnect;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import cc.southseast.model.User;
import cc.southseast.view.ui.manage.ManagePanel;


public class ToLoginPanel implements EventHandler<MouseEvent> {

    private JFXTextField id;
    private JFXPasswordField password;

    public ToLoginPanel(JFXTextField id, JFXPasswordField password) {

        this.id = id;
        this.password = password;
    }

    @Override
    public void handle(MouseEvent event) {

        User user = ToConnect.dao.fetch(User.class,Integer.parseInt(id.getText()));

        if (user.getPassword().equals(SM3Digest.encode(password.getText()))) {

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