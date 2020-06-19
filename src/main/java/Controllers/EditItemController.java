package Controllers;

import Services.ItemsService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditItemController {
    @FXML
    private Label label;
    @FXML
    private TextField textField;

    @FXML
    public void initialize(){
        label.setText(String.valueOf(AdminController.getSelected().getPrice()));
    }

    @FXML
    public void backButton(){
        try{
            Stage primaryStage = (Stage)label.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("StoreManagement.fxml"));
            primaryStage.setTitle("Administration Page");
            primaryStage.setScene(new Scene(root,600,600));
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void okButton(){
        AdminController.getSelected().setPrice(Integer.parseInt(textField.getText()));
        ItemsService.writeItems();

        this.initialize();
    }
}
