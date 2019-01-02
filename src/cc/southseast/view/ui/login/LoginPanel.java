package cc.southseast.view.ui.login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import cc.southseast.controller.change.ToLoginPanel;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class LoginPanel extends HBox
{
    private JFXButton loginButton = new JFXButton();

    private JFXTextField loginId = new JFXTextField();

    private JFXPasswordField loginPassword = new JFXPasswordField();

    private GridPane loginMain = new GridPane();

    private HBox bg = new HBox();

    public LoginPanel(){

        // 引入样式文件
        this.getStylesheets().add("cc/southseast/view/resources/css/LoginPanel.css");

        // 设置CSSID
        this.setId("LoginPanel");

        this.setMinSize(1024,768);
        this.setMaxSize(1024,768);

        // 设置间隔
        this.setPadding(new Insets(400, 0, 0 ,100));

        bg.setMinSize(200,200);
        bg.setId("bg");

        // 间隔
        loginMain.setHgap(10);
        loginMain.setVgap(10);

        loginId.setId("loginId");
        loginId.setPromptText("请输入账号");
        loginId.setText("1712120423");
        loginMain.add(loginId, 0, 0);

        loginPassword.setId("loginPassword");
        loginPassword.setPromptText("请输入密码");
        loginPassword.setText("south");
        loginMain.add(loginPassword, 0, 1);

        loginButton.setId("loginButton");
        loginButton.setMinHeight(73);
        loginButton.setMinWidth(73);
        loginButton.setText("登陆");
        loginMain.add(loginButton,1,0,1,2);
        loginMain.setPadding(new Insets(100,0,0,0));

        loginButton.setOnMousePressed(new ToLoginPanel(loginId, loginPassword));
        this.setSpacing(300);



        this.getChildren().addAll(bg,loginMain);

    }

}
