/**
 * Sample Skeleton for 'loginView.fxml' Controller Class
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
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.User;


public class loginController {

    
    
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="forgotPasswordLink"
    private Hyperlink forgotPasswordLink; // Value injected by FXMLLoader

    @FXML // fx:id="existingUsername"
    private TextField existingUsername; // Value injected by FXMLLoader

    @FXML // fx:id="existingPassword"
    private PasswordField existingPassword; // Value injected by FXMLLoader

    @FXML // fx:id="loginButton"
    private Button loginButton; // Value injected by FXMLLoader

    @FXML
    private Label accountNotFound;
    
    @FXML // fx:id="createAccountButton"
    private Button createAccountButton; // Value injected by FXMLLoader

    @FXML // fx:id="strengthBar"
    private ProgressBar strengthBar; // Value injected by FXMLLoader

    @FXML // fx:id="accountSelector"
    private MenuButton accountSelector; // Value injected by FXMLLoader

    @FXML // fx:id="buyerSelected"
    private MenuItem buyerSelected; // Value injected by FXMLLoader

    @FXML // fx:id="sellerSelected"
    private MenuItem sellerSelected; // Value injected by FXMLLoader

    @FXML // fx:id="usernameField"
    private TextField usernameField; // Value injected by FXMLLoader

    @FXML // fx:id="passwordField"
    private PasswordField passwordField; // Value injected by FXMLLoader

    @FXML // fx:id="firstNameField"
    private TextField firstNameField; // Value injected by FXMLLoader

    @FXML // fx:id="lastNameField"
    private TextField lastNameField; // Value injected by FXMLLoader
    
    @FXML
    private Label usernameExists;
    
    @FXML
    private Label failureToRegister;
    
    @FXML
    private Label accountCreated;
        
    private User newUser = new User();
    private User userLogin = new User();
    
    
 
    @FXML
    void createAccount(ActionEvent event) {
        if(verifyRegisterFields() == false) {
            failureToRegister.setVisible(true);
        } else if (verifyUsername(usernameField.getText()) == true) {
            usernameExists.setVisible(true);
        } else {
            createUser(newUser);
        }
    }
    

    @FXML
    void launchForgotPassword(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/resetPasswordView.fxml"));
        Parent reset = loader.load();
        Scene resetPwScene = new Scene(reset);
        resetPasswordController controller = loader.getController();
        Stage stage = new Stage();
        stage.setScene(resetPwScene);
        stage.show();
    }

    @FXML
    void login(ActionEvent event) throws IOException {
         if(verifyLoginFields() == false) {
            failureToRegister.setVisible(true);
        } else if(verifyUsername(existingUsername.getText()) == true) {
             signIn(existingUsername.getText(), existingPassword.getText(), event);
        }       
    }

    @FXML
    void setBuyerAccount(ActionEvent event) {
        accountSelector.setText("Buyer");
        newUser.setUserType("buyer");
    }

    @FXML
    void setFirstName(KeyEvent event) {
        newUser.setFirstName(firstNameField.getText());
    }

    @FXML
    void setLastName(KeyEvent event) {
        newUser.setLastName(lastNameField.getText());
    }

    @FXML
    void setLoginPassword(KeyEvent event) {
        userLogin.setPassword(existingPassword.getText());
    }

    @FXML
    void setLoginUsername(KeyEvent event) {
        userLogin.setUsername(existingUsername.getText());
    }

    @FXML
    void setPassword(KeyEvent event) {
        newUser.setPassword(passwordField.getText());
    }

    @FXML
    void setSellerAccount(ActionEvent event) {
        accountSelector.setText("Seller");
        newUser.setUserType("seller");
    }   

    @FXML
    void setUserName(KeyEvent event) {
        newUser.setUsername(usernameField.getText());
    }

    public boolean verifyRegisterFields(){
        String fName = firstNameField.getText();
        String lName = lastNameField.getText();
        String uName = usernameField.getText();
        String pw = passwordField.getText();
        String typeSelected = accountSelector.getText();
        return !(fName.trim().equals("") || lName.trim().equals("") || uName.trim().equals("") || pw.trim().equals("") || null == typeSelected);
    }
    
    public boolean verifyLoginFields() {
        String uName = existingUsername.getText();
        String pw = existingPassword.getText();
        return !(uName.trim().equals("") || pw.trim().equals(""));
    }
    
    EntityManager em;
    
    public void createUser(User user) {
        try {
            em.getTransaction().begin();
            if (user.getUsername() != null) {
                em.persist(user);
                em.getTransaction().commit();
                usernameExists.setVisible(false);
                failureToRegister.setVisible(false);
                accountCreated.setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void signIn(String username, String password, ActionEvent e) throws IOException {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE  u.username = :username AND u.password = :password", User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        try {
            switch(query.getSingleResult().getUserType()) {
                case 0: // Admin
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/mainView.fxml"));
                    Parent main = loader.load();
                    Scene adminUI = new Scene(main);
                    mainController controller = loader.getController();
                    controller.setActiveUser(userLogin);
                    controller.setGreeting("Hello, " + username +"!");
                    Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    window.setScene(adminUI);
                    window.show();
                    break;
                case 1: // Seller
                    FXMLLoader sellerLoader = new FXMLLoader(getClass().getResource("/view/sellerView.fxml"));
                    Parent seller = sellerLoader.load();
                    Scene sellerUI = new Scene(seller);
                    sellerController sController = sellerLoader.getController();
                    sController.setActiveUser(userLogin);
                    sController.setGreeting();
                    Stage sellerWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    sellerWindow.setScene(sellerUI);
                    sellerWindow.show();
                    break;
                case 2:
                    FXMLLoader buyerLoader = new FXMLLoader(getClass().getResource("/view/buyerView.fxml"));
                    Parent buyer = buyerLoader.load();
                    Scene buyerUI = new Scene(buyer);
                    buyerController bController = buyerLoader.getController();
                    bController.setActiveUser(userLogin);
                    bController.setGreeting();
                    Stage buyerWindow = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    buyerWindow.setScene(buyerUI);
                    buyerWindow.show();
                    break;
                default:
                    System.out.println("Error switching scenes");
                    break;
            }   
        } catch (Exception ex) {
            System.out.println(ex);
            accountNotFound.setVisible(true);
        }
    }
    
    
    
        
    public boolean verifyUsername(String username) {
        Query query = em.createNamedQuery("User.findByUsername");
        query.setParameter("username", username);
        try {
            Object result = query.getSingleResult();
            return true;
        } catch(NoResultException e) {
            e.getMessage();
            return false;
        } 
    }
    

    
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert forgotPasswordLink != null : "fx:id=\"forgotPasswordLink\" was not injected: check your FXML file 'loginView.fxml'.";
        assert existingUsername != null : "fx:id=\"existingUsername\" was not injected: check your FXML file 'loginView.fxml'.";
        assert existingPassword != null : "fx:id=\"existingPassword\" was not injected: check your FXML file 'loginView.fxml'.";
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'loginView.fxml'.";
        assert accountNotFound != null : "fx:id=\"accountNotFound\" was not injected: check your FXML file 'loginView.fxml'.";
        assert createAccountButton != null : "fx:id=\"createAccountButton\" was not injected: check your FXML file 'loginView.fxml'.";
        assert strengthBar != null : "fx:id=\"strengthBar\" was not injected: check your FXML file 'loginView.fxml'.";
        assert accountSelector != null : "fx:id=\"accountSelector\" was not injected: check your FXML file 'loginView.fxml'.";
        assert buyerSelected != null : "fx:id=\"buyerSelected\" was not injected: check your FXML file 'loginView.fxml'.";
        assert sellerSelected != null : "fx:id=\"sellerSelected\" was not injected: check your FXML file 'loginView.fxml'.";
        assert usernameField != null : "fx:id=\"usernameField\" was not injected: check your FXML file 'loginView.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'loginView.fxml'.";
        assert firstNameField != null : "fx:id=\"firstNameField\" was not injected: check your FXML file 'loginView.fxml'.";
        assert lastNameField != null : "fx:id=\"lastNameField\" was not injected: check your FXML file 'loginView.fxml'.";
        assert usernameExists != null : "fx:id=\"usernameExists\" was not injected: check your FXML file 'loginView.fxml'.";
        assert failureToRegister != null : "fx:id=\"failureToRegister\" was not injected: check your FXML file 'loginView.fxml'.";
        assert accountCreated != null : "fx:id=\"accountCreated\" was not injected: check your FXML file 'loginView.fxml'.";

        em = (EntityManager) Persistence.createEntityManagerFactory("CarfolioPU").createEntityManager();
        
    }
    
    
    
}