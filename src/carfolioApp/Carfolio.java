
package carfolioApp;



import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


/**
 *
 * @author Dstet
 */
public class Carfolio extends Application
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception 
    {                                
        //JavaFX stuff   
      Parent root = FXMLLoader.load(getClass().getResource("/view/mainView.fxml")); 
      Scene scene = new Scene(root);
      primaryStage.setScene(scene);
      primaryStage.show();
    }
    
}
