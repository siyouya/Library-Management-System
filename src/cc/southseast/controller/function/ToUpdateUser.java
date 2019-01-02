package cc.southseast.controller.function;

import cc.southseast.model.User;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;


import static cc.southseast.controller.function.ToConnect.*;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.sql.Date;
import java.time.ZoneId;

/**
 * @Author: Southseast
 * @Date: 2019/1/2 11:34 PM
 * @Version 1.0
 */
public class ToUpdateUser implements EventHandler<ActionEvent> {

    private TableView tableView = new TableView();
    private Label studentId = new Label();
    private JFXTextField nameInput = new JFXTextField();
    private JFXTextField sexInput = new JFXTextField();
    private DatePicker birthdayInput = new DatePicker();
    private JFXTextField telphoneInput = new JFXTextField();
    private JFXTextField emailInput = new JFXTextField();
    private Stage editStage = new Stage();

    public ToUpdateUser(TableView tableView, Label studentId, JFXTextField nameInput,
                        JFXTextField sexInput, DatePicker birthdayInput, JFXTextField telphoneInput,
                        JFXTextField emailInput, Stage editStage) {
        this.tableView = tableView;
        this.studentId = studentId;
        this.nameInput = nameInput;
        this.sexInput = sexInput;
        this.birthdayInput = birthdayInput;
        this.telphoneInput = telphoneInput;
        this.emailInput = emailInput;
        this.editStage = editStage;
    }

    @Override
    public void handle(ActionEvent event) {
        User user = dao.fetch(User.class, Long.parseLong(studentId.getText()));
//        user.setStudentId(Long.parseLong(studentId.getText()));
        user.setName(nameInput.getText());
        user.setSex(sexInput.getText());
        user.setBirthday(
                new Date(Date.from(birthdayInput.getValue().atStartOfDay()
                        .atZone(ZoneId.systemDefault()).toInstant()).getTime()));
        user.setTelphone(telphoneInput.getText());
        user.setEmail(emailInput.getText());
        user.setCheck(false);
        dao.create(User.class, false);
        dao.update(user);
        tableView.refresh();
        editStage.close();


    }
}
