/**
 * Sample Skeleton for 'loginView.fxml' Controller Class
 */

package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class loginController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="forgotPasswordLink"
    private Hyperlink forgotPasswordLink; // Value injected by FXMLLoader

    @FXML // fx:id="existingUsername"
    private TextField existingUsername; // Value injected by FXMLLoader

    @FXML // fx:id="existingPassword"
    private PasswordField existingPassword; // Value injected by FXMLLoader

    @FXML // fx:id="loginButton"
    private Button loginButton; // Value injected by FXMLLoader

    @FXML // fx:id="createAccountButton"
    private Button createAccountButton; // Value injected by FXMLLoader

    @FXML // fx:id="strengthBar"
    private ProgressBar strengthBar; // Value injected by FXMLLoader

    @FXML // fx:id="accountSelector"
    private MenuButton accountSelector; // Value injected by FXMLLoader

    @FXML // fx:id="usernameField"
    private TextField usernameField; // Value injected by FXMLLoader

    @FXML // fx:id="passwordField"
    private PasswordField passwordField; // Value injected by FXMLLoader

    @FXML // fx:id="firstNameField"
    private TextField firstNameField; // Value injected by FXMLLoader

    @FXML // fx:id="lastNameField"
    private TextField lastNameField; // Value injected by FXMLLoader

    @FXML
    void createAccount(ActionEvent event) {

    }

    @FXML
    void launchForgotPassword(ActionEvent event) {

    }

    @FXML
    void login(ActionEvent event) {

    }

    @FXML
    void setAccountType(ActionEvent event) {

    }

    @FXML
    void setFirstName(ActionEvent event) {

    }

    @FXML
    void setLastName(ActionEvent event) {

    }

    @FXML
    void setLoginPassword(ActionEvent event) {

    }

    @FXML
    void setLoginUsername(ActionEvent event) {

    }

    @FXML
    void setPassword(ActionEvent event) {

    }

    @FXML
    void setUserName(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert forgotPasswordLink != null : "fx:id=\"forgotPasswordLink\" was not injected: check your FXML file 'loginView.fxml'.";
        assert existingUsername != null : "fx:id=\"existingUsername\" was not injected: check your FXML file 'loginView.fxml'.";
        assert existingPassword != null : "fx:id=\"existingPassword\" was not injected: check your FXML file 'loginView.fxml'.";
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'loginView.fxml'.";
        assert createAccountButton != null : "fx:id=\"createAccountButton\" was not injected: check your FXML file 'loginView.fxml'.";
        assert strengthBar != null : "fx:id=\"strengthBar\" was not injected: check your FXML file 'loginView.fxml'.";
        assert accountSelector != null : "fx:id=\"accountSelector\" was not injected: check your FXML file 'loginView.fxml'.";
        assert usernameField != null : "fx:id=\"usernameField\" was not injected: check your FXML file 'loginView.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'loginView.fxml'.";
        assert firstNameField != null : "fx:id=\"firstNameField\" was not injected: check your FXML file 'loginView.fxml'.";
        assert lastNameField != null : "fx:id=\"lastNameField\" was not injected: check your FXML file 'loginView.fxml'.";

    }
}
