package Controllers;

import Exceptions.InvalidAdmin;
import Exceptions.InvalidUser;
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
        try {
            if (UserService.checkCredentials(usernameTextField.getText(), passwordField.getText()).equals("customer")) {
                //pagina shop
            } else {
                throw new InvalidUser();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void adminLoginButton(){
        try{
            if(UserService.checkCredentials(usernameTextField.getText(),passwordField.getText()).equals("customer")){
                //pagina shop
            }else{
                throw new InvalidAdmin();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
