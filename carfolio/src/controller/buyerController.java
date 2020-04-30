/**
 * Sample Skeleton for 'buyerView.fxml' Controller Class
 */

package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
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

    @FXML // fx:id="searchByMenu"
    private MenuButton searchByMenu; // Value injected by FXMLLoader

    @FXML // fx:id="searchMake"
    private MenuItem searchMake; // Value injected by FXMLLoader

    @FXML // fx:id="searchModel"
    private MenuItem searchModel; // Value injected by FXMLLoader

    @FXML // fx:id="searchMileage"
    private MenuItem searchMileage; // Value injected by FXMLLoader

    @FXML // fx:id="searchStyle"
    private MenuItem searchStyle; // Value injected by FXMLLoader

    @FXML // fx:id="searchYear"
    private MenuItem searchYear; // Value injected by FXMLLoader
    
    @FXML // fx:id="greetingName"
    private Label greetingName; // Value injected by FXMLLoader
    
    private User activeUser;

    @FXML
    void beginSearchBy(ActionEvent event) throws IOException {
        // Load advanced search and pass in search term
        FXMLLoader searchLoader = new FXMLLoader(getClass().getResource("/view/searchView.fxml"));
        Parent search = searchLoader.load();
        Scene searchUI = new Scene(search);
        searchController sController = searchLoader.getController();
        sController.setActiveUser(activeUser);
        Stage searchWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        searchWindow.setScene(searchUI);
        searchWindow.show();
        
    }

    @FXML
    void openAccount(ActionEvent event) throws IOException {
        //opens in new window
        FXMLLoader accountLoader = new FXMLLoader(getClass().getResource("/view/accountView.fxml"));
        Parent account = accountLoader.load();
        Scene accountUI = new Scene(account);
        accountController aController = accountLoader.getController();
        Stage stage = new Stage();
        stage.setScene(accountUI);
        stage.show();
    }

    @FXML 
    void openAdvancedSearch(ActionEvent event) throws IOException {
        //opens in new window
        FXMLLoader searchLoader = new FXMLLoader(getClass().getResource("/view/searchView.fxml"));
        Parent search = searchLoader.load();
        Scene searchUI = new Scene(search);
        searchController sController = searchLoader.getController();
        sController.setActiveUser(activeUser);
        Stage stage = new Stage();
        stage.setScene(searchUI);
        stage.show();
    }

    @FXML
    void openMessages(ActionEvent event) throws IOException {
        //opens in same window
        FXMLLoader messageLoader = new FXMLLoader(getClass().getResource("/view/messageView.fxml"));
        Parent message = messageLoader.load();
        Scene messageUI = new Scene(message);
        messageController mController = messageLoader.getController();
        Stage messageWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        messageWindow.setScene(messageUI);
        mController.setActiveUser(activeUser);
        mController.setPreviousScene(((Node) event.getSource()).getScene());
        messageWindow.show();
    }

    @FXML
    void setMakeSearch(ActionEvent event) {

    }

    @FXML
    void setMileageSearch(ActionEvent event) {

    }

    @FXML
    void setModelSearch(ActionEvent event) {

    }

    @FXML
    void setSearch(ActionEvent event) {

    }

    @FXML
    void setStyleSearch(ActionEvent event) {

    }

    @FXML
    void setYearSearch(ActionEvent event) {

    }

    @FXML
    void viewUserPortfolios(ActionEvent event) {

    }
    
    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }
    
    //Username appears in top right
    public void setGreeting() {
        this.greetingName.setText("Hello, " + activeUser.getUsername());
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert carPicture != null : "fx:id=\"carPicture\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert carfolioTitle != null : "fx:id=\"carfolioTitle\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert searchTermField != null : "fx:id=\"searchTermField\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert advancedSearchButton != null : "fx:id=\"advancedSearchButton\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert searchButton != null : "fx:id=\"searchButton\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert accountButton != null : "fx:id=\"accountButton\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert portfolioButton != null : "fx:id=\"portfolioButton\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert messagesButton != null : "fx:id=\"messagesButton\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert sellCarLabel != null : "fx:id=\"sellCarLabel\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert searchByMenu != null : "fx:id=\"searchByMenu\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert searchMake != null : "fx:id=\"searchMake\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert searchModel != null : "fx:id=\"searchModel\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert searchMileage != null : "fx:id=\"searchMileage\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert searchStyle != null : "fx:id=\"searchStyle\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert searchYear != null : "fx:id=\"searchYear\" was not injected: check your FXML file 'buyerView.fxml'.";

    }
}
