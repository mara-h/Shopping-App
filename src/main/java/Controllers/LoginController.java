package Controllers;

import Exceptions.InvalidAdmin;
import Exceptions.InvalidUser;
import Services.UserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Objects;

public class LoginController {
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;

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
            System.out.println(e);
        }
    }

    @FXML
    public void adminLoginButton(){
        try{
            if(UserService.checkCredentials(usernameTextField.getText(), UserService.encodePassword(passwordField.getText().toString())).equals("admin")){
                //pagina admin
            }
            else{
                throw new InvalidAdmin();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
