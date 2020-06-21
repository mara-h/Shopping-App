package Controllers;

import Models.Item;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

public class ItemsControllerTest extends ApplicationTest {
    private ItemsController controller;

    @Before
    public void setUp() {
        controller = new ItemsController();
        controller.shoppingTable = new TableView<>();
        controller.itemColumn = new TableColumn<>();
        controller.priceColumn = new TableColumn<>();
    }

    @Test
    public void addToCart(){
        SelectSizeController.setSize("size");
        Item i = new Item("name",10);
        controller.shoppingTable.getSelectionModel().select(i);

        controller.addToCartButton();

        assertEquals(1, ItemsController.getCartItems().size());
    }

    @Test
    public void placeOrder(){
        ItemsController.getCartItems().add(new Item("name",10));

        controller.placeOrderButton();

        assertEquals(0,ItemsController.getCartItems().size());
    }
}
