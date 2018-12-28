package view.login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import controller.toLogin;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import org.nutz.dao.Dao;


public class LoginInterface extends HBox
{
    private JFXButton loginButton = new JFXButton();

    private JFXTextField loginId = new JFXTextField();

    private JFXPasswordField loginPassword = new JFXPasswordField();

    private GridPane LoginMain = new GridPane();

    public LoginInterface(Dao dao){

        // 引入样式文件
        this.getStylesheets().add("view/resources/css/LoginInterface.css");

        // 设置CSSID
        this.setId("loginInterface");

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

        loginButton.setOnMousePressed(new toLogin(loginId, loginPassword, dao));

        this.getChildren().addAll(LoginMain);

    }

}
