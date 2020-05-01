/**
 * Sample Skeleton for 'portfolioView.fxml' Controller Class
 */

package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import model.Car;
import model.Message;
import model.User;

public class portfolioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane portfolioPane;

    @FXML
    private Label askingPrice;

    @FXML
    private Label model;

    @FXML
    private Label style;

    @FXML
    private Label ownerName;

    @FXML
    private Button contactOwnerButton;

    @FXML
    private Button makeOfferButton;

    @FXML
    private Label miles;

    @FXML
    private Label askingPrice1;

    @FXML
    private Label year;

    @FXML
    private Label make;
    
    @FXML
    private Label safetyRating;


    private Car selectedCar = new Car();
    private User activeUser;
    private Message createdMessage;
    private EntityManager manager;

    @FXML
    public void contactOwner(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/messageView.fxml"));
        Parent messageView = loader.load();
        Scene messageViewScene = new Scene(messageView);
        messageController controller = loader.getController();
        controller.setActiveUser(activeUser);
        controller.setMessageRecipient(selectedCar.getSellerUsername());
        Stage stage = new Stage();
        stage.setScene(messageViewScene);
        stage.show();
    }

    // Works the same as in searchController
    @FXML
    public void makeOffer(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog("0.00");
        dialog.setTitle("Make Offer");
        dialog.setHeaderText("Make Offer");
        dialog.setContentText("Please enter an amount:");
        
        Optional<String> result = dialog.showAndWait();
        String amount = "";
        if (result.isPresent()){
            try {
                Double.parseDouble(result.get());
                amount = result.get();
                
                this.createdMessage = new Message();
                createdMessage.setRecipient(selectedCar.getSellerUsername());
                createdMessage.setSender(activeUser.getUsername());
                createdMessage.setMessageBody(activeUser.getUsername() + " has submitted an offer to buy your " + selectedCar.getMake() + ", VIN " + selectedCar.getVin() + ", for: " + "$" + amount);
                Date dt = new Date(System.currentTimeMillis());
                createdMessage.setTimeSent(dt);

                List<Message> data  = manager.createNamedQuery("Message.findAll").getResultList();
                int last_id = data.size();
                createdMessage.setMessageID((last_id + 1) + "");

                manager.getTransaction().begin();
                manager.persist(createdMessage);
                manager.getTransaction().commit();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Offer submitted successfully!");
                alert.showAndWait();
            }
            catch(NumberFormatException x){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("Please enter a valid numeric dollar amount.");
                alert.showAndWait();
             }
        }   
    }
    
    public void setMake(Car car) {
        make.setText(selectedCar.getMake());
    }
    
    public void setModel(Car car) {
        model.setText(selectedCar.getModel());
    }
    
    public void setMiles(Car car) {
        miles.setText(Integer.toString(selectedCar.getMiles()));
    }
    
    public void setPrice(Car car) {
        //askingPrice.setText(selectedCar.getPrice());
    }

    public void setCar(Car setCar) {
        selectedCar = setCar;
        setAttributes();
    }
    
    // Set all portfolio data of the selected car
    public void setAttributes() {
        
        make.setText(selectedCar.getMake());
        miles.setText(Integer.toString(selectedCar.getMiles()));
        model.setText(selectedCar.getModel());
        style.setText(selectedCar.getStyle());
        askingPrice.setText(Integer.toString(selectedCar.getPrice()));
        ownerName.setText(selectedCar.getSellerUsername());
        safetyRating.setText(Integer.toString(selectedCar.getSafteyRating()));
        
        
    }
    
    public void setActiveUser(User usr) {
        this.activeUser = usr;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert portfolioPane != null : "fx:id=\"portfolioPane\" was not injected: check your FXML file 'portfolioView.fxml'.";
        assert askingPrice != null : "fx:id=\"askingPrice\" was not injected: check your FXML file 'portfolioView.fxml'.";
        assert model != null : "fx:id=\"model\" was not injected: check your FXML file 'portfolioView.fxml'.";
        assert style != null : "fx:id=\"style\" was not injected: check your FXML file 'portfolioView.fxml'.";
        assert ownerName != null : "fx:id=\"ownerName\" was not injected: check your FXML file 'portfolioView.fxml'.";
        assert contactOwnerButton != null : "fx:id=\"contactOwnerButton\" was not injected: check your FXML file 'portfolioView.fxml'.";
        assert makeOfferButton != null : "fx:id=\"makeOfferButton\" was not injected: check your FXML file 'portfolioView.fxml'.";
        assert miles != null : "fx:id=\"miles\" was not injected: check your FXML file 'portfolioView.fxml'.";
        assert askingPrice1 != null : "fx:id=\"askingPrice1\" was not injected: check your FXML file 'portfolioView.fxml'.";
        assert year != null : "fx:id=\"year\" was not injected: check your FXML file 'portfolioView.fxml'.";
        assert make != null : "fx:id=\"make\" was not injected: check your FXML file 'portfolioView.fxml'.";
        assert safetyRating != null : "fx:id=\"safetyRating\" was not injected: check your FXML file 'portfolioView.fxml'.";

        //Database connection, named in persistence.xml
        manager = (EntityManager) Persistence.createEntityManagerFactory("CarfolioPU").createEntityManager();
    }
}

