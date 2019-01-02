package cc.southseast.controller.function;

import cc.southseast.model.User;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import org.nutz.dao.Cnd;

import java.util.List;

import static cc.southseast.controller.function.ToConnect.dao;

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

        String studentId = searchInput.getText();
        List<User> userList = dao.query(User.class, Cnd.where("studentId", "like", "%" + studentId + "%"));
        tableView.getItems().clear();

        ObservableList<User> cacheData = FXCollections.observableArrayList(userList);
        tableView.setItems(cacheData);
        tableView.refresh();
    }
}
