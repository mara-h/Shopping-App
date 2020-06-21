package Controllers;

import Models.Item;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

public class EditItemControllerTest extends ApplicationTest {
    private EditItemController controller;

    @Before
    public void setUp(){
        controller = new EditItemController();
        controller.label = new Label();
        controller.textField = new TextField();
    }

    @Test
    public void editItem(){
        Item i = new Item("name",10);
        AdminController.setSelected(i);
        controller.textField.setText("0");

        controller.okButton();

        assertEquals(0,AdminController.getSelected().getPrice());
    }
}
