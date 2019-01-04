package cc.southseast.controller.function.user;

import cc.southseast.model.User;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import org.nutz.dao.Cnd;

import java.util.List;

import static cc.southseast.controller.function.ToConnect.dao;
import static cc.southseast.controller.function.ToGetData.userCacheData;

/**
 * @Author: Southseast
 * @Date: 2019/1/1 4:33 PM
 * @Version 1.0
 */
public class ToSearch implements EventHandler<ActionEvent> {

    private JFXTextField searchInput;

    private TableView tableView;

    public ToSearch(JFXTextField searchInput, TableView tableView) {

        this.searchInput = searchInput;
        this.tableView = tableView;
    }

    @Override
    public void handle(ActionEvent event) {

        String id = searchInput.getText();
        List<User> userList = dao.query(User.class, Cnd.where("id", "like", "%" + id + "%"));
        tableView.getItems().clear();

        userCacheData = FXCollections.observableArrayList(userList);
        tableView.setItems(userCacheData);


        for (User user: userCacheData) {
            System.out.println(user.toString());
        }

        tableView.refresh();
    }
}
