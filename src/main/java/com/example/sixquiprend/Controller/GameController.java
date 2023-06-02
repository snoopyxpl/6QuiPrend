package com.example.sixquiprend.Controller;

import com.example.sixquiprend.Game;
import com.example.sixquiprend.Items.Card;
import com.example.sixquiprend.Player;
import com.example.sixquiprend.Timer;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameController extends BaseController {
    Timer timer = new Timer();
    @FXML
    private ImageView cardSelected;
    @FXML
    private ImageView cardMovement;
    @FXML
    private Label currentPlayerName;
    private int currentPlayer = Game.option.getCurrentPlayer();
    private Map<Image, Card> cardBaseImage = Game.option.getCardBaseImage();
    @FXML
    private Button check;
    @FXML
    private ImageView col1Im1, col1Im2, col1Im3, col1Im4, col1Im5, col1Im6;
    @FXML
    private HBox column1, column2, column3, column4;
    @FXML
    private VBox vboxBoard;
    @FXML
    private ImageView col2Im1, col2Im2, col2Im3, col2Im4, col2Im5, col2Im6;
    @FXML
    private ImageView col3Im1, col3Im2, col3Im3, col3Im4, col3Im5, col3Im6;
    @FXML
    private ImageView col4Im1, col4Im2, col4Im3, col4Im4, col4Im5, col4Im6;
    //Introduire toutes les imageViews du board      //done
    //Introduire lasts cards avec labels        //done
    @FXML
    private Label labelLast1, labelLast2, labelLast3, labelLast4;
    @FXML
    private ImageView lastIma1, lastIma2, lastIma3, lastIma4, lastIma1bot;
    @FXML
    private HBox hboxLastCard;
    @FXML
    private Label scorePlayer1, scorePlayer2, scorePlayer3, scorePlayer4;
    @FXML
    private Label labelSco1, labelSco2, labelSco3, labelSco4;
    //introduire les scores
    @FXML
    private Button validate;
    @FXML
    private Button quitter;
    @FXML
    private Button nextPlayerButton;
    private boolean isValidateClicked = false;

    @FXML
    private ImageView CplayerCard1, CplayerCard2, CplayerCard3, CplayerCard4, CplayerCard5, CplayerCard6, CplayerCard7, CplayerCard8, CplayerCard9, CplayerCard10;
    //Stocker l'id de l'image qui est joué par le joueur

    @FXML
    private ImageView CplayerCardRef;
    @FXML
    private Label errorMsg;
    @FXML
    private ImageView currentImageViewOnClick;
    private String currentCardOnClick;
    private int i;
    private Map<Integer, Player> playerMap = Game.option.getPlayerBaseNum();

    private final List<ImageView> ImageDeck = new ArrayList<>();
    private Map<String, ImageView> imageDeck = new HashMap<>();
    private Map<String, ImageView> lastImageBase = new HashMap<>();
    private Map<Image, Card> cardBaseImageController = new HashMap<>();
    private List<Integer> listplayerscore = new ArrayList<>();
    @FXML
    private VBox vboxScore;
    @FXML
    private VBox vboxPlayerNameScore;

    public void onLeafClick() {
        loadPage("Accueil");
    }

    public void fillImageDeck() {
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

        lastImageBase.put("lastIma1", lastIma1);
        lastImageBase.put("lastIma2", lastIma2);
        lastImageBase.put("lastIma3", lastIma3);
        lastImageBase.put("lastIma4", lastIma4);
    }

    public void onImageDeckMouseClick(ImageView imageView) {
        imageView.setOnMouseClicked(event -> {
            if (i == 0) {
                resetImageSize(CplayerCard1);
            } else {
                resetImageSize(currentImageViewOnClick);
            }
            currentImageViewOnClick = imageView;
            currentCardOnClick = currentImageViewOnClick.getId();
            bigSizeImage(imageView);
            i += 1;
        });
    }

    public void bigSizeImage(ImageView imageView) {
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
        double offsetX = (125 - newWidth) / 4;
        double offsetY = (125 - newHeight) / 4;

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
    }

    public void printCardOnTable(ImageView imageViewTarget, Image imageStart) {
        printImage(imageStart, imageViewTarget);
    }

    public void endTurn() {
        returnCardFace();
    }

    public void returnCardFace() {
        int nbPlayer = Game.option.getNbPlayer();
        int size = Game.option.getListlastcard().size();
        for (int z = 0; z <= size - 1; z++) {
            System.out.println("List Last Card" + Game.option.getListlastcard());
            Image imageFace = Game.option.getListlastcard().get(z).getImage();
            ImageView imageViewToReturn = (ImageView) hboxLastCard.getChildren().get(z);
            imageViewToReturn.setImage(imageFace);
        }
    }

    @FXML
    public void initialize() {
        System.out.println(Game.option.getPlayerList());
        fillImageDeck();
        Game.option.initialization();
        Game.option.addfirscardtotable();
        printCardOnTable(col1Im1, Game.option.getListlastcardontable().get(0).getImage());
        printCardOnTable(col2Im1, Game.option.getListlastcardontable().get(1).getImage());
        printCardOnTable(col3Im1, Game.option.getListlastcardontable().get(2).getImage());
        printCardOnTable(col4Im1, Game.option.getListlastcardontable().get(3).getImage());
        newPlayerTurn();
    }

    public void printDeckPlayer(List<Card> deck) {
        int lenDeck = deck.size();
        System.out.println("lenDeck " + lenDeck);
        for (int c = 0; c <= lenDeck - 1; c++) {
            System.out.println("c  est " + c);
            int num = deck.get(c).getValue();
            ImageView imageViewContainer = imageDeck.get("CplayerCard" + (c + 1));
            String numString = Game.option.IntToString(num);
            imageViewContainer.setId(numString);
            //System.out.println(imageViewContainer.getId());
            Image imageCard = deck.get(c).getImage();
            System.out.println("Id imageView " + imageViewContainer.getId());
            System.out.println("numString " + numString);
            System.out.println("nb tête de beef " + deck.get(c).getBeefhead());
            //imageView.setImage(setAnImage(path));
            if (imageViewContainer != null) {
                printImage(imageCard, imageViewContainer);
            }

        }
        int diff = 10 - lenDeck;
        for (int j = diff - 1; j > 0; j--) {
            removeImage(imageDeck.get("CplayerCard" + (j + 1)));
        }
    }

    public void printLastCard() {
        ImageView imageViewTarget = (ImageView) hboxLastCard.getChildren().get(Game.option.getCurrentPlayer());
        System.out.println("CurrentPlayer" + Game.option.getCurrentPlayer());
        System.out.println("class de hoxbox children : " + hboxLastCard.getChildren().get(Game.option.getCurrentPlayer()).getClass());
        //Image imageTodeplace = lastCardToPrint.getImage();
        translateCard(imageViewTarget, true);
    }

    public void initializeCountClick() {
        i = 0;
    }

    public void newPlayerTurn() {
        validate.setDisable(false);
        List<Card> currentPlayerHand;
        System.out.println("Next tour");
        currentPlayerHand = Game.option.getPlayerList().get(Game.option.getCurrentPlayer()).getHand();
        printDeckPlayer(currentPlayerHand);
        //System.out.println(Game.option.getPlayerList().get(Game.option.getCurrentPlayer()).getName());
        System.out.println("Hand du premier joueur " + currentPlayerHand);
        currentPlayerName.setText("A votre tour : " + Game.option.getPlayerList().get(Game.option.getCurrentPlayer()).getName());
    }


    public void placeLastCard() {
        System.out.println("Dans placeLastCard");
        for (int i = 0; i <= 3; i++) {
            HBox hbox = (HBox) vboxBoard.getChildren().get(i);
            printCol(Game.option.getTable().get(i), hbox);
        }
        int sizeLastCard = Game.option.getListlastcard().size();
        for (int j = 0; j <= sizeLastCard - 1; j++) {
            ImageView imageViewToClear = (ImageView) hboxLastCard.getChildren().get(j);
            removeImage(imageViewToClear);
        }
    }

    public void printScore() {
        Game.option.putscoreinlist(Game.option.getPlayerList());
        listplayerscore = Game.option.getListplayerscore();
        for (int j = 0; j <= listplayerscore.size() - 1; j++) {
            Label labelScore = (Label) vboxScore.getChildren().get(j);
            Label labelName = (Label) vboxPlayerNameScore.getChildren().get(j);
            int scorePlayer = listplayerscore.get(j);
            String namePlayer = Game.option.getPlayerList().get(j).getName();
            labelScore.setText(Game.option.IntToString(scorePlayer));
            labelName.setText(namePlayer);
        }
    }

    public void printCol(List<Card> colCard, HBox hbox) {
        // System.out.println("Dans printCol");
        for (int k = 0; k <= colCard.size() - 1; k++) {
            //System.out.println("Dans printCol");
            Image image = colCard.get(k).getImage();
            System.out.println("ColCard " + colCard);
            ImageView imageViewTarget = (ImageView) hbox.getChildren().get(k);
            printImage(image, imageViewTarget);
        }
    }

    public void onValidateClick() {
        validate.setDisable(true);
        isValidateClicked = true;
        errorMsg.setText("");
        nextPlayerButton.setDisable(false);
        printLastCard();
        resetImageSize(currentImageViewOnClick);
        Game.option.endTurnPlayer(selectHandCard());
        System.out.println("Avant setPlayerTurn");
        System.out.println("Après setPlayerTurn");

        initializeCountClick();
        System.out.println("Avant setPlayerTurn");
        Game.option.setPlayerTurn();
        System.out.println("Après setPlayerTurn");
    }

    public void onCheckClick() {
        placeLastCard();
        printScore();
    }

    public void onEndTurnPlayerClick() {
        nextPlayerButton.setDisable(true);
        if (!Game.option.getTurnClose()) {
            if (isValidateClicked) {
                System.out.println("isValidateCliked " + isValidateClicked);
                System.out.println("Dans le fond de onEndTurnPlayer");
                isValidateClicked = false;
                nextPlayerButton.setCursor(Cursor.DEFAULT);
                System.out.println("List Last Card" + Game.option.getListlastcard());
                newPlayerTurn();
            } else {
                errorMsg.setText("Veuiller sélectionner une carte !");
            }
        } else {
            System.out.println("Fin du tour de jeu ");
            System.out.println("List Last Card" + Game.option.getListlastcard());
            returnCardFace();
            Game.option.getPlayerWithMatchingLastCardValue();
            newPlayerTurn();
            //Fin du tour de jeu
        }

    }

    public Card selectHandCard() {
        List<Card> currentPlayerHand;
        currentPlayerHand = Game.option.getPlayerList().get(Game.option.getCurrentPlayer()).getHand();
        System.out.println("currentPlayerHand " + currentPlayerHand);
        Card card;
        Card defCard = null;
        int count = 0;
        int sizeHand = currentPlayerHand.size();
        System.out.println("Taille hand " + sizeHand);
        for (int k = 0; k < sizeHand; k++) {
            card = currentPlayerHand.get(k);
            System.out.println(Game.option.IntToString(card.getValue()) + "==" + currentCardOnClick);
            if (card.getValue() == Integer.parseInt(currentCardOnClick)) {
                defCard = card;
            }
            count++;
        }
        System.out.println("Compteur " + count);
        System.out.println("currentImageViewOnclick" + currentImageViewOnClick);
        return defCard;
    }

    public void printImage(Image imageCard, ImageView imageViewContainer) {
        imageViewContainer.setImage(imageCard);
        imageViewContainer.setOpacity(1);
        onImageDeckMouseClick(imageViewContainer);
        imageViewContainer.setCursor(Cursor.HAND);
    }

    public void removeImage(ImageView imageView) {
        imageView.setImage(setAnImage("Images/dashedImage.png"));
        imageView.setOpacity(0.5);
        imageView.setOnMouseClicked(event -> {
        });
        imageView.setCursor(Cursor.DEFAULT);
    }

    public void translateCard(ImageView targetImageView, boolean isHide) {
        ImageView imageViewToDeplace = currentImageViewOnClick;
        double posImgMoveX = imageViewToDeplace.getLocalToSceneTransform().getTx();
        double posImgMoveY = imageViewToDeplace.getLocalToSceneTransform().getTy();
        // Met l'imageS de CardSelect et la rend visible
        this.cardMovement.setImage(imageViewToDeplace.getImage());
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
            if (isHide) {
                targetImageView.setImage(setAnImage("cards/backside.png"));
            } else {
                targetImageView.setImage(currentImageViewOnClick.getImage());
            }
            targetImageView.setOpacity(1);
            cardMovement.setVisible(false);
            removeImage(imageViewToDeplace);
            //this.endTurn();
        });
        tt.play();

    }
}
