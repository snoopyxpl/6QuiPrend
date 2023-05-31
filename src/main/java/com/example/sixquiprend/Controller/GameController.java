package com.example.sixquiprend.Controller;

import com.example.sixquiprend.Game;
import com.example.sixquiprend.Items.Card;
import com.example.sixquiprend.Timer;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private Button quitter;

    @FXML
    private ImageView CplayerCard1,CplayerCard2,CplayerCard3,CplayerCard4,CplayerCard5,CplayerCard6,CplayerCard7,CplayerCard8,CplayerCard9,CplayerCard10;
    //Stocker l'id de l'image qui est joué par le joueur

    @FXML
    private ImageView CplayerCardRef;
    @FXML
    private ImageView currentImageOnClick;
    private int i;

    private final List<ImageView> ImageDeck=new ArrayList<>();
    private Map<String, ImageView> imageDeck = new HashMap<>();
    public void onLeafClick(){
        loadPage("Accueil");
    }
    public void fillImageDeck(){
        imageDeck.put("CplayerCard1", CplayerCard1);
        imageDeck.put("CplayerCard2", CplayerCard2);
        imageDeck.put("CplayerCard3", CplayerCard3);
        imageDeck.put("CplayerCard4", CplayerCard4);
        imageDeck.put("CplayerCard5", CplayerCard5);
        imageDeck.put("CplayerCard6", CplayerCard6);
        imageDeck.put("CplayerCard7", CplayerCard7);
        imageDeck.put("CplayerCard8", CplayerCard8);
        imageDeck.put("CplayerCard9", CplayerCard9);
        imageDeck.put("CplayerCard10", CplayerCard10);
    }


    //Faire fonction qui prend comme argument une liste de carte et qui l'affiche
    public void printDeckPlayer(List<Card> deck){
        int lenDeck = deck.size();
        for (int i=0;i<=lenDeck-1;i++){
            int Num = deck.get(i).getValue();
            ImageView imageView = imageDeck.get("CplayerCard" + (i + 1));
            if (imageView != null) {
                //imageView.setImage(setAnImage(path));
                printImage(Num,imageView);
            }
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
    public void ImageDeckID(){
        for (Map.Entry<String, ImageView> entry : imageDeck.entrySet()) {
            ImageView imageView = entry.getValue();
            imageView.setOnMouseClicked(event -> {
                if (i==0){
                    resetImageSize(CplayerCard1);
                }else{
                    resetImageSize(imageDeck.get(currentImageOnClick));
                }
                //currentImageOnClick = entry.getKey();
                bigSizeImage(imageDeck.get(currentImageOnClick));
                System.out.println("Salut");
                i+=1;
            });
            imageView.setOnMouseDragOver(event ->{

            });
        }
        System.out.println("intérieur de la fonction ImageDeckID");
    }
    public void onImageDeckMouseClick(ImageView imageView){
        imageView.setOnMouseClicked(event -> {
            if (i==0){
                resetImageSize(CplayerCard1);
            }else{
                resetImageSize(currentImageOnClick);
            }
            currentImageOnClick= imageView;
            bigSizeImage(imageView);
            //System.out.println("Salut");
            i+=1;
        });
    }
    public void bigSizeImage(ImageView imageView){
        imageView.toFront();
        double originalWidth = imageView.getImage().getWidth();
        double originalHeight = imageView.getImage().getHeight();

        double scaleFactor = Math.min(125 / originalWidth, 125 / originalHeight);
        double newWidth = originalWidth * scaleFactor;
        double newHeight = originalHeight * scaleFactor;

        imageView.setFitWidth(newWidth);
        imageView.setFitHeight(newHeight);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);

        // Calcul du décalage horizontal et vertical pour centrer l'image
        double offsetX = (125 - newWidth)/4 ;
        double offsetY = (125 - newHeight) /4;

        imageView.setX(-offsetX);
        imageView.setY(-offsetY);

    }
    public void resetImageSize(ImageView imageView) {
        imageView.setFitWidth(CplayerCardRef.getFitWidth());
        imageView.setFitHeight(CplayerCardRef.getFitHeight());
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setX(0);
        imageView.setY(0);
        //imageView.setOpacity(0.5);
    }

    @FXML
    public void onImageClick(){

        //System.out.println("Image clicked confirmed");
        //CplayerCard1.setImage(setAnImage("cards/1.png"));
        //initializeBoard();
        //translateCard(CplayerCard1,lastIma1);
        //System.out.println(currentImageOnClick);
        //System.out.println();

        //timer.getTime(3000);

    }
    @FXML
    public void initialize(){
        fillImageDeck();
        //ImageDeckID();
        int Ncol1Im1 = Game.option.giveCardRandom();
        String path = "cards/"+Game.option.IntToString(Ncol1Im1)+".png";
        printImage(Ncol1Im1,col1Im1);
        //col1Im1.setImage(setAnImage("cards/"+Game.option.IntToString(Ncol1Im1)+".png"));
        int Ncol2Im1 = Game.option.giveCardRandom();
        printImage(Ncol2Im1,col2Im1);
        int Ncol3Im1 = Game.option.giveCardRandom();
        printImage(Ncol3Im1,col3Im1);
        int Ncol4Im1 = Game.option.giveCardRandom();
        printImage(Ncol4Im1,col4Im1);
        printImage(55,lastIma1);

        //test unitaire de la fonction affichage du deck du current player
        List<Card> TestCardList = new ArrayList<>();
        TestCardList.add(0,new Card(Game.option.giveCardRandom(),1));
        TestCardList.add(0,new Card(Game.option.giveCardRandom(),1));
        TestCardList.add(0,new Card(Game.option.giveCardRandom(),1));
        TestCardList.add(0,new Card(Game.option.giveCardRandom(),1));
        TestCardList.add(0,new Card(Game.option.giveCardRandom(),1));
        TestCardList.add(0,new Card(Game.option.giveCardRandom(),1));
        TestCardList.add(0,new Card(Game.option.giveCardRandom(),1));


        printDeckPlayer(TestCardList);

    }
    @FXML
    public void onImage2Click(){

        //CplayerCard1.toFront();
    }

    public void onValidateClick(){
        //Réinitialiser le conteur i (resetImage)
        i=0;
        System.out.println("Image clicked confirmed");
        CplayerCard1.toFront();
        System.out.println("Dans validate Click");
        //translateCard(CplayerCard1,lastIma1);
        translateCard(currentImageOnClick,lastIma2);
        resetImageSize(currentImageOnClick);
        //translateCard(lastIma1,col2Im2);
        System.out.println(currentImageOnClick);
        //translateCard(lastIma2,CplayerCard2);
//        col1Im1.setFitHeight(200.0);
//        col1Im1.setFitWidth(100.0);
        //removeImage(col1Im1);
        //translateCard(CplayerCard2,578,-490,1.0);
    }

    //Faire deux fonctions élémentaires : qui affiche une carte et qui enlève une carte (et donc remet l'ancienne image)
    public void printImage(int Num, ImageView imageView){
        imageView.setImage(setAnImage("cards/"+Game.option.IntToString(Num)+".png"));
        imageView.setOpacity(1);
        onImageDeckMouseClick(imageView);
        imageView.setCursor(Cursor.HAND);
    }//Ensuite, à toi de te démerder pour faire le path avant
    public void removeImage(ImageView imageView){
        imageView.setImage(setAnImage("Images/dashedImage.png"));
        imageView.setOpacity(0.5);
        imageView.setOnMouseClicked(event ->{});
        imageView.setCursor(Cursor.DEFAULT);
    }

    public void translateCard(ImageView imageToDeplace,ImageView targetImageView) {
        if (imageToDeplace!=null) {
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
            int timeStep = 800;
            // Création et parameters de l'annimation
            TranslateTransition tt = new TranslateTransition(Duration.millis(timeStep), this.cardMovement);
            tt.setFromX(posImgMoveX);
            tt.setFromY(posImgMoveY - 500);
            tt.setToX(posTrashX);
            tt.setToY(posTrashY - 500);
            cardMovement.toFront();
            tt.setOnFinished(event -> {
                targetImageView.setImage(imageToDeplace.getImage());
                targetImageView.setOpacity(1);
                cardMovement.setVisible(false);
                //imageToDeplace.setImage(setAnImage("Images/dashedImage.png"));
                removeImage(imageToDeplace);
                //this.endTurn();
            });
            tt.play();
        }
    }
}
