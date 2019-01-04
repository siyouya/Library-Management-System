package cc.southseast.view.ui.base;

import cc.southseast.controller.function.ToClose;
import cc.southseast.controller.function.ToDrag;
import cc.southseast.view.ui.manage.book.BookInsertPanel;
import cc.southseast.view.ui.manage.book.BookUpdatePanel;
import cc.southseast.view.ui.manage.publish.PublishInsertPanel;
import cc.southseast.view.ui.manage.publish.PublishUpdatePanel;
import cc.southseast.view.ui.manage.user.InsertPanel;
import cc.southseast.view.ui.manage.user.UpdatePanel;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import cc.southseast.view.ui.login.LoginPanel;
import cc.southseast.view.ui.manage.ManagePanel;
import javafx.stage.StageStyle;

public class BasePanel extends HBox {

    private VBox root = new VBox();

    private AnchorPane title = new AnchorPane();

    private Button closeWindows = new Button();

    private VBox subject = new VBox();

    public BasePanel(){

        // 引入样式
        this.getStylesheets().add(
                "cc/southseast/view/resources/css/BasePanel.css");
        // 引入CSSID
        this.setId("BasePanel");

        // 阴影范围
        this.setPadding(new Insets(10,10,10,10));

        root.setId("root");

        //设置关闭按钮大小
        closeWindows.setPrefSize(20,20);

        //设置css样式id为closeWindows
        closeWindows.setId("toClose");

        //设置关闭按钮为标题栏子级
        title.getChildren().add(closeWindows);
        //设置标题栏绝对停靠右部位置
        title.setRightAnchor(closeWindows, 5.0);
        //设置标题栏绝对停靠顶部位置
        title.setTopAnchor(closeWindows, 5.0);

//        subject.setPadding(new Insets(20,30,20,30));

        root.getChildren().addAll(title,subject);

        //外部透明框，为做阴影效果
        this.getChildren().addAll(root);
    }

    //窗体初始化
    public void windowsInit(Stage primaryStage) {

//        //隐藏原窗体
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        //设置全局拖动
        ToDrag toDrag = new ToDrag(primaryStage);
        toDrag.enableDrag(this);

        //关闭功能
        closeWindows.setOnAction(new ToClose(primaryStage));
    }

    //界面跳转，传入布局为LoginPanel的界面
    public void addLoginPanel(LoginPanel loginPanel) {

        subject.getChildren().clear();
        subject.getChildren().addAll(loginPanel);
    }


    //界面跳转，传入布局为ManagePanel的界面
    public void addManagePanel(ManagePanel managePanel) {

        subject.getChildren().clear();
        subject.getChildren().addAll(managePanel);
    }

    public void addUpdatePanel(UpdatePanel updatePanel) {

        subject.getChildren().clear();
        subject.getChildren().addAll(updatePanel);
    }

    public void addInsertPanel(InsertPanel insertPanel) {

        subject.getChildren().clear();
        subject.getChildren().addAll(insertPanel);
    }

    public void addHintPanel(HintPanel hintPanel) {

        subject.getChildren().clear();
        subject.getChildren().addAll(hintPanel);
    }

    public void addBookUpdatePanel(BookUpdatePanel bookUpdatePanel) {

        subject.getChildren().clear();
        subject.getChildren().addAll(bookUpdatePanel);
    }

    public void addBookInsertPanel(BookInsertPanel bookInsertPanel) {

        subject.getChildren().clear();
        subject.getChildren().addAll(bookInsertPanel);
    }

    public void addPublishInsertPanel(PublishInsertPanel publishInsertPanel) {

        subject.getChildren().clear();
        subject.getChildren().addAll(publishInsertPanel);
    }


    public void addPublishUpdatePanel(PublishUpdatePanel publishUpdatePanel) {

        subject.getChildren().clear();
        subject.getChildren().addAll(publishUpdatePanel);
    }

}
