package cc.southseast.view.ui.manage;

import com.jfoenix.controls.JFXButton;
import cc.southseast.controller.change.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ManagePanel extends HBox {

    private BorderPane chooseMain = new BorderPane();

    private HBox manageMain = new HBox();

    private UserManagePanel userManagePanel = new UserManagePanel();

    private JFXButton userManageButton = new JFXButton("用户管理");

    private JFXButton bookManageButton = new JFXButton("图书管理");

    private JFXButton borrowManageButton = new JFXButton("借阅管理");

    private JFXButton publishManageButton = new JFXButton("出版社管理");

    private JFXButton quitButton = new JFXButton("退出登录");

    private VBox menuBar = new VBox();

    private VBox bottomBar = new VBox();

    private HBox backImage = new HBox();

    public ManagePanel() {

        // 引入样式文件
        this.getStylesheets().add("cc/southseast/view/resources/css/ManagePanel.css");

        this.setId("ManagePanel");

        chooseMain.setId("chooseMain");

        backImage.setId("backImage");
        backImage.setMinSize(100,106);
        backImage.setMaxSize(100,106);

        userManageButton.setId("userManageButton");
        userManageButton.setMinSize(100,50);
        userManageButton.setStyle("-fx-background-color: #2f3136");
        userManageButton.setOnMousePressed(new ToUserManagePanel(this));

        bookManageButton.setId("bookManageButton");
        bookManageButton.setMinSize(100,50);
        bookManageButton.setOnMousePressed(new ToBookManagePanel(this));

        borrowManageButton.setId("borrowManageButton");
        borrowManageButton.setMinSize(100,50);
        borrowManageButton.setOnMousePressed(new ToBorrowManagePanel(this));

        publishManageButton.setId("publishManageButton");
        publishManageButton.setMinSize(100,50);
        publishManageButton.setOnMousePressed(new ToPublishManagePanel(this));

        quitButton.setId("quitButton");
        quitButton.setMinSize(100,50);
        quitButton.setOnMousePressed(new ToQuitLoginPanel(this));

        menuBar.getChildren().addAll(userManageButton, bookManageButton,
                borrowManageButton, publishManageButton, quitButton);

        bottomBar.setSpacing(10);
        bottomBar.getChildren().addAll(backImage, quitButton);

        chooseMain.setTop(menuBar);
        chooseMain.setBottom(bottomBar);

//        chooseMain.setMinSize(104,768);
//        chooseMain.setPadding(new Insets(2,0,2,0));
//        manageMain.setMinSize(920,768);
        chooseMain.setMinSize(100,768);
        manageMain.setMinSize(924,768);
        manageMain.getChildren().addAll(userManagePanel);

        this.getChildren().addAll(chooseMain, manageMain);


    }

    public JFXButton getUserManageButton() {
        return userManageButton;
    }

    public JFXButton getBookManageButton() {
        return bookManageButton;
    }

    public JFXButton getBorrowManageButton() {
        return borrowManageButton;
    }

    public JFXButton getPublishManageButton() {
        return publishManageButton;
    }

    public BorderPane getChooseMain() {
        return chooseMain;
    }

    public HBox getManageMain() {
        return manageMain;
    }

}
