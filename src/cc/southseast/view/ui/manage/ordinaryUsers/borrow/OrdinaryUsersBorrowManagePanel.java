package cc.southseast.view.ui.manage.ordinaryUsers.borrow;

import cc.southseast.controller.change.borrow.ToInsertBorrowPanel;
import cc.southseast.controller.change.borrow.ToUpdateBorrowPanel;
import cc.southseast.controller.function.ToConnect;
import cc.southseast.controller.function.borrow.ToBatchDeleteBorrow;
import cc.southseast.controller.function.borrow.ToDeleteBorrow;
import cc.southseast.controller.function.borrow.ToSearchBorrow;
import cc.southseast.model.Borrow;
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

import static cc.southseast.controller.function.ToConnect.dao;
import static cc.southseast.controller.function.ToGetData.borrowCacheData;

public class OrdinaryUsersBorrowManagePanel extends VBox {

    private JFXTextField searchInput = new JFXTextField();

    private JFXButton searchButton = new JFXButton("搜索");

    private JFXButton addButton = new JFXButton("添加");

    private HBox functionBar = new HBox();

    private TableView tableView = new TableView();

    public OrdinaryUsersBorrowManagePanel() {

        // 引入样式文件
        this.getStylesheets().add("cc/southseast/view/resources/css/UserManagePanel.css");
        this.setPadding(new Insets(20,20,20,20));
        this.setSpacing(20);

        dao.create(Borrow.class, false);
        List<Borrow> borrowList = ToConnect.dao.query(Borrow.class, null);

        borrowCacheData = FXCollections.observableArrayList(borrowList);

        TableColumn borrowNumber = new TableColumn<Borrow, Integer>("序号");
        borrowNumber.setCellValueFactory(new PropertyValueFactory<Borrow, Integer>("number"));
        borrowNumber.setCellFactory((col) -> {
            TableCell<Borrow, String> cell = new TableCell<Borrow, String>() {
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

        TableColumn borrowId = new TableColumn<Borrow, String>("借阅人账号");
        borrowId.setCellValueFactory(new PropertyValueFactory<Borrow, String>("id"));

        TableColumn borrowBookId = new TableColumn<Borrow, String>("书号");
        borrowBookId.setCellValueFactory(new PropertyValueFactory<Borrow, String>("bookId"));

        TableColumn borrowDay = new TableColumn<Borrow, Date>("借阅日期");
        borrowDay.setCellValueFactory(new PropertyValueFactory<Borrow, Double>("borrowDay"));

        TableColumn borrowReturnDay = new TableColumn<Borrow, Date>("应该归还日期");
        borrowReturnDay.setCellValueFactory(new PropertyValueFactory<Borrow, String>("returnDay"));

        TableColumn borrowOverTime = new TableColumn<Borrow, Date>("超时归还时间");
        borrowOverTime.setCellValueFactory(new PropertyValueFactory<Borrow, Date>("overtime"));
        borrowOverTime.setCellFactory((col) -> {
            TableCell<Borrow, String> cell = new TableCell<Borrow, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Borrow borrow = getTableView().getItems().get(getIndex());
                        long rowIndex = borrow.getReturnDay().toEpochDay() - borrow.getBorrowDay().toEpochDay();
                        if (rowIndex >= 0)
                            this.setText(String.valueOf(0));
                        else
                            this.setText(String.valueOf(Math.abs(rowIndex)));
                    }
                }
            };
            return cell;
        });

        tableView.setEditable(true);
        tableView.setId("tableView");
        tableView.setItems(borrowCacheData);
        tableView.setMinSize(884,680);
        tableView.styleProperty();
        tableView.getColumns().setAll(borrowNumber, borrowId, borrowBookId,
                borrowDay, borrowReturnDay, borrowOverTime);

        searchInput.setId("searchInput");
        searchInput.setPadding(new Insets(0,0,0,10));
        searchInput.setMinHeight(30);
        searchInput.setPromptText("搜索书名");

        searchButton.setId("searchButton");
        searchButton.setOnAction(new ToSearchBorrow(searchInput, tableView));

        addButton.setId("addButton");
        addButton.setOnAction(new ToInsertBorrowPanel(tableView));

        functionBar.setSpacing(20);
        functionBar.getChildren().addAll(searchInput, searchButton, addButton);

        this.getChildren().addAll(functionBar,tableView);

    }
}