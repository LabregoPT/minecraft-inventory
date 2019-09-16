package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import model.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GUIController {
	@FXML
    public ImageView changeInvButton;

    @FXML
    public BorderPane pane;

    @FXML
    public ImageView inventoryImage;

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

    Game g = new Game();
    
    int currentBlockId = 0;
    
    @FXML
    void addBlockPressed(ActionEvent event) {
    	g.addBlock(currentBlockId, Integer.parseInt(qttTF.getText()));
    }

    @FXML
    void prevBlockButton(ActionEvent event) {
    	if(currentBlockId == 0) {
    		currentBlockId = Game.USED_BLOCKS-1;
    	}else {
    		currentBlockId--;
    	}
    	blockDisplay.setImage(new Image(g.getBlockDB().get(currentBlockId).getURL()));
    }

    @FXML
    void nextBlockButton(ActionEvent event) {
    	if(currentBlockId == Game.USED_BLOCKS-1) {
    		currentBlockId = 0;
    	}else {
    		currentBlockId++;
    	}
    	blockDisplay.setImage(new Image(g.getBlockDB().get(currentBlockId).getURL()));
    }

    @FXML
    void nextHotbar(MouseEvent event) {
        //inventory.
    }

    public void setupInterface(MouseEvent mouseEvent) throws FileNotFoundException {
        FileInputStream inventoryInputstream = new FileInputStream("imgs/inventory.png");
        Image inventory = new Image(inventoryInputstream);
        inventoryImage.setImage(inventory);

        FileInputStream inputstream = new FileInputStream("imgs/change-bttn.png");
        Image invTypeImage = new Image(inputstream);
        changeInvButton.setImage(invTypeImage);

        FileInputStream hotbarInputstream = new FileInputStream("imgs/next-bttn.png");
        Image nextBarImage = new Image(hotbarInputstream);
        nextHotbarButton.setImage(nextBarImage);

        FileInputStream backgroundInputstream = new FileInputStream("imgs/background.png");
        Image backgroundImage = new Image(backgroundInputstream);
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, true);
        BackgroundImage bImage = new BackgroundImage(backgroundImage, null, null, null, backgroundSize);
        Background background = new Background(bImage);
        pane.setBackground(background);
    }

    public void changeInventory(MouseEvent mouseEvent) {

    }

    public void highlightNextButton(MouseEvent mouseEvent) throws FileNotFoundException {
        FileInputStream inputstream = new FileInputStream("imgs/next-bttn-highlight.png");
        Image highlightedButton = new Image(inputstream);
        nextHotbarButton.setImage(highlightedButton);
    }

    public void unHighlightNextButton(MouseEvent mouseEvent) throws FileNotFoundException {
        FileInputStream inputstream = new FileInputStream("imgs/next-bttn.png");
        Image unhighlightedButton = new Image(inputstream);
        nextHotbarButton.setImage(unhighlightedButton);
    }

    public void highlightInvButton(MouseEvent mouseEvent) throws FileNotFoundException {
        FileInputStream inputstream = new FileInputStream("imgs/change-bttn-highlight.png");
        Image highlightedButton = new Image(inputstream);
        changeInvButton.setImage(highlightedButton);
    }

    public void unhighlightInvButton(MouseEvent mouseEvent) throws FileNotFoundException {
        FileInputStream inputstream = new FileInputStream("imgs/change-bttn.png");
        Image highlightedButton = new Image(inputstream);
        changeInvButton.setImage(highlightedButton);
    }
}
