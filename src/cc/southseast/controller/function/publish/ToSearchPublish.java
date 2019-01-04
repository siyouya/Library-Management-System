package cc.southseast.controller.function.publish;

import cc.southseast.model.Publish;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import org.nutz.dao.Cnd;

import java.util.List;

import static cc.southseast.controller.function.ToConnect.dao;
import static cc.southseast.controller.function.ToGetData.publishCacheData;

/**
 * @Author: Southseast
 * @Date: 2019/1/1 4:33 PM
 * @Version 1.0
 */
public class ToSearchPublish implements EventHandler<ActionEvent> {

    private JFXTextField searchInput;

    private TableView tableView;

    public ToSearchPublish(JFXTextField searchInput, TableView tableView) {

        this.searchInput = searchInput;
        this.tableView = tableView;
    }

    @Override
    public void handle(ActionEvent event) {

        String id = searchInput.getText();
        List<Publish> userList = dao.query(Publish.class, Cnd.where("publishName", "like", "%" + id + "%"));
        tableView.getItems().clear();

        publishCacheData = FXCollections.observableArrayList(userList);
        tableView.setItems(publishCacheData);


        for (Publish publish: publishCacheData) {
            System.out.println(publish.toString());
        }

        tableView.refresh();
    }
}
