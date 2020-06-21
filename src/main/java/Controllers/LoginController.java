package Controllers;

import Exceptions.InvalidAdmin;
import Exceptions.InvalidUser;
import Services.UserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Objects;

public class LoginController {
    @FXML
    TextField usernameTextField;
    @FXML
    PasswordField passwordField;
    @FXML
    Label label;

    @FXML
    public void initialize(){
        label.setText("");
    }

    @FXML
    public void userLoginButton(){
        try {
            if (UserService.checkCredentials(usernameTextField.getText(), UserService.encodePassword(passwordField.getText())).equals("customer")) {
                Stage primaryStage = (Stage)usernameTextField.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Items.fxml"));
                primaryStage.setTitle("Shop Page");
                primaryStage.setScene(new Scene(root,600,600));
                primaryStage.show();
            }
            else {
                throw new InvalidUser();
            }
        }catch (Exception e){
            label.setText("Invalid user!");
        }
    }

    @FXML
    public void adminLoginButton(){
        try{
            if(UserService.checkCredentials(usernameTextField.getText(), UserService.encodePassword(passwordField.getText().toString())).equals("admin")){
                Stage primaryStage = (Stage)usernameTextField.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("StoreManagement.fxml"));
                primaryStage.setTitle("Administration Page");
                primaryStage.setScene(new Scene(root,600,600));
                primaryStage.show();
            }
            else{
                throw new InvalidAdmin();
            }
        }catch (Exception e){
            label.setText("Invalid user!");
        }
    }
}
