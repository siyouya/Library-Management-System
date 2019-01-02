package cc.southseast.view.ui.manage;

import cc.southseast.controller.change.ToInsertUserPanel;
import cc.southseast.controller.change.ToUpdateUserPanel;
import cc.southseast.controller.function.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

        for (User user: userList) {
            System.out.println(user.toString());
        }

        ObservableList<User> cacheData = FXCollections.observableArrayList(userList);


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
//                        System.out.println("1");
                        User user = cacheData.get(cell.getIndex());
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

//        TableColumn userId = new TableColumn<User, Integer>("序号");
//        userId.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));

        TableColumn userStudentId = new TableColumn<User, String>("学号");
        userStudentId.setCellValueFactory(new PropertyValueFactory<User, String>("studentId"));

        TableColumn userName = new TableColumn<User, String>("姓名");
        userName.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
//        userName.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn userSex = new TableColumn<User, String>("性别");
        userSex.setCellValueFactory(new PropertyValueFactory<User, String>("sex"));
//        userSex.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn userBirthday = new TableColumn<User, Date>("生日");
        userBirthday.setCellValueFactory(new PropertyValueFactory<User, Date>("birthday"));
//        userBirthday.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn userTelphone = new TableColumn<User, String>("电话");
        userTelphone.setCellValueFactory(new PropertyValueFactory<User, String>("telphone"));
//        userTelphone.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn userEmail = new TableColumn<User, String>("邮箱");
        userEmail.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
//        userEmail.setCellFactory(TextFieldTableCell.forTableColumn());

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
                                            new ToDelete(getTableView().getItems().get(getIndex()).getStudentId(), tableView));

                                    setGraphic(commandBar);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };
        userCommand.setCellFactory(cellCommand);


        // 多选
//        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        tableView.setEditable(true);
        tableView.setId("tableView");
        tableView.setItems(cacheData);
        tableView.setMinSize(884,680);
        tableView.styleProperty();
//        tableView.getColumns().setAll(checkBoxColumn, userId, userStudentId, userName, userSex,
//                userBirthday, userTelphone, userEmail, userCommand);
        tableView.getColumns().setAll(checkBoxColumn, userStudentId, userName, userSex,
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

//        batchDeletionButton.setOnMousePressed(new ToBatchDelete(tableView));
        batchDeletionButton.setOnAction(new ToBatchDelete(tableView));

        functionBar.setSpacing(20);
        functionBar.getChildren().addAll(searchInput, searchButton, addButton, batchDeletionButton);


        this.getChildren().addAll(functionBar,tableView);



    }
}
