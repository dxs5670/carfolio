/*
    This is the loginContoller that is paired with the loginView.fxml class. 
    The login controller has several responsibilities: registering a new user,
    logging in an existing user, and providing access to multiple different 
    views. 

    These views include the mainView (admin), buyerView (buyer), sellerView
    (seller), and a forgotPassword view. Each can be found in the view package
    of this application.

    A user is redirected to the login view when logging out from account view. 
    Since everything that this application does is account-based, it is 
    necessary that a user is presented with the login page before any other 
    views are accessed.

    The login view features some input validation, which will hide and show 
    differnet JLabels that inform the user what went wrong while trying to login
    or signup for an account.
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
    private Hyperlink forgotPasswordLink;

    @FXML // fx:id="existingUsername"
    private TextField existingUsername;

    @FXML // fx:id="existingPassword"
    private PasswordField existingPassword;

    @FXML // fx:id="loginButton"
    private Button loginButton;

    @FXML // fx:id="accountNotFound"
    private Label accountNotFound;
    
    @FXML // fx:id="createAccountButton"
    private Button createAccountButton;

    @FXML // fx:id="strengthBar"
    private ProgressBar strengthBar;

    @FXML // fx:id="accountSelector"
    private MenuButton accountSelector;

    @FXML // fx:id="buyerSelected"
    private MenuItem buyerSelected;

    @FXML // fx:id="sellerSelected"
    private MenuItem sellerSelected;

    @FXML // fx:id="usernameField"
    private TextField usernameField;

    @FXML // fx:id="passwordField"
    private PasswordField passwordField;

    @FXML // fx:id="firstNameField"
    private TextField firstNameField;

    @FXML // fx:id="lastNameField"
    private TextField lastNameField;
    
    @FXML // fx:id="usernameExists"
    private Label usernameExists;
    
    @FXML // fx:id="failureToRegister"
    private Label failureToRegister;
    
    @FXML // fx:id="accountCreated"
    private Label accountCreated;
    

    // newUser is used for registering an account
    private User newUser = new User();
    
    // userLogin is used for logging into an existing account
    private User userLogin = new User();
    
    // EntityManager em is used for finding users from persistence queries
    private EntityManager em;
    
    /*
    The setLoginPassword function sets the userLogin password to the text 
    contained in existingPassword whenever a key is pressed 
    */
    @FXML
    void setLoginPassword(KeyEvent event) {
        userLogin.setPassword(existingPassword.getText());
    }
    
    /*
    The setLoginUsername function sets the userLogin username to the text 
    contained in existingUsername whenever a key is pressed 
    */
    @FXML
    void setLoginUsername(KeyEvent event) {
        userLogin.setUsername(existingUsername.getText());
    }
    
    /*
    The login function corresponds wth the Button loginButton. When clicked, it
    calls function verifyLoginFields to check that each login field is filled. 
    If not, it will didsplay an error message contained in the failureToRegister
    Label. 
    
    If the loginFields are filled, the function then calls the verify username
    function and checks for an existing user with that username. The signIn 
    function is then called, passing the strings found in the existingUsername 
    and existingPassword field as parameters.
    */
    @FXML
    void login(ActionEvent event) throws IOException {
         if(verifyLoginFields() == false) {
            failureToRegister.setVisible(true);
        } else if(verifyUsername(existingUsername.getText()) == true) {
             signIn(existingUsername.getText(), existingPassword.getText(), event);
        }       
    }
    
    // This function returns false if any of the login fields are empty    
    public boolean verifyLoginFields() {
        String uName = existingUsername.getText();
        String pw = existingPassword.getText();
        return !(uName.trim().equals("") || pw.trim().equals(""));
    }
    
    // Launch the resetPassword view when the forgotPasswordLink is clicked
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
    
    /*
    The verifyUsername function takes in a username as a String to locate 
    a user with that username in the linked database using EntityManager em
    and NamedQuery User.findByUsername with the username as the set parameter.
    
    If a user is found, it returns true. If not, it returns false by catching 
    an error that is thrown by the getSingleResult function
    */    
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

    /*
    The signIn function searches for a user using a typed query and setting
    the parameters for the query to the username and password parameters 
    passed to the signIn function. 

    It then serves the next page depending on the userType of the user it
    finds, sets the activeUser on these pages to the userLogin and sets the
    next page's greeting to include the name of the activeUser.

    The function will catch an error if the account with the given 
    credentials is not found and display an error message with the 
    accountNotFound label. 
    */
    public void signIn(String username, String password, ActionEvent e) throws IOException {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE  u.username = :username AND u.password = :password", User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        try {
            switch(query.getSingleResult().getUserType()) {
                case 0:
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
                case 1:
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
    
    /*
    The setFirstName function sets the newUser firstName to the text contained
    in firstNameField whenever a key is pressed 
    */
    @FXML
    void setFirstName(KeyEvent event) {
        newUser.setFirstName(firstNameField.getText());
    }    
    
    /*
    The setLastName function sets the newUser lastName to the text contained
    in lastNameField whenever a key is pressed 
    */
    @FXML
    void setLastName(KeyEvent event) {
        newUser.setLastName(lastNameField.getText());
    }    
    
    /*
    The setUserName function sets the newUser username to the text contained
    in usernameField whenever a key is pressed 
    */    
    @FXML
    void setUserName(KeyEvent event) {
        newUser.setUsername(usernameField.getText());
    }  
    
    /*
    The setPasssword function sets the newUser password to the text contained
    in passwordField whenever a key is pressed 
    */
    @FXML
    void setPassword(KeyEvent event) {
        newUser.setPassword(passwordField.getText());
    }    
    
    /*
    When the sellerSelect MenuItem is pressed, the setSellerAccount function 
    sets the MenuButton text and the newUser's userType to seller
    */    
    @FXML
    void setSellerAccount(ActionEvent event) {
        accountSelector.setText("Seller");
        newUser.setUserType("seller");
    }       
    
    /* 
    When the buyerSelect MenuItem is pressed, the setBuyerAccount function 
    sets the MenuButton text and the newUser's userType to buyer
    */
    @FXML
    void setBuyerAccount(ActionEvent event) {
        accountSelector.setText("Buyer");
        newUser.setUserType("buyer");
    }

    // Uses EntityManager em to commit a new user to the database
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
    
    /* 
    The createAccount function corresponds with the Button 
    createAccountButton. 
    
    When the button is clicked, the function checks to see
    that the required register fields are filled out with the 
    verifyRegisterFields() function. 
    
    If the function returns false, it will set the failureToRegisster Label 
    visible.
    
    Then, the function checks if the username already exists with the 
    verifyUsername() function. If the username does already exist, a new error 
    message contained in the Label usernameExists is set to visible.
    
    If the fields are filled out and the username does not exist, 
    the createUser() function is called and the new user is created.
    */
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
        
    // This function returns false if any of the registration fields are empty
    public boolean verifyRegisterFields(){
        String fName = firstNameField.getText();
        String lName = lastNameField.getText();
        String uName = usernameField.getText();
        String pw = passwordField.getText();
        String typeSelected = accountSelector.getText();
        return !(fName.trim().equals("") || lName.trim().equals("") || uName.trim().equals("") || pw.trim().equals("") || null == typeSelected);
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