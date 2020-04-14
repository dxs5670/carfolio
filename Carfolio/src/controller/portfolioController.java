/**
 * Sample Skeleton for 'portfolioView.fxml' Controller Class
 */

package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class portfolioController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="portfolioPane"
    private AnchorPane portfolioPane; // Value injected by FXMLLoader

    @FXML // fx:id="portfolioPicture"
    private Rectangle portfolioPicture; // Value injected by FXMLLoader

    @FXML // fx:id="askingPrice"
    private Label askingPrice; // Value injected by FXMLLoader

    @FXML // fx:id="make"
    private Label make; // Value injected by FXMLLoader

    @FXML // fx:id="model"
    private Label model; // Value injected by FXMLLoader

    @FXML // fx:id="style"
    private Label style; // Value injected by FXMLLoader

    @FXML // fx:id="miles"
    private Label miles; // Value injected by FXMLLoader

    @FXML // fx:id="ownerName"
    private Label ownerName; // Value injected by FXMLLoader

    @FXML // fx:id="contactOwnerButton"
    private Button contactOwnerButton; // Value injected by FXMLLoader

    @FXML // fx:id="offerHistory"
    private TableView<?> offerHistory; // Value injected by FXMLLoader

    @FXML // fx:id="carLocation"
    private Label carLocation; // Value injected by FXMLLoader

    @FXML // fx:id="portfolioDescription"
    private TextArea portfolioDescription; // Value injected by FXMLLoader

    @FXML // fx:id="maintnenceHistory"
    private TableView<?> maintnenceHistory; // Value injected by FXMLLoader

    @FXML // fx:id="recommendedPrice"
    private Label recommendedPrice; // Value injected by FXMLLoader

    @FXML // fx:id="makeOfferButton"
    private Button makeOfferButton; // Value injected by FXMLLoader

    @FXML
    void contactOwner(ActionEvent event) {

    }

    @FXML
    void makeOffer(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert portfolioPane != null : "fx:id=\"portfolioPane\" was not injected: check your FXML file 'portfolioView.fxml'.";
        assert portfolioPicture != null : "fx:id=\"portfolioPicture\" was not injected: check your FXML file 'portfolioView.fxml'.";
        assert askingPrice != null : "fx:id=\"askingPrice\" was not injected: check your FXML file 'portfolioView.fxml'.";
        assert make != null : "fx:id=\"make\" was not injected: check your FXML file 'portfolioView.fxml'.";
        assert model != null : "fx:id=\"model\" was not injected: check your FXML file 'portfolioView.fxml'.";
        assert style != null : "fx:id=\"style\" was not injected: check your FXML file 'portfolioView.fxml'.";
        assert miles != null : "fx:id=\"miles\" was not injected: check your FXML file 'portfolioView.fxml'.";
        assert ownerName != null : "fx:id=\"ownerName\" was not injected: check your FXML file 'portfolioView.fxml'.";
        assert contactOwnerButton != null : "fx:id=\"contactOwnerButton\" was not injected: check your FXML file 'portfolioView.fxml'.";
        assert offerHistory != null : "fx:id=\"offerHistory\" was not injected: check your FXML file 'portfolioView.fxml'.";
        assert carLocation != null : "fx:id=\"carLocation\" was not injected: check your FXML file 'portfolioView.fxml'.";
        assert portfolioDescription != null : "fx:id=\"portfolioDescription\" was not injected: check your FXML file 'portfolioView.fxml'.";
        assert maintnenceHistory != null : "fx:id=\"maintnenceHistory\" was not injected: check your FXML file 'portfolioView.fxml'.";
        assert recommendedPrice != null : "fx:id=\"recommendedPrice\" was not injected: check your FXML file 'portfolioView.fxml'.";
        assert makeOfferButton != null : "fx:id=\"makeOfferButton\" was not injected: check your FXML file 'portfolioView.fxml'.";

    }
}

