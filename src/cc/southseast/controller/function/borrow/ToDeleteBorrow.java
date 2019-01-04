package cc.southseast.controller.function.borrow;

import cc.southseast.model.Borrow;
import cc.southseast.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;

import java.util.Iterator;

import static cc.southseast.controller.function.ToConnect.dao;

public class ToDeleteBorrow implements EventHandler<ActionEvent> {

    private long borrowId;
    private TableView tableView;

    public ToDeleteBorrow(long borrowId, TableView tableView) {
        this.borrowId = borrowId;
        this.tableView = tableView;
    }

    @Override
    public void handle(ActionEvent event) {

        Iterator<Borrow> iterator = tableView.getItems().iterator();
        while (iterator.hasNext()) {
            Borrow borrow = iterator.next();
            if (borrow.getBorrowId() == borrowId) {
                iterator.remove();
                dao.delete(Borrow.class, borrow.getBorrowId());
                break;
            }
        }
        tableView.refresh();
    }
}