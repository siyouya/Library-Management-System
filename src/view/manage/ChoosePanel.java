package view.manage;

import com.jfoenix.controls.JFXButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ChoosePanel extends BorderPane {

    private JFXButton userManageButton = new JFXButton("用户管理");

    private JFXButton bookManageButton = new JFXButton("图书管理");

    private JFXButton borrowManageButton = new JFXButton("借阅管理");

    private JFXButton pressManageButton = new JFXButton("出版社管理");

    private JFXButton quitButton = new JFXButton("退出登录");

    private VBox menuBar = new VBox();

    public ChoosePanel() {

        this.setMinSize(100,768);
        this.setId("ChoosePanel");
        // 引入样式文件
        this.getStylesheets().add("view/resources/css/ChoosePanel.css");

        userManageButton.setMinSize(100,50);
        bookManageButton.setMinSize(100,50);
        borrowManageButton.setMinSize(100,50);
        pressManageButton.setMinSize(100,50);
        quitButton.setMinSize(100,50);

        menuBar.getChildren().addAll(userManageButton, bookManageButton,
                borrowManageButton, pressManageButton);

        this.setTop(menuBar);
        this.setBottom(quitButton);
    }
}
