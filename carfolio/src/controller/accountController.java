/*
    The account controller has a few responsibilities: Updating the activeUser's
    account, logging the user out and deleting the user's account are the main
    functionality.

    However, one additional feature that is to be added is stars that correspond 
    to a user's userRating. The stars would be set to visible based on the value
    of the user rating.
*/

package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import model.User;

public class accountController {
    
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="firstName"
    private TextField firstName;

    @FXML // fx:id="lastName"
    private TextField lastName;

    @FXML // fx:id="username"
    private TextField username;

    @FXML // fx:id="password"
    private PasswordField password;

    @FXML // fx:id="confirmPassword"
    private PasswordField confirmPassword;

    @FXML // fx:id="updateAccount"
    private Button updateAccount;

    @FXML // fx:id="signOutButton"
    private Button signOutButton;

    @FXML // fx:id="deleteAccountButton"
    private Button deleteAccountButton;

    @FXML // fx:id="star1"
    private SVGPath star1;

    @FXML // fx:id="star2"
    private SVGPath star2;

    @FXML // fx:id="star3"
    private SVGPath star3;

    @FXML // fx:id="star4"
    private SVGPath star4;

    @FXML // fx:id="star5"
    private SVGPath star5;

    @FXML // fx:id="accountType"
    private Label accountType;
   
    @FXML // fx:id="noMatch"
    private Label noMatch;

    @FXML // fx:id="backButton"
    private Button backButton;
    
    
    // Used for deleting and updating the active user
    private EntityManager em;
    // The scene that accessed accountView
    private Scene previousScene;
    //the lpgged-in user
    private User activeUser;
    // firstName field
    private String fn;
    // lastName field
    private String ln;
    // username field
    private String un;
    // password field
    private String pw;
    //confirm password field
    private String cp;
    
    
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
    setPreviousScene enures Button backButton is enabled and sets
    the previousScene variable to the Scene parameter scene
    */    
    public void setPreviousScene(Scene scene) {
        previousScene = scene;
        backButton.setDisable(false);
    } 
    
    // Set the variable fn to the text from Field firstName on keypress
    @FXML
    void setFirst(KeyEvent event) {
        fn = firstName.getText();
    }

    // Set the variable ln to the text from Field lastName on keypress
    @FXML
    void setLast(KeyEvent event) {
        ln = lastName.getText();
    }
    
    // Set the variable un to the text from Field username on keypress
    @FXML
    void setUsername(KeyEvent event) {
        un = username.getText();
    }
    
    // Set the variable pw to the text from Field password on keypress
    @FXML
    void setPassword(KeyEvent event) {
        pw = password.getText();
    }
    
    // Set the variable cp to the text from Field confirmPassword on keypress
    @FXML
    void setConfirmPassword(KeyEvent event) {
        cp = confirmPassword.getText();
    }

    /*
    Update user updates activeUser's information based on the variables fn, ln,
    un, and pw.
    
    It will only update the user if the password equals confirm password and 
    the user can be found in the database. 
    
    Then, the function loads the loginUI after User activeUser has been updated. 
    */
    @FXML
    void updateUser(ActionEvent event) throws IOException {
    
        try {

         User toUpdate = em.find(User.class, activeUser.getUsername());

            if (toUpdate != null && (pw == null ? cp == null : pw.equals(cp))) {
                em.getTransaction().begin();
                // update
                activeUser.setFirstName(fn);
                activeUser.setLastName(ln);
                activeUser.setUsername(un);
                activeUser.setPassword(pw);
                em.getTransaction().commit();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/loginView.fxml"));
            Parent login = loader.load();
            Scene loginUI = new Scene(login);
            loginController controller = loader.getController();
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(loginUI);
            window.show();
         }
    }    

    // Function signOut opens the logIn view in place of the current window
    @FXML
    void signOut(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/loginView.fxml"));
        Parent login = loader.load();
        Scene loginUI = new Scene(login);
        loginController controller = loader.getController();
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginUI);
        window.show();
    }

    /*
    The deleteAccount function will delete User activeUser's account as long as 
    a user is found with the username of activeUser
    */
    @FXML
    void deleteAccount(ActionEvent event) {
        try {
            User toRemove = em.find(User.class, activeUser.getUsername());
            if (toRemove != null) {
                em.getTransaction().begin();
                em.remove(toRemove);
                em.getTransaction().commit();
            }    
        } catch (Exception e) {
                System.out.println(e.getMessage());
        }
            
    }    


    
    // Function used for setting the User activeUser when directed to this page
    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
        updateActiveUser();
    }
    
    // Function used for setting the label Greeting as text specified in login    
    public void updateActiveUser() {
        username.setText(activeUser.getUsername());
        firstName.setText(activeUser.getFirstName());
        lastName.setText(activeUser.getLastName());
        switch(activeUser.getUserType()) {
            case (0): 
                accountType.setText("Admin Rating");
                break;
            case (1):
                accountType.setText("Seller Rating");
                break;
            case (2):
                accountType.setText("Buyer Rating");
                break;
        }
    }
    
    
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert firstName != null : "fx:id=\"firstName\" was not injected: check your FXML file 'accountView.fxml'.";
        assert lastName != null : "fx:id=\"lastName\" was not injected: check your FXML file 'accountView.fxml'.";
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'accountView.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'accountView.fxml'.";
        assert confirmPassword != null : "fx:id=\"confirmPassword\" was not injected: check your FXML file 'accountView.fxml'.";
        assert updateAccount != null : "fx:id=\"updateAccount\" was not injected: check your FXML file 'accountView.fxml'.";
        assert signOutButton != null : "fx:id=\"signOutButton\" was not injected: check your FXML file 'accountView.fxml'.";
        assert deleteAccountButton != null : "fx:id=\"deleteAccountButton\" was not injected: check your FXML file 'accountView.fxml'.";
        assert star1 != null : "fx:id=\"star1\" was not injected: check your FXML file 'accountView.fxml'.";
        assert star2 != null : "fx:id=\"star2\" was not injected: check your FXML file 'accountView.fxml'.";
        assert star3 != null : "fx:id=\"star3\" was not injected: check your FXML file 'accountView.fxml'.";
        assert star4 != null : "fx:id=\"star4\" was not injected: check your FXML file 'accountView.fxml'.";
        assert star5 != null : "fx:id=\"star5\" was not injected: check your FXML file 'accountView.fxml'.";
        assert accountType != null : "fx:id=\"accountType\" was not injected: check your FXML file 'accountView.fxml'.";
        assert noMatch != null : "fx:id=\"noMatch\" was not injected: check your FXML file 'accountView.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'accountView.fxml'.";


        em = (EntityManager) Persistence.createEntityManagerFactory("CarfolioPU").createEntityManager();

    }
}
