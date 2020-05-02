package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

//    @FXML // fx:id="carBestOffer"
//    // How to grab from message and display in the same table?
//    private TableColumn<?, ?> carBestOffer; // Value injected by FXMLLoader
    
    @FXML
    private Button backButton;

    private User activeUser;
    private EntityManager manager;
    
    

    @FXML
    void toPrevious(ActionEvent event) {

    }
    
    public void setActiveUser(User user) {
        String queryUsername = user.getUsername();
        activeUser = manager.find(User.class, queryUsername);
    }
    
    public void completeTable() {
        Query query = manager.createNamedQuery("Car.findBySellerUsername");
        System.out.println(activeUser.getUsername());
        query.setParameter("sellerUsername", activeUser.getUsername());
        
        List<Car> data = query.getResultList();
        ObservableList<Car> odata = FXCollections.observableArrayList();
        for (Car c: data)
        {
            odata.add(c);
        }

        carYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        carMake.setCellValueFactory(new PropertyValueFactory<>("make"));
        carModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        carStyle.setCellValueFactory(new PropertyValueFactory<>("style"));
        carSafety.setCellValueFactory(new PropertyValueFactory<>("safetyRating"));
        carMiles.setCellValueFactory(new PropertyValueFactory<>("miles"));
        carListPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        carTable.setItems(odata);
        
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
//        assert carBestOffer != null : "fx:id=\"carBestOffer\" was not injected: check your FXML file 'userPortfolioView.fxml'.";

        manager = (EntityManager) Persistence.createEntityManagerFactory("CarfolioPU").createEntityManager();
        
    }
}
