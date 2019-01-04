package cc.southseast.view.ui.manage.admin.publish;

import cc.southseast.controller.change.publish.ToInsertPublishPanel;
import cc.southseast.controller.change.publish.ToUpdatePublishPanel;
import cc.southseast.controller.function.ToConnect;
import cc.southseast.controller.function.publish.ToBatchDeletePublish;
import cc.southseast.controller.function.publish.ToSearchPublish;
import cc.southseast.controller.function.publish.ToDeletePublish;
import cc.southseast.model.Publish;
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

import java.util.List;

import static cc.southseast.controller.function.ToConnect.*;
import static cc.southseast.controller.function.ToGetData.*;

public class PublishManagePanel extends VBox {

    private JFXTextField searchInput = new JFXTextField();

    private JFXButton searchButton = new JFXButton("搜索");

    private JFXButton addButton = new JFXButton("添加");

    private JFXButton batchDeletionButton = new JFXButton("批量删除");

    private HBox functionBar = new HBox();

    private TableView tableView = new TableView();

    public PublishManagePanel() {

        // 引入样式文件
        this.getStylesheets().add("cc/southseast/view/resources/css/UserManagePanel.css");
        this.setPadding(new Insets(20,20,20,20));
        this.setSpacing(20);

        dao.create(Publish.class, false);
        List<Publish> publishList = ToConnect.dao.query(Publish.class, null);

        publishCacheData = FXCollections.observableArrayList(publishList);

        //多选
        TableColumn checkBoxColumn = new TableColumn<Publish, Boolean>();

        checkBoxColumn.setCellValueFactory(new PropertyValueFactory<Publish, Boolean>("isCheck"));
        Callback<TableColumn<Publish, Boolean>, TableCell<Publish, Boolean>> cellCheckBox
                = new Callback<TableColumn<Publish, Boolean>, TableCell<Publish, Boolean>>() {

            public TableCell<Publish, Boolean> call(TableColumn<Publish, Boolean> param) {

                CheckBoxTableView<Publish, Boolean> cell = new CheckBoxTableView<>();

                JFXCheckBox jfxCheckBox = (JFXCheckBox) cell.getGraphic();

                jfxCheckBox.setOnAction(new EventHandler<ActionEvent>(){

                    @Override
                    public void handle(ActionEvent event) {
                        Publish publish = publishCacheData.get(cell.getIndex());
                        if(publish.getCheck()){
                            publish.setCheck(false);
                        }else{
                            publish.setCheck(true);
                        }

                    }
                });
                return cell;
            }
        };
        checkBoxColumn.setCellFactory(cellCheckBox);
        checkBoxColumn.setMaxWidth(25);

        TableColumn publishNumber = new TableColumn<Publish, Integer>("序号");
        publishNumber.setCellValueFactory(new PropertyValueFactory<Publish, Integer>("number"));
        publishNumber.setCellFactory((col) -> {
            TableCell<Publish, String> cell = new TableCell<Publish, String>() {
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

        TableColumn publishId = new TableColumn<Publish, String>("出版社号");
        publishId.setCellValueFactory(new PropertyValueFactory<Publish, String>("publishId"));

        TableColumn publishName = new TableColumn<Publish, String>("出版社名");
        publishName.setCellValueFactory(new PropertyValueFactory<Publish, String>("publishName"));

        TableColumn publishPrice = new TableColumn<Publish, Double>("出版社电话");
        publishPrice.setCellValueFactory(new PropertyValueFactory<Publish, Double>("publishPhone"));

        TableColumn userCommand = new TableColumn<>("操作");

        Callback<TableColumn<Publish, String>, TableCell<Publish, String>> cellCommand
                = new Callback<TableColumn<Publish, String>, TableCell<Publish, String>>() {

            @Override
            public TableCell call(TableColumn<Publish, String> param) {

                TableCell<Publish, String> cell = new TableCell<Publish, String>() {

                    CommandBarTableView commandBar = new CommandBarTableView();

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            commandBar.getUserEdit().setOnAction(
                                    new ToUpdatePublishPanel(getTableView().getItems().get(getIndex()), tableView));

                            commandBar.getUserDelete().setOnAction(
                                    new ToDeletePublish(getTableView().getItems().get(getIndex()).getPublishId(), tableView));

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
        tableView.setItems(publishCacheData);
        tableView.setMinSize(884,680);
        tableView.styleProperty();
        tableView.getColumns().setAll(checkBoxColumn, publishNumber, publishId, publishName,
                publishPrice, userCommand);

        searchInput.setId("searchInput");
        searchInput.setPadding(new Insets(0,0,0,10));
        searchInput.setMinHeight(30);
        searchInput.setPromptText("搜索出版社名");

        searchButton.setId("searchButton");
        searchButton.setOnAction(new ToSearchPublish(searchInput, tableView));

        addButton.setId("addButton");
        addButton.setOnAction(new ToInsertPublishPanel(tableView));

        batchDeletionButton.setId("batchDeletionButton");
        batchDeletionButton.setOnAction(new ToBatchDeletePublish(tableView));

        functionBar.setSpacing(20);
        functionBar.getChildren().addAll(searchInput, searchButton, addButton, batchDeletionButton);

        this.getChildren().addAll(functionBar,tableView);

    }
}