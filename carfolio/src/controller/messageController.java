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

public class messageController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="backButton"
    private Button backButton; // Value injected by FXMLLoader

    @FXML // fx:id="sendButton"
    private Button sendButton; // Value injected by FXMLLoader

    @FXML // fx:id="messageField"
    private TextArea messageField; // Value injected by FXMLLoader

    @FXML // fx:id="recipientField"
    private TextField recipientField; // Value injected by FXMLLoader

    @FXML
    void backClicked(ActionEvent event) {

    }

    @FXML
    void sendClicked(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'messageView.fxml'.";
        assert sendButton != null : "fx:id=\"sendButton\" was not injected: check your FXML file 'messageView.fxml'.";
        assert messageField != null : "fx:id=\"messageField\" was not injected: check your FXML file 'messageView.fxml'.";
        assert recipientField != null : "fx:id=\"recipientField\" was not injected: check your FXML file 'messageView.fxml'.";

    }
}
