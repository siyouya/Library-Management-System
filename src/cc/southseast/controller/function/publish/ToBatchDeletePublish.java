package cc.southseast.controller.function.publish;

import cc.southseast.model.Publish;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;

import java.util.Iterator;

import static cc.southseast.controller.function.ToConnect.dao;

public class ToBatchDeletePublish implements EventHandler<ActionEvent> {
    private TableView tableView;

    public ToBatchDeletePublish(TableView tableView) {
        this.tableView = tableView;
    }

    @Override
    public void handle(ActionEvent event) {

        Iterator<Publish> iterator = tableView.getItems().iterator();

        while (iterator.hasNext()) {

            Publish publish = iterator.next();
            if (publish.getCheck()) {
                iterator.remove();
                dao.delete(Publish.class, publish.getPublishId());
            }
        }
        tableView.refresh();

    }
}