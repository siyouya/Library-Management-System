package cc.southseast.view.ui.manage;

import cc.southseast.controller.function.ToInsertUser;
import cc.southseast.controller.function.ToClose;
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
public class InsertPanel extends GridPane {

//    private JFXListView
    private Label studentIdLabel = new Label("学号");
    private Label nameLabel = new Label("姓名");
    private Label sexLabel = new Label("性别");
    private Label birthdaydLabel = new Label("生日");
    private Label emailLabel = new Label("邮箱");
    private Label telphoneLabel = new Label("电话");
    private JFXTextField studentIdInput = new JFXTextField();
    private JFXTextField nameInput = new JFXTextField();
    private JFXTextField sexInput = new JFXTextField();
    private DatePicker birthdayInput = new DatePicker();
    private JFXTextField telphoneInput = new JFXTextField();
    private JFXTextField emailInput = new JFXTextField();
    private JFXButton addButton = new JFXButton("添加");
    private JFXButton quitButton = new JFXButton("取消");

    public InsertPanel(TableView tableView, Stage addStage) {

        // 引入样式文件
        this.getStylesheets().add("cc/southseast/view/resources/css/EditPanel.css");
        this.setPadding(new Insets(0,20,20,20));
        this.setHgap(10);
        this.setVgap(10);

        addButton.setId("saveButton");
        addButton.setOnAction(new ToInsertUser(tableView, studentIdInput, nameInput,
                sexInput, birthdayInput, telphoneInput, emailInput, addStage));
        addButton.setMinWidth(45);
        quitButton.setId("quitButton");
        quitButton.setOnAction(new ToClose(addStage));

        this.add(studentIdLabel, 0, 0);
        this.add(studentIdInput, 1, 0);
        this.add(nameLabel, 0, 1);
        this.add(nameInput, 1, 1);
        this.add(sexLabel, 0, 2);
        this.add(sexInput, 1, 2);
        this.add(birthdaydLabel, 0, 3);
        this.add(birthdayInput, 1, 3);
        this.add(telphoneLabel, 0, 4);
        this.add(telphoneInput, 1, 4);
        this.add(emailLabel, 0, 5);
        this.add(emailInput, 1, 5);
        this.add(addButton, 0, 7);
        this.add(quitButton, 1, 7);

    }

    public void init() {

    }

}
