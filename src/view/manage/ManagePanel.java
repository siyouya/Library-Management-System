package view.manage;

import javafx.scene.layout.HBox;

public class ManagePanel extends HBox {

    private ChoosePanel choosePanel = new ChoosePanel();

    private HBox manageMain = new HBox();

    public ManagePanel() {

        // 引入样式文件
        this.getStylesheets().add("view/resources/css/ManagePanel.css");

        this.setId("ManagePanel");

        manageMain.setMinSize(924,768);

        this.getChildren().addAll(choosePanel,manageMain);


    }

}
