package cc.southseast;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import cc.southseast.view.ui.base.BasePanel;
import cc.southseast.view.ui.manage.ManagePanel;

public class StartTest extends Application {


    private Stage primaryStage = new Stage();

    private BasePanel root = new BasePanel();

    private ManagePanel managePanel = new ManagePanel();

    private Scene scene = new Scene(root);

    @Override
    public void start(Stage primaryStage) {

        // 创建登陆界面
//        LoginPanel loginPanel = new LoginPanel(dao);

        // 添加登陆界面
        root.windowsInit(primaryStage);
        root.addManagePanel(managePanel);

        // 设置透明度
        scene.setFill(null);

        // 添加舞台
        primaryStage.setScene(scene);

        // 显示舞台
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}