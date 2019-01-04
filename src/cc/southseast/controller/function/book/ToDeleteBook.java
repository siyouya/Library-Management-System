package cc.southseast.controller.function.book;

import cc.southseast.model.Book;
import cc.southseast.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;

import java.util.Iterator;

import static cc.southseast.controller.function.ToConnect.dao;

public class ToDeleteBook implements EventHandler<ActionEvent> {

    private long bookId;
    private TableView tableView;

    public ToDeleteBook(long bookId, TableView tableView) {
        this.bookId = bookId;
        this.tableView = tableView;
    }

    @Override
    public void handle(ActionEvent event) {

        Iterator<Book> iterator = tableView.getItems().iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getBookId() == bookId) {
                iterator.remove();
                dao.delete(User.class, book.getBookId());
                break;
            }
        }
        tableView.refresh();
    }
}