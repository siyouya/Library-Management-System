package cc.southseast.controller.change;

import cc.southseast.controller.sm.SM3Digest;
import cc.southseast.view.ui.base.BasePanel;
import cc.southseast.view.ui.base.HintPanel;
import cc.southseast.view.ui.manage.admin.AdminManagePanel;
import cc.southseast.view.ui.manage.ordinaryUsers.OrdinaryUsersManagePanel;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import cc.southseast.controller.function.ToConnect;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import cc.southseast.model.User;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static cc.southseast.view.ui.base.Hint.LOGIN_ERROR;


public class ToLoginPanel implements EventHandler<MouseEvent> {

    private JFXTextField id;
    private JFXPasswordField password;

    public ToLoginPanel(JFXTextField id, JFXPasswordField password) {

        this.id = id;
        this.password = password;
    }

    @Override
    public void handle(MouseEvent event) {

        if (id.getText().equals("") || password.getText().equals("")) {
            Stage hintStage = new Stage();
            BasePanel root = new BasePanel();
            HintPanel hintPanel = new HintPanel(LOGIN_ERROR);
            Scene scene = new Scene(root);
            Stage stage = (Stage) password.getScene().getWindow();
            root.windowsInit(hintStage);
            root.addHintPanel(hintPanel);
            // 设置透明度
            scene.setFill(Color.TRANSPARENT);
            hintStage.initModality(Modality.WINDOW_MODAL);
            hintStage.initOwner(stage);
            hintStage.setScene(scene);
            hintStage.show();
        }
        else{

            User user = ToConnect.dao.fetch(User.class,Integer.parseInt(id.getText()));

            if (user.getAdmin() && user.getPassword().equals(SM3Digest.encode(password.getText()))) {

                    //创建管理面板
                    AdminManagePanel adminManagePanel = new AdminManagePanel();

                    // 获取父级
                    VBox root = (VBox) id.getParent().getParent().getParent();

                    // 清除所有子级
                    root.getChildren().clear();

                    // 添加管理面板
                    root.getChildren().addAll(adminManagePanel);
            }
            else if (!user.getAdmin() && user.getPassword().equals(SM3Digest.encode(password.getText()))) {

                //创建管理面板
                OrdinaryUsersManagePanel ordinaryUsersManagePanel = new OrdinaryUsersManagePanel();

                // 获取父级
                VBox root = (VBox) id.getParent().getParent().getParent();

                // 清除所有子级
                root.getChildren().clear();

                // 添加管理面板
                root.getChildren().addAll(ordinaryUsersManagePanel);
            }
            else {

                Stage hintStage = new Stage();
                BasePanel root = new BasePanel();
                HintPanel hintPanel = new HintPanel(LOGIN_ERROR);
                Scene scene = new Scene(root);
                Stage stage = (Stage) password.getScene().getWindow();
                root.windowsInit(hintStage);
                root.addHintPanel(hintPanel);
                // 设置透明度
                scene.setFill(Color.TRANSPARENT);
                hintStage.initModality(Modality.WINDOW_MODAL);
                hintStage.initOwner(stage);
                hintStage.setScene(scene);
                hintStage.show();
            }
        }

    }

}