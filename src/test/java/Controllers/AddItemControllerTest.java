package Controllers;

import Services.ItemsService;
import javafx.scene.control.TextField;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

public class AddItemControllerTest extends ApplicationTest {
    private AddItemController controller;

    @BeforeClass
    public static void setupClass(){
        ItemsService.setPath("src/test/resources/shoppingItems.json");
    }

    @Before
    public void setUp(){
        controller = new AddItemController();
        controller.itemTextField = new TextField();
        controller.priceTextField = new TextField();
    }

    @Test
    public void addItem(){
        controller.priceTextField.setText("10");
        controller.itemTextField.setText("item");

        controller.addButton();

        assertEquals(1,ItemsService.getItems().size());
    }

    @After
    public void clean(){
        ItemsService.getItems().clear();
        ItemsService.writeItems();
    }
}
