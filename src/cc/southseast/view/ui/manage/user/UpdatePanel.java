package cc.southseast.view.ui.manage.user;

import cc.southseast.controller.function.ToClose;
import cc.southseast.controller.function.user.ToUpdateUser;
import cc.southseast.model.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.Insets;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @Author: Southseast
 * @Date: 2019/1/1 7:21 PM
 * @Version 1.0
 */
public class UpdatePanel extends GridPane {

//    private JFXListView
    private Label studentIdLabel = new Label("学号");
    private Label nameLabel = new Label("姓名");
    private Label passwordLabel = new Label("密码");
    private Label sexLabel = new Label("性别");
    private Label birthdaydLabel = new Label("生日");
    private Label telphoneLabel = new Label("电话");
    private Label emailLabel = new Label("邮箱");
    private JFXButton updateButton = new JFXButton("保存");
    private JFXButton quitButton = new JFXButton("取消");
    private Label studentId = new Label();
    private JFXTextField nameInput = new JFXTextField();
    private JFXTextField passwordInput = new JFXTextField();
    private JFXTextField sexInput = new JFXTextField();
    private DatePicker birthdayInput = new DatePicker();
    private JFXTextField telphoneInput = new JFXTextField();
    private JFXTextField emailInput = new JFXTextField();

    public UpdatePanel(TableView tableView, Stage editStage) {

        // 引入样式文件
        this.getStylesheets().add("cc/southseast/view/resources/css/EditPanel.css");
        this.setPadding(new Insets(0,20,20,20));
        this.setHgap(10);
        this.setVgap(10);

        updateButton.setId("saveButton");
        updateButton.setOnAction(new ToUpdateUser(tableView, studentId, nameInput,
                passwordInput, sexInput, birthdayInput, telphoneInput, emailInput, editStage));
        updateButton.setMinWidth(45);
        quitButton.setId("quitButton");
        quitButton.setOnAction(new ToClose(editStage));
        birthdayInput.setId("birthdayInput");

        this.add(studentIdLabel, 0, 0);
        this.add(studentId, 1, 0);
        this.add(nameLabel, 0, 1);
        this.add(nameInput, 1, 1);
        this.add(passwordLabel, 0, 2);
        this.add(passwordInput, 1, 2);
        this.add(sexLabel, 0, 3);
        this.add(sexInput, 1, 3);
        this.add(birthdaydLabel, 0, 4);
        this.add(birthdayInput, 1, 4);
        this.add(telphoneLabel, 0, 5);
        this.add(telphoneInput, 1, 5);
        this.add(emailLabel, 0, 6);
        this.add(emailInput, 1, 6);
        this.add(updateButton, 0, 8);
        this.add(quitButton, 1, 8);

    }

    public void addUserInformation(User user) {
        studentId.setText(String.valueOf(user.getId()));
        nameInput.setText(user.getName());
        passwordInput.setText(user.getPassword());
        sexInput.setText(user.getSex());
        birthdayInput.setValue(user.getBirthday());
        telphoneInput.setText(user.getTelphone());
        emailInput.setText(user.getEmail());
    }

}
