package com.example.sixquiprend.Controller;

import com.example.sixquiprend.Game;
import com.example.sixquiprend.Items.Card;
import com.example.sixquiprend.Timer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class GameController extends BaseController{
    Timer timer = new Timer();
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
    //Introduire toutes les imageViews du board
    //Ainsi que les scores et lasts cards
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
    private List<ImageView> ImageDeck=new ArrayList<>();
    public void fillImageDeck(){
        ImageDeck.add(0,CplayerCard1);
        ImageDeck.add(1,CplayerCard2);
        ImageDeck.add(2,CplayerCard3);
        ImageDeck.add(3,CplayerCard4);
        ImageDeck.add(4,CplayerCard5);
        ImageDeck.add(5,CplayerCard6);
        ImageDeck.add(6,CplayerCard7);
        ImageDeck.add(7,CplayerCard8);
        ImageDeck.add(8,CplayerCard9);
        ImageDeck.add(9,CplayerCard10);
    }


    //Faire fonction qui prend comme argument une liste de carte et qui l'affiche
    public void printDeckPlayer(List<Card> deck){
        int lenDeck = deck.size();
        for (int i=0;i<=lenDeck-1;i++){
            String path = "cards/"+deck.get(i).getValue()+".png";
            ImageDeck.get(i).setImage(setAnImage(path));
        }
    }
    //Faire la même pour afficher sur le plateau
    public void printCardOnBoard(){

    }
    public void useCaseDeck(){
        ImageView imageView = ImageDeck.get(0);
        //ImageDeck.(0);
    }
    public void freeCaseDeck(int lastIndexIn){
        for (int i =10-lastIndexIn;i>0;i--){

        }
    }

    @FXML
    public void onImageClick(){
        System.out.println("Image clicked confirmed");
        //CplayerCard1.setImage(setAnImage("cards/1.png"));
        initializeBoard();
        //timer.getTime(3000);

    }
    @FXML
    public void initializeBoard(){
        fillImageDeck();
        int Ncol1Im1 = Game.option.giveCardRandom();
        String path = "cards/"+Game.option.IntToString(Ncol1Im1)+".png";
        printImage(path,col1Im1);
        //col1Im1.setImage(setAnImage("cards/"+Game.option.IntToString(Ncol1Im1)+".png"));
        int Ncol2Im1 = Game.option.giveCardRandom();
        col2Im1.setImage(setAnImage("cards/"+Game.option.IntToString(Ncol2Im1)+".png"));
        int Ncol3Im1 = Game.option.giveCardRandom();
        col3Im1.setImage(setAnImage("cards/"+Game.option.IntToString(Ncol3Im1)+".png"));
        int Ncol4Im1 = Game.option.giveCardRandom();
        col4Im1.setImage(setAnImage("cards/"+Game.option.IntToString(Ncol4Im1)+".png"));

        //test unitaire de la fonction affichage du deck du current player
        List<Card> TestCardList = new ArrayList<>();
        TestCardList.add(0,new Card(2,1));
        TestCardList.add(1,new Card(3,2));
        TestCardList.add(2,new Card(5,3));
        TestCardList.add(3,new Card(15,5));
        TestCardList.add(4,new Card(103,1));

        printDeckPlayer(TestCardList);
    }

    public void onValidateClick(){
//        col1Im1.setFitHeight(200.0);
//        col1Im1.setFitWidth(100.0);
        removeImage(col1Im1);
    }

    //Faire deux fonctions élémentaires : qui affiche une carte et qui enlève une carte (et donc remet l'ancienne image)
    public void printImage(String path, ImageView imageView){
        imageView.setImage(setAnImage(path));
    }//Ensuite, à toi de te démerder pour faire le path avant
    public void removeImage(ImageView imageView){
        imageView.setImage(setAnImage("Images/dashedImage.png"));
    }
}
