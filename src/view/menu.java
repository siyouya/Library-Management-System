package view;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;
import view.login.LoginInterface;

import javax.sql.DataSource;

public class menu extends Application {

    HBox root = new HBox();

    @Override
    public void start(Stage primaryStage) {

        // 数据库
        Ioc ioc = new NutIoc(new JsonLoader("db_server.js"));
        DataSource ds = ioc.get(DataSource.class);
        Dao dao = new NutDao(ds); //如果已经定义了dao,那么改成dao = ioc.get(Dao.class);

        // 创建登陆界面
        LoginInterface loginInterface= new LoginInterface(dao);

        // 添加登陆界面
        root.getChildren().addAll(loginInterface);
        System.out.println(loginInterface.getParent());

        // 创建舞台
        Scene scene = new Scene(root, 1024, 768);

        // 添加舞台
        primaryStage.setScene(scene);

        // 展示舞台
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}