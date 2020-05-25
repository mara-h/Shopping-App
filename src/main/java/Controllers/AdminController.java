package Controllers;

import Models.Item;
import Services.ItemsService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AdminController {
    @FXML
    private TableView<Item> itemsTable;
    @FXML
    private TableColumn<Item,String> itemColumn;
    @FXML
    private TableColumn<Item,Integer> priceColumn;

    @FXML
    public void initialize(){
        itemsTable.setItems(FXCollections.observableArrayList(ItemsService.getItems()));
        itemColumn.setCellValueFactory(new PropertyValueFactory<Item,String>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Item,Integer>("price"));
    }

    @FXML
    public void backButton(){
        try{
            Stage primaryStage = (Stage)itemsTable.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Login.fxml"));
            primaryStage.setTitle("Login");
            primaryStage.setScene(new Scene(root,600,600));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
