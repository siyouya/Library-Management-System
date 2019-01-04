package cc.southseast.controller.function.borrow;

import cc.southseast.model.Borrow;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import org.nutz.dao.Cnd;

import java.util.List;

import static cc.southseast.controller.function.ToConnect.dao;
import static cc.southseast.controller.function.ToGetData.borrowCacheData;

/**
 * @Author: Southseast
 * @Date: 2019/1/1 4:33 PM
 * @Version 1.0
 */
public class ToSearchBorrow implements EventHandler<ActionEvent> {

    private JFXTextField searchInput;

    private TableView tableView;

    public ToSearchBorrow(JFXTextField searchInput, TableView tableView) {

        this.searchInput = searchInput;
        this.tableView = tableView;
    }

    @Override
    public void handle(ActionEvent event) {

        String id = searchInput.getText();
        List<Borrow> borrowList = dao.query(Borrow.class, Cnd.where("id", "like", "%" + id + "%"));
        tableView.getItems().clear();

        borrowCacheData = FXCollections.observableArrayList(borrowList);
        tableView.setItems(borrowCacheData);


        for (Borrow borrow: borrowCacheData) {
            System.out.println(borrow.toString());
        }

        tableView.refresh();
    }
}
