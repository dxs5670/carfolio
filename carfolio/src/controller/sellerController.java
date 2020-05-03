/*
    This is the sellerView controller, responsible for directing to the 
    various seller-enabled pages. This includes: Account, Messages and
    portfolios.

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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import model.Car;
import model.User;

public class sellerController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="carPicture"
    private ImageView carPicture; 

    @FXML // fx:id="carfolioTitle"
    private Label carfolioTitle; 

    @FXML // fx:id="sellCarLabel"
    private Label sellCarLabel; 

    @FXML // fx:id="initializePortfolioButton"
    private Button initializePortfolioButton; 

    @FXML // fx:id="makeField"
    private TextField makeField; 

    @FXML // fx:id="modelField"
    private TextField modelField; 

    @FXML // fx:id="vinField"
    private TextField vinField; 

    @FXML // fx:id="milageField"
    private TextField milageField; 

    @FXML // fx:id="makeLabel"
    private Label makeLabel; 

    @FXML // fx:id="modelLabel"
    private Label modelLabel; 

    @FXML // fx:id="vinLabel"
    private Label vinLabel; 

    @FXML // fx:id="mileageLabel"
    private Label mileageLabel; 

    @FXML // fx:id="accountButton"
    private Button accountButton; 

    @FXML // fx:id="portfolioButton"
    private Button portfolioButton; 

    @FXML // fx:id="messagesButton"
    private Button messagesButton; 

    @FXML // fx:id="greetingName"
    private Label greetingName; 

    @FXML // fx:id="styleField"
    private TextField styleField; 

    @FXML // fx:id="yearField"
    private TextField yearField; 
    
    @FXML
    private TextField priceField;
    
    
    // Used for finding the current user from username given by loginController    
    private EntityManager manager;
    // The logged-in user
    private User activeUser;
    // Car made form attributes
    private Car createdCar = new Car();
    
    /* Opens the accountView in the current window when accountButton is 
    clicked. Also passes the activeUser to the accountController and sets the 
    previous scene as the curent one (sellerView)*/      
    @FXML
    void openAccount(ActionEvent event) throws IOException {

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
    the previous scene as the curent one (sellerView)*/     
    @FXML
    void openMessages(ActionEvent event) throws IOException {
        
        FXMLLoader messageLoader = new FXMLLoader(getClass().getResource("/view/messageView.fxml"));
        Parent message = messageLoader.load();
        Scene messageUI = new Scene(message);
        messageController mController = messageLoader.getController();
        mController.setActiveUser(activeUser);
        mController.setPreviousScene(((Node) event.getSource()).getScene());
        Stage messageWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        messageWindow.setScene(messageUI);
        messageWindow.show();
    }
    
    /* Opens the userPortfolioView in the current window when portfolioButton 
    is clicked. Also passes the activeUser to the userPortfolioController and
    sets the previous scene as the curent one (sellerView)*/    
    @FXML
    void viewUserPortfolios(ActionEvent event) throws IOException {
        
        FXMLLoader userPortfolioLoader = new FXMLLoader(getClass().getResource("/view/userPortfolioView.fxml"));
        Parent userPortfolio = userPortfolioLoader.load();
        Scene userPortfolioUI = new Scene(userPortfolio);
        userPortfolioController upController = userPortfolioLoader.getController();
        upController.setActiveUser(activeUser);
        upController.completeTable();
        upController.setPreviousScene(((Node) event.getSource()).getScene());
        Stage userPortfolioWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        userPortfolioWindow.setScene(userPortfolioUI);
        userPortfolioWindow.show();
        
    }    
    
    // Sets the make of createdCar to the text in makeField when a key is pressed            
    @FXML
    void setMake(KeyEvent event) {
        createdCar.setMake(makeField.getText());
    }

    // Sets the model of createdCar to the text in modelField when a key is pressed    
    @FXML
    void setModel(KeyEvent event) {
        createdCar.setMake(makeField.getText());
    }
    
    // Sets the year of createdCar to the text in yearField when a key is pressed        
    @FXML
    void setYear(KeyEvent event) {
        createdCar.setYear(Short.parseShort(yearField.getText()));
    }

    // Sets the style of createdCar to the text in styleField when a key is pressed    
    @FXML
    void setStyle(KeyEvent event) {
        createdCar.setStyle(styleField.getText());
    }
    
    // Sets the vin of createdCar to the text in vinField when a key is pressed    
    @FXML
    void setVin(KeyEvent event) {
        createdCar.setVin(vinField.getText());
    }
    
    // Sets the miles of createdCar to the text in mileageField when a key is pressed    
    @FXML
    void setMileage(KeyEvent event) {
        createdCar.setMiles(Integer.parseInt(milageField.getText()));
    }
    
    // Sets the price of createdCar to the text in priceField when a key is pressed    
    @FXML
    void setPrice(KeyEvent event) {
        createdCar.setPrice(Integer.parseInt(priceField.getText()));
    }
    
    // Use EntityManager manager to send the car to the database 
    @FXML 
    void initializePortfolio(ActionEvent event) {
        // Set the sellerUsername attribute to the activeUser username 
        createdCar.setSellerUsername(activeUser.getUsername());
        
        manager.getTransaction().begin();
        manager.persist(createdCar);
        manager.getTransaction().commit();
        
        // Create an alert to notify users that the car was created
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setContentText("Your Car has been created!");
        alert.showAndWait();
        
        // Clear fields
        clearTextFields();
    }

    // Function used for clearing all fields when a car is created successfully
    public void clearTextFields() {
        modelField.setText("");
        makeField.setText("");
        styleField.setText("");
        yearField.setText("");
        vinField.setText("");
        milageField.setText("");
        priceField.setText("");
    }

    
    
    // Function used for setting the User activeUser when directed to this page    
    public void setActiveUser(User fromLogin) {
        String queryUsername = fromLogin.getUsername();
        activeUser = manager.find(User.class, queryUsername);
    }
    
    // Function used for setting the label Greeting as text specified in login
    public void setGreeting() {
        this.greetingName.setText("Hello, " + activeUser.getUsername());
    }

    
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert carPicture != null : "fx:id=\"carPicture\" was not injected: check your FXML file 'sellerView.fxml'.";
        assert carfolioTitle != null : "fx:id=\"carfolioTitle\" was not injected: check your FXML file 'sellerView.fxml'.";
        assert sellCarLabel != null : "fx:id=\"sellCarLabel\" was not injected: check your FXML file 'sellerView.fxml'.";
        assert initializePortfolioButton != null : "fx:id=\"initializePortfolioButton\" was not injected: check your FXML file 'sellerView.fxml'.";
        assert makeField != null : "fx:id=\"makeField\" was not injected: check your FXML file 'sellerView.fxml'.";
        assert modelField != null : "fx:id=\"modelField\" was not injected: check your FXML file 'sellerView.fxml'.";
        assert vinField != null : "fx:id=\"vinField\" was not injected: check your FXML file 'sellerView.fxml'.";
        assert milageField != null : "fx:id=\"milageField\" was not injected: check your FXML file 'sellerView.fxml'.";
        assert makeLabel != null : "fx:id=\"makeLabel\" was not injected: check your FXML file 'sellerView.fxml'.";
        assert modelLabel != null : "fx:id=\"modelLabel\" was not injected: check your FXML file 'sellerView.fxml'.";
        assert vinLabel != null : "fx:id=\"vinLabel\" was not injected: check your FXML file 'sellerView.fxml'.";
        assert mileageLabel != null : "fx:id=\"mileageLabel\" was not injected: check your FXML file 'sellerView.fxml'.";
        assert accountButton != null : "fx:id=\"accountButton\" was not injected: check your FXML file 'sellerView.fxml'.";
        assert portfolioButton != null : "fx:id=\"portfolioButton\" was not injected: check your FXML file 'sellerView.fxml'.";
        assert messagesButton != null : "fx:id=\"messagesButton\" was not injected: check your FXML file 'sellerView.fxml'.";
        assert greetingName != null : "fx:id=\"greetingName\" was not injected: check your FXML file 'sellerView.fxml'.";
        assert styleField != null : "fx:id=\"styleField\" was not injected: check your FXML file 'sellerView.fxml'.";
        assert yearField != null : "fx:id=\"yearField\" was not injected: check your FXML file 'sellerView.fxml'.";
        assert priceField != null : "fx:id=\"priceField\" was not injected: check your FXML file 'sellerView.fxml'.";


        manager = (EntityManager) Persistence.createEntityManagerFactory("CarfolioPU").createEntityManager();
    }
}
