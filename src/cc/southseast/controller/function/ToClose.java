package cc.southseast.controller.function;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ToClose implements EventHandler<ActionEvent> {

    private Stage primaryStage;

    public ToClose(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void handle(ActionEvent event) {
        // 关闭功能
        primaryStage.close();
    }
}
