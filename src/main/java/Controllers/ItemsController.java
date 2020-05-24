package Controllers;

import Models.Item;
import Services.ItemsService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ItemsController {
    //un size pasiv care se seteaza la add to cart
    //un arraylist de alea selectate
    @FXML
    private TableView<Item> shoppingTable;
    @FXML
    private TableColumn<Item,String> itemColumn;
    @FXML
    private TableColumn<Item,Integer> priceColumn;

    @FXML
    public void initialize(){
        ItemsService.loadItems();

        shoppingTable.setItems(FXCollections.observableArrayList(ItemsService.getItems()));
        itemColumn.setCellValueFactory(new PropertyValueFactory<Item,String>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Item,Integer>("price"));
    }

    @FXML
    public void selectSizeButton(){
    }

    @FXML
    public void addToCartButton(){

    }

    @FXML
    public void placeOrderButton(){

    }
}
