/**
 * Sample Skeleton for 'searchView.fxml' Controller Class
 */

package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Car;
import model.Message;
import model.User;




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

    @FXML // fx:id="pageNumber"
    private Label pageNumber; // Value injected by FXMLLoader

    @FXML // fx:id="carListPane"
    private SplitPane carListPane; // Value injected by FXMLLoader

    @FXML // fx:id="car1Pane"
    private AnchorPane car1Pane; // Value injected by FXMLLoader

    @FXML // fx:id="moreDetailsButton1"
    private Button moreDetailsButton1; // Value injected by FXMLLoader

    @FXML // fx:id="moreDetailsLabel1"
    private Label moreDetailsLabel1; // Value injected by FXMLLoader

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

    @FXML // fx:id="priceCar4"
    private Label priceCar4; // Value injected by FXMLLoader

    @FXML // fx:id="contactButtonCar4"
    private Button contactButtonCar4; // Value injected by FXMLLoader

    @FXML // fx:id="makeOfferButton4"
    private Button makeOfferButton4; // Value injected by FXMLLoader

    @FXML // fx:id="milesCar4"
    private Label milesCar4; // Value injected by FXMLLoader
    
    private EntityManager manager;
    
    private Car one = new Car(); 
    private Car two = new Car();
    private Car three = new Car();
    private Car four = new Car();
    
    private int firstCar = 0;
    private int lastCar = 3;
    
    private User activeUser;
    private Message createdMessage;
    
    
    //Needed to determine who is sending offer/message
    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }
    
    //For messaging car owners 
    
    @FXML
    void contactCar1Owner(ActionEvent event) throws IOException {
        contact(one);
    }

    @FXML
    void contactCar2Owner(ActionEvent event) throws IOException {
        contact(two);
    }

    @FXML
    void contactCar3Owner(ActionEvent event) throws IOException {
        contact(three);
    }

    @FXML
    void contactCar4Owner(ActionEvent event) throws IOException {
        contact(four);
    }
    
    
    //For making an offer on a vehicle
    @FXML
    void makeOfferCar1(ActionEvent event) {
        message(one);
    }

    @FXML
    void makeOfferCar2(ActionEvent event) {
        message(two);
    }

    @FXML
    void makeOfferCar3(ActionEvent event) {
        message(three);
    }

    @FXML
    void makeOfferCar4(ActionEvent event) {
        message(four);
    }   
    
    
    @FXML
    void initializeSearch(ActionEvent event) {

    }
    
    //For launching the portfolio matching each car

    @FXML
    void openCar1Portfolio(ActionEvent event) throws IOException {
        portfolio(one);
    }

    @FXML
    void openCar2Portfolio(ActionEvent event) throws IOException {
        portfolio(two);
    }

    @FXML
    void openCar3Portfolio(ActionEvent event) throws IOException {
        portfolio(three);
    }

    @FXML
    void openCar4Portfolio(ActionEvent event) throws IOException {
        portfolio(four);
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
            int newPage = getPage() - 1;
            pageNumber.setText(Integer.toString(newPage));
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
            int newPage = getPage() + 1;
            pageNumber.setText(Integer.toString(newPage));
            
        } else {
            lastCar = getCarList().size();
            firstCar = lastCar - 4;
            
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
        
        SetCars();
        setPageCarData();
        
    }
    
    
    // Retrieve the list of cars from the database
    private List<Car> getCarList() {
        Query query = manager.createNamedQuery("Car.findAll");
        List<Car> data = query.getResultList();
        ObservableList<Car> odata = FXCollections.observableArrayList();
        data.forEach((d) -> {
            odata.add(d);
        });
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
        int nowSelected = Integer.parseInt(pageNumber.getText());
        System.out.println(nowSelected);
        return nowSelected;
    }
    
    // set the data for the first car on the page
    public void setCarDataOne() {
        makeCar1.setText(one.getMake());
        modelCar1.setText(one.getModel());
        yearCar1.setText(Integer.toString(one.getYear()));
        milesCar1.setText(Integer.toString(one.getMiles()));
        priceCar1.setText(Integer.toString(one.getPrice()));
            
    }
    
    // set the data for the second car on the page
    public void setCarDataTwo() {
        makeCar2.setText(two.getMake());
        modelCar2.setText(two.getModel());
        yearCar2.setText(Integer.toString(two.getYear()));
        milesCar2.setText(Integer.toString(two.getMiles()));
        priceCar2.setText(Integer.toString(two.getPrice()));
            
    }    
    
    // set the data for the third car on the page
    public void setCarDataThree() {
        makeCar3.setText(three.getMake());
        modelCar3.setText(three.getModel());
        yearCar3.setText(Integer.toString(three.getYear()));
        milesCar3.setText(Integer.toString(three.getMiles()));
        priceCar3.setText(Integer.toString(three.getPrice()));
    }    
    
    // set the data for the fourth car on the page
    public void setCarDataFour() {
        makeCar4.setText(four.getMake());
        modelCar4.setText(four.getModel());
        yearCar4.setText(Integer.toString(four.getYear()));
        milesCar4.setText(Integer.toString(four.getMiles()));
        priceCar4.setText(Integer.toString(four.getPrice()));
            
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
        
        int pages = (getCarList().size()) / 4;
        return pages;
    }
    
    
    public void message(Car car) {
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
                
                //Auto-send message with the offer
                this.createdMessage = new Message();
                createdMessage.setRecipient(car.getSellerUsername());
                createdMessage.setSender(activeUser.getUsername());
                createdMessage.setMessageBody(activeUser.getUsername() + " has submitted an offer to buy your " + four.getMake() + ", VIN " + four.getVin() + ", for: " + "$" + amount);
                Date dt = new Date(System.currentTimeMillis());
                createdMessage.setTimeSent(dt);

                List<Message> data  = manager.createNamedQuery("Message.findAll").getResultList();
                int last_id = data.size();
                createdMessage.setMessageID((last_id + 1) + "");

                manager.getTransaction().begin();
                manager.persist(createdMessage);
                manager.getTransaction().commit();

                //Success msg
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Offer submitted successfully!");
                alert.showAndWait();
            }
            catch(NumberFormatException x){
                System.out.println(x.getMessage());
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("Please enter a valid numeric dollar amount.");
                alert.showAndWait();
             }
        }   
    }
    
    
    public void contact(Car car) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/messageView.fxml"));
        Parent messageView = loader.load();
        Scene messageViewScene = new Scene(messageView);
        messageController controller = loader.getController();
        controller.setActiveUser(activeUser);
        controller.setMessageRecipient(car.getSellerUsername());
        Stage stage = new Stage();
        stage.setScene(messageViewScene);
        stage.show();
    }
    
    public void portfolio(Car car) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/portfolioView.fxml"));
        Parent portfolioView = loader.load();
        Scene portfolioViewScene = new Scene(portfolioView);
        portfolioController controller = loader.getController();
        controller.setCar(car);
        controller.setActiveUser(activeUser);
        Stage stage = new Stage();
        stage.setScene(portfolioViewScene);
        stage.show();
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
        assert pageNumber != null : "fx:id=\"pageNumber\" was not injected: check your FXML file 'searchView.fxml'.";
        assert carListPane != null : "fx:id=\"carListPane\" was not injected: check your FXML file 'searchView.fxml'.";
        assert car1Pane != null : "fx:id=\"car1Pane\" was not injected: check your FXML file 'searchView.fxml'.";
        assert moreDetailsButton1 != null : "fx:id=\"moreDetailsButton1\" was not injected: check your FXML file 'searchView.fxml'.";
        assert moreDetailsLabel1 != null : "fx:id=\"moreDetailsLabel1\" was not injected: check your FXML file 'searchView.fxml'.";
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
