/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Sample Skeleton for 'wireframe.fxml' Controller Class
 */

package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;

public class scraperController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="toggleStyle"
    private CheckBox toggleStyle; // Value injected by FXMLLoader

    @FXML // fx:id="toggleVIN"
    private CheckBox toggleVIN; // Value injected by FXMLLoader

    @FXML // fx:id="toggleModel"
    private CheckBox toggleModel; // Value injected by FXMLLoader

    @FXML // fx:id="toggleMiles"
    private CheckBox toggleMiles; // Value injected by FXMLLoader

    @FXML // fx:id="toggleMake"
    private CheckBox toggleMake; // Value injected by FXMLLoader

    @FXML // fx:id="toggleYear"
    private CheckBox toggleYear; // Value injected by FXMLLoader

    @FXML // fx:id="progressBar"
    private ProgressBar progressBar; // Value injected by FXMLLoader

    @FXML // fx:id="startButton"
    private Button startButton; // Value injected by FXMLLoader

    @FXML // fx:id="urlSelecor"
    private ChoiceBox<?> urlSelecor; // Value injected by FXMLLoader

    @FXML // fx:id="urlSelectorLabel"
    private Label urlSelectorLabel; // Value injected by FXMLLoader

    @FXML // fx:id="progressLabel"
    private Label progressLabel; // Value injected by FXMLLoader

    @FXML // fx:id="scraperViewTitle"
    private Label scraperViewTitle; // Value injected by FXMLLoader

    @FXML // fx:id="vinColumn"
    private TableColumn<?, ?> vinColumn; // Value injected by FXMLLoader

    @FXML // fx:id="makeColumn"
    private TableColumn<?, ?> makeColumn; // Value injected by FXMLLoader

    @FXML // fx:id="modelColumn"
    private TableColumn<?, ?> modelColumn; // Value injected by FXMLLoader

    @FXML // fx:id="styleColumn"
    private TableColumn<?, ?> styleColumn; // Value injected by FXMLLoader

    @FXML // fx:id="yearColumn"
    private TableColumn<?, ?> yearColumn; // Value injected by FXMLLoader

    @FXML // fx:id="milesColumn"
    private TableColumn<?, ?> milesColumn; // Value injected by FXMLLoader

    @FXML
    void initializeScrape(ActionEvent event) {

    }

    @FXML
    void makeRequired(ActionEvent event) {

    }

    @FXML
    void milesRequired(ActionEvent event) {

    }

    @FXML
    void modelRequired(ActionEvent event) {

    }

    @FXML
    void openUrlSelector(MouseEvent event) {

    }

    @FXML
    void startScrape(MouseEvent event) {

    }

    @FXML
    void styleRequired(ActionEvent event) {

    }

    @FXML
    void vinRequired(ActionEvent event) {

    }

    @FXML
    void yearRequired(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert toggleStyle != null : "fx:id=\"toggleStyle\" was not injected: check your FXML file 'wireframe.fxml'.";
        assert toggleVIN != null : "fx:id=\"toggleVIN\" was not injected: check your FXML file 'wireframe.fxml'.";
        assert toggleModel != null : "fx:id=\"toggleModel\" was not injected: check your FXML file 'wireframe.fxml'.";
        assert toggleMiles != null : "fx:id=\"toggleMiles\" was not injected: check your FXML file 'wireframe.fxml'.";
        assert toggleMake != null : "fx:id=\"toggleMake\" was not injected: check your FXML file 'wireframe.fxml'.";
        assert toggleYear != null : "fx:id=\"toggleYear\" was not injected: check your FXML file 'wireframe.fxml'.";
        assert progressBar != null : "fx:id=\"progressBar\" was not injected: check your FXML file 'wireframe.fxml'.";
        assert startButton != null : "fx:id=\"startButton\" was not injected: check your FXML file 'wireframe.fxml'.";
        assert urlSelecor != null : "fx:id=\"urlSelecor\" was not injected: check your FXML file 'wireframe.fxml'.";
        assert urlSelectorLabel != null : "fx:id=\"urlSelectorLabel\" was not injected: check your FXML file 'wireframe.fxml'.";
        assert progressLabel != null : "fx:id=\"progressLabel\" was not injected: check your FXML file 'wireframe.fxml'.";
        assert scraperViewTitle != null : "fx:id=\"scraperViewTitle\" was not injected: check your FXML file 'wireframe.fxml'.";
        assert vinColumn != null : "fx:id=\"vinColumn\" was not injected: check your FXML file 'wireframe.fxml'.";
        assert makeColumn != null : "fx:id=\"makeColumn\" was not injected: check your FXML file 'wireframe.fxml'.";
        assert modelColumn != null : "fx:id=\"modelColumn\" was not injected: check your FXML file 'wireframe.fxml'.";
        assert styleColumn != null : "fx:id=\"styleColumn\" was not injected: check your FXML file 'wireframe.fxml'.";
        assert yearColumn != null : "fx:id=\"yearColumn\" was not injected: check your FXML file 'wireframe.fxml'.";
        assert milesColumn != null : "fx:id=\"milesColumn\" was not injected: check your FXML file 'wireframe.fxml'.";

    }
}
