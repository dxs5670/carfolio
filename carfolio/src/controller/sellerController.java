/**
 * Sample Skeleton for 'sellerView.fxml' Controller Class
 */

package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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
    private ImageView carPicture; // Value injected by FXMLLoader

    @FXML // fx:id="carfolioTitle"
    private Label carfolioTitle; // Value injected by FXMLLoader

    @FXML // fx:id="sellCarLabel"
    private Label sellCarLabel; // Value injected by FXMLLoader

    @FXML // fx:id="initializePortfolioButton"
    private Button initializePortfolioButton; // Value injected by FXMLLoader

    @FXML // fx:id="makeField"
    private TextField makeField; // Value injected by FXMLLoader

    @FXML // fx:id="modelField"
    private TextField modelField; // Value injected by FXMLLoader

    @FXML // fx:id="vinField"
    private TextField vinField; // Value injected by FXMLLoader

    @FXML // fx:id="milageField"
    private TextField milageField; // Value injected by FXMLLoader

    @FXML // fx:id="makeLabel"
    private Label makeLabel; // Value injected by FXMLLoader

    @FXML // fx:id="modelLabel"
    private Label modelLabel; // Value injected by FXMLLoader

    @FXML // fx:id="vinLabel"
    private Label vinLabel; // Value injected by FXMLLoader

    @FXML // fx:id="mileageLabel"
    private Label mileageLabel; // Value injected by FXMLLoader

    @FXML // fx:id="accountButton"
    private Button accountButton; // Value injected by FXMLLoader

    @FXML // fx:id="portfolioButton"
    private Button portfolioButton; // Value injected by FXMLLoader

    @FXML // fx:id="messagesButton"
    private Button messagesButton; // Value injected by FXMLLoader

    @FXML // fx:id="greetingName"
    private Label greetingName; // Value injected by FXMLLoader

    @FXML // fx:id="styleField"
    private TextField styleField; // Value injected by FXMLLoader

    @FXML // fx:id="yearField"
    private TextField yearField; // Value injected by FXMLLoader
    
    private User activeUser;
    private Car createdCar;
    
    EntityManager manager;

    // Should this be "Create listing" instead of portfolio?
    @FXML
    void initializePortfolio(ActionEvent event) {
        this.createdCar = new Car();
        // TODO: add error checking
        createdCar.setMake(makeField.getText());
        createdCar.setModel(modelField.getText());
        createdCar.setStyle(styleField.getText());
        createdCar.setYear(Short.parseShort(yearField.getText()));
        createdCar.setVin(vinField.getText());
        createdCar.setMiles(Integer.parseInt(milageField.getText()));
        
        manager.getTransaction().begin();
        manager.persist(createdCar);
        manager.getTransaction().commit();
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setContentText("Your Car has been created!");
        alert.showAndWait();
        
        modelField.setText("");
        makeField.setText("");
        styleField.setText("");
        yearField.setText("");
        vinField.setText("");
        milageField.setText("");
    }

    @FXML
    void openAccount(ActionEvent event) {

    }

    @FXML
    void openMessages(ActionEvent event) {

    }

    @FXML
    void setMake(ActionEvent event) {

    }

    @FXML
    void setMileage(ActionEvent event) {

    }

    @FXML
    void setModel(ActionEvent event) {

    }

    @FXML
    void setStyle(ActionEvent event) {

    }

    @FXML
    void setVin(ActionEvent event) {

    }

    @FXML
    void setYear(ActionEvent event) {

    }

    @FXML
    void viewUserPortfolios(ActionEvent event) {

    }
    
    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }
    
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

        manager = (EntityManager) Persistence.createEntityManagerFactory("CarfolioPU").createEntityManager();
    }
}
