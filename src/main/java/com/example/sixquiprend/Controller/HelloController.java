package com.example.sixquiprend.Controller;

import com.example.sixquiprend.Game;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class HelloController extends BaseController{
    @FXML
    private Slider sliderNbPlayers;
    @FXML
    private Label errorAlone;

    @FXML
    private CheckBox CheckBoxBot;

    @FXML
    private Button Play;
    @FXML
    public void onPlayClick(){
        if (!CheckBoxBot.isSelected() && sliderNbPlayers.getValue()==1){
            errorAlone.setText("Vous ne pouvez pas jouer tout seul !");
        }else{
            int nbPlayerTot;
            if (CheckBoxBot.isSelected()){
                nbPlayerTot = (int) (sliderNbPlayers.getValue()+1);
            }else{
                nbPlayerTot = (int) sliderNbPlayers.getValue();
            }
            Game.startNewGame();
            Game.option.setNbPlayer(nbPlayerTot);
            //System.out.println(Game.option.getNbPlayer());
            loadPage("PlayerCreation");
        }
        //System.out.println(sliderNbPlayers.getValue());
    }

//    @FXML
//    public void initialize() {
//        this.screenElements.setScaleX(1.3);
//        this.screenElements.setScaleY(1.3);
//        // Stop la musique est en cours
//        try {Game.option.musiquePlayer.stopMedia();
//        } catch (Exception ignored) {}
//        // Création de la partie de jeu
//        Game.startNewGame();
//        // Joue une nouvelle musique
//        Game.option.musiquePlayer.playMedia();
//    }



//    @FXML
//    protected void startGame() {
//        // Récureration du nombre de heros pour la partie
//        int nbHeroesChoose = (int) sliderNbPlayers.getValue();
//        // Si bot choice select
//        if (this.CheckBoxBot.isSelected()) {
//            Game.option.selectBotMod();
//        }
//        Game.option.setNbPlayers(nbHeroesChoose);
//        // Chargement de la nouvelle scene
//        super.loadPage("playerCreation");
//    }


//    @FXML
//    protected void startGameTest() {
//        // Récureration du nombre de heros pour la partie
//        int nbHeroesChoose = (int) sliderNbPlayers.getValue();
//        Game.option.setNbPlayers(nbHeroesChoose);
//
//        // Alexandrie, Babylone, Gizeh, Ephese, Halicarnasse, Olympie, Rhodes
//        Game.option.setNbPlayers(7);
//        Game.option.addPlayer("Admin-1", 20, "Ephese");
//        Game.option.addPlayer("Admin-2", 19, "Rhodes");
//        Game.option.addPlayer("Admin-3", 60, "Gizeh");
//
//        Game.option.addPlayer("Jon", 45, "Halicarnasse");
//        Game.option.addPlayer("Brutus", 10, "Olympie");
//        Game.option.addPlayer("Apollo", 70, "Babylone");
//        Game.option.addPlayer("Astride", 42, "Alexandrie");
//
//        // Chargement de la nouvelle scene
//        super.loadPage("game");
//    }

//    @FXML
//    protected void exitGame() {((Stage) stageAP.getScene().getWindow()).close();}
}