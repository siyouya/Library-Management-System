package cc.southseast.controller.function.publish;

import cc.southseast.model.Publish;
import cc.southseast.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;

import java.util.Iterator;

import static cc.southseast.controller.function.ToConnect.dao;

public class ToDeletePublish implements EventHandler<ActionEvent> {

    private long publishId;
    private TableView tableView;

    public ToDeletePublish(long publishId, TableView tableView) {
        this.publishId = publishId;
        this.tableView = tableView;
    }

    @Override
    public void handle(ActionEvent event) {

        Iterator<Publish> iterator = tableView.getItems().iterator();
        while (iterator.hasNext()) {
            Publish publish = iterator.next();
            if (publish.getPublishId() == publishId) {
                iterator.remove();
                dao.delete(User.class, publish.getPublishId());
                break;
            }
        }
        tableView.refresh();
    }
}