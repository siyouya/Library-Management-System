package cc.southseast.view.ui.base;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * @Author: Southseast
 * @Date: 2019/1/3 11:18 PM
 * @Version 1.0
 */
public class HintPanel extends HBox {

    private Label hintLabel = new Label();

    public HintPanel(String hint) {

        hintLabel.setText(hint);
        hintLabel.setStyle("-fx-text-fill: white");
        this.setPadding(new Insets(0,20,20,20));
        this.getChildren().addAll(hintLabel);

    }

}
