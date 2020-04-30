/**
 * Sample Skeleton for 'messageView.fxml' Controller Class
 */

package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Message;
import model.User;
import org.controlsfx.control.textfield.TextFields;

public class messageController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="recipientUser"
    private TextField recipientUser; // Value injected by FXMLLoader

    @FXML // fx:id="messageBody"
    private TextArea messageBody; // Value injected by FXMLLoader

    @FXML // fx:id="delete"
    private Button delete; // Value injected by FXMLLoader

    @FXML // fx:id="sendButton"
    private Button sendButton; // Value injected by FXMLLoader

    @FXML // fx:id="back"
    private Button back; // Value injected by FXMLLoader
    
    @FXML
    private SplitPane messagePane;
    
    @FXML
    private Tab messageTab;

    private User activeUser;
    private Scene previousScene;
    private Message createdMessage;
    private EntityManager manager;
    
    @FXML //Clear text box
    void discardMessage(ActionEvent event) {
        recipientUser.setText("");
        messageBody.setText("");
    }

    @FXML // Store a new Message in DB
    void sendMessage(ActionEvent event) {
        
        this.createdMessage = new Message();
        createdMessage.setRecipient(recipientUser.getText());
        createdMessage.setSender(activeUser.getUsername());
        createdMessage.setMessageBody(messageBody.getText());
        Date dt = new Date(System.currentTimeMillis());
        createdMessage.setTimeSent(dt);
        
        List<Message> data  = manager.createNamedQuery("Message.findAll").getResultList();
        int last_id = data.size();
        createdMessage.setMessageID((last_id + 1) + "");
        
        manager.getTransaction().begin();
        manager.persist(createdMessage);
        manager.getTransaction().commit();
        
        // Give confirmation and reset the text fields
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setContentText("Your message has been sent!");
        alert.showAndWait();
        
        recipientUser.setText("");
        messageBody.setText("");

    }

    @FXML // View messages addressed to current user
    void loadMessages(ActionEvent event) {
        // Not working
//        List<Message> data = manager.createNamedQuery("Message.findAll").getResultList();
//        ArrayList<Message> matching = new ArrayList<Message>();
//        for (Message msg: data)
//        {
//            if (msg.getRecipient() == activeUser.getUsername())
//            {
//                matching.add(msg);
//            }
//        }
//        
//        for (Message msg: matching)
//        {
//            System.out.println(msg.getMessageBody());
//        }
        
        
    }
    
    @FXML
    void setRecipient(KeyEvent event) {
        
    }

    @FXML // Return to previous view
    void toPrevious(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (previousScene != null){
            stage.setScene(previousScene);
        }
    }

    @FXML
    void updateBody(KeyEvent event) {
        
    }
    
    // Should be called from anywhere messageView is entered
    public void setPreviousScene(Scene scene) {
        previousScene = scene;
        back.setDisable(false);
    } 
    
    // Called from sellerController, buyerController, mainController
    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert recipientUser != null : "fx:id=\"recipientUser\" was not injected: check your FXML file 'messageView.fxml'.";
        assert messageBody != null : "fx:id=\"messageBody\" was not injected: check your FXML file 'messageView.fxml'.";
        assert delete != null : "fx:id=\"delete\" was not injected: check your FXML file 'messageView.fxml'.";
        assert sendButton != null : "fx:id=\"sendButton\" was not injected: check your FXML file 'messageView.fxml'.";
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'messageView.fxml'.";
        assert messagePane != null : "fx:id=\"messagePane\" was not injected: check your FXML file 'messageView.fxml'.";
        assert messageTab != null : "fx:id=\"messageTab\" was not injected: check your FXML file 'messageView.fxml'.";

        manager = (EntityManager) Persistence.createEntityManagerFactory("CarfolioPU").createEntityManager();
        
        // Auto-complete recipient field
        List<User> data  = manager.createNamedQuery("User.findAll").getResultList();
        ArrayList<String> suggestions = new ArrayList<>();
        for (User model : data) {
            suggestions.add(model.getUsername());
        }
        TextFields.bindAutoCompletion(recipientUser, suggestions);
    }
}
