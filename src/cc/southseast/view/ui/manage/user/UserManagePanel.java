package cc.southseast.view.ui.manage.user;

import cc.southseast.controller.change.user.ToInsertUserPanel;
import cc.southseast.controller.change.user.ToUpdateUserPanel;
import cc.southseast.controller.function.*;
import cc.southseast.controller.function.user.ToBatchDelete;
import cc.southseast.controller.function.user.ToDelete;
import cc.southseast.controller.function.user.ToSearch;
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
import cc.southseast.model.User;
import static cc.southseast.controller.function.ToConnect.*;
import static cc.southseast.controller.function.ToGetData.*;
import java.util.Date;
import java.util.List;

public class UserManagePanel extends VBox {

    private JFXTextField searchInput = new JFXTextField();

    private JFXButton searchButton = new JFXButton("搜索");

    private JFXButton addButton = new JFXButton("添加");

    private JFXButton batchDeletionButton = new JFXButton("批量删除");

    private HBox functionBar = new HBox();

    private TableView tableView = new TableView();

    public UserManagePanel() {

        // 引入样式文件
        this.getStylesheets().add("cc/southseast/view/resources/css/UserManagePanel.css");
        this.setPadding(new Insets(20,20,20,20));
        this.setSpacing(20);

        dao.create(User.class, false);
        List<User> userList = ToConnect.dao.query(User.class, null);

//        for (User user: userList) {
//            System.out.println(user.toString());
//        }

        userCacheData = FXCollections.observableArrayList(userList);

        //多选
        TableColumn checkBoxColumn = new TableColumn<User, Boolean>();

        checkBoxColumn.setCellValueFactory(new PropertyValueFactory<User, Boolean>("isCheck"));
        Callback<TableColumn<User, Boolean>, TableCell<User, Boolean>> cellCheckBox
                = new Callback<TableColumn<User, Boolean>, TableCell<User, Boolean>>() {

            public TableCell<User, Boolean> call(TableColumn<User, Boolean> param) {

                CheckBoxTableView<User, Boolean> cell = new CheckBoxTableView<>();

                JFXCheckBox jfxCheckBox = (JFXCheckBox) cell.getGraphic();

                jfxCheckBox.setOnAction(new EventHandler<ActionEvent>(){

                    @Override
                    public void handle(ActionEvent event) {
                        User user = userCacheData.get(cell.getIndex());
                        if(user.getCheck()){
                            user.setCheck(false);
                        }else{
                            user.setCheck(true);
                        }

                    }
                });
                return cell;
            }
        };
        checkBoxColumn.setCellFactory(cellCheckBox);
        checkBoxColumn.setMaxWidth(25);

        TableColumn userNumber = new TableColumn<User, Integer>("序号");
        userNumber.setCellValueFactory(new PropertyValueFactory<User, Integer>("number"));
        userNumber.setCellFactory((col) -> {
            TableCell<User, String> cell = new TableCell<User, String>() {
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

        TableColumn userId = new TableColumn<User, String>("账号");
        userId.setCellValueFactory(new PropertyValueFactory<User, String>("id"));

        TableColumn userName = new TableColumn<User, String>("姓名");
        userName.setCellValueFactory(new PropertyValueFactory<User, String>("name"));

        TableColumn userPassword = new TableColumn<User, String>("密码");
        userPassword.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
        userPassword.setMaxWidth(130);

        TableColumn userSex = new TableColumn<User, String>("性别");
        userSex.setCellValueFactory(new PropertyValueFactory<User, String>("sex"));

        TableColumn userBirthday = new TableColumn<User, Date>("生日");
        userBirthday.setCellValueFactory(new PropertyValueFactory<User, Date>("birthday"));

        TableColumn userTelphone = new TableColumn<User, String>("电话");
        userTelphone.setCellValueFactory(new PropertyValueFactory<User, String>("telphone"));

        TableColumn userEmail = new TableColumn<User, String>("邮箱");
        userEmail.setCellValueFactory(new PropertyValueFactory<User, String>("email"));

        TableColumn userCommand = new TableColumn<>("操作");

        Callback<TableColumn<User, String>, TableCell<User, String>> cellCommand
                = new Callback<TableColumn<User, String>, TableCell<User, String>>() {

            @Override
            public TableCell call(TableColumn<User, String> param) {

                TableCell<User, String> cell = new TableCell<User, String>() {

                    CommandBarTableView commandBar = new CommandBarTableView();

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            commandBar.getUserEdit().setOnAction(
                                    new ToUpdateUserPanel(getTableView().getItems().get(getIndex()), tableView));

                            commandBar.getUserDelete().setOnAction(
                                    new ToDelete(getTableView().getItems().get(getIndex()).getId(), tableView));

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
        tableView.setItems(userCacheData);
        tableView.setMinSize(884,680);
        tableView.styleProperty();
        tableView.getColumns().setAll(checkBoxColumn, userNumber, userId, userName, userPassword, userSex,
                userBirthday, userTelphone, userEmail, userCommand);

        searchInput.setId("searchInput");
        searchInput.setPadding(new Insets(0,0,0,10));
        searchInput.setMinHeight(30);
        searchInput.setPromptText("搜索学号");

        searchButton.setId("searchButton");
        searchButton.setOnAction(new ToSearch(searchInput, tableView));

        addButton.setId("addButton");
        addButton.setOnAction(new ToInsertUserPanel(tableView));

        batchDeletionButton.setId("batchDeletionButton");
        batchDeletionButton.setOnAction(new ToBatchDelete(tableView));

        functionBar.setSpacing(20);
        functionBar.getChildren().addAll(searchInput, searchButton, addButton, batchDeletionButton);

        this.getChildren().addAll(functionBar,tableView);

    }
}