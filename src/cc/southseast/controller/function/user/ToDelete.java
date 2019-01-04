package cc.southseast.controller.function.user;

import cc.southseast.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;

import java.util.Iterator;

import static cc.southseast.controller.function.ToConnect.dao;

public class ToDelete implements EventHandler<ActionEvent> {

    private long userId;
    private TableView tableView;

    public ToDelete(long userId, TableView tableView) {
        this.userId = userId;
        this.tableView = tableView;
    }

    @Override
    public void handle(ActionEvent event) {

        Iterator<User> iterator = tableView.getItems().iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == userId) {
                iterator.remove();
                dao.delete(User.class, user.getId());
                break;
            }
        }
        tableView.refresh();
    }
}