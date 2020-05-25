package Controllers;

import Models.Item;
import Services.ItemsService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ItemsController {
    private ArrayList<Item> cartItems = new ArrayList<>();//un size pasiv care se seteaza la add to cart
    private String size;//un arraylist de alea selectate

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

    }

    @FXML
    public void placeOrderButton(){

    }
}
