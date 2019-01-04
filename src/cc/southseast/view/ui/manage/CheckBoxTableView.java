package cc.southseast.view.ui.manage;

import com.jfoenix.controls.JFXCheckBox;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableCell;

public class CheckBoxTableView<S, T> extends TableCell<S, T> {
    private JFXCheckBox jfxCheckBox;
    private ObservableValue<T> ov;

    public CheckBoxTableView() {
        this.jfxCheckBox = new JFXCheckBox();
        // 添加元素
        setGraphic(jfxCheckBox);
    }

    @Override
    protected void updateItem(T item, boolean empty) {

        super.updateItem(item, empty);
        if (empty) {
            // 如果此列为空默认不添加元素
            setText(null);
            setGraphic(null);
        } else {
            // 初始化为不选中
            jfxCheckBox.setSelected(false);
            setGraphic(jfxCheckBox);
        }
    }
}
