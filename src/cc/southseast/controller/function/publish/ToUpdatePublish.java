package cc.southseast.controller.function.publish;

import cc.southseast.model.Publish;
import cc.southseast.model.User;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import static cc.southseast.controller.function.ToConnect.dao;
import static cc.southseast.controller.function.ToGetData.publishCacheData;

/**
 * @Author: Southseast
 * @Date: 2019/1/2 11:34 PM
 * @Version 1.0
 */
public class ToUpdatePublish implements EventHandler<ActionEvent> {

    private TableView tableView = new TableView();

    private Label id = new Label();
    private JFXTextField publishNameInput = new JFXTextField();
    private JFXTextField publishPhoneInput = new JFXTextField();
    private Stage editStage = new Stage();

    public ToUpdatePublish(TableView tableView, Label id, JFXTextField publishNameInput, JFXTextField publishPhoneInput, Stage editStage) {
        this.tableView = tableView;
        this.id = id;
        this.publishNameInput = publishNameInput;
        this.publishPhoneInput = publishPhoneInput;
        this.editStage = editStage;
    }

    @Override
    public void handle(ActionEvent event) {

        Publish publish = dao.fetch(Publish.class, Long.parseLong(id.getText()));
        publish.setPublishName(publishNameInput.getText());
        publish.setPublishPhone(publishPhoneInput.getText());
        publish.setCheck(false);

        dao.create(User.class, false);
        dao.update(publish);
        tableView.refresh();

        int i = 0;
        for (Publish beforePublish: publishCacheData) {
            if (beforePublish.getPublishId() == publish.getPublishId()){
                (publishCacheData.get(i)).setPublishName(publishNameInput.getText());
                (publishCacheData.get(i)).setPublishPhone(publishPhoneInput.getText());
                (publishCacheData.get(i)).setCheck(false);
            }
            i++;
        }

        editStage.close();


    }
}
