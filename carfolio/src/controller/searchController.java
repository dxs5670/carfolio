/*


*/

package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
    private SplitPane advancedSearchPane; 

    @FXML // fx:id="searchPane"
    private AnchorPane searchPane; 

    @FXML // fx:id="searchButton"
    private Button searchButton; 

    @FXML // fx:id="sortByMenu"
    private MenuButton sortByMenu; 

    @FXML // fx:id="priceSortMenuItem"
    private MenuItem priceSortMenuItem; 

    @FXML // fx:id="mileageSortMenuItem"
    private MenuItem mileageSortMenuItem; 

    @FXML // fx:id="distanceSortMenuItem"
    private MenuItem yearSortMenuItem; 

    @FXML // fx:id="bestValueSortMenuItem"
    private MenuItem safetySortMenuItem; 

    @FXML // fx:id="searchField"
    private TextField searchField; 

    @FXML // fx:id="searchTermLabel"
    private Label searchTermLabel; 

    @FXML // fx:id="filterTitleLabel"
    private Label filterTitleLabel; 

    @FXML // fx:id="maxPriceField"
    private TextField maxPriceField; 

    @FXML // fx:id="minPriceField"
    private TextField minPriceField; 

    @FXML // fx:id="minMilesField"
    private TextField minMilesField; 

    @FXML // fx:id="maxMilesField"
    private TextField maxMilesField; 

    @FXML // fx:id="manufacturerMenu"
    private MenuButton manufacturerMenu; 

    @FXML // fx:id="modelMenu"
    private MenuButton modelMenu; 

    @FXML // fx:id="filterPriceLabel"
    private Label filterPriceLabel; 

    @FXML // fx:id="filterMilesLabel"
    private Label filterMilesLabel; 

    @FXML // fx:id="greaterThanPrice"
    private Label greaterThanPrice; 

    @FXML // fx:id="greaterThanMiles"
    private Label greaterThanMiles; 

    @FXML // fx:id="lessThanPrice"
    private Label lessThanPrice; 

    @FXML // fx:id="lessThanMiles"
    private Label lessThanMiles; 

    @FXML // fx:id="andPrice"
    private Label andPrice; 

    @FXML // fx:id="andMiles"
    private Label andMiles; 

    @FXML // fx:id="nextPageButton"
    private Button nextPageButton; 

    @FXML // fx:id="lastButton"
    private Button lastButton; 

    @FXML // fx:id="lastButtonLabel"
    private Label lastButtonLabel; 

    @FXML // fx:id="nextButtonLabel"
    private Label nextButtonLabel; 

    @FXML // fx:id="pageNumber"
    private Label pageNumber; 

    @FXML // fx:id="backButton"
    private Button backButton;
    
    @FXML // fx:id="carListPane"
    private SplitPane carListPane; 

    @FXML // fx:id="car1Pane"
    private AnchorPane car1Pane; 

    @FXML // fx:id="moreDetailsButton1"
    private Button moreDetailsButton1; 

    @FXML // fx:id="moreDetailsLabel1"
    private Label moreDetailsLabel1; 

    @FXML // fx:id="priceCar1"
    private Label priceCar1; 

    @FXML // fx:id="contactButton1"
    private Button contactButton1; 

    @FXML // fx:id="makeOfferButton1"
    private Button makeOfferButton1; 

    @FXML // fx:id="makeCar1"
    private Label makeCar1; 

    @FXML // fx:id="modelCar1"
    private Label modelCar1; 

    @FXML // fx:id="yearCar1"
    private Label yearCar1; 

    @FXML // fx:id="milesCar1"
    private Label milesCar1; 

    @FXML // fx:id="car2Pane"
    private AnchorPane car2Pane; 

    @FXML // fx:id="moreDetailsButton2"
    private Button moreDetailsButton2; 

    @FXML // fx:id="moreDetailsLabe2"
    private Label moreDetailsLabe2; 

    @FXML // fx:id="priceCar2"
    private Label priceCar2; 

    @FXML // fx:id="contactButtonCar2"
    private Button contactButtonCar2; 

    @FXML // fx:id="makeOfferButton2"
    private Button makeOfferButton2; 

    @FXML // fx:id="makeCar2"
    private Label makeCar2; 

    @FXML // fx:id="modelCar2"
    private Label modelCar2; 

    @FXML // fx:id="yearCar2"
    private Label yearCar2; 

    @FXML // fx:id="milesCar2"
    private Label milesCar2; 

    @FXML // fx:id="car3Pane"
    private AnchorPane car3Pane; 

    @FXML // fx:id="moreDetailsButton3"
    private Button moreDetailsButton3; 

    @FXML // fx:id="moreDetailsLabel3"
    private Label moreDetailsLabel3; 

    @FXML // fx:id="priceCar3"
    private Label priceCar3; 

    @FXML // fx:id="contactButtonCar3"
    private Button contactButtonCar3; 

    @FXML // fx:id="makeOfferButton3"
    private Button makeOfferButton3; 

    @FXML // fx:id="makeCar3"
    private Label makeCar3; 

    @FXML // fx:id="modelCar3"
    private Label modelCar3; 

    @FXML // fx:id="yearCar3"
    private Label yearCar3; 

    @FXML // fx:id="milesCar3"
    private Label milesCar3; 

    @FXML // fx:id="car4Pane"
    private AnchorPane car4Pane; 

    @FXML // fx:id="moreDetailsButton4"
    private Button moreDetailsButton4; 

    @FXML // fx:id="moreDetailsLabel4"
    private Label moreDetailsLabel4; 

    @FXML // fx:id="makeCar4"
    private Label makeCar4; 

    @FXML // fx:id="modelCar4"
    private Label modelCar4; 

    @FXML // fx:id="yearCar4"
    private Label yearCar4; 

    @FXML // fx:id="priceCar4"
    private Label priceCar4; 

    @FXML // fx:id="contactButtonCar4"
    private Button contactButtonCar4; 

    @FXML // fx:id="makeOfferButton4"
    private Button makeOfferButton4; 

    @FXML // fx:id="milesCar4"
    private Label milesCar4; 
    
    
    // Used for finding users, cars, and adding messages from and to the DB
    private EntityManager manager;
    // The car loaded into the first spot on the page
    private Car one = new Car(); 
    // The car loaded into the second spot on the page
    private Car two = new Car();
    // The car loaded into the third spot on the page
    private Car three = new Car();
    // The car loaded into the fourth spot on the page    
    private Car four = new Car();
    // The default position of the firstCar in a list
    private int firstCar = 0;
    // The default position of the last car in a list
    private int lastCar = 3;
    // The logged-in user
    private User activeUser;
    // Declaration of the scene accessed previously
    private Scene previousScene;
    // Declaration of a message created when an offer is made
    private Message createdMessage;
    
    
    /*
    When the Button backButton is clicked, toPrevious will set the previous
    scene to the Scene previousScene
    */    
    @FXML
    void toPrevious(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (previousScene != null){
            stage.setScene(previousScene);
        }
    }
    
    /*
    setPreviousScene ensures Button backButton is enabled and sets
    the previousScene variable to the Scene parameter scene
    */     
    public void setPreviousScene(Scene scene) {
        previousScene = scene;
        backButton.setDisable(false);
    } 
    
    // Set the text of the search query to Field searchField
    @FXML
    void setSearchField(KeyEvent event) {

    }
    
    // When searchButton is clicked, begin a search using the specified query
    @FXML
    void initializeSearch(ActionEvent event) {

    }
    
    // Sort by the car price, low to high
    @FXML
    void togglePriceSort(ActionEvent event) {
        sortByMenu.setText("Price");
    }
    
    /// Sort by the car mileage, low to high 
    @FXML
    void toggleMileageSort(ActionEvent event) {
        sortByMenu.setText("Miles");
    }
    
    // Sort by the car manufacturing year, low to high
    @FXML
    void toggleYearSort(ActionEvent event) {
        sortByMenu.setText("Year");
    }
    
    // Sort by the car safety rating, high to low 
    @FXML
    void toggleSafetySort(ActionEvent event) {
        sortByMenu.setText("Safety");
    }
    
    // Set the minimum number of miles on the displayed cars
    @FXML
    void setMinMiles(KeyEvent event) {

    }

    // Set the maximum number of miles on the displayed cars
    @FXML
    void setMaxMiles(KeyEvent event) {

    }
    
    // Set the minimum price on the displayed cars
    @FXML
    void setMinPrice(KeyEvent event) {

    }
    
    // Set the maximum price on the displayed cars \
    @FXML
    void setMaxPrice(KeyEvent event) {

    }

    /*
    This function finds all of the different manufacturers in the database of
    cars. Then, it populates the manufacturer dropdown button with only the 
    manufacturers found.
    */
    public void addManufacturerToMenu() {
        ArrayList<String> toAdd = new ArrayList<>();
        for ( Car car : getCarList() ) {
            String manufacturer = car.getMake();
            if(!toAdd.contains(manufacturer)) {
                toAdd.add(manufacturer);
            }
        }
        toAdd.forEach((item) -> {            
            RadioMenuItem added = new RadioMenuItem();
            added.setText(item);
            manufacturerMenu.getItems().add(added);
        });
    }
    
    /*
    This function finds all of the different models in the database of
    cars. Then, it populates the manufacturer dropdown button with only the 
    models found.
    */
    public void addModelToMenu() {
        ArrayList<String> toAdd = new ArrayList<>();
        for ( Car car : getCarList() ) {
            String model = car.getModel();
            if(!toAdd.contains(model)) {
                toAdd.add(model);
            }
        }
        toAdd.forEach((String item) -> {
            RadioMenuItem added = new RadioMenuItem();
            added.setText(item);
            modelMenu.getItems().add(added);
        });
    }
    
    /* 
    On back button click, set Car objects corresponding with the first and last
    cars in the database. Then, the function makes a call to functions SetCars
    and setPageCarData to set the data on the page to the last four car entries
    */
    @FXML
    void renderLastCars(ActionEvent event) {
        if (getPage() > 1 && firstCar >= 4) {
            firstCar -= 4;
            lastCar -= 4;
            int newPage = getPage() - 1;
            pageNumber.setText(Integer.toString(newPage));
        }
        else {
            firstCar = 0;
            lastCar = 3;
            pageNumber.setText("1");
        }
        SetCars();
        setPageCarData();
    }

    // this will fetch the current page
    public int getPage() {
        int nowSelected = Integer.parseInt(pageNumber.getText());
        System.out.println(nowSelected);
        return nowSelected;
    }

    /* 
    On next button click, set Car objects corresponding with the first and last
    cars in the database. Then, the function makes a call to functions SetCars
    and setPageCarData to set the data on the page to the next four car entries
    */
    @FXML
    void renderNextCars(ActionEvent event) {
        if (getPage() < totalPages()) {
            firstCar += 4;
            lastCar += 4;
            int newPage = getPage() + 1;
            pageNumber.setText(Integer.toString(newPage));
        } else {
            lastCar = getCarList().size() - 1;
            firstCar = lastCar - 3;
        }
        SetCars();
        setPageCarData();
    }    

    // Retrieve the list of cars from the database in the order they appear in 
    // the database
    private List<Car> getCarList() {
        Query query = manager.createNamedQuery("Car.findAll");
        List<Car> data = query.getResultList();
        ObservableList<Car> odata = FXCollections.observableArrayList();
        data.forEach((d) -> {
            odata.add(d);
        });
        return odata;
    } 

    // set the cars to be rendered; these are initiallized as Car objects
    private void SetCars() {
        one = getCarList().get(firstCar);
        two = getCarList().get(firstCar + 1);
        three = getCarList().get(lastCar - 1);
        four = getCarList().get(lastCar);
    }

    // set the data for the first car on the page (this is only page data)
    public void setCarDataOne() {
        makeCar1.setText(one.getMake());
        modelCar1.setText(one.getModel());
        yearCar1.setText(Integer.toString(one.getYear()));
        milesCar1.setText(Integer.toString(one.getMiles()));
        priceCar1.setText(Integer.toString(one.getPrice()));
            
    }
    
    // set the data for the second car on the page (this is only page data)
    public void setCarDataTwo() {
        makeCar2.setText(two.getMake());
        modelCar2.setText(two.getModel());
        yearCar2.setText(Integer.toString(two.getYear()));
        milesCar2.setText(Integer.toString(two.getMiles()));
        priceCar2.setText(Integer.toString(two.getPrice()));
            
    }    
    
    // set the data for the third car on the page (this is only page data)
    public void setCarDataThree() {
        makeCar3.setText(three.getMake());
        modelCar3.setText(three.getModel());
        yearCar3.setText(Integer.toString(three.getYear()));
        milesCar3.setText(Integer.toString(three.getMiles()));
        priceCar3.setText(Integer.toString(three.getPrice()));
    }    
    
    // set the data for the fourth car on the page (this is only page data)
    public void setCarDataFour() {
        makeCar4.setText(four.getMake());
        modelCar4.setText(four.getModel());
        yearCar4.setText(Integer.toString(four.getYear()));
        milesCar4.setText(Integer.toString(four.getMiles()));
        priceCar4.setText(Integer.toString(four.getPrice()));
            
    }    

    /*
    Update the page with data corresponding to the declared Car objects using 
    the four functions above
    */
    public void setPageCarData() {
        setCarDataOne();
        setCarDataTwo();
        setCarDataThree();
        setCarDataFour();
    }
    
    // Return the total number of pages
    public int totalPages() {
        // divide the size of carList by four since there are four cars/page
        int pages = (getCarList().size()) / 4;
        return pages;
    }
    
    /*
    Each of the functions below set the makeOfferButtons to open an offer 
    dialogue when the buttons are clicked. They each reference the message() 
    function which takes in a car to send a message to the seller.
    */
    @FXML
    void makeOfferCar1(ActionEvent event) { message(one); }
    @FXML
    void makeOfferCar2(ActionEvent event) { message(two); }
    @FXML
    void makeOfferCar3(ActionEvent event) { message(three); }
    @FXML
    void makeOfferCar4(ActionEvent event) { message(four); } 

    /*
    Each of the functions below set the contactButtons to open a messageView 
    window when the buttons are clicked. They each reference the contact() 
    function which takes in a car to send a message to the seller using the 
    car's sellerUsername attribute.
    */
    @FXML
    void contactCar1Owner(ActionEvent event) throws IOException { contact(one); }
    @FXML
    void contactCar2Owner(ActionEvent event) throws IOException { contact(two); }
    @FXML
    void contactCar3Owner(ActionEvent event) throws IOException { contact(three); }
    @FXML
    void contactCar4Owner(ActionEvent event) throws IOException { contact(four); }
    
 
    /*
    Each of the functions below set the moreDetailsButtons to open a page with 
    the car's data when the buttons are clicked. They each reference the 
    portfolio() function which takes in a car to render a page with the car's 
    data.
    */
    @FXML
    void openCar1Portfolio(ActionEvent event) throws IOException { portfolio(one); }
    @FXML
    void openCar2Portfolio(ActionEvent event) throws IOException { portfolio(two); }
    @FXML
    void openCar3Portfolio(ActionEvent event) throws IOException { portfolio(three); }
    @FXML
    void openCar4Portfolio(ActionEvent event) throws IOException { portfolio(four); }
    
    /*
    The message funciton takes in a single car to make an offer using the 
    message model to a particular vehicle seller. This version of a message is 
    sent to the seller's userPortfolio as well as their messaging inbox
    */
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
    
    /*
    The contact fucntion passes a Car to set a message recipient while opening 
    an instance of messageView in a new window. The back button is set to 
    invisible when the message is launched to prevent any glitches in page
    duplication.
    */
    public void contact(Car car) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/messageView.fxml"));
        Parent messageView = loader.load();
        Scene messageViewScene = new Scene(messageView);
        messageController controller = loader.getController();
        controller.setActiveUser(activeUser);
        controller.setMessageRecipient(car.getSellerUsername());
        controller.setBackButtnInvisible();
        Stage stage = new Stage();
        stage.setScene(messageViewScene);
        stage.show();
    }
    
    /*
    The portfolio funciton passes a car to open a new window of portfolioView 
    that will render that car's data. The user can also access the make an offer 
    and send message buttons from this interface. 
    
    Opening in a small-sized new window gives the user a way to compare 
    different cars without switching back and forth between different views.
    */
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
    
    
    
    // Method used to initialize the page with essential data
    private void loadPage() {
        SetCars();
        setPageCarData();
        addModelToMenu();
        addManufacturerToMenu();   
    }

    // Needed to determine who is sending offer/message
    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }
    
    
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

        assert advancedSearchPane != null : "fx:id=\"advancedSearchPane\" was not injected: check your FXML file 'searchView.fxml'.";
        assert searchPane != null : "fx:id=\"searchPane\" was not injected: check your FXML file 'searchView.fxml'.";
        assert searchButton != null : "fx:id=\"searchButton\" was not injected: check your FXML file 'searchView.fxml'.";
        assert sortByMenu != null : "fx:id=\"sortByMenu\" was not injected: check your FXML file 'searchView.fxml'.";
        assert priceSortMenuItem != null : "fx:id=\"priceSortMenuItem\" was not injected: check your FXML file 'searchView.fxml'.";
        assert mileageSortMenuItem != null : "fx:id=\"mileageSortMenuItem\" was not injected: check your FXML file 'searchView.fxml'.";
        assert safetySortMenuItem != null : "fx:id=\"distanceSortMenuItem\" was not injected: check your FXML file 'searchView.fxml'.";
        assert yearSortMenuItem != null : "fx:id=\"bestValueSortMenuItem\" was not injected: check your FXML file 'searchView.fxml'.";
        assert searchField != null : "fx:id=\"searchField\" was not injected: check your FXML file 'searchView.fxml'.";
        assert searchTermLabel != null : "fx:id=\"searchTermLabel\" was not injected: check your FXML file 'searchView.fxml'.";
        assert filterTitleLabel != null : "fx:id=\"filterTitleLabel\" was not injected: check your FXML file 'searchView.fxml'.";
        assert maxPriceField != null : "fx:id=\"maxPriceField\" was not injected: check your FXML file 'searchView.fxml'.";
        assert minPriceField != null : "fx:id=\"minPriceField\" was not injected: check your FXML file 'searchView.fxml'.";
        assert minMilesField != null : "fx:id=\"minMilesField\" was not injected: check your FXML file 'searchView.fxml'.";
        assert maxMilesField != null : "fx:id=\"maxMilesField\" was not injected: check your FXML file 'searchView.fxml'.";
        assert manufacturerMenu != null : "fx:id=\"manufacturerMenu\" was not injected: check your FXML file 'searchView.fxml'.";
        assert modelMenu != null : "fx:id=\"modelMenu\" was not injected: check your FXML file 'searchView.fxml'.";
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
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'searchView.fxml'.";
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
