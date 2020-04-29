/**
 * Sample Skeleton for 'messageView.fxml' Controller Class
 */

package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import model.User;

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

    private User activeUser;
    
    @FXML
    void discardMessage(ActionEvent event) {

    }

    @FXML
    void sendMessage(ActionEvent event) {

    }

    @FXML
    void setRecipient(KeyEvent event) {

    }

    @FXML
    void toPrevious(ActionEvent event) {

    }

    @FXML
    void updateBody(KeyEvent event) {

    }

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

    }
}
