package cc.southseast.controller.function.book;

import cc.southseast.controller.sm.SM3Digest;
import cc.southseast.model.Book;
import cc.southseast.model.User;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.sql.Date;
import java.time.ZoneId;

import static cc.southseast.controller.function.ToConnect.dao;
import static cc.southseast.controller.function.ToGetData.bookCacheData;
import static cc.southseast.controller.function.ToGetData.userCacheData;

/**
 * @Author: Southseast
 * @Date: 2019/1/2 11:34 PM
 * @Version 1.0
 */
public class ToUpdateBook implements EventHandler<ActionEvent> {

    private TableView tableView = new TableView();

    private Label id = new Label();
    private JFXTextField nameInput = new JFXTextField();
    private JFXTextField writerInput = new JFXTextField();
    private JFXTextField priceInput = new JFXTextField();
    private JFXTextField publishInput = new JFXTextField();
    private Stage editStage = new Stage();

    public ToUpdateBook(TableView tableView, Label id, JFXTextField nameInput, JFXTextField writerInput, JFXTextField priceInput, JFXTextField publishInput, Stage editStage) {
        this.tableView = tableView;
        this.id = id;
        this.nameInput = nameInput;
        this.writerInput = writerInput;
        this.priceInput = priceInput;
        this.publishInput = publishInput;
        this.editStage = editStage;
    }

    @Override
    public void handle(ActionEvent event) {

        Book book = dao.fetch(Book.class, Long.parseLong(id.getText()));
        book.setBookName(nameInput.getText());
        book.setBookPrice(Double.parseDouble(priceInput.getText()));
        book.setWriter(writerInput.getText());
        book.setPublishId(Long.parseLong(publishInput.getText()));
        book.setCheck(false);

        dao.create(User.class, false);
        dao.update(book);
        tableView.refresh();

        int i = 0;
        for (Book beforeBook: bookCacheData) {
            if (beforeBook.getBookId() == book.getBookId()){
                (bookCacheData.get(i)).setBookName(nameInput.getText());
                (bookCacheData.get(i)).setWriter(writerInput.getText());
                (bookCacheData.get(i)).setPublishId(Long.parseLong(publishInput.getText()));
                (bookCacheData.get(i)).setBookPrice(Double.parseDouble(priceInput.getText()));
                (bookCacheData.get(i)).setCheck(false);
            }
            i++;
        }

        editStage.close();


    }
}
