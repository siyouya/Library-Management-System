package cc.southseast.controller.function;

import cc.southseast.model.User;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.sql.Date;
import java.time.ZoneId;

import static cc.southseast.controller.function.ToConnect.dao;

/**
 * @Author: Southseast
 * @Date: 2019/1/1 11:56 PM
 * @Version 1.0
 */
public class ToInsertUser implements EventHandler<ActionEvent> {

    private TableView tableView = new TableView();
    private JFXTextField studentIdInput = new JFXTextField();
    private JFXTextField nameInput = new JFXTextField();
    private JFXTextField sexInput = new JFXTextField();
    private DatePicker birthdayInput = new DatePicker();
    private JFXTextField telphoneInput = new JFXTextField();
    private JFXTextField emailInput = new JFXTextField();
    private User user = new User();
    private Stage addStage = new Stage();

    public ToInsertUser(TableView tableView, JFXTextField studentIdInput, JFXTextField nameInput,
                        JFXTextField sexInput, DatePicker birthdayInput, JFXTextField telphoneInput,
                        JFXTextField emailInput, Stage addStage) {
        this.tableView = tableView;
        this.studentIdInput = studentIdInput;
        this.nameInput = nameInput;
        this.sexInput = sexInput;
        this.birthdayInput = birthdayInput;
        this.telphoneInput = telphoneInput;
        this.emailInput = emailInput;
        this.addStage = addStage;
    }

    @Override
    public void handle(ActionEvent event) {
        if (studentIdInput.getText().equals(null) || studentIdInput.getText().equals("")){

        }
        else {
            user.setStudentId(Long.parseLong(studentIdInput.getText()));
            user.setName(nameInput.getText());
            user.setSex(sexInput.getText());
            user.setBirthday(
                    new Date(Date.from(birthdayInput.getValue().atStartOfDay()
                            .atZone(ZoneId.systemDefault()).toInstant()).getTime()));
            user.setTelphone(telphoneInput.getText());
            user.setEmail(emailInput.getText());
            user.setCheck(false);
            dao.create(User.class, false);
            dao.insert(user);
            addStage.close();
        }
    }

}
