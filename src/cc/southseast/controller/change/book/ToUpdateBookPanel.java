package cc.southseast.controller.change.book;

import cc.southseast.model.Book;
import cc.southseast.view.ui.base.BasePanel;
import cc.southseast.view.ui.manage.admin.book.BookUpdatePanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @Author: Southseast
 * @Date: 2019/1/1 7:09 PM
 * @Version 1.0
 */
public class ToUpdateBookPanel implements EventHandler<ActionEvent> {

    private TableView tableView = new TableView();

    private Book book = new Book();

    public ToUpdateBookPanel(Book book, TableView tableView) {

        this.tableView = tableView;
        this.book = book;
    }

    @Override
    public void handle(ActionEvent event) {

        Stage editStage = new Stage();

        BasePanel root = new BasePanel();

        BookUpdatePanel bookUpdatePanel = new BookUpdatePanel(tableView, editStage);

        Scene scene = new Scene(root);

        Stage stage = (Stage) tableView.getScene().getWindow();

        root.windowsInit(editStage);

        root.addBookUpdatePanel(bookUpdatePanel);
        bookUpdatePanel.addUserInformation(book);
        // 设置透明度
        scene.setFill(Color.TRANSPARENT);

        editStage.initModality(Modality.WINDOW_MODAL);
        editStage.initOwner(stage);
        editStage.setScene(scene);
        editStage.show();

    }
}