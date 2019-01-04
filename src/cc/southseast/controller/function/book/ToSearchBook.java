package cc.southseast.controller.function.book;

import cc.southseast.model.Book;
import cc.southseast.model.User;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import org.nutz.dao.Cnd;

import java.util.List;

import static cc.southseast.controller.function.ToConnect.dao;
import static cc.southseast.controller.function.ToGetData.bookCacheData;
import static cc.southseast.controller.function.ToGetData.userCacheData;

/**
 * @Author: Southseast
 * @Date: 2019/1/1 4:33 PM
 * @Version 1.0
 */
public class ToSearchBook implements EventHandler<ActionEvent> {

    private JFXTextField searchInput;

    private TableView tableView;

    public ToSearchBook(JFXTextField searchInput, TableView tableView) {

        this.searchInput = searchInput;
        this.tableView = tableView;
    }

    @Override
    public void handle(ActionEvent event) {

        String id = searchInput.getText();
        List<Book> userList = dao.query(Book.class, Cnd.where("bookName", "like", "%" + id + "%"));
        tableView.getItems().clear();

        bookCacheData = FXCollections.observableArrayList(userList);
        tableView.setItems(bookCacheData);


        for (Book book: bookCacheData) {
            System.out.println(book.toString());
        }

        tableView.refresh();
    }
}
