package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import model.Inventory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

public class GUIController {

    Inventory inventory = new Inventory();

    @FXML
    private GridPane basicInventoryGP;

    @FXML
    private GridPane hotBarGP;

    @FXML
    private ImageView nextHotbarButton;

    @FXML
    private ImageView blockDisplay;

    @FXML
    private TextField qttTF;

    @FXML
    void addBlockPressed(ActionEvent event) {

    }


    @FXML
    void highlightButton(MouseEvent event) throws FileNotFoundException, MalformedURLException {
        FileInputStream inputstream = new FileInputStream("imgs/next-bttn.png");
        Image highlightedButton = new Image(inputstream);
        nextHotbarButton.setImage(highlightedButton);
    }

    private boolean mouseIsInside(Node node, MouseEvent mouseClick) {
        if (node.getLayoutX() <= mouseClick.getSceneX());
        return true;
    }

    @FXML
    void prevBlockButton(ActionEvent event) {

    }

    @FXML
    void nextBlockButton(ActionEvent event) {

    }

    @FXML
    void nextHotbar(MouseEvent event) {
        //inventory.
    }

}
