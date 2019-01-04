package cc.southseast.controller.function.book;

import cc.southseast.model.Book;
import cc.southseast.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;

import java.util.Iterator;

import static cc.southseast.controller.function.ToConnect.dao;

public class ToBatchDeleteBook implements EventHandler<ActionEvent> {
    private TableView tableView;

    public ToBatchDeleteBook(TableView tableView) {
        this.tableView = tableView;
    }

    @Override
    public void handle(ActionEvent event) {

        Iterator<Book> iterator = tableView.getItems().iterator();

        while (iterator.hasNext()) {

            Book book = iterator.next();
            if (book.getCheck()) {
                iterator.remove();
                dao.delete(Book.class, book.getBookId());
            }
        }
        tableView.refresh();

    }
}