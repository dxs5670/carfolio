/**
 * Sample Skeleton for 'resetPasswordView.fxml' Controller Class
 */

package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.User;

public class resetPasswordController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="existingUser"
    private TextField existingUser; // Value injected by FXMLLoader

    @FXML // fx:id="resetPW"
    private PasswordField resetPW; // Value injected by FXMLLoader

    @FXML // fx:id="confirmResetPW"
    private PasswordField confirmResetPW; // Value injected by FXMLLoader

    @FXML // fx:id="submitChanges"
    private Button submitChanges; // Value injected by FXMLLoader

    @FXML // fx:id="success"
    private Label success; // Value injected by FXMLLoader

    @FXML
    private Label failConfirm;

    @FXML
    private Label failComplete;
    
    @FXML
    private Label notFound;
    
    private EntityManager em;
    private String user;
    private String pw;
    private String confirm;

    @FXML
    void setConfrimPW(KeyEvent event) {
        confirm = confirmResetPW.getText();
    }

    @FXML
    void setExistingUser(KeyEvent event) {
        user = existingUser.getText();
    }

    @FXML
    void setPW(KeyEvent event) {
        pw = resetPW.getText();
    }

    @FXML
    void updatePassword(ActionEvent event) {
        TypedQuery<User> find = em.createQuery("SELECT u FROM User u WHERE  u.username = :username", User.class);
        
        if (!"".equals(pw) && !"".equals(user)) {
            try {
                if (pw.equals(confirm)) {
                    User foundUser = find.setParameter("username", user).getSingleResult();
                    foundUser.setPassword(pw);
                    em.persist(foundUser);
                    em.getTransaction().commit();
                    success.setVisible(true);
                } else {
                    System.out.println("Passwords do not match");
                    success.setVisible(false);
                    failComplete.setVisible(false);
                    notFound.setVisible(false);
                    failConfirm.setVisible(true);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                success.setVisible(false);
                failComplete.setVisible(false);
                failConfirm.setVisible(false);
                notFound.setVisible(true);
            }
        } else {
            System.out.println("Fields cannot be empty");
            success.setVisible(false);
            failConfirm.setVisible(false);
            notFound.setVisible(false);
            failComplete.setVisible(true);
            
        }
    }
    

    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert existingUser != null : "fx:id=\"existingUser\" was not injected: check your FXML file 'resetPasswordView.fxml'.";
        assert resetPW != null : "fx:id=\"resetPW\" was not injected: check your FXML file 'resetPasswordView.fxml'.";
        assert confirmResetPW != null : "fx:id=\"confirmResetPW\" was not injected: check your FXML file 'resetPasswordView.fxml'.";
        assert submitChanges != null : "fx:id=\"submitChanges\" was not injected: check your FXML file 'resetPasswordView.fxml'.";
        assert success != null : "fx:id=\"success\" was not injected: check your FXML file 'resetPasswordView.fxml'.";
        assert failConfirm != null : "fx:id=\"failConfirm\" was not injected: check your FXML file 'resetPasswordView.fxml'.";
        assert failComplete != null : "fx:id=\"failComplete\" was not injected: check your FXML file 'resetPasswordView.fxml'.";
        assert notFound != null : "fx:id=\"notFound\" was not injected: check your FXML file 'resetPasswordView.fxml'.";

        em = (EntityManager) Persistence.createEntityManagerFactory("CarfolioPU").createEntityManager();
    }
}
