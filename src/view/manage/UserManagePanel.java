package view.manage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import controller.ToConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import model.User;

import java.util.Date;
import java.util.List;

public class UserManagePanel extends VBox {

    private JFXTextField searchInput = new JFXTextField();

    private JFXButton searchButton = new JFXButton("搜索");

    private JFXButton addButton = new JFXButton("添加");

    private HBox functionBar = new HBox();

    private TableView tableView = new TableView();

    public UserManagePanel() {


        // 引入样式文件
        this.getStylesheets().add("view/resources/css/UserManagePanel.css");

        this.setPadding(new Insets(20,20,20,20));

        this.setSpacing(20);

        searchInput.setId("searchInput");
        searchInput.setPadding(new Insets(0,0,0,10));
        searchInput.setMinHeight(30);
        searchInput.setPromptText("搜索学号");

        searchButton.setId("searchButton");

        addButton.setId("addButton");

        functionBar.setSpacing(20);
        functionBar.getChildren().addAll(searchInput,searchButton,addButton);

        ToConnect.dao.create(User.class, false);
        List<User> user = ToConnect.dao.query(User.class, null);

        for (User test: user) {
            System.out.println(test.toString());

        }

        ObservableList<User> data = FXCollections.observableArrayList(user);

        TableColumn userId = new TableColumn<User, Integer>("序号");
        userId.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));

        TableColumn userStudentId = new TableColumn<User, String>("学号");
        userStudentId.setCellValueFactory(new PropertyValueFactory<User, String>("studentId"));

        TableColumn userName = new TableColumn<User, String>("姓名");
        userName.setCellValueFactory(new PropertyValueFactory<User, String>("name"));

        TableColumn userSex = new TableColumn<User, String>("性别");
        userSex.setCellValueFactory(new PropertyValueFactory<User, String>("sex"));

        TableColumn userBirthday = new TableColumn<User, Date>("生日");
        userBirthday.setCellValueFactory(new PropertyValueFactory<User, Date>("birthday"));

        TableColumn userTelphone = new TableColumn<User, String>("电话");
        userTelphone.setCellValueFactory(new PropertyValueFactory<User, String>("telphone"));

        TableColumn userEmail = new TableColumn<User, String>("邮箱");
        userEmail.setCellValueFactory(new PropertyValueFactory<User, String>("email"));

        TableColumn userCommand = new TableColumn<>("操作");
        userCommand.setCellValueFactory(new PropertyValueFactory<>("userCommand"));

        Callback<TableColumn<User, String>, TableCell<User, String>> cellFactory
                = new Callback<TableColumn<User, String>, TableCell<User, String>>() {

                    @Override
                    public TableCell call(TableColumn<User, String> param) {

                        TableCell<User, String> cell = new TableCell<User, String>() {

                            private CommandBar commandBar = new CommandBar();

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    commandBar.getUserEdit().setOnAction(event -> {
                                        User user = getTableView().getItems().get(getIndex());
                                        System.out.println("edit:"+user.getId());
                                    });

                                    commandBar.getUserDelete().setOnAction(event -> {
                                        User user = getTableView().getItems().get(getIndex());
                                        System.out.println("delete:"+user.getId());
                                    });

                                    setGraphic(commandBar);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };

//        TableCell.setId("userEdit");
//
//        userDelete.setId("userDelete");


        userCommand.setCellFactory(cellFactory);

        // 多选
//        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);



        tableView.setId("tableView");
        tableView.setItems(data);
        tableView.setMinSize(884,680);
        tableView.styleProperty();
        tableView.getColumns().setAll(userId, userStudentId, userName, userSex, userBirthday,
                userTelphone, userEmail, userCommand);


        this.getChildren().addAll(functionBar,tableView);



    }
}
