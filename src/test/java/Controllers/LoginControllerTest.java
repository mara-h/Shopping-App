package Controllers;

import Services.UserService;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

public class LoginControllerTest extends ApplicationTest {
    private LoginController controller;

    @BeforeClass
    public static void setupClass(){
        UserService.loadUsers();
    }

    @Before
    public void setUp(){
        controller = new LoginController();
        controller.usernameTextField = new TextField();
        controller.passwordField = new PasswordField();
        controller.label = new Label();
    }

    @Test
    public void incorrectUser(){
        controller.usernameTextField.setText("user");
        controller.passwordField.setText("pass");

        controller.userLoginButton();

        assertEquals("Invalid user!",controller.label.getText());
    }
}
