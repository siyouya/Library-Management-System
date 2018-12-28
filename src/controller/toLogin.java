package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.User;
import org.nutz.dao.Dao;


public class toLogin implements EventHandler<MouseEvent> {

    private JFXTextField id;
    private JFXPasswordField password;
    private Dao dao;

    public toLogin(JFXTextField id, JFXPasswordField password, Dao dao) {

        this.id = id;
        this.password = password;
        this.dao = dao;
    }

    @Override
    public void handle(MouseEvent event) {

        User user = dao.fetch(User.class,Integer.parseInt(id.getText()));
        if (user.getPassword().equals(password.getText())) {
            System.out.println("yes");
        }

//        System.out.println(account.getText());
//        System.out.println(password.getText());  //判断数据库

    }

}