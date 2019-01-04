package cc.southseast.controller.function.borrow;

import cc.southseast.model.Borrow;
import cc.southseast.model.User;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import static cc.southseast.controller.function.ToConnect.dao;
import static cc.southseast.controller.function.ToGetData.borrowCacheData;

/**
 * @Author: Southseast
 * @Date: 2019/1/2 11:34 PM
 * @Version 1.0
 */
public class ToUpdateBorrow implements EventHandler<ActionEvent> {

    private TableView tableView = new TableView();

    private Label id = new Label();
    private JFXTextField idInput = new JFXTextField();
    private JFXTextField bookIdInput = new JFXTextField();
    private Stage editStage = new Stage();

    public ToUpdateBorrow(TableView tableView, JFXTextField idInput, JFXTextField bookIdInput, Stage editStage) {
        this.tableView = tableView;
        this.idInput = idInput;
        this.bookIdInput = bookIdInput;
        this.editStage = editStage;
    }

    @Override
    public void handle(ActionEvent event) {

        Borrow borrow = dao.fetch(Borrow.class, Long.parseLong(id.getText()));
        borrow.setId(Long.parseLong(idInput.getText()));
        borrow.setBookId(Long.parseLong(bookIdInput.getText()));
        borrow.setCheck(false);

        dao.create(User.class, false);
        dao.update(borrow);
        tableView.refresh();

        int i = 0;
        for (Borrow beforeBorrow: borrowCacheData) {
            if (beforeBorrow.getBorrowId() == borrow.getBorrowId()){
                (borrowCacheData.get(i)).setId(Long.parseLong(idInput.getText()));
                (borrowCacheData.get(i)).setBookId(Long.parseLong(bookIdInput.getText()));
                (borrowCacheData.get(i)).setCheck(false);
            }
            i++;
        }

        editStage.close();


    }
}
