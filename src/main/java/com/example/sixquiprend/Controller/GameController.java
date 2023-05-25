package com.example.sixquiprend.Controller;

import com.example.sixquiprend.Game;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class GameController extends BaseController{
    @FXML
    private ImageView cardSelected;
    @FXML
    private Label currentPlayerName;
    @FXML
    private ImageView col1Im1;
    @FXML
    private ImageView col2Im1;
    @FXML
    private ImageView col3Im1;
    @FXML
    private ImageView col4Im1;
    @FXML
    private Button validate;

    @FXML
    private ImageView CplayerCard1;
    @FXML
    private ImageView CplayerCard2;
    @FXML
    private ImageView CplayerCard3;
    @FXML
    private ImageView CplayerCard4;
    @FXML
    private ImageView CplayerCard5;
    @FXML
    private ImageView CplayerCard6;
    @FXML
    private ImageView CplayerCard7;
    @FXML
    private ImageView CplayerCard8;
    @FXML
    private ImageView CplayerCard9;
    @FXML
    private ImageView CplayerCard10;


    @FXML
    public void onImageClick(){
        System.out.println("Image clicked confirmed");
        CplayerCard1.setImage(setAnImage("cards/1.png"));
        initializeBoard();
    }
    @FXML
    public void initializeBoard(){
        int Ncol1Im1 = Game.option.giveCardRandom();
        col1Im1.setImage(setAnImage("cards/"+Game.option.IntToString(Ncol1Im1)+".png"));
        int Ncol2Im1 = Game.option.giveCardRandom();
        col2Im1.setImage(setAnImage("cards/"+Game.option.IntToString(Ncol2Im1)+".png"));
        int Ncol3Im1 = Game.option.giveCardRandom();
        col3Im1.setImage(setAnImage("cards/"+Game.option.IntToString(Ncol3Im1)+".png"));
        int Ncol4Im1 = Game.option.giveCardRandom();
        col4Im1.setImage(setAnImage("cards/"+Game.option.IntToString(Ncol4Im1)+".png"));
    }

    public void onValidateClick(){
        col1Im1.setFitHeight(200.0);
        col1Im1.setFitWidth(100.0);
    }
}
