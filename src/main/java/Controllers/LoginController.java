package Controllers;

import Services.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;

    @FXML
    public void userLoginButton(){
        if(UserService.checkCredentials(usernameTextField.getText(),passwordField.getText()).equals("customer")){
            //pagina shop
        }else{
            //invalid user
        }
    }

    @FXML
    public void adminLoginButton(){
        if(UserService.checkCredentials(usernameTextField.getText(),passwordField.getText()).equals("customer")){
            //pagina shop
        }else{
            //invalid admin
        }
    }
}
