package controller;

/**
 * Sample Skeleton for 'mainView.fxml' Controller Class
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import model.Car;
import model.User;

public class mainController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="carPicture"
    private ImageView carPicture; // Value injected by FXMLLoader

    @FXML // fx:id="accountButton"
    private Button accountButton; // Value injected by FXMLLoader

    @FXML // fx:id="portfolioButton"
    private Button portfolioButton; // Value injected by FXMLLoader

    @FXML // fx:id="messagesButton"
    private Button messagesButton; // Value injected by FXMLLoader

    @FXML // fx:id="horizontalSeparator"
    private Separator horizontalSeparator; // Value injected by FXMLLoader

    @FXML // fx:id="searchCarLabel"
    private Label searchCarLabel; // Value injected by FXMLLoader

    @FXML // fx:id="sellCarLabel"
    private Label sellCarLabel; // Value injected by FXMLLoader

    @FXML // fx:id="vSeparator"
    private Separator vSeparator; // Value injected by FXMLLoader

    @FXML // fx:id="searchTermField"
    private TextField searchTermField; // Value injected by FXMLLoader

    @FXML // fx:id="initializePortfolioButton"
    private Button initializePortfolioButton; // Value injected by FXMLLoader

    @FXML // fx:id="advancedSearchButton"
    private Button advancedSearchButton; // Value injected by FXMLLoader

    @FXML // fx:id="launchScraperButton"
    private Button launchScraperButton; // Value injected by FXMLLoader

    @FXML // fx:id="searchButton"
    private Button searchButton; // Value injected by FXMLLoader

    @FXML // fx:id="makeField"
    private TextField makeField; // Value injected by FXMLLoader

    @FXML // fx:id="modelField"
    private TextField modelField; // Value injected by FXMLLoader

    @FXML // fx:id="vinField"
    private TextField vinField; // Value injected by FXMLLoader

    @FXML // fx:id="milageField"
    private TextField mileageField; // Value injected by FXMLLoader

    @FXML // fx:id="makeLabel"
    private Label makeLabel; // Value injected by FXMLLoader

    @FXML // fx:id="modelLabel"
    private Label modelLabel; // Value injected by FXMLLoader

    @FXML // fx:id="vinLabel"
    private Label vinLabel; // Value injected by FXMLLoader

    @FXML // fx:id="mileageLabel"
    private Label mileageLabel; // Value injected by FXMLLoader

    @FXML // fx:id="carfolioTitle"
    private Label carfolioTitle; // Value injected by FXMLLoader

    @FXML // fx:id="greeting"
    private Label greeting; // Value injected by FXMLLoader

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

    private User loggedUser;
    private Car sellCar;
    

    @FXML
    void beginSearch(ActionEvent event) {

    }

    @FXML
    void initializePortfolio(ActionEvent event) {
        
    }

    @FXML
    void openAccount(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/accountView.fxml"));
        Parent accountView = loader.load();
        Scene accountViewScene = new Scene(accountView);
        accountController controller = loader.getController();
        Stage stage = new Stage();
        stage.setScene(accountViewScene);
        stage.show();
    }

    @FXML
    void openAdvancedSearch(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/searchView.fxml"));
        Parent searchView = loader.load();
        Scene searchViewScene = new Scene(searchView);
        searchController controller = loader.getController();
        Stage stage = new Stage();
        stage.setScene(searchViewScene);
        stage.show();

    }

    @FXML
    void openMessages(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/messageView.fxml"));
        Parent messageView = loader.load();
        Scene messageViewScene = new Scene(messageView);
        messageController controller = loader.getController();
        
        Stage stage = new Stage();
        stage.setScene(messageViewScene);
        stage.show();
    }

    @FXML
    void openPortfolios(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/userPortfolioView.fxml"));
        Parent userPortfolioView = loader.load();
        Scene userPortfolioViewScene = new Scene(userPortfolioView);
        portfolioController controller = loader.getController();
        
        Stage stage = new Stage();
        stage.setScene(userPortfolioViewScene);
        stage.show();
    }

    @FXML
    void openScraper(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/scraperView.fxml"));
        Parent scraperView = loader.load();
        Scene scraperViewScene = new Scene(scraperView);
        scraperController controller = loader.getController();
        
        Stage stage = new Stage();
        stage.setScene(scraperViewScene);
        stage.show();
    }

    @FXML
    void setMake(KeyEvent event) {
        sellCar.setMake(makeField.getText());
    }

    @FXML
    void setMakeSearch(ActionEvent event) {
        searchByMenu.setText("Make");
    }

    @FXML
    void setMileage(KeyEvent event) {
        sellCar.setMiles(Integer.valueOf(mileageField.getText()));
    }

    @FXML
    void setMileageSearch(ActionEvent event) {
        searchByMenu.setText("Mileage");
    }

    @FXML
    void setModel(KeyEvent event) {
        sellCar.setMake(makeField.getText());
    }

    @FXML
    void setModelSearch(ActionEvent event) {
        searchByMenu.setText("Model");
    }

    @FXML
    void setSearch(KeyEvent event) {

    }

    @FXML
    void setStyleSearch(ActionEvent event) {
        searchByMenu.setText("Style");
    }

    @FXML
    void setVin(KeyEvent event) {
        sellCar.setVin(vinField.getText());
    }

    @FXML
    void setYearSearch(ActionEvent event) {
        searchByMenu.setText("Year");
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }
    
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
        
        
        
    }


}

