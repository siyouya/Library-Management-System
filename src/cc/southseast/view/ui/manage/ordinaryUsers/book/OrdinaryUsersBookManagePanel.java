package cc.southseast.view.ui.manage.ordinaryUsers.book;

import cc.southseast.controller.function.ToConnect;
import cc.southseast.controller.function.book.ToSearchBook;
import cc.southseast.model.Book;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Date;
import java.util.List;

import static cc.southseast.controller.function.ToConnect.dao;
import static cc.southseast.controller.function.ToGetData.bookCacheData;

public class OrdinaryUsersBookManagePanel extends VBox {

    private JFXTextField searchInput = new JFXTextField();

    private JFXButton searchButton = new JFXButton("搜索");

    private HBox functionBar = new HBox();

    private TableView tableView = new TableView();

    public OrdinaryUsersBookManagePanel() {

        // 引入样式文件
        this.getStylesheets().add("cc/southseast/view/resources/css/UserManagePanel.css");
        this.setPadding(new Insets(20,20,20,20));
        this.setSpacing(20);

        dao.create(Book.class, false);
        List<Book> bookList = ToConnect.dao.query(Book.class, null);

        bookCacheData = FXCollections.observableArrayList(bookList);

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

        tableView.setEditable(true);
        tableView.setId("tableView");
        tableView.setItems(bookCacheData);
        tableView.setMinSize(884,680);
        tableView.styleProperty();
        tableView.getColumns().setAll(bookNumber, bookId, bookName,
                bookPrice, bookWriter, bookPublishId);

        searchInput.setId("searchInput");
        searchInput.setPadding(new Insets(0,0,0,10));
        searchInput.setMinHeight(30);
        searchInput.setPromptText("搜索书名");

        searchButton.setId("searchButton");
        searchButton.setOnAction(new ToSearchBook(searchInput, tableView));

        functionBar.setSpacing(20);
        functionBar.getChildren().addAll(searchInput, searchButton);

        this.getChildren().addAll(functionBar,tableView);

    }
}