package cc.southseast.controller.function;

import cc.southseast.controller.sm.SM3Digest;
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
import java.util.List;

/**
 * @Author: Southseast
 * @Date: 2019/1/2 11:34 PM
 * @Version 1.0
 */
public class ToUpdateUser implements EventHandler<ActionEvent> {

    private TableView tableView = new TableView();
    private Label studentId = new Label();
    private JFXTextField nameInput = new JFXTextField();
    private JFXTextField passwordInput = new JFXTextField();
    private JFXTextField sexInput = new JFXTextField();
    private DatePicker birthdayInput = new DatePicker();
    private JFXTextField telphoneInput = new JFXTextField();
    private JFXTextField emailInput = new JFXTextField();
    private Stage editStage = new Stage();

    public ToUpdateUser(TableView tableView, Label studentId, JFXTextField nameInput, JFXTextField passwordInput,
                        JFXTextField sexInput, DatePicker birthdayInput, JFXTextField telphoneInput,
                        JFXTextField emailInput, Stage editStage) {
        this.tableView = tableView;
        this.studentId = studentId;
        this.nameInput = nameInput;
        this.passwordInput = passwordInput;
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
        user.setPassword(SM3Digest.encode(passwordInput.getText()));
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
        List<User> o = tableView.getItems();
        int i = 0;
        for (User beforeUser: o) {
            if (beforeUser.getId() == user.getId()){
                ((User) tableView.getItems().get(i)).setName(nameInput.getText());
                ((User) tableView.getItems().get(i)).setPassword(SM3Digest.encode(passwordInput.getText()));
                ((User) tableView.getItems().get(i)).setSex(sexInput.getText());
                ((User) tableView.getItems().get(i)).setBirthday(
                        new Date(Date.from(birthdayInput.getValue().atStartOfDay()
                                .atZone(ZoneId.systemDefault()).toInstant()).getTime()));
                ((User) tableView.getItems().get(i)).setTelphone(telphoneInput.getText());
                ((User) tableView.getItems().get(i)).setEmail(emailInput.getText());
                ((User) tableView.getItems().get(i)).setCheck(false);
            }
            i++;
        }

        editStage.close();


    }
}
