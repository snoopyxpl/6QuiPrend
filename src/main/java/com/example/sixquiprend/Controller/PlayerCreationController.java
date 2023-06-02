package com.example.sixquiprend.Controller;

import com.example.sixquiprend.Game;
import com.example.sixquiprend.Items.Card;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class PlayerCreationController extends BaseController {
    @FXML
    private Button playButton;
    @FXML
    private Button skipButton;
    @FXML
    private TextField fieldPlayerName1, fieldPlayerName2, fieldPlayerName3, fieldPlayerName4;
    @FXML
    private Label labelPlayerName1, labelPlayerName2, labelPlayerName3, labelPlayerName4;
    @FXML
    private VBox vboxNamePlayer;
    @FXML
    private VBox vboxLabelNamePlayer;
    @FXML
    private Label labelPlayerName;
    @FXML
    private Button okPlayerName;
    @FXML
    private Label labelError;
    @FXML
    private Slider sliderNbeef;
    private boolean areAllNameCompleted;
    @FXML
    private Button quitter;
    private List<Card> deck;

    public void onPlayButtonClick() {
        if (!areAllNameCompleted) {
            labelError.setText("Veuillez compléter les noms des joueurs !");
            return;
        }
        //Game.option.setNbBeefToLoose((int) sliderNbeef.getValue());
        loadPage("GameBoard");
    }

    public void onLeafClick() {
        loadPage("Accueil");
    }

    public void onOkPlayerNameButtonClick() {
        int nbPlayer = Game.option.getNbPlayer();
//        for (int n=1;n<=nbPlayer;n++){
//            System.out.println(vboxNamePlayer.getChildren().get(n-1).getAccessibleText());
//        }
        areAllNameCompleted = false;
        labelError.setText("");
        if (Game.option.getNbPlayer() == 1) {
            if (!fieldPlayerName1.getText().isEmpty()) {
                Game.option.addPlayerToList(fieldPlayerName1.getText(), 0, new ArrayList<>());
                fieldPlayerName1.clear();
                areAllNameCompleted = true;
            } else {
                labelError.setText("Veuillez renseigner 1 noms !");

            }
        } else if (Game.option.getNbPlayer() == 2) {
            if (!fieldPlayerName1.getText().isEmpty() && !fieldPlayerName2.getText().isEmpty()) {
                Game.option.addPlayerToList(fieldPlayerName1.getText(), 0, new ArrayList<>());
                Game.option.addPlayerToList(fieldPlayerName2.getText(), 1, new ArrayList<>());
                fieldPlayerName1.clear();
                fieldPlayerName2.clear();
                areAllNameCompleted = true;
            } else {
                labelError.setText("Veuillez renseigner 2 noms !");

            }
        } else if (Game.option.getNbPlayer() == 3) {
            if (!fieldPlayerName1.getText().isEmpty() && !fieldPlayerName2.getText().isEmpty() && !fieldPlayerName3.getText().isEmpty()) {
                Game.option.addPlayerToList(fieldPlayerName1.getText(), 0, new ArrayList<>());
                Game.option.addPlayerToList(fieldPlayerName2.getText(), 1, new ArrayList<>());
                Game.option.addPlayerToList(fieldPlayerName3.getText(), 2, new ArrayList<>());
                fieldPlayerName1.clear();
                fieldPlayerName2.clear();
                fieldPlayerName3.clear();
                areAllNameCompleted = true;
            } else {
                labelError.setText("Veuillez renseigner 3 noms !");

            }
        } else if (Game.option.getNbPlayer() == 4) {
            if (!fieldPlayerName1.getText().isEmpty() && !fieldPlayerName2.getText().isEmpty() && !fieldPlayerName3.getText().isEmpty()) {
                Game.option.addPlayerToList(fieldPlayerName1.getText(), 0, new ArrayList<>());
                Game.option.addPlayerToList(fieldPlayerName2.getText(), 1, new ArrayList<>());
                Game.option.addPlayerToList(fieldPlayerName3.getText(), 2, new ArrayList<>());
                Game.option.addPlayerToList(fieldPlayerName4.getText(), 3, new ArrayList<>());
                fieldPlayerName1.clear();
                fieldPlayerName2.clear();
                fieldPlayerName3.clear();
                fieldPlayerName4.clear();
                areAllNameCompleted = true;
            } else {
                labelError.setText("Veuillez renseigner 4 noms !");

            }
        }
        Game.option.dealCards();
        Game.option.shorthand();
        System.out.println(Game.option.getPlayerList());
    }

    public void initialize() {
        deck = Game.option.getDeck();
        //Game.option.makeHashMapCardImage();
        int nbPlayer = Game.option.getNbPlayer();
        for (int i = 0; i <= nbPlayer - 1; i++) {
            vboxNamePlayer.getChildren().get(i).setVisible(true);
            vboxLabelNamePlayer.getChildren().get(i).setVisible(true);
        }
    }

    public void initializeNbBeeftoLoose() {
        Game.option.setNbBeefToLoose((int) sliderNbeef.getValue());
    }

    public void onSkipClick() {
        int nbPlayer = Game.option.getNbPlayer();
        String n1 = "Saïd";
        String n2 = "Thibaud";
        String n3 = "Nico";
        String n4 = "Charles";
        List<String> listTestName = new ArrayList<>();
        listTestName.add(n1);
        listTestName.add(n2);
        listTestName.add(n3);
        listTestName.add(n4);
        for (int i = 0; i <= nbPlayer - 1; i++) {
            Game.option.addPlayerToList(listTestName.get(i), i, new ArrayList<>());
        }
        Game.option.dealCards();
        Game.option.shorthand();
        System.out.println(Game.option.getPlayerList());
        loadPage("GameBoard");
    }

}
