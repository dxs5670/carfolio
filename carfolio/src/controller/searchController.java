/**
 * Sample Skeleton for 'searchView.fxml' Controller Class
 */

package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Car;


public class searchController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="advancedSearchPane"
    private SplitPane advancedSearchPane; // Value injected by FXMLLoader

    @FXML // fx:id="searchPane"
    private AnchorPane searchPane; // Value injected by FXMLLoader

    @FXML // fx:id="searchButton"
    private Button searchButton; // Value injected by FXMLLoader

    @FXML // fx:id="sortByMenu"
    private MenuButton sortByMenu; // Value injected by FXMLLoader

    @FXML // fx:id="priceSortMenuItem"
    private MenuItem priceSortMenuItem; // Value injected by FXMLLoader

    @FXML // fx:id="mileageSortMenuItem"
    private MenuItem mileageSortMenuItem; // Value injected by FXMLLoader

    @FXML // fx:id="distanceSortMenuItem"
    private MenuItem distanceSortMenuItem; // Value injected by FXMLLoader

    @FXML // fx:id="bestValueSortMenuItem"
    private MenuItem bestValueSortMenuItem; // Value injected by FXMLLoader

    @FXML // fx:id="searchField"
    private TextField searchField; // Value injected by FXMLLoader

    @FXML // fx:id="searchTermLabel"
    private Label searchTermLabel; // Value injected by FXMLLoader

    @FXML // fx:id="filterTitleLabel"
    private Label filterTitleLabel; // Value injected by FXMLLoader

    @FXML // fx:id="maxPriceField"
    private TextField maxPriceField; // Value injected by FXMLLoader

    @FXML // fx:id="minPriceField"
    private TextField minPriceField; // Value injected by FXMLLoader

    @FXML // fx:id="minMilesField"
    private TextField minMilesField; // Value injected by FXMLLoader

    @FXML // fx:id="maxMilesField"
    private TextField maxMilesField; // Value injected by FXMLLoader

    @FXML // fx:id="manufacturerMenu"
    private MenuButton manufacturerMenu; // Value injected by FXMLLoader

    @FXML // fx:id="make1"
    private RadioMenuItem make1; // Value injected by FXMLLoader

    @FXML // fx:id="make2"
    private RadioMenuItem make2; // Value injected by FXMLLoader

    @FXML // fx:id="make3"
    private RadioMenuItem make3; // Value injected by FXMLLoader

    @FXML // fx:id="make4"
    private RadioMenuItem make4; // Value injected by FXMLLoader

    @FXML // fx:id="make5"
    private RadioMenuItem make5; // Value injected by FXMLLoader

    @FXML // fx:id="modelMenu"
    private MenuButton modelMenu; // Value injected by FXMLLoader

    @FXML // fx:id="model1"
    private RadioMenuItem model1; // Value injected by FXMLLoader

    @FXML // fx:id="model2"
    private RadioMenuItem model2; // Value injected by FXMLLoader

    @FXML // fx:id="model3"
    private RadioMenuItem model3; // Value injected by FXMLLoader

    @FXML // fx:id="model4"
    private RadioMenuItem model4; // Value injected by FXMLLoader

    @FXML // fx:id="model5"
    private RadioMenuItem model5; // Value injected by FXMLLoader

    @FXML // fx:id="filterPriceLabel"
    private Label filterPriceLabel; // Value injected by FXMLLoader

    @FXML // fx:id="filterMilesLabel"
    private Label filterMilesLabel; // Value injected by FXMLLoader

    @FXML // fx:id="greaterThanPrice"
    private Label greaterThanPrice; // Value injected by FXMLLoader

    @FXML // fx:id="greaterThanMiles"
    private Label greaterThanMiles; // Value injected by FXMLLoader

    @FXML // fx:id="lessThanPrice"
    private Label lessThanPrice; // Value injected by FXMLLoader

    @FXML // fx:id="lessThanMiles"
    private Label lessThanMiles; // Value injected by FXMLLoader

    @FXML // fx:id="andPrice"
    private Label andPrice; // Value injected by FXMLLoader

    @FXML // fx:id="andMiles"
    private Label andMiles; // Value injected by FXMLLoader

    @FXML // fx:id="nextPageButton"
    private Button nextPageButton; // Value injected by FXMLLoader

    @FXML // fx:id="lastButton"
    private Button lastButton; // Value injected by FXMLLoader

    @FXML // fx:id="lastButtonLabel"
    private Label lastButtonLabel; // Value injected by FXMLLoader

    @FXML // fx:id="nextButtonLabel"
    private Label nextButtonLabel; // Value injected by FXMLLoader

    @FXML // fx:id="currentPageLabel"
    private TextField currentPageLabel; // Value injected by FXMLLoader

    @FXML // fx:id="carListPane"
    private SplitPane carListPane; // Value injected by FXMLLoader

    @FXML // fx:id="car1Pane"
    private AnchorPane car1Pane; // Value injected by FXMLLoader

    @FXML // fx:id="moreDetailsButton1"
    private Button moreDetailsButton1; // Value injected by FXMLLoader

    @FXML // fx:id="moreDetailsLabel1"
    private Label moreDetailsLabel1; // Value injected by FXMLLoader

    @FXML // fx:id="pictureCar1"
    private Rectangle pictureCar1; // Value injected by FXMLLoader

    @FXML // fx:id="priceCar1"
    private Label priceCar1; // Value injected by FXMLLoader

    @FXML // fx:id="contactButton1"
    private Button contactButton1; // Value injected by FXMLLoader

    @FXML // fx:id="makeOfferButton1"
    private Button makeOfferButton1; // Value injected by FXMLLoader

    @FXML // fx:id="makeCar1"
    private Label makeCar1; // Value injected by FXMLLoader

    @FXML // fx:id="modelCar1"
    private Label modelCar1; // Value injected by FXMLLoader

    @FXML // fx:id="yearCar1"
    private Label yearCar1; // Value injected by FXMLLoader

    @FXML // fx:id="milesCar1"
    private Label milesCar1; // Value injected by FXMLLoader

    @FXML // fx:id="car2Pane"
    private AnchorPane car2Pane; // Value injected by FXMLLoader

    @FXML // fx:id="moreDetailsButton2"
    private Button moreDetailsButton2; // Value injected by FXMLLoader

    @FXML // fx:id="moreDetailsLabe2"
    private Label moreDetailsLabe2; // Value injected by FXMLLoader

    @FXML // fx:id="pictureCar2"
    private Rectangle pictureCar2; // Value injected by FXMLLoader

    @FXML // fx:id="priceCar2"
    private Label priceCar2; // Value injected by FXMLLoader

    @FXML // fx:id="contactButtonCar2"
    private Button contactButtonCar2; // Value injected by FXMLLoader

    @FXML // fx:id="makeOfferButton2"
    private Button makeOfferButton2; // Value injected by FXMLLoader

    @FXML // fx:id="makeCar2"
    private Label makeCar2; // Value injected by FXMLLoader

    @FXML // fx:id="modelCar2"
    private Label modelCar2; // Value injected by FXMLLoader

    @FXML // fx:id="yearCar2"
    private Label yearCar2; // Value injected by FXMLLoader

    @FXML // fx:id="milesCar2"
    private Label milesCar2; // Value injected by FXMLLoader

    @FXML // fx:id="car3Pane"
    private AnchorPane car3Pane; // Value injected by FXMLLoader

    @FXML // fx:id="moreDetailsButton3"
    private Button moreDetailsButton3; // Value injected by FXMLLoader

    @FXML // fx:id="moreDetailsLabel3"
    private Label moreDetailsLabel3; // Value injected by FXMLLoader

    @FXML // fx:id="pictureCar3"
    private Rectangle pictureCar3; // Value injected by FXMLLoader

    @FXML // fx:id="priceCar3"
    private Label priceCar3; // Value injected by FXMLLoader

    @FXML // fx:id="contactButtonCar3"
    private Button contactButtonCar3; // Value injected by FXMLLoader

    @FXML // fx:id="makeOfferButton3"
    private Button makeOfferButton3; // Value injected by FXMLLoader

    @FXML // fx:id="makeCar3"
    private Label makeCar3; // Value injected by FXMLLoader

    @FXML // fx:id="modelCar3"
    private Label modelCar3; // Value injected by FXMLLoader

    @FXML // fx:id="yearCar3"
    private Label yearCar3; // Value injected by FXMLLoader

    @FXML // fx:id="milesCar3"
    private Label milesCar3; // Value injected by FXMLLoader

    @FXML // fx:id="car4Pane"
    private AnchorPane car4Pane; // Value injected by FXMLLoader

    @FXML // fx:id="moreDetailsButton4"
    private Button moreDetailsButton4; // Value injected by FXMLLoader

    @FXML // fx:id="moreDetailsLabel4"
    private Label moreDetailsLabel4; // Value injected by FXMLLoader

    @FXML // fx:id="makeCar4"
    private Label makeCar4; // Value injected by FXMLLoader

    @FXML // fx:id="modelCar4"
    private Label modelCar4; // Value injected by FXMLLoader

    @FXML // fx:id="yearCar4"
    private Label yearCar4; // Value injected by FXMLLoader

    @FXML // fx:id="pictureCar4"
    private Rectangle pictureCar4; // Value injected by FXMLLoader

    @FXML // fx:id="priceCar4"
    private Label priceCar4; // Value injected by FXMLLoader

    @FXML // fx:id="contactButtonCar4"
    private Button contactButtonCar4; // Value injected by FXMLLoader

    @FXML // fx:id="makeOfferButton4"
    private Button makeOfferButton4; // Value injected by FXMLLoader

    @FXML // fx:id="milesCar4"
    private Label milesCar4; // Value injected by FXMLLoader
    
    EntityManager manager;

    @FXML
    void contactCar1Owner(ActionEvent event) {

    }

    @FXML
    void contactCar2Owner(ActionEvent event) {

    }

    @FXML
    void contactCar3Owner(ActionEvent event) {

    }

    @FXML
    void contactCar4Owner(ActionEvent event) {

    }

    @FXML
    void initializeSearch(ActionEvent event) {

    }

    @FXML
    void makeOfferCar1(ActionEvent event) {

    }

    @FXML
    void makeOfferCar2(ActionEvent event) {

    }

    @FXML
    void makeOfferCar3(ActionEvent event) {

    }

    @FXML
    void makeOfferCar4(ActionEvent event) {

    }

    @FXML
    void openCar1Portfolio(ActionEvent event) throws IOException {
        
        //Need to pass car data or id
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/portfolioView.fxml"));
        
        Parent portfolioView = loader.load();
        
        Scene portfolioViewScene = new Scene(portfolioView);
        
        portfolioController controller = loader.getController();
        
        Stage stage = new Stage();
        stage.setScene(portfolioViewScene);
        stage.show();
    }

    @FXML
    void openCar2Portfolio(ActionEvent event) {

    }

    @FXML
    void openCar3Portfolio(ActionEvent event) {

    }

    @FXML
    void openCar4Portfolio(ActionEvent event) {

    }

    @FXML
    void openSortMenu(ActionEvent event) {

    }

    @FXML
    void renderLastCars(ActionEvent event) {

    }

    @FXML
    void renderNextCars(ActionEvent event) {

    }

    @FXML
    void setCurrentPage(ActionEvent event) {

    }

    @FXML
    void setMaxMiles(ActionEvent event) {

    }

    @FXML
    void setMaxPrice(ActionEvent event) {

    }

    @FXML
    void setMinMiles(ActionEvent event) {

    }

    @FXML
    void setMinPrice(ActionEvent event) {

    }

    @FXML
    void setSearchField(ActionEvent event) {

    }

    @FXML
    void toggleBVSort(ActionEvent event) {

    }

    @FXML
    void toggleDistanceSort(ActionEvent event) {

    }

    @FXML
    void toggleMake1(ActionEvent event) {

    }

    @FXML
    void toggleMake2(ActionEvent event) {

    }

    @FXML
    void toggleMake3(ActionEvent event) {

    }

    @FXML
    void toggleMake4(ActionEvent event) {

    }

    @FXML
    void toggleMake5(ActionEvent event) {

    }

    @FXML
    void toggleMakeMenu(ActionEvent event) {

    }

    @FXML
    void toggleMileageSort(ActionEvent event) {

    }

    @FXML
    void toggleModel1(ActionEvent event) {

    }

    @FXML
    void toggleModel2(ActionEvent event) {

    }

    @FXML
    void toggleModel3(ActionEvent event) {

    }

    @FXML
    void toggleModel4(ActionEvent event) {

    }

    @FXML
    void toggleModel5(ActionEvent event) {

    }

    @FXML
    void toggleModelMenu(ActionEvent event) {

    }

    @FXML
    void togglePriceSort(ActionEvent event) {

    }
    
    private void loadDefault() {
        Query query = manager.createNamedQuery("Car.findAll");
        
        List<Car> data = query.getResultList();
        
        // JavaFX docs: observablelist lets listeners track changes to the list
        ObservableList<Car> odata = FXCollections.observableArrayList();

        for (Car d : data) {
               
            System.out.println(d.getVin());
            odata.add(d);
        }
        
        //set first row car
        makeCar1.setText(odata.get(0).getMake());
        modelCar1.setText(odata.get(0).getModel());
        yearCar1.setText(odata.get(0).getYear().toString());
        milesCar1.setText(odata.get(0).getMiles().toString());
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

        assert advancedSearchPane != null : "fx:id=\"advancedSearchPane\" was not injected: check your FXML file 'searchView.fxml'.";
        assert searchPane != null : "fx:id=\"searchPane\" was not injected: check your FXML file 'searchView.fxml'.";
        assert searchButton != null : "fx:id=\"searchButton\" was not injected: check your FXML file 'searchView.fxml'.";
        assert sortByMenu != null : "fx:id=\"sortByMenu\" was not injected: check your FXML file 'searchView.fxml'.";
        assert priceSortMenuItem != null : "fx:id=\"priceSortMenuItem\" was not injected: check your FXML file 'searchView.fxml'.";
        assert mileageSortMenuItem != null : "fx:id=\"mileageSortMenuItem\" was not injected: check your FXML file 'searchView.fxml'.";
        assert distanceSortMenuItem != null : "fx:id=\"distanceSortMenuItem\" was not injected: check your FXML file 'searchView.fxml'.";
        assert bestValueSortMenuItem != null : "fx:id=\"bestValueSortMenuItem\" was not injected: check your FXML file 'searchView.fxml'.";
        assert searchField != null : "fx:id=\"searchField\" was not injected: check your FXML file 'searchView.fxml'.";
        assert searchTermLabel != null : "fx:id=\"searchTermLabel\" was not injected: check your FXML file 'searchView.fxml'.";
        assert filterTitleLabel != null : "fx:id=\"filterTitleLabel\" was not injected: check your FXML file 'searchView.fxml'.";
        assert maxPriceField != null : "fx:id=\"maxPriceField\" was not injected: check your FXML file 'searchView.fxml'.";
        assert minPriceField != null : "fx:id=\"minPriceField\" was not injected: check your FXML file 'searchView.fxml'.";
        assert minMilesField != null : "fx:id=\"minMilesField\" was not injected: check your FXML file 'searchView.fxml'.";
        assert maxMilesField != null : "fx:id=\"maxMilesField\" was not injected: check your FXML file 'searchView.fxml'.";
        assert manufacturerMenu != null : "fx:id=\"manufacturerMenu\" was not injected: check your FXML file 'searchView.fxml'.";
        assert make1 != null : "fx:id=\"make1\" was not injected: check your FXML file 'searchView.fxml'.";
        assert make2 != null : "fx:id=\"make2\" was not injected: check your FXML file 'searchView.fxml'.";
        assert make3 != null : "fx:id=\"make3\" was not injected: check your FXML file 'searchView.fxml'.";
        assert make4 != null : "fx:id=\"make4\" was not injected: check your FXML file 'searchView.fxml'.";
        assert make5 != null : "fx:id=\"make5\" was not injected: check your FXML file 'searchView.fxml'.";
        assert modelMenu != null : "fx:id=\"modelMenu\" was not injected: check your FXML file 'searchView.fxml'.";
        assert model1 != null : "fx:id=\"model1\" was not injected: check your FXML file 'searchView.fxml'.";
        assert model2 != null : "fx:id=\"model2\" was not injected: check your FXML file 'searchView.fxml'.";
        assert model3 != null : "fx:id=\"model3\" was not injected: check your FXML file 'searchView.fxml'.";
        assert model4 != null : "fx:id=\"model4\" was not injected: check your FXML file 'searchView.fxml'.";
        assert model5 != null : "fx:id=\"model5\" was not injected: check your FXML file 'searchView.fxml'.";
        assert filterPriceLabel != null : "fx:id=\"filterPriceLabel\" was not injected: check your FXML file 'searchView.fxml'.";
        assert filterMilesLabel != null : "fx:id=\"filterMilesLabel\" was not injected: check your FXML file 'searchView.fxml'.";
        assert greaterThanPrice != null : "fx:id=\"greaterThanPrice\" was not injected: check your FXML file 'searchView.fxml'.";
        assert greaterThanMiles != null : "fx:id=\"greaterThanMiles\" was not injected: check your FXML file 'searchView.fxml'.";
        assert lessThanPrice != null : "fx:id=\"lessThanPrice\" was not injected: check your FXML file 'searchView.fxml'.";
        assert lessThanMiles != null : "fx:id=\"lessThanMiles\" was not injected: check your FXML file 'searchView.fxml'.";
        assert andPrice != null : "fx:id=\"andPrice\" was not injected: check your FXML file 'searchView.fxml'.";
        assert andMiles != null : "fx:id=\"andMiles\" was not injected: check your FXML file 'searchView.fxml'.";
        assert nextPageButton != null : "fx:id=\"nextPageButton\" was not injected: check your FXML file 'searchView.fxml'.";
        assert lastButton != null : "fx:id=\"lastButton\" was not injected: check your FXML file 'searchView.fxml'.";
        assert lastButtonLabel != null : "fx:id=\"lastButtonLabel\" was not injected: check your FXML file 'searchView.fxml'.";
        assert nextButtonLabel != null : "fx:id=\"nextButtonLabel\" was not injected: check your FXML file 'searchView.fxml'.";
        assert currentPageLabel != null : "fx:id=\"currentPageLabel\" was not injected: check your FXML file 'searchView.fxml'.";
        assert carListPane != null : "fx:id=\"carListPane\" was not injected: check your FXML file 'searchView.fxml'.";
        assert car1Pane != null : "fx:id=\"car1Pane\" was not injected: check your FXML file 'searchView.fxml'.";
        assert moreDetailsButton1 != null : "fx:id=\"moreDetailsButton1\" was not injected: check your FXML file 'searchView.fxml'.";
        assert moreDetailsLabel1 != null : "fx:id=\"moreDetailsLabel1\" was not injected: check your FXML file 'searchView.fxml'.";
        assert pictureCar1 != null : "fx:id=\"pictureCar1\" was not injected: check your FXML file 'searchView.fxml'.";
        assert priceCar1 != null : "fx:id=\"priceCar1\" was not injected: check your FXML file 'searchView.fxml'.";
        assert contactButton1 != null : "fx:id=\"contactButton1\" was not injected: check your FXML file 'searchView.fxml'.";
        assert makeOfferButton1 != null : "fx:id=\"makeOfferButton1\" was not injected: check your FXML file 'searchView.fxml'.";
        assert makeCar1 != null : "fx:id=\"makeCar1\" was not injected: check your FXML file 'searchView.fxml'.";
        assert modelCar1 != null : "fx:id=\"modelCar1\" was not injected: check your FXML file 'searchView.fxml'.";
        assert yearCar1 != null : "fx:id=\"yearCar1\" was not injected: check your FXML file 'searchView.fxml'.";
        assert milesCar1 != null : "fx:id=\"milesCar1\" was not injected: check your FXML file 'searchView.fxml'.";
        assert car2Pane != null : "fx:id=\"car2Pane\" was not injected: check your FXML file 'searchView.fxml'.";
        assert moreDetailsButton2 != null : "fx:id=\"moreDetailsButton2\" was not injected: check your FXML file 'searchView.fxml'.";
        assert moreDetailsLabe2 != null : "fx:id=\"moreDetailsLabe2\" was not injected: check your FXML file 'searchView.fxml'.";
        assert pictureCar2 != null : "fx:id=\"pictureCar2\" was not injected: check your FXML file 'searchView.fxml'.";
        assert priceCar2 != null : "fx:id=\"priceCar2\" was not injected: check your FXML file 'searchView.fxml'.";
        assert contactButtonCar2 != null : "fx:id=\"contactButtonCar2\" was not injected: check your FXML file 'searchView.fxml'.";
        assert makeOfferButton2 != null : "fx:id=\"makeOfferButton2\" was not injected: check your FXML file 'searchView.fxml'.";
        assert makeCar2 != null : "fx:id=\"makeCar2\" was not injected: check your FXML file 'searchView.fxml'.";
        assert modelCar2 != null : "fx:id=\"modelCar2\" was not injected: check your FXML file 'searchView.fxml'.";
        assert yearCar2 != null : "fx:id=\"yearCar2\" was not injected: check your FXML file 'searchView.fxml'.";
        assert milesCar2 != null : "fx:id=\"milesCar2\" was not injected: check your FXML file 'searchView.fxml'.";
        assert car3Pane != null : "fx:id=\"car3Pane\" was not injected: check your FXML file 'searchView.fxml'.";
        assert moreDetailsButton3 != null : "fx:id=\"moreDetailsButton3\" was not injected: check your FXML file 'searchView.fxml'.";
        assert moreDetailsLabel3 != null : "fx:id=\"moreDetailsLabel3\" was not injected: check your FXML file 'searchView.fxml'.";
        assert pictureCar3 != null : "fx:id=\"pictureCar3\" was not injected: check your FXML file 'searchView.fxml'.";
        assert priceCar3 != null : "fx:id=\"priceCar3\" was not injected: check your FXML file 'searchView.fxml'.";
        assert contactButtonCar3 != null : "fx:id=\"contactButtonCar3\" was not injected: check your FXML file 'searchView.fxml'.";
        assert makeOfferButton3 != null : "fx:id=\"makeOfferButton3\" was not injected: check your FXML file 'searchView.fxml'.";
        assert makeCar3 != null : "fx:id=\"makeCar3\" was not injected: check your FXML file 'searchView.fxml'.";
        assert modelCar3 != null : "fx:id=\"modelCar3\" was not injected: check your FXML file 'searchView.fxml'.";
        assert yearCar3 != null : "fx:id=\"yearCar3\" was not injected: check your FXML file 'searchView.fxml'.";
        assert milesCar3 != null : "fx:id=\"milesCar3\" was not injected: check your FXML file 'searchView.fxml'.";
        assert car4Pane != null : "fx:id=\"car4Pane\" was not injected: check your FXML file 'searchView.fxml'.";
        assert moreDetailsButton4 != null : "fx:id=\"moreDetailsButton4\" was not injected: check your FXML file 'searchView.fxml'.";
        assert moreDetailsLabel4 != null : "fx:id=\"moreDetailsLabel4\" was not injected: check your FXML file 'searchView.fxml'.";
        assert makeCar4 != null : "fx:id=\"makeCar4\" was not injected: check your FXML file 'searchView.fxml'.";
        assert modelCar4 != null : "fx:id=\"modelCar4\" was not injected: check your FXML file 'searchView.fxml'.";
        assert yearCar4 != null : "fx:id=\"yearCar4\" was not injected: check your FXML file 'searchView.fxml'.";
        assert pictureCar4 != null : "fx:id=\"pictureCar4\" was not injected: check your FXML file 'searchView.fxml'.";
        assert priceCar4 != null : "fx:id=\"priceCar4\" was not injected: check your FXML file 'searchView.fxml'.";
        assert contactButtonCar4 != null : "fx:id=\"contactButtonCar4\" was not injected: check your FXML file 'searchView.fxml'.";
        assert makeOfferButton4 != null : "fx:id=\"makeOfferButton4\" was not injected: check your FXML file 'searchView.fxml'.";
        assert milesCar4 != null : "fx:id=\"milesCar4\" was not injected: check your FXML file 'searchView.fxml'.";
        
        //Database connection, named in persistence.xml
        manager = (EntityManager) Persistence.createEntityManagerFactory("CarfolioPU").createEntityManager();
        
        //Display first few cars in the DB for now
        loadDefault();

    }

    
}
