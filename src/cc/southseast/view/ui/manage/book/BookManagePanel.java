package cc.southseast.view.ui.manage.book;

import cc.southseast.controller.change.book.ToInsertBookPanel;
import cc.southseast.controller.change.book.ToUpdateBookPanel;
import cc.southseast.controller.function.ToConnect;
import cc.southseast.controller.function.book.ToBatchDeleteBook;
import cc.southseast.controller.function.book.ToSearchBook;
import cc.southseast.controller.function.book.ToDeleteBook;
import cc.southseast.model.Book;
import cc.southseast.view.ui.manage.CheckBoxTableView;
import cc.southseast.view.ui.manage.CommandBarTableView;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.util.Date;
import java.util.List;

import static cc.southseast.controller.function.ToConnect.*;
import static cc.southseast.controller.function.ToGetData.*;

public class BookManagePanel extends VBox {

    private JFXTextField searchInput = new JFXTextField();

    private JFXButton searchButton = new JFXButton("搜索");

    private JFXButton addButton = new JFXButton("添加");

    private JFXButton batchDeletionButton = new JFXButton("批量删除");

    private HBox functionBar = new HBox();

    private TableView tableView = new TableView();

    public BookManagePanel() {

        // 引入样式文件
        this.getStylesheets().add("cc/southseast/view/resources/css/UserManagePanel.css");
        this.setPadding(new Insets(20,20,20,20));
        this.setSpacing(20);

        dao.create(Book.class, false);
        List<Book> bookList = ToConnect.dao.query(Book.class, null);

        bookCacheData = FXCollections.observableArrayList(bookList);

        //多选
        TableColumn checkBoxColumn = new TableColumn<Book, Boolean>();

        checkBoxColumn.setCellValueFactory(new PropertyValueFactory<Book, Boolean>("isCheck"));
        Callback<TableColumn<Book, Boolean>, TableCell<Book, Boolean>> cellCheckBox
                = new Callback<TableColumn<Book, Boolean>, TableCell<Book, Boolean>>() {

            public TableCell<Book, Boolean> call(TableColumn<Book, Boolean> param) {

                CheckBoxTableView<Book, Boolean> cell = new CheckBoxTableView<>();

                JFXCheckBox jfxCheckBox = (JFXCheckBox) cell.getGraphic();

                jfxCheckBox.setOnAction(new EventHandler<ActionEvent>(){

                    @Override
                    public void handle(ActionEvent event) {
                        Book book = bookCacheData.get(cell.getIndex());
                        if(book.getCheck()){
                            book.setCheck(false);
                        }else{
                            book.setCheck(true);
                        }

                    }
                });
                return cell;
            }
        };
        checkBoxColumn.setCellFactory(cellCheckBox);
        checkBoxColumn.setMaxWidth(25);

        TableColumn bookNumber = new TableColumn<Book, Integer>("序号");
        bookNumber.setCellValueFactory(new PropertyValueFactory<Book, Integer>("number"));
        bookNumber.setCellFactory((col) -> {
            TableCell<Book, String> cell = new TableCell<Book, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        int rowIndex = this.getIndex() + 1;
                        this.setText(String.valueOf(rowIndex));
                    }
                }
            };
            return cell;
        });

        TableColumn bookId = new TableColumn<Book, String>("书号");
        bookId.setCellValueFactory(new PropertyValueFactory<Book, String>("bookId"));

        TableColumn bookName = new TableColumn<Book, String>("书名");
        bookName.setCellValueFactory(new PropertyValueFactory<Book, String>("bookName"));

        TableColumn bookPrice = new TableColumn<Book, Double>("价格");
        bookPrice.setCellValueFactory(new PropertyValueFactory<Book, Double>("bookPrice"));

        TableColumn bookWriter = new TableColumn<Book, String>("作者");
        bookWriter.setCellValueFactory(new PropertyValueFactory<Book, String>("writer"));

        TableColumn bookPublishId = new TableColumn<Book, Date>("出版社号");
        bookPublishId.setCellValueFactory(new PropertyValueFactory<Book, Date>("publishId"));

        TableColumn userCommand = new TableColumn<>("操作");

        Callback<TableColumn<Book, String>, TableCell<Book, String>> cellCommand
                = new Callback<TableColumn<Book, String>, TableCell<Book, String>>() {

            @Override
            public TableCell call(TableColumn<Book, String> param) {

                TableCell<Book, String> cell = new TableCell<Book, String>() {

                    CommandBarTableView commandBar = new CommandBarTableView();

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            commandBar.getUserEdit().setOnAction(
                                    new ToUpdateBookPanel(getTableView().getItems().get(getIndex()), tableView));

                            commandBar.getUserDelete().setOnAction(
                                    new ToDeleteBook(getTableView().getItems().get(getIndex()).getBookId(), tableView));

                            setGraphic(commandBar);
                            setText(null);
                        }
                    }
                };
                return cell;
            }
        };
        userCommand.setCellFactory(cellCommand);

        tableView.setEditable(true);
        tableView.setId("tableView");
        tableView.setItems(bookCacheData);
        tableView.setMinSize(884,680);
        tableView.styleProperty();
        tableView.getColumns().setAll(checkBoxColumn, bookNumber, bookId, bookName,
                bookPrice, bookWriter, bookPublishId, userCommand);

        searchInput.setId("searchInput");
        searchInput.setPadding(new Insets(0,0,0,10));
        searchInput.setMinHeight(30);
        searchInput.setPromptText("搜索书名");

        searchButton.setId("searchButton");
        searchButton.setOnAction(new ToSearchBook(searchInput, tableView));

        addButton.setId("addButton");
        addButton.setOnAction(new ToInsertBookPanel(tableView));

        batchDeletionButton.setId("batchDeletionButton");
        batchDeletionButton.setOnAction(new ToBatchDeleteBook(tableView));

        functionBar.setSpacing(20);
        functionBar.getChildren().addAll(searchInput, searchButton, addButton, batchDeletionButton);

        this.getChildren().addAll(functionBar,tableView);

    }
}