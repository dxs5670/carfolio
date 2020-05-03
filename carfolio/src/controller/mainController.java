/*
    The mainController class is a "administrator only" controller. While the
    same functionality is not available to the actual users of the application, 
    it has been pivotal in designing and testing as many of the functions 
    were able to be tested and created here before being passed onto the 
    buyerController and sellerController

    The only funcitonality unique to mainController is the scraper, which is
    currently unfinished.
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
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import model.Car;
import model.User;

public class mainController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="carPicture"
    private ImageView carPicture;

    @FXML // fx:id="accountButton"
    private Button accountButton;

    @FXML // fx:id="portfolioButton"
    private Button portfolioButton;

    @FXML // fx:id="messagesButton"
    private Button messagesButton;

    @FXML // fx:id="horizontalSeparator"
    private Separator horizontalSeparator;

    @FXML // fx:id="searchCarLabel"
    private Label searchCarLabel;

    @FXML // fx:id="sellCarLabel"
    private Label sellCarLabel;

    @FXML // fx:id="vSeparator"
    private Separator vSeparator;

    @FXML // fx:id="searchTermField"
    private TextField searchTermField;

    @FXML // fx:id="initializePortfolioButton"
    private Button initializePortfolioButton;

    @FXML // fx:id="advancedSearchButton"
    private Button advancedSearchButton;

    @FXML // fx:id="launchScraperButton"
    private Button launchScraperButton;

    @FXML // fx:id="searchButton"
    private Button searchButton;

    @FXML // fx:id="makeField"
    private TextField makeField;

    @FXML // fx:id="modelField"
    private TextField modelField;

    @FXML // fx:id="vinField"
    private TextField vinField;

    @FXML // fx:id="milageField"
    private TextField mileageField;

    @FXML // fx:id="makeLabel"
    private Label makeLabel;

    @FXML // fx:id="modelLabel"
    private Label modelLabel;

    @FXML // fx:id="vinLabel"
    private Label vinLabel;

    @FXML // fx:id="mileageLabel"
    private Label mileageLabel;

    @FXML // fx:id="carfolioTitle"
    private Label carfolioTitle;

    @FXML // fx:id="greeting"
    private Label greeting;

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

    
    // Used for finding the current user from username given by loginController
    private EntityManager em;
    // The logged-in user
    private User activeUser;
    // Car made form attributes in the "Sell a Car" section
    private Car sellCar;
    
    
    /* Opens the scraperView in package view in a new window when the 
       launchScraperButton is clicked */
    @FXML
    void openScraper(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/scraperView.fxml"));
        Parent scraperView = loader.load();
        Scene scraperViewScene = new Scene(scraperView);        
        Stage stage = new Stage();
        stage.setScene(scraperViewScene);
        stage.show();
    }    

    /* Opens the accountView in the current window when accountButton is 
    clicked. Also passes the activeUser to the accountController and sets the 
    previous scene as the curent one (mainView)*/     
    @FXML
    void openAccount(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/accountView.fxml"));
        Parent accountView = loader.load();
        Scene accountViewScene = new Scene(accountView);
        accountController aController = loader.getController();
        aController.setActiveUser(activeUser);
        aController.setPreviousScene(((Node) event.getSource()).getScene());
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(accountViewScene);
        window.show();
    }
    
    /* Opens the messageView in the current window when messagesButton is 
    clicked. Also passes the activeUser to the messageController and sets 
    the previous scene as the curent one (mainView)*/    
    @FXML
    void openMessages(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/messageView.fxml"));
        Parent messageView = loader.load();
        Scene messageViewScene = new Scene(messageView);
        messageController mController = loader.getController();
        mController.setActiveUser(activeUser);
        mController.setPreviousScene(((Node) event.getSource()).getScene());
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(messageViewScene);
        window.show();
    }    
    
    /* Opens the userPortfolioView in the current window when portfolioButton 
    is clicked. Also passes the activeUser to the userPortfolioController and
    sets the previous scene as the curent one (mainView)*/
    @FXML
    void openPortfolios(ActionEvent event) throws IOException {
        FXMLLoader userPortfolioLoader = new FXMLLoader(getClass().getResource("/view/userPortfolioView.fxml"));
        Parent userPortfolio = userPortfolioLoader.load();
        Scene userPortfolioUI = new Scene(userPortfolio);
        userPortfolioController upController = userPortfolioLoader.getController();
        upController.setActiveUser(activeUser);
        upController.setPreviousScene(((Node) event.getSource()).getScene());
        Stage userPortfolioWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        userPortfolioWindow.setScene(userPortfolioUI);
        userPortfolioWindow.show();
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
    previous scene as the curent one (mainView)*/ 
    @FXML
    void openAdvancedSearch(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/searchView.fxml"));
        Parent searchView = loader.load();
        Scene searchViewScene = new Scene(searchView);
        searchController sController = loader.getController();
        sController.setActiveUser(activeUser);
        sController.setPreviousScene(((Node) event.getSource()).getScene());
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(searchViewScene);
        window.show();

    }
    
    // TODO: Add search function
    @FXML
    void beginSearch(ActionEvent event) {

    }

    // TODO: Create portfolio function
    @FXML
    void initializePortfolio(ActionEvent event) {
        
    }
    
    // Sets the make of sellCar to the text in makeField when a key is pressed            
    @FXML
    void setMake(KeyEvent event) {
        sellCar.setMake(makeField.getText());
    }
    
    // Sets the model of sellCar to the text in modelField when a key is pressed    
    @FXML
    void setModel(KeyEvent event) {
        sellCar.setMake(makeField.getText());
    }

    // Sets the vin of sellCar to the text in vinField when a key is pressed
    @FXML
    void setVin(KeyEvent event) {
        sellCar.setVin(vinField.getText());
    }
    
    // Sets the miles of sellCar to the text in mileageField when a key is pressed    
    @FXML
    void setMileage(KeyEvent event) {
        sellCar.setMiles(Integer.valueOf(mileageField.getText()));
    }



    // Function used for setting the User activeUser when directed to this page
    public void setActiveUser(User fromLogin) {
        //activeUser = fromLogin;
        String queryUsername = fromLogin.getUsername();
        activeUser = em.find(User.class, queryUsername);
    }    
    
    // Function used for setting the label Greeting as text specified in login
    public void setGreeting(String greet) {
        this.greeting.setText(greet);
    }
    

    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert carPicture != null : "fx:id=\"carPicture\" was not injected: check your FXML file 'mainView.fxml'.";
        assert accountButton != null : "fx:id=\"accountButton\" was not injected: check your FXML file 'mainView.fxml'.";
        assert portfolioButton != null : "fx:id=\"portfolioButton\" was not injected: check your FXML file 'mainView.fxml'.";
        assert messagesButton != null : "fx:id=\"messagesButton\" was not injected: check your FXML file 'mainView.fxml'.";
        assert horizontalSeparator != null : "fx:id=\"horizontalSeparator\" was not injected: check your FXML file 'mainView.fxml'.";
        assert searchCarLabel != null : "fx:id=\"searchCarLabel\" was not injected: check your FXML file 'mainView.fxml'.";
        assert sellCarLabel != null : "fx:id=\"sellCarLabel\" was not injected: check your FXML file 'mainView.fxml'.";
        assert vSeparator != null : "fx:id=\"vSeparator\" was not injected: check your FXML file 'mainView.fxml'.";
        assert searchTermField != null : "fx:id=\"searchTermField\" was not injected: check your FXML file 'mainView.fxml'.";
        assert initializePortfolioButton != null : "fx:id=\"initializePortfolioButton\" was not injected: check your FXML file 'mainView.fxml'.";
        assert advancedSearchButton != null : "fx:id=\"advancedSearchButton\" was not injected: check your FXML file 'mainView.fxml'.";
        assert launchScraperButton != null : "fx:id=\"launchScraperButton\" was not injected: check your FXML file 'mainView.fxml'.";
        assert searchButton != null : "fx:id=\"searchButton\" was not injected: check your FXML file 'mainView.fxml'.";
        assert makeField != null : "fx:id=\"makeField\" was not injected: check your FXML file 'mainView.fxml'.";
        assert modelField != null : "fx:id=\"modelField\" was not injected: check your FXML file 'mainView.fxml'.";
        assert vinField != null : "fx:id=\"vinField\" was not injected: check your FXML file 'mainView.fxml'.";
        assert mileageField != null : "fx:id=\"milageField\" was not injected: check your FXML file 'mainView.fxml'.";
        assert makeLabel != null : "fx:id=\"makeLabel\" was not injected: check your FXML file 'mainView.fxml'.";
        assert modelLabel != null : "fx:id=\"modelLabel\" was not injected: check your FXML file 'mainView.fxml'.";
        assert vinLabel != null : "fx:id=\"vinLabel\" was not injected: check your FXML file 'mainView.fxml'.";
        assert mileageLabel != null : "fx:id=\"mileageLabel\" was not injected: check your FXML file 'mainView.fxml'.";
        assert carfolioTitle != null : "fx:id=\"carfolioTitle\" was not injected: check your FXML file 'mainView.fxml'.";
        assert greeting != null : "fx:id=\"greeting\" was not injected: check your FXML file 'mainView.fxml'.";
        assert searchByMenu != null : "fx:id=\"searchByMenu\" was not injected: check your FXML file 'mainView.fxml'.";
        assert searchMake != null : "fx:id=\"searchMake\" was not injected: check your FXML file 'mainView.fxml'.";
        assert searchModel != null : "fx:id=\"searchModel\" was not injected: check your FXML file 'mainView.fxml'.";
        assert searchMileage != null : "fx:id=\"searchMileage\" was not injected: check your FXML file 'mainView.fxml'.";
        assert searchStyle != null : "fx:id=\"searchStyle\" was not injected: check your FXML file 'mainView.fxml'.";
        assert searchYear != null : "fx:id=\"searchYear\" was not injected: check your FXML file 'mainView.fxml'.";
        
        em = (EntityManager) Persistence.createEntityManagerFactory("CarfolioPU").createEntityManager();
        
    }


}

