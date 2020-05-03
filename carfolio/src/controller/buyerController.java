/*
    This is the buyerView controller, responsible for directing to the 
    various buyer-eneabled pages. This includes: Account, Messages and Search.

    It serves as a communication layer between other views and controllers.

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
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import model.User;

public class buyerController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="carPicture"
    private ImageView carPicture;

    @FXML // fx:id="carfolioTitle"
    private Label carfolioTitle;

    @FXML // fx:id="searchTermField"
    private TextField searchTermField;

    @FXML // fx:id="advancedSearchButton"
    private Button advancedSearchButton;

    @FXML // fx:id="searchButton"
    private Button searchButton;

    @FXML // fx:id="accountButton"
    private Button accountButton;

    @FXML // fx:id="messagesButton"
    private Button messagesButton;

    @FXML // fx:id="sellCarLabel"
    private Label sellCarLabel;

    @FXML // fx:id="searchByMenu"
    private MenuButton searchByMenu;

    @FXML // fx:id="searchMake"
    private MenuItem searchMake;

    @FXML // fx:id="searchModel"
    private MenuItem searchModel;

    @FXML // fx:id="searchMileage"
    private MenuItem searchMileage;

    @FXML // fx:id="searchStyle"
    private MenuItem searchStyle;

    @FXML // fx:id="searchYear"
    private MenuItem searchYear;
    
    @FXML // fx:id="greetingName"
    private Label greetingName;
    
    
    // Used for finding the current user from username given by loginController
    private EntityManager em;
    // The logged-in user
    private User activeUser;

    
    /* Opens the accountView in the current window when accountButton is 
    clicked. Also passes the activeUser to the accountController and sets the 
    previous scene as the curent one (buyerView)*/        
    @FXML
    void openAccount(ActionEvent event) throws IOException {
        //opens in new window
        FXMLLoader accountLoader = new FXMLLoader(getClass().getResource("/view/accountView.fxml"));
        Parent account = accountLoader.load();
        Scene accountUI = new Scene(account);
        accountController aController = accountLoader.getController();
        aController.setActiveUser(activeUser);
        aController.setPreviousScene(((Node) event.getSource()).getScene());
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(accountUI);
        window.show();
    }    
    
    /* Opens the messageView in the current window when messagesButton is 
    clicked. Also passes the activeUser to the messageController and sets 
    the previous scene as the curent one (buyerView)*/        
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
    
    // Sets the text of searchByMenu to Make when searchMake is selected
    @FXML
    void setMakeSearch(ActionEvent event) {
        searchByMenu.setText("Make");
    }    
   
    // Sets the text of searchByMenu to Model when searchModel is selected
    @FXML
    void setModelSearch(ActionEvent event) {
        searchByMenu.setText("Model");
    }
    
    // Sets the text of searchByMenu to Mileage when searchMiles is selected
    @FXML
    void setMileageSearch(ActionEvent event) {
        searchByMenu.setText("Mileage");
    }
    
    // Sets the text of searchByMenu to style when searchStyle is selected
    @FXML
    void setStyleSearch(ActionEvent event) {
        searchByMenu.setText("Style");
    }
    
    // Sets the text of searchByMenu to Year when searchYear is selected
    @FXML
    void setYearSearch(ActionEvent event) {
        searchByMenu.setText("Year");
    }
    
    // TODO: Entering a search term
    @FXML
    void setSearch(KeyEvent event) {

    }
    
    /* Opens the searchView in the current window when advancedSearchButton is 
    clicked. Also passes the activeUser to the searchController and sets the 
    previous scene as the curent one (buyerView)*/ 
    @FXML 
    void openAdvancedSearch(ActionEvent event) throws IOException {
        //opens in new window
        FXMLLoader searchLoader = new FXMLLoader(getClass().getResource("/view/searchView.fxml"));
        Parent search = searchLoader.load();
        Scene searchUI = new Scene(search);
        searchController sController = searchLoader.getController();
        sController.setActiveUser(activeUser);
        sController.setPreviousScene(((Node) event.getSource()).getScene());
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(searchUI);
        window.show();
    }   

    // TODO: Load advanced search and pass in search term
    @FXML
    void beginSearchBy(ActionEvent event) throws IOException {
        FXMLLoader searchLoader = new FXMLLoader(getClass().getResource("/view/searchView.fxml"));
        Parent search = searchLoader.load();
        Scene searchUI = new Scene(search);
        searchController sController = searchLoader.getController();
        sController.setActiveUser(activeUser);
        sController.setPreviousScene(((Node) event.getSource()).getScene());
        Stage searchWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        searchWindow.setScene(searchUI);
        searchWindow.show();
        
    }

    
    
    public void setActiveUser(User fromLogin) {
        String queryUsername = fromLogin.getUsername();
        activeUser = em.find(User.class, queryUsername);
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
        assert messagesButton != null : "fx:id=\"messagesButton\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert sellCarLabel != null : "fx:id=\"sellCarLabel\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert searchByMenu != null : "fx:id=\"searchByMenu\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert searchMake != null : "fx:id=\"searchMake\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert searchModel != null : "fx:id=\"searchModel\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert searchMileage != null : "fx:id=\"searchMileage\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert searchStyle != null : "fx:id=\"searchStyle\" was not injected: check your FXML file 'buyerView.fxml'.";
        assert searchYear != null : "fx:id=\"searchYear\" was not injected: check your FXML file 'buyerView.fxml'.";

        em = (EntityManager) Persistence.createEntityManagerFactory("CarfolioPU").createEntityManager();
    }
}
