package cc.southseast.controller.function.borrow;

import cc.southseast.model.Borrow;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.sql.Date;

import static cc.southseast.controller.function.ToConnect.dao;

/**
 * @Author: Southseast
 * @Date: 2019/1/1 11:56 PM
 * @Version 1.0
 */
public class ToInsertBorrow implements EventHandler<ActionEvent> {

    private TableView tableView = new TableView();
    private JFXTextField idInput = new JFXTextField();
    private JFXTextField bookIdInput = new JFXTextField();
    private Borrow borrow = new Borrow();
    private Stage addStage = new Stage();

    public ToInsertBorrow(TableView tableView, JFXTextField idInput, JFXTextField bookIdInput, Stage addStage) {
        this.tableView = tableView;
        this.idInput = idInput;
        this.bookIdInput = bookIdInput;
        this.addStage = addStage;
    }

    @Override
    public void handle(ActionEvent event) {
        if (idInput.getText().equals(null) || idInput.getText().equals("")){

        }
        else {
            borrow.setId(Long.parseLong(idInput.getText()));
            borrow.setBookId(Long.parseLong(bookIdInput.getText()));
            borrow.setBorrowDay(new java.sql.Date(new java.util.Date().getTime()));
            borrow.setReturnDay(Date.valueOf((new Date(new java.util.Date().getTime())).toLocalDate().plusDays(7)));
            borrow.setCheck(false);
            dao.create(Borrow.class, false);
            dao.insert(borrow);
            tableView.getItems().add(borrow);
            tableView.refresh();
            addStage.close();
        }
    }

}
