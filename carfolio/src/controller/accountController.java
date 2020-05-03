/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import model.User;


public class accountController {
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="firstName"
    private TextField firstName; // Value injected by FXMLLoader

    @FXML // fx:id="lastName"
    private TextField lastName; // Value injected by FXMLLoader

    @FXML // fx:id="username"
    private TextField username; // Value injected by FXMLLoader

    @FXML // fx:id="password"
    private PasswordField password; // Value injected by FXMLLoader

    @FXML // fx:id="confirmPassword"
    private PasswordField confirmPassword; // Value injected by FXMLLoader

    @FXML // fx:id="updateAccount"
    private Button updateAccount; // Value injected by FXMLLoader

    @FXML // fx:id="signOutButton"
    private Button signOutButton; // Value injected by FXMLLoader

    @FXML // fx:id="deleteAccountButton"
    private Button deleteAccountButton; // Value injected by FXMLLoader

    @FXML // fx:id="star1"
    private SVGPath star1; // Value injected by FXMLLoader

    @FXML // fx:id="star2"
    private SVGPath star2; // Value injected by FXMLLoader

    @FXML // fx:id="star3"
    private SVGPath star3; // Value injected by FXMLLoader

    @FXML // fx:id="star4"
    private SVGPath star4; // Value injected by FXMLLoader

    @FXML // fx:id="star5"
    private SVGPath star5; // Value injected by FXMLLoader

    @FXML // fx:id="accountType"
    private Label accountType; // Value injected by FXMLLoader
   
    @FXML
    private Label noMatch;

    @FXML
    private Button backButton;
    
    private EntityManager em;
    private Scene previousScene;
    private User activeUser;
        
    private String fn;
    private String ln;
    private String un;
    private String pw;
    private String cp;
    
    
    
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
    

    @FXML
    void setConfirmPassword(KeyEvent event) {
        cp = confirmPassword.getText();
    }

    @FXML
    void setFirst(KeyEvent event) {
        fn = firstName.getText();
    }

    @FXML
    void setLast(KeyEvent event) {
        ln = lastName.getText();
    }

    @FXML
    void setPassword(KeyEvent event) {
        pw = password.getText();
    }

    @FXML
    void setUsername(KeyEvent event) {
        un = username.getText();
    }

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

    public void setPreviousScene(Scene scene) {
        previousScene = scene;
        backButton.setDisable(false);
    } 
    
    
    @FXML
    void toPrevious(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (previousScene != null){
            stage.setScene(previousScene);
        }
    }
    
    
    
    
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

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
        updateActiveUser();
    }
    
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


        
    }
}
