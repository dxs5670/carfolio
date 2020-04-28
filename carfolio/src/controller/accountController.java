/**
 * Sample Skeleton for 'accountView.fxml' Controller Class
 */

package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;

public class accountController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="scrollBar"
    private ScrollBar scrollBar; // Value injected by FXMLLoader

    @FXML // fx:id="passwordField"
    private PasswordField passwordField; // Value injected by FXMLLoader

    @FXML // fx:id="usernameField"
    private TextField usernameField; // Value injected by FXMLLoader

    @FXML // fx:id="clickSave"
    private Button clickSave; // Value injected by FXMLLoader

    @FXML // fx:id="clickBack"
    private Button clickBack; // Value injected by FXMLLoader

    @FXML // fx:id="checkDisableBox"
    private CheckBox checkDisableBox; // Value injected by FXMLLoader

    @FXML // fx:id="passwordConfirm"
    private PasswordField passwordConfirm; // Value injected by FXMLLoader

    @FXML // fx:id="regionDropdown"
    private MenuButton regionDropdown; // Value injected by FXMLLoader

    @FXML // fx:id="languageDropdown"
    private MenuButton languageDropdown; // Value injected by FXMLLoader

    @FXML
    void goBack(ActionEvent event) {

    }

    @FXML
    void saveChange(ActionEvent event) {

    }

    @FXML
    void selectionChanged(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert scrollBar != null : "fx:id=\"scrollBar\" was not injected: check your FXML file 'accountView.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'accountView.fxml'.";
        assert usernameField != null : "fx:id=\"usernameField\" was not injected: check your FXML file 'accountView.fxml'.";
        assert clickSave != null : "fx:id=\"clickSave\" was not injected: check your FXML file 'accountView.fxml'.";
        assert clickBack != null : "fx:id=\"clickBack\" was not injected: check your FXML file 'accountView.fxml'.";
        assert checkDisableBox != null : "fx:id=\"checkDisableBox\" was not injected: check your FXML file 'accountView.fxml'.";
        assert passwordConfirm != null : "fx:id=\"passwordConfirm\" was not injected: check your FXML file 'accountView.fxml'.";
        assert regionDropdown != null : "fx:id=\"regionDropdown\" was not injected: check your FXML file 'accountView.fxml'.";
        assert languageDropdown != null : "fx:id=\"languageDropdown\" was not injected: check your FXML file 'accountView.fxml'.";

    }
}
