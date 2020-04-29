/**
 * Sample Skeleton for 'buyerView.fxml' Controller Class
 */

package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.User;

public class buyerController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="carPicture"
    private ImageView carPicture; // Value injected by FXMLLoader

    @FXML // fx:id="carfolioTitle"
    private Label carfolioTitle; // Value injected by FXMLLoader

    @FXML // fx:id="searchByMenu"
    private ComboBox<?> searchByMenu; // Value injected by FXMLLoader

    @FXML // fx:id="searchTermField"
    private TextField searchTermField; // Value injected by FXMLLoader

    @FXML // fx:id="advancedSearchButton"
    private Button advancedSearchButton; // Value injected by FXMLLoader

    @FXML // fx:id="searchButton"
    private Button searchButton; // Value injected by FXMLLoader

    @FXML // fx:id="accountButton"
    private Button accountButton; // Value injected by FXMLLoader

    @FXML // fx:id="portfolioButton"
    private Button portfolioButton; // Value injected by FXMLLoader

    @FXML // fx:id="messagesButton"
    private Button messagesButton; // Value injected by FXMLLoader

    @FXML // fx:id="sellCarLabel"
    private Label sellCarLabel; // Value injected by FXMLLoader

    private User activeUser;


    
    @FXML
    void beginSearchBy(ActionEvent event) {

    }

    @FXML
    void openAccount(ActionEvent event) {

    }

    @FXML
    void openAdvancedSearch(ActionEvent event) {

    }

    @FXML
    void openMessages(ActionEvent event) {

    }

    @FXML
    void openSearchContextMenu(ActionEvent event) {

    }

    @FXML
    void setSearch(ActionEvent event) {

    }

    @FXML
    void viewUserPortfolios(ActionEvent event) {

    }
    
    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert carPicture != null : "fx:id=\"carPicture\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert carfolioTitle != null : "fx:id=\"carfolioTitle\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert searchByMenu != null : "fx:id=\"searchByMenu\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert searchTermField != null : "fx:id=\"searchTermField\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert advancedSearchButton != null : "fx:id=\"advancedSearchButton\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert searchButton != null : "fx:id=\"searchButton\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert accountButton != null : "fx:id=\"accountButton\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert portfolioButton != null : "fx:id=\"portfolioButton\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert messagesButton != null : "fx:id=\"messagesButton\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert sellCarLabel != null : "fx:id=\"sellCarLabel\" was not injected: check your FXML file 'buyerView.fxml'.";

    }
}
