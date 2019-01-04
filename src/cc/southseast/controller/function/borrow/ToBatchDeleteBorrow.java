package cc.southseast.controller.function.borrow;

import cc.southseast.model.Borrow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;

import java.util.Iterator;

import static cc.southseast.controller.function.ToConnect.dao;

public class ToBatchDeleteBorrow implements EventHandler<ActionEvent> {
    private TableView tableView;

    public ToBatchDeleteBorrow(TableView tableView) {
        this.tableView = tableView;
    }

    @Override
    public void handle(ActionEvent event) {

        Iterator<Borrow> iterator = tableView.getItems().iterator();

        while (iterator.hasNext()) {

            Borrow borrow = iterator.next();
            if (borrow.getCheck()) {
                iterator.remove();
                dao.delete(Borrow.class, borrow.getBorrowId());
            }
        }
        tableView.refresh();

    }
}