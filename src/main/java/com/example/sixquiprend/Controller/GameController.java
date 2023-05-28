package com.example.sixquiprend.Controller;

import com.example.sixquiprend.Game;
import com.example.sixquiprend.Items.Card;
import com.example.sixquiprend.Timer;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class GameController extends BaseController{
    Timer timer = new Timer();
    @FXML
    private ImageView cardSelected;
    @FXML
    private ImageView cardMovement;
    @FXML
    private Label currentPlayerName;
    @FXML
    private ImageView col1Im1, col1Im2,col1Im3, col1Im4,col1Im5,col1Im6;
    @FXML
    private ImageView col2Im1,col2Im2,col2Im3,col2Im4,col2Im5,col2Im6;
    @FXML
    private ImageView col3Im1,col3Im2,col3Im3,col3Im4,col3Im5,col3Im6;
    @FXML
    private ImageView col4Im1,col4Im2,col4Im3,col4Im4,col4Im5,col4Im6;
    //Introduire toutes les imageViews du board      //done
    //Introduire lasts cards avec labels        //done
    @FXML
    private Label labelLast1,labelLast2,labelLast3,labelLast4;
    @FXML
    private ImageView lastIma1,lastIma2,lastIma3,lastIma4,lastIma1bot;
    @FXML
    private Label scorePlayer1,scorePlayer2,scorePlayer3,scorePlayer4;
    @FXML
    private Label labelSco1,labelSco2,labelSco3, labelSco4;
    //introduire les scores
    @FXML
    private Button validate;

    @FXML
    private ImageView CplayerCard1,CplayerCard2,CplayerCard3,CplayerCard4,CplayerCard5,CplayerCard6,CplayerCard7,CplayerCard8,CplayerCard9,CplayerCard10;

    private final List<ImageView> ImageDeck=new ArrayList<>();
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
    public void addCardOnBoard(int colNumber,Card card){
        //fonction back pour déterminer si la carte rammasse le tas ...
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
        translateCard(CplayerCard1,lastIma1);

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
    @FXML
    public void onImage2Click(){

        //CplayerCard1.toFront();
    }

    public void onValidateClick(){
        System.out.println("Image clicked confirmed");
        CplayerCard1.toFront();
        //translateCard(CplayerCard1,lastIma1);
        translateCard(lastIma1,col2Im2);
        //translateCard(lastIma2,CplayerCard2);
//        col1Im1.setFitHeight(200.0);
//        col1Im1.setFitWidth(100.0);
        //removeImage(col1Im1);
        //translateCard(CplayerCard2,578,-490,1.0);
    }

    //Faire deux fonctions élémentaires : qui affiche une carte et qui enlève une carte (et donc remet l'ancienne image)
    public void printImage(String path, ImageView imageView){
        imageView.setImage(setAnImage(path));
    }//Ensuite, à toi de te démerder pour faire le path avant
    public void removeImage(ImageView imageView){
        imageView.setImage(setAnImage("Images/dashedImage.png"));
    }

    public void translateCard(ImageView imageToDeplace,ImageView targetImageView) {
        // Retour la nouvelle carte du deck
        //CardDeckView.setImage(newCardDeck);
        // Image de la nouvelle Card
        //String pathImgGet = this.playerTurn.getCardInIsHandImgPath();
        //Image newRubbichImg = ControlleurBase.setAnImage(pathImgGet);
        // Deplace le cardMovement sur la position du deck selectionné
        double posImgMoveX = imageToDeplace.getLocalToSceneTransform().getTx();
        double posImgMoveY = imageToDeplace.getLocalToSceneTransform().getTy();
        // Met l'imageS de CardSelect et la rend visible
        this.cardMovement.setImage(imageToDeplace.getImage());
        this.cardMovement.setVisible(true);
        // Coordonnée de la carte cible
        double posTrashX = targetImageView.getLocalToSceneTransform().getTx();
        double posTrashY = targetImageView.getLocalToSceneTransform().getTy();
        int  timeStep = 800;
        // Création et parameters de l'annimation
        TranslateTransition tt = new TranslateTransition(Duration.millis(timeStep), this.cardMovement);
        tt.setFromX(posImgMoveX);
        tt.setFromY(posImgMoveY-500);
        tt.setToX(posTrashX);
        tt.setToY(posTrashY-500);
        cardMovement.toFront();
        tt.setOnFinished(event-> {
            targetImageView.setImage(imageToDeplace.getImage());
            cardMovement.setVisible(false);
            imageToDeplace.setImage(setAnImage("Images/dashedImage.png"));
            //this.endTurn();
        });
        tt.play();
    }
}
