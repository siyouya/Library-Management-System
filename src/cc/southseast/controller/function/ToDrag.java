package cc.southseast.controller.function;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ToDrag implements EventHandler<MouseEvent> {


    private double xOffset = 0;
    private double yOffset = 0;
    private final Stage primaryStage;

    public ToDrag(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void handle(MouseEvent event) {
        event.consume();
        if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        } else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
            primaryStage.setX(event.getScreenX() - xOffset);
            if(event.getScreenY() - yOffset < 0) {
                primaryStage.setY(0);
            }else {
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        }
    }

    public void enableDrag(Node node) {
        node.setOnMousePressed(this);
        node.setOnMouseDragged(this);
    }
}
