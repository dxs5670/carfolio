package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import model.User;

public class userPortfolioController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="carYear"
    private TableColumn<?, ?> carYear; // Value injected by FXMLLoader

    @FXML // fx:id="carMake"
    private TableColumn<?, ?> carMake; // Value injected by FXMLLoader

    @FXML // fx:id="carModel"
    private TableColumn<?, ?> carModel; // Value injected by FXMLLoader

    @FXML // fx:id="carStyle"
    private TableColumn<?, ?> carStyle; // Value injected by FXMLLoader

    @FXML // fx:id="carSafety"
    private TableColumn<?, ?> carSafety; // Value injected by FXMLLoader

    @FXML // fx:id="carMiles"
    private TableColumn<?, ?> carMiles; // Value injected by FXMLLoader

    @FXML // fx:id="carListPrice"
    private TableColumn<?, ?> carListPrice; // Value injected by FXMLLoader

    @FXML // fx:id="carBestOffer"
    private TableColumn<?, ?> carBestOffer; // Value injected by FXMLLoader

    User activeUser;
    
    public void setActiveUser(User user) {
        activeUser = user;
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
        assert carBestOffer != null : "fx:id=\"carBestOffer\" was not injected: check your FXML file 'userPortfolioView.fxml'.";

    }
}
