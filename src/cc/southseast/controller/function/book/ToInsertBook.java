package cc.southseast.controller.function.book;

import cc.southseast.controller.sm.SM3Digest;
import cc.southseast.model.Book;
import cc.southseast.model.User;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.sql.Date;
import java.time.ZoneId;

import static cc.southseast.controller.function.ToConnect.dao;

/**
 * @Author: Southseast
 * @Date: 2019/1/1 11:56 PM
 * @Version 1.0
 */
public class ToInsertBook implements EventHandler<ActionEvent> {

    private TableView tableView = new TableView();
    private JFXTextField idInput = new JFXTextField();
    private JFXTextField nameInput = new JFXTextField();
    private JFXTextField writerInput = new JFXTextField();
    private JFXTextField priceInput = new JFXTextField();
    private JFXTextField publishInput = new JFXTextField();
    private Book book = new Book();
    private Stage addStage = new Stage();

    public ToInsertBook(TableView tableView, JFXTextField idInput, JFXTextField nameInput, JFXTextField writerInput, JFXTextField priceInput, JFXTextField publishInput, Stage addStage) {
        this.tableView = tableView;
        this.idInput = idInput;
        this.nameInput = nameInput;
        this.writerInput = writerInput;
        this.priceInput = priceInput;
        this.publishInput = publishInput;
        this.addStage = addStage;
    }

    @Override
    public void handle(ActionEvent event) {
        if (idInput.getText().equals(null) || idInput.getText().equals("")){

        }
        else {
            book.setBookId(Long.parseLong(idInput.getText()));
            book.setBookName(nameInput.getText());
            book.setWriter(writerInput.getText());
            book.setBookPrice(Double.parseDouble(priceInput.getText()));
            book.setPublishId(Long.parseLong(publishInput.getText()));
            book.setCheck(false);
            dao.create(Book.class, false);
            dao.insert(book);
            tableView.getItems().add(book);
            tableView.refresh();
            addStage.close();
        }
    }

}
