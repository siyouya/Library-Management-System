package cc.southseast.controller.function.user;

import cc.southseast.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;

import java.util.Iterator;

import static cc.southseast.controller.function.ToConnect.dao;

public class ToBatchDelete implements EventHandler<ActionEvent> {
    private TableView tableView;

    public ToBatchDelete(TableView tableView) {
        this.tableView = tableView;
    }

    @Override
    public void handle(ActionEvent event) {

        Iterator<User> iterator = tableView.getItems().iterator();

        while (iterator.hasNext()) {

            User user = iterator.next();
            if (user.getCheck()) {
                iterator.remove();
                dao.delete(User.class, user.getId());
            }
        }
        tableView.refresh();

    }
}