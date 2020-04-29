/**
 * Sample Skeleton for 'accountView.fxml' Controller Class
 */

package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.SVGPath;
import model.User;

public class accountController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="firstName"
    private TextField firstName; // Value injected by FXMLLoader

    @FXML // fx:id="lastName"
    private TextField lastName; // Value injected by FXMLLoader

    @FXML // fx:id="username"
    private TextField username; // Value injected by FXMLLoader

    @FXML // fx:id="password"
    private PasswordField password; // Value injected by FXMLLoader

    @FXML // fx:id="confirmPassword"
    private PasswordField confirmPassword; // Value injected by FXMLLoader

    @FXML // fx:id="updateAccount"
    private Button updateAccount; // Value injected by FXMLLoader

    @FXML // fx:id="signOutButton"
    private Button signOutButton; // Value injected by FXMLLoader

    @FXML // fx:id="deleteAccountButton"
    private Button deleteAccountButton; // Value injected by FXMLLoader

    @FXML // fx:id="star1"
    private SVGPath star1; // Value injected by FXMLLoader

    @FXML // fx:id="star2"
    private SVGPath star2; // Value injected by FXMLLoader

    @FXML // fx:id="star3"
    private SVGPath star3; // Value injected by FXMLLoader

    @FXML // fx:id="star4"
    private SVGPath star4; // Value injected by FXMLLoader

    @FXML // fx:id="star5"
    private SVGPath star5; // Value injected by FXMLLoader

    @FXML // fx:id="accountType"
    private Label accountType; // Value injected by FXMLLoader
    
    private User activeUser;

    @FXML
    void deleteAccount(ActionEvent event) {

    }

    @FXML
    void setConfirmPassword(KeyEvent event) {

    }

    @FXML
    void setFirst(KeyEvent event) {

    }

    @FXML
    void setLast(KeyEvent event) {

    }

    @FXML
    void setPassword(KeyEvent event) {

    }

    @FXML
    void setUsername(KeyEvent event) {

    }

    @FXML
    void signOut(ActionEvent event) {

    }

    @FXML
    void updateUser(ActionEvent event) {

    }
    
    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert firstName != null : "fx:id=\"firstName\" was not injected: check your FXML file 'accountView.fxml'.";
        assert lastName != null : "fx:id=\"lastName\" was not injected: check your FXML file 'accountView.fxml'.";
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'accountView.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'accountView.fxml'.";
        assert confirmPassword != null : "fx:id=\"confirmPassword\" was not injected: check your FXML file 'accountView.fxml'.";
        assert updateAccount != null : "fx:id=\"updateAccount\" was not injected: check your FXML file 'accountView.fxml'.";
        assert signOutButton != null : "fx:id=\"signOutButton\" was not injected: check your FXML file 'accountView.fxml'.";
        assert deleteAccountButton != null : "fx:id=\"deleteAccountButton\" was not injected: check your FXML file 'accountView.fxml'.";
        assert star1 != null : "fx:id=\"star1\" was not injected: check your FXML file 'accountView.fxml'.";
        assert star2 != null : "fx:id=\"star2\" was not injected: check your FXML file 'accountView.fxml'.";
        assert star3 != null : "fx:id=\"star3\" was not injected: check your FXML file 'accountView.fxml'.";
        assert star4 != null : "fx:id=\"star4\" was not injected: check your FXML file 'accountView.fxml'.";
        assert star5 != null : "fx:id=\"star5\" was not injected: check your FXML file 'accountView.fxml'.";
        assert accountType != null : "fx:id=\"accountType\" was not injected: check your FXML file 'accountView.fxml'.";

    }
}
