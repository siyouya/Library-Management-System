package cc.southseast.controller.change;

import cc.southseast.view.ui.manage.admin.AdminManagePanel;
import cc.southseast.view.ui.manage.admin.book.BookManagePanel;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

//import cc.southseast.view.ui.manage.ChoosePanel;

public class ToBookManagePanel implements EventHandler<MouseEvent> {

    private AdminManagePanel adminManagePanel;

    private BookManagePanel bookManagePanel = new BookManagePanel();

    public ToBookManagePanel(AdminManagePanel adminManagePanel){

        this.adminManagePanel = adminManagePanel;
    }

    @Override
    public void handle(MouseEvent event) {

        adminManagePanel.getBookManageButton().setStyle("-fx-background-color: #2f3136");
        adminManagePanel.getUserManageButton().setStyle("-fx-background-color: TRANSPARENT");
        adminManagePanel.getPublishManageButton().setStyle("-fx-background-color: TRANSPARENT");
        adminManagePanel.getBorrowManageButton().setStyle("-fx-background-color: TRANSPARENT");
        adminManagePanel.getManageMain().getChildren().clear();
        adminManagePanel.getManageMain().getChildren().addAll(bookManagePanel);


//        for (int i = 0; i < 4; i++)
//            choosePanel.getChildren().get(i).setStyle("-fx-background-color: TRANSPARENT");
//        choosePanel.getChildren().get(1).setStyle("-fx-background-color: #aaaaaa");

//        UserManagePanel userManagePanel = new UserManagePanel();
//        manageMain.getChildren().clear();
//        manageMain.getChildren().addAll(userManagePanel);

    }
}
