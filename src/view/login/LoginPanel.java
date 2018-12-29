package view.login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import controller.ToLogin;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class LoginPanel extends HBox
{
    private JFXButton loginButton = new JFXButton();

    private JFXTextField loginId = new JFXTextField();

    private JFXPasswordField loginPassword = new JFXPasswordField();

    private GridPane LoginMain = new GridPane();

    public LoginPanel(){

        // 引入样式文件
        this.getStylesheets().add("view/resources/css/LoginPanel.css");

        // 设置CSSID
        this.setId("LoginPanel");

        this.setMinSize(1024,768);
        this.setMaxSize(1024,768);

        // 设置间隔
        this.setPadding(new Insets(500, 0, 0 ,500));

        // 间隔
        LoginMain.setHgap(10);
        LoginMain.setVgap(10);

        loginId.setId("loginId");
        loginId.setPromptText("请输入账号");
        LoginMain.add(loginId, 0, 0);

        loginPassword.setId("loginPassword");
        loginPassword.setPromptText("请输入密码");
        LoginMain.add(loginPassword, 0, 1);

        loginButton.setId("loginButton");
        loginButton.setMinHeight(73);
        loginButton.setMinWidth(73);
        loginButton.setText("登陆");
        LoginMain.add(loginButton,1,0,1,2);

        loginButton.setOnMousePressed(new ToLogin(loginId, loginPassword));

        this.getChildren().addAll(LoginMain);

    }

}
