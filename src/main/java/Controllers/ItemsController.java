package Controllers;

import Models.Item;
import Services.ItemsService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ItemsController {
    private ArrayList<Item> cartItems = new ArrayList<>();
    private String size;

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
        try{
            Stage primaryStage = (Stage)shoppingTable.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("SelectSize.fxml"));
            primaryStage.setTitle("Select Size");
            primaryStage.setScene(new Scene(root,600,600));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void addToCartButton(){
        size = SelectSizeController.getSize();
        cartItems.add(new Item(shoppingTable.getSelectionModel().getSelectedItem().getName(),shoppingTable.getSelectionModel().getSelectedItem().getPrice(),size));
    }

    @FXML
    public void placeOrderButton() {
        cartItems = new ArrayList<>();
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("OrderPlaced.fxml"));
            primaryStage.setTitle("Order Placed");
            primaryStage.setScene(new Scene(root,400,200));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
