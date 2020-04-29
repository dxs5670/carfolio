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

    @FXML
    private SplitPane advancedSearchPane;

    @FXML
    private AnchorPane searchPane;

    @FXML
    private Button searchButton;

    @FXML
    private MenuButton sortByMenu;

    @FXML
    private MenuItem priceSortMenuItem;

    @FXML
    private MenuItem mileageSortMenuItem;

    @FXML
    private MenuItem distanceSortMenuItem;

    @FXML
    private MenuItem bestValueSortMenuItem;

    @FXML
    private TextField searchField;

    @FXML
    private Label searchTermLabel;

    @FXML
    private Label filterTitleLabel;

    @FXML
    private TextField maxPriceField;

    @FXML
    private TextField minPriceField;

    @FXML
    private TextField minMilesField;

    @FXML
    private TextField maxMilesField;

    @FXML
    private MenuButton manufacturerMenu;

    @FXML
    private RadioMenuItem make1;

    @FXML
    private RadioMenuItem make2;

    @FXML
    private RadioMenuItem make3;

    @FXML
    private RadioMenuItem make4;

    @FXML
    private RadioMenuItem make5;

    @FXML
    private MenuButton modelMenu;

    @FXML
    private RadioMenuItem model1;

    @FXML
    private RadioMenuItem model2;

    @FXML
    private RadioMenuItem model3;

    @FXML
    private RadioMenuItem model4;

    @FXML
    private RadioMenuItem model5;

    @FXML
    private Label filterPriceLabel;

    @FXML
    private Label filterMilesLabel;

    @FXML
    private Label greaterThanPrice;

    @FXML
    private Label greaterThanMiles;

    @FXML
    private Label lessThanPrice;

    @FXML
    private Label lessThanMiles;

    @FXML
    private Label andPrice;

    @FXML
    private Label andMiles;

    @FXML
    private Button nextPageButton;

    @FXML
    private Button lastButton;

    @FXML
    private Label lastButtonLabel;

    @FXML
    private Label nextButtonLabel;

    @FXML
    private TextField currentPageLabel;

    @FXML
    private SplitPane carListPane;

    @FXML
    private AnchorPane car1Pane;

    @FXML
    private Button moreDetailsButton1;

    @FXML
    private Label moreDetailsLabel1;

    @FXML
    private Rectangle pictureCar1;

    @FXML
    private Label priceCar1;

    @FXML
    private Button contactButton1;

    @FXML
    private Button makeOfferButton1;

    @FXML
    private Label makeCar1;

    @FXML
    private Label modelCar1;

    @FXML
    private Label yearCar1;

    @FXML
    private Label milesCar1;

    @FXML
    private AnchorPane car2Pane;

    @FXML
    private Button moreDetailsButton2;

    @FXML
    private Label moreDetailsLabe2;

    @FXML
    private Rectangle pictureCar2;

    @FXML
    private Label priceCar2;

    @FXML
    private Button contactButtonCar2;

    @FXML
    private Button makeOfferButton2;

    @FXML
    private Label makeCar2;

    @FXML
    private Label modelCar2;

    @FXML
    private Label yearCar2;

    @FXML
    private Label milesCar2;

    @FXML
    private AnchorPane car3Pane;

    @FXML
    private Button moreDetailsButton3;

    @FXML
    private Label moreDetailsLabel3;

    @FXML
    private Rectangle pictureCar3;

    @FXML
    private Label priceCar3;

    @FXML
    private Button contactButtonCar3;

    @FXML
    private Button makeOfferButton3;

    @FXML
    private Label makeCar3;

    @FXML
    private Label modelCar3;

    @FXML
    private Label yearCar3;

    @FXML
    private Label milesCar3;

    @FXML
    private AnchorPane car4Pane;

    @FXML
    private Button moreDetailsButton4;

    @FXML
    private Label moreDetailsLabel4;

    @FXML
    private Label makeCar4;

    @FXML
    private Label modelCar4;

    @FXML
    private Label yearCar4;

    @FXML
    private Rectangle pictureCar4;

    @FXML
    private Label priceCar4;

    @FXML
    private Button contactButtonCar4;

    @FXML
    private Button makeOfferButton4;

    @FXML
    private Label milesCar4;
    
    private EntityManager manager;
    
    private Car one = new Car(); 
    private Car two = new Car();
    private Car three = new Car();
    private Car four = new Car();
    
    private int firstCar = 0;
    private int lastCar = 3;
    
    
    //For messaging car owners 
    
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
    
    
    //For making an offer on a vehicle
    
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
    void initializeSearch(ActionEvent event) {

    }
    
    
    
    
    
    //For launching the portfolio matching each car

    @FXML
    void openCar1Portfolio(ActionEvent event) throws IOException {
        
        //Need to pass car data or id
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/portfolioView.fxml"));
        Parent portfolioView = loader.load();
        Scene portfolioViewScene = new Scene(portfolioView);
        portfolioController controller = loader.getController();
        controller.setCar(one);
        Stage stage = new Stage();
        stage.setScene(portfolioViewScene);
        stage.show();
    }

    @FXML
    void openCar2Portfolio(ActionEvent event) throws IOException {
        
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/portfolioView.fxml"));
        Parent portfolioView = loader.load();
        Scene portfolioViewScene = new Scene(portfolioView);
        portfolioController controller = loader.getController();
        controller.setCar(two);
        Stage stage = new Stage();
        stage.setScene(portfolioViewScene);
        stage.show();
    }

    @FXML
    void openCar3Portfolio(ActionEvent event) throws IOException {
        
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/portfolioView.fxml"));
        Parent portfolioView = loader.load();
        Scene portfolioViewScene = new Scene(portfolioView);
        portfolioController controller = loader.getController();
        controller.setCar(three);
        Stage stage = new Stage();
        stage.setScene(portfolioViewScene);
        stage.show();
    }

    @FXML
    void openCar4Portfolio(ActionEvent event) throws IOException {
        
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/portfolioView.fxml"));
        Parent portfolioView = loader.load();
        Scene portfolioViewScene = new Scene(portfolioView);
        portfolioController controller = loader.getController();
        controller.setCar(four);
        Stage stage = new Stage();
        stage.setScene(portfolioViewScene);
        stage.show();
    }

    
    
    
    @FXML
    void openSortMenu(ActionEvent event) {

    }

    
    /* On back button click, set Car objects corresponding with the data entry 
       and render the page with updated data */
    @FXML
    void renderLastCars(ActionEvent event) {
        if (getPage() > 1) {
            firstCar -= 4;
            lastCar -= 4;
            int newPage = Integer.getInteger(currentPageLabel.getText()) - 1;
            currentPageLabel.setText(Integer.toString(newPage));
        } else {
            firstCar = 0;
            lastCar = 3;
        }

        SetCars();
        setPageCarData();
    }

    /* On back button click, set Car objects corresponding with the data entry 
    and render the page with updated data */
    @FXML
    void renderNextCars(ActionEvent event) {
        if (getPage() < totalPages()) {
            firstCar += 4;
            lastCar += 4; 
            int newPage = Integer.getInteger(currentPageLabel.getText()) + 1;
            currentPageLabel.setText(Integer.toString(newPage));
        } else {
            lastCar = getCarList().size();
            firstCar = lastCar - 4;
            
        }

        SetCars();
        setPageCarData();
    }

    /* When the user types a page number, set Car objects corresponding with 
    the data entry and render the page with updated data */
    
    @FXML
    void setCurrentPage(ActionEvent event) {
        
        
        if( getPage() > totalPages() ) {
            lastCar = getCarList().size();
            firstCar = lastCar - 4;        
        } else {
            firstCar = 4 * getPage() - 1;
            lastCar = firstCar + 4;
        }
        
        SetCars();
        setPageCarData();
    }
    
    // The following methods are used to search and sort the car data
    
    /* Set the maximum number of miles on the displayed cars */
    @FXML
    void setMaxMiles(ActionEvent event) {

    }
    
    /* Set the maximum price on the displayed cars */
    @FXML
    void setMaxPrice(ActionEvent event) {

    }

    /* Set the minimum number of miles on the displayed cars */
    @FXML
    void setMinMiles(ActionEvent event) {

    }
    
    /* Set the minimum price on the displayed cars */
    @FXML
    void setMinPrice(ActionEvent event) {

    }

    /* Set the term to search by */
    @FXML
    void setSearchField(ActionEvent event) {

    }

    /* Sort the cars in order of their reccomneded value index */ 
    @FXML
    void toggleBVSort(ActionEvent event) {

    }

    /* Sort the cars by their distacne from the buyer */
    @FXML
    void toggleDistanceSort(ActionEvent event) {

    }

    /* toggle search by a particular make 
    This is the first manufacturer in the dropdown list*/
    @FXML
    void toggleMake1(ActionEvent event) {

    }
    
    /* toggle search by a particular make 
    This is the second manufacturer in the dropdown list*/
    @FXML
    void toggleMake2(ActionEvent event) {

    }
    
    /* toggle search by a particular make 
    This is the third manufacturer in the dropdown list*/
    @FXML
    void toggleMake3(ActionEvent event) {

    }

    /* toggle search by a particular make 
    This is the fourth manufacturer in the dropdown list*/
    @FXML
    void toggleMake4(ActionEvent event) {

    }

    /* toggle search by a particular make 
    This is the fifth manufacturer in the dropdown list*/
    @FXML
    void toggleMake5(ActionEvent event) {

    }

    
    // to be removed
    @FXML
    void toggleMakeMenu(ActionEvent event) {

    }

    /* toggle sort by mileage */
    @FXML
    void toggleMileageSort(ActionEvent event) {

    }

    /* toggle search by a particular model 
    This is the first model in the dropdown list*/
    @FXML
    void toggleModel1(ActionEvent event) {

    }

    /* toggle search by a particular model 
    This is the second model in the dropdown list*/
    @FXML
    void toggleModel2(ActionEvent event) {

    }

    /* toggle search by a particular model 
    This is the third model in the dropdown list*/
    @FXML
    void toggleModel3(ActionEvent event) {

    }
    
    /* toggle search by a particular model 
    This is the fourth model in the dropdown list*/
    @FXML
    void toggleModel4(ActionEvent event) {

    }

    /* toggle search by a particular model 
    This is the fifth model in the dropdown list*/
    @FXML
    void toggleModel5(ActionEvent event) {

    }

    
    // to be removed
    @FXML
    void toggleModelMenu(ActionEvent event) {

    }

    
    /* toggle sorting by lowest price */
    @FXML
    void togglePriceSort(ActionEvent event) {

    }
    
    
    // Method used to initialize the page with essential data
    private void loadPage() {
        
        currentPageLabel.setText("1");
        SetCars();
        setPageCarData();
        
    }
    
    
    // Retrieve the list of cars from the database
    private List<Car> getCarList() {
        Query query = manager.createNamedQuery("Car.findAll");
        List<Car> data = query.getResultList();
        ObservableList<Car> odata = FXCollections.observableArrayList();
        for (Car d : data) {
                odata.add(d);
        }
        return odata;
    } 
    
    //set the cars to be rendered; these are initiallized as Car objects
    private void SetCars() {
        one = getCarList().get(firstCar);
        two = getCarList().get(firstCar + 1);
        three = getCarList().get(lastCar - 1);
        four = getCarList().get(lastCar);
    }
    
    
    // this will fetch the current page
    public int getPage() {
        int nowSelected = Integer.getInteger(currentPageLabel.getText());
        return nowSelected;
    }
    
    // set the data for the first car on the page
    public void setCarDataOne() {
        makeCar1.setText(one.getMake());
        modelCar1.setText(one.getModel());
        yearCar1.setText(Integer.toString(one.getYear()));
        milesCar1.setText(Integer.toString(one.getMiles()));
            
    }
    
    // set the data for the second car on the page
    public void setCarDataTwo() {
        makeCar2.setText(two.getMake());
        modelCar2.setText(two.getModel());
        yearCar2.setText(Integer.toString(two.getYear()));
        milesCar2.setText(Integer.toString(two.getMiles()));
            
    }    
    
    // set the data for the third car on the page
    public void setCarDataThree() {
        makeCar3.setText(three.getMake());
        modelCar3.setText(three.getModel());
        yearCar3.setText(Integer.toString(three.getYear()));
        milesCar3.setText(Integer.toString(three.getMiles()));
            
    }    
    
    // set the data for the fourth car on the page
    public void setCarDataFour() {
        makeCar4.setText(four.getMake());
        modelCar4.setText(four.getModel());
        yearCar4.setText(Integer.toString(four.getYear()));
        milesCar4.setText(Integer.toString(four.getMiles()));
            
    }    
    
    // set the data for the all cars on the page
    public void setPageCarData() {
        setCarDataOne();
        setCarDataTwo();
        setCarDataThree();
        setCarDataFour();
    }
    
    // the total number of pages 
    public int totalPages() {
        
        int pages = (getCarList().size() + 1) / 4;
        return pages;
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
        
        // Render the first page of cars
        loadPage();
        
        
        

    }

    
}
