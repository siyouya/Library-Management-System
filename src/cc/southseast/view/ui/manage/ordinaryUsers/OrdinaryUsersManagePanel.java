package cc.southseast.view.ui.manage.ordinaryUsers;

import cc.southseast.controller.change.*;
import cc.southseast.view.ui.manage.ordinaryUsers.book.OrdinaryUsersBookManagePanel;
import com.jfoenix.controls.JFXButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class OrdinaryUsersManagePanel extends HBox {

    private BorderPane chooseMain = new BorderPane();

    private HBox manageMain = new HBox();

    private OrdinaryUsersBookManagePanel userManagePanel = new OrdinaryUsersBookManagePanel();

    private JFXButton bookManageButton = new JFXButton("书籍管理");

    private JFXButton borrowManageButton = new JFXButton("借阅管理");

    private JFXButton quitButton = new JFXButton("退出登录");

    private VBox menuBar = new VBox();

    private VBox bottomBar = new VBox();

    private HBox backImage = new HBox();

    public OrdinaryUsersManagePanel() {

        // 引入样式文件
        this.getStylesheets().add("cc/southseast/view/resources/css/ManagePanel.css");

        this.setId("AdminManagePanel");

        chooseMain.setId("chooseMain");

        backImage.setId("backImage");
        backImage.setMinSize(100,106);
        backImage.setMaxSize(100,106);

        bookManageButton.setId("bookManageButton");
        bookManageButton.setMinSize(100,50);
        bookManageButton.setOnMousePressed(new OrdinaryUsersToBookManagePanel(this));

        borrowManageButton.setId("borrowManageButton");
        borrowManageButton.setMinSize(100,50);
        borrowManageButton.setOnMousePressed(new OrdinaryUsersToBorrowManagePanel(this));

        quitButton.setId("quitButton");
        quitButton.setMinSize(100,50);
        quitButton.setOnMousePressed(new OrdinaryUsersToQuitLoginPanel(this));

        menuBar.getChildren().addAll(bookManageButton,
                borrowManageButton, quitButton);

        bottomBar.setSpacing(10);
        bottomBar.getChildren().addAll(backImage, quitButton);

        chooseMain.setTop(menuBar);
        chooseMain.setBottom(bottomBar);
        chooseMain.setMinSize(100,768);

        manageMain.setMinSize(924,768);
        manageMain.getChildren().addAll(userManagePanel);

        this.getChildren().addAll(chooseMain, manageMain);


    }

    public JFXButton getBookManageButton() {
        return bookManageButton;
    }

    public JFXButton getBorrowManageButton() {
        return borrowManageButton;
    }

    public BorderPane getChooseMain() {
        return chooseMain;
    }

    public HBox getManageMain() {
        return manageMain;
    }

}
