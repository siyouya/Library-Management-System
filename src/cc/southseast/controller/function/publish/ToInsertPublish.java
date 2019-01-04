package cc.southseast.controller.function.publish;

import cc.southseast.model.Publish;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import static cc.southseast.controller.function.ToConnect.dao;

/**
 * @Author: Southseast
 * @Date: 2019/1/1 11:56 PM
 * @Version 1.0
 */
public class ToInsertPublish implements EventHandler<ActionEvent> {

    private TableView tableView = new TableView();
    private JFXTextField publishIdInput = new JFXTextField();
    private JFXTextField publishNameInput = new JFXTextField();
    private JFXTextField publishPhoneInput = new JFXTextField();
    private Publish publish = new Publish();
    private Stage addStage = new Stage();

    public ToInsertPublish(TableView tableView, JFXTextField publishIdInput, JFXTextField publishNameInput, JFXTextField publishPhoneInput, Stage addStage) {
        this.tableView = tableView;
        this.publishIdInput = publishIdInput;
        this.publishNameInput = publishNameInput;
        this.publishPhoneInput = publishPhoneInput;
        this.addStage = addStage;
    }

    @Override
    public void handle(ActionEvent event) {
        if (publishIdInput.getText().equals(null) || publishIdInput.getText().equals("")){

        }
        else {System.out.println(publishPhoneInput.getText());
            publish.setPublishId(Long.parseLong(publishIdInput.getText()));
            publish.setPublishName(publishNameInput.getText());
            publish.setPublishPhone(publishPhoneInput.getText());
            publish.setCheck(false);
            dao.create(Publish.class, false);
            dao.insert(publish);
            tableView.getItems().add(publish);
            tableView.refresh();
            addStage.close();
        }
    }

}
