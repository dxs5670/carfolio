/*
    Supports userPortfolioView, a window that allows sellers and admins to view
    cars they have added to the database. This is also where they can quickly
    see if they have an offer on any particular car. messageView is opened 
    upon clicking the "respond to offers" button.
*/

package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Car;
import model.Message;
import model.User;

public class userPortfolioController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    // Table of cars
    @FXML
    private TableView<Car> carTable;

    @FXML // fx:id="carYear"
    private TableColumn<Car, Integer> carYear; // Value injected by FXMLLoader

    @FXML // fx:id="carMake"
    private TableColumn<Car, String> carMake; // Value injected by FXMLLoader

    @FXML // fx:id="carModel"
    private TableColumn<Car, String> carModel; // Value injected by FXMLLoader

    @FXML // fx:id="carStyle"
    private TableColumn<Car, String> carStyle; // Value injected by FXMLLoader

    @FXML // fx:id="carSafety"
    private TableColumn<Car, Integer> carSafety; // Value injected by FXMLLoader

    @FXML // fx:id="carMiles"
    private TableColumn<Car, Double> carMiles; // Value injected by FXMLLoader

    @FXML // fx:id="carListPrice"
    private TableColumn<Car, Integer> carListPrice; // Value injected by FXMLLoader

    // Table of offers
    @FXML
    private TableView<Message> offerTable;
    
    @FXML
    private TableColumn<Message, String> carOffer;
    
    @FXML
    private Button backButton;
    
    @FXML
    private Button offerButton;
    
    private User activeUser;
    private EntityManager manager;
    private Scene previousScene;
    
    // Open messaging when "Respond to Offers" is clicked
    @FXML
    void openMessages(ActionEvent event) {
        try {
            FXMLLoader messageLoader = new FXMLLoader(getClass().getResource("/view/messageView.fxml"));
            Parent message = messageLoader.load();
            Scene messageUI = new Scene(message);
            messageController mController = messageLoader.getController();
            mController.setActiveUser(activeUser);
            mController.setPreviousScene(((Node) event.getSource()).getScene());
            Stage stage = new Stage();
            stage.setScene(messageUI);
            stage.show();
            } catch (IOException ex) {
                Logger.getLogger(userPortfolioController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    // Go back to the last screen
    @FXML
    void toPrevious(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (previousScene != null){
            stage.setScene(previousScene);
        }
    }
    
    // Called from sellerController
    public void setPreviousScene(Scene scene) {
        previousScene = scene;
        backButton.setDisable(false);
    } 
    
    // Called from sellerController
    public void setActiveUser(User user) {
        String queryUsername = user.getUsername();
        activeUser = manager.find(User.class, queryUsername);
    }
    
    // Show all the cars belonging to the current seller, as well as any offers on them
    public void completeTable() {
        Query query = manager.createNamedQuery("Car.findBySellerUsername");
        query.setParameter("sellerUsername", activeUser.getUsername());
        
        // Fill Car table
        List<Car> data = query.getResultList();
        ObservableList<Car> odata = FXCollections.observableArrayList();
        for (Car c: data){
            odata.add(c);
        }

        // In order to edit these values in place, we would probably have to use something
        // other than an FX table
        carYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        carMake.setCellValueFactory(new PropertyValueFactory<>("make"));
        carModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        carStyle.setCellValueFactory(new PropertyValueFactory<>("style"));
        carSafety.setCellValueFactory(new PropertyValueFactory<>("safteyRating"));
        carMiles.setCellValueFactory(new PropertyValueFactory<>("miles"));
        carListPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        carTable.setItems(odata);
        
        // Add offers in separate table
        query = manager.createNamedQuery("Message.findByRecipient");
        query.setParameter("recipient", activeUser.getUsername());
        List<Message> data2 = query.getResultList();
        ObservableList<Message> odata2 = FXCollections.observableArrayList();
        // Get all messages addressed to this seller
        for (Message m: data2){
            odata2.add(m);
        }

        // Pull first message for each car with a matching VIN
        ObservableList<Message> odata3 = FXCollections.observableArrayList();
        Boolean match = false;
        for (Car c: odata) {
            match = false;
            for (Message m: odata2){
                if (m.getMessageBody().contains(c.getVin())) {
                    match = true;
                    String[] temp = m.getMessageBody().split("for: "); // Cut out everything except offer $amount
                    m.setMessageBody(temp[1]);
                    odata3.add(m);
                    break; // Only using 1st offer in message DB table
                } 
            }
            if (match == false) {
                odata3.add(new Message()); // Blank
            }
        }
        
        carOffer.setCellValueFactory(new PropertyValueFactory<>("messageBody"));
        offerTable.setItems(odata3);
    }
    
   
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert carYear != null : "fx:id=\"carYear\" was not injected: check your FXML file 'userPortfolioView.fxml'.";
        assert carMake != null : "fx:id=\"carMake\" was not injected: check your FXML file 'userPortfolioView.fxml'.";
        assert carModel != null : "fx:id=\"carModel\" was not injected: check your FXML file 'userPortfolioView.fxml'.";
        assert carStyle != null : "fx:id=\"carStyle\" was not injected: check your FXML file 'userPortfolioView.fxml'.";
        assert carSafety != null : "fx:id=\"carSafety\" was not injected: check your FXML file 'userPortfolioView.fxml'.";
        assert carMiles != null : "fx:id=\"carMiles\" was not injected: check your FXML file 'userPortfolioView.fxml'.";
        assert carListPrice != null : "fx:id=\"carListPrice\" was not injected: check your FXML file 'userPortfolioView.fxml'.";
        assert offerTable != null : "fx:id=\"offerTable\" was not injected: check your FXML file 'userPortfolioView.fxml'.";
        assert carOffer != null : "fx:id=\"carOffer\" was not injected: check your FXML file 'userPortfolioView.fxml'.";
        assert offerButton != null : "fx:id=\"offerButton\" was not injected: check your FXML file 'userPortfolioView.fxml'.";

        manager = (EntityManager) Persistence.createEntityManagerFactory("CarfolioPU").createEntityManager();
        
    }
}
