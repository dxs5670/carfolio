/*
    This class supports messageView, which is accessable by all types of accounts 
    from their respective controllers. It's a tabbed interface that allows for 
    composing messages to other users of the application, as well as viewing 
    those addressed to the current one. 

    The reply function is unfinished, but users can always compose another message.
 */

package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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

    @FXML // Message history tab
    private Tab history;

    @FXML // fx:id="clickedMessageBody"
    private TextArea clickedMessageBody; // Value injected by FXMLLoader

    @FXML // fx:id="replyButton"
    private Button replyButton; // Value injected by FXMLLoader
    
    @FXML // fx:id="messageTable"
    private TableView<Message> messageTable; // Value injected by FXMLLoader

    @FXML // fx:id="from"
    private TableColumn<Message, String> from; // Value injected by FXMLLoader

    @FXML // fx:id="recieved"
    private TableColumn<Message, Date> recieved; // Value injected by FXMLLoader

    private User activeUser;
    private Scene previousScene;
    private Message createdMessage;
    private EntityManager manager;

    @FXML // Clear message body & recipient
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

    // For replying
    @FXML
    void sendMessageToSelected(ActionEvent event) {
        
    }

    // Unused
    @FXML
    void setRecipient(KeyEvent event) {
        
    }

    // Go back to the last screen
    @FXML
    void toPrevious(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (previousScene != null){
            stage.setScene(previousScene);
        }
    }

    // Unused
    @FXML
    void updateBody(KeyEvent event) {
        
    }
    
    // Called upon clicking the Message History tab
    @FXML
    void readMessages(Event event) {
        retrieveMessages();
        
    }
    
    // Unused
    @FXML
    void findRow(MouseEvent event) {
        
    }

    
    public void setMessageRecipient(String username) {
       recipientUser.setText(username);
    }
    
    // Should be called from anywhere messageView is entered
    public void setPreviousScene(Scene scene) {
        previousScene = scene;
        back.setDisable(false);
    } 
    
    // Called from sellerController, buyerController, mainController
    public void setActiveUser(User user) {
        activeUser = user;
    }
    
    // Show active user's messages
    public void retrieveMessages() {
        
        Query query = manager.createNamedQuery("Message.findByRecipient");
        query.setParameter("recipient", activeUser.getUsername());
        List<Message> data = query.getResultList();
        ObservableList<Message> odata = FXCollections.observableArrayList();
        data.forEach((d) -> {
            odata.add(d);
        });
    
        from.setCellValueFactory(new PropertyValueFactory<>("Sender"));
        recieved.setCellValueFactory(new PropertyValueFactory<>("TimeSent"));
        messageTable.setItems(odata);
        messageFromRow();
        
        
        
    }
    
    // Display message body on double click
    public void messageFromRow() {
        messageTable.setRowFactory( tv -> {
            TableRow<Message> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (! row.isEmpty() && event.getButton()==MouseButton.PRIMARY 
                    && event.getClickCount() == 2) {

                    Message clickedRow = row.getItem();
                    clickedMessageBody.setText(clickedRow.getMessageBody());
                    
                }
            });
            return row;
        });
    }
    
    // set back button invisible when opened from search
    public void setBackButtnInvisible() {
        back.setVisible(false);
    }
    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert recipientUser != null : "fx:id=\"recipientUser\" was not injected: check your FXML file 'messageView.fxml'.";
        assert messageBody != null : "fx:id=\"messageBody\" was not injected: check your FXML file 'messageView.fxml'.";
        assert delete != null : "fx:id=\"delete\" was not injected: check your FXML file 'messageView.fxml'.";
        assert sendButton != null : "fx:id=\"sendButton\" was not injected: check your FXML file 'messageView.fxml'.";
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'messageView.fxml'.";
        assert clickedMessageBody != null : "fx:id=\"clickedMessageBody\" was not injected: check your FXML file 'messageView.fxml'.";
        assert replyButton != null : "fx:id=\"replyButton\" was not injected: check your FXML file 'messageView.fxml'.";
        assert messageTable != null : "fx:id=\"messageTable\" was not injected: check your FXML file 'messageView.fxml'.";
        assert from != null : "fx:id=\"from\" was not injected: check your FXML file 'messageView.fxml'.";
        assert recieved != null : "fx:id=\"recieved\" was not injected: check your FXML file 'messageView.fxml'.";
        assert history != null : "fx:id=\"history\" was not injected: check your FXML file 'messageView.fxml'.";



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