package cc.southseast.controller.change;

import cc.southseast.view.ui.manage.book.BookManagePanel;
import cc.southseast.view.ui.manage.publish.PublishManagePanel;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import cc.southseast.view.ui.manage.ManagePanel;

public class ToPublishManagePanel implements EventHandler<MouseEvent> {

    private ManagePanel managePanel;

    private PublishManagePanel publishManagePanel = new PublishManagePanel();

    public ToPublishManagePanel(ManagePanel managePanel){

        this.managePanel = managePanel;
    }

    @Override
    public void handle(MouseEvent event) {

        managePanel.getPublishManageButton().setStyle("-fx-background-color: #2f3136");
        managePanel.getBookManageButton().setStyle("-fx-background-color: TRANSPARENT");
        managePanel.getBorrowManageButton().setStyle("-fx-background-color: TRANSPARENT");
        managePanel.getUserManageButton().setStyle("-fx-background-color: TRANSPARENT");
        managePanel.getManageMain().getChildren().clear();
        managePanel.getManageMain().getChildren().addAll(publishManagePanel);

    }
}
