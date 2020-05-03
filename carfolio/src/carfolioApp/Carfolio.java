/*
    The main logic for staring the Carfolio application. The app launches the 
    JavaFX view "loginView", found in the view package. A user may then register
    or login if they have an account. 

    After logging in, a user will be sent to whichever view corresponds 
    with their userType (sellers served sellerView, buyers buyerView, and 
    administrators mainView). From there, the user will find a select and 
    mostly distinct group of actions they can participate in.

    Sellers will be presented with several inputs for adding information on 
    the car they wish to sell. All of the data they will submit corresponds
    to attributes from the Car class found in the model package. They can also
    access their messages from the button labeled messages, edit their account 
    information or logout from the button labeled account, or view
    their cars as well as see what offers have been recieved from their 
    "portfolio," which can be accessed usign the button labeled "portfolios".

    Buyers maintain the functionality of accessing messages and their account 
    with similarly-labeled buttons. However, they no longer have a portfolio 
    to access or fields of attributes to fill out. Instead, they are greeted
    with a search button and have access to an entirely new view, searchView,
    which allows them to browse available cars, send messages to the sellers 
    and make offers on a vehicle. This view can be accessed directly by clicking
    the button labeled advanced search.

    Administrators see a combination of both UI and functionality as well as a 
    new view for a web scraper. While the scraper is currently under development,
    it will be able to search for car data and submit it (or use it to find 
    advanced analytics to help assist buyers). Administrators maintain all 
    functionality from both the buyer and seller.
*/


package carfolioApp;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Carfolio extends Application
{
    public static void main(String[] args) 
    {
        launch(args);
    }
    
 
    @Override
    public void start(Stage primaryStage) throws Exception 
    {                                
      // Load loginView upon running the application
      Parent root = FXMLLoader.load(getClass().getResource("/view/loginView.fxml")); 
      Scene scene = new Scene(root);
      primaryStage.setScene(scene);
      primaryStage.show();
    }
    
}
