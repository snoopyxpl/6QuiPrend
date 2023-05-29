package com.example.sixquiprend.Controller;

import com.example.sixquiprend.Game;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class PlayerCreationController extends BaseController{
    @FXML
    private Button playButton;
    @FXML
    private TextField fieldPlayerName1,fieldPlayerName2,fieldPlayerName3,fieldPlayerName4;
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
    public void onPlayButtonClick(){
        if (!areAllNameCompleted){
            labelError.setText("Veuillez compléter les noms des joueurs !");
            return;
        }
        Game.option.setNbBeefToLoose((int) sliderNbeef.getValue());
        loadPage("GameBoard");
    }
    public void onLeafClick(){
        loadPage("Accueil");
    }
    public void onOkPlayerNameButtonClick(){
        areAllNameCompleted=false;
        labelError.setText("");
        if (Game.option.getNbPlayer()==1){
            if (!fieldPlayerName1.getText().isEmpty()){
                Game.option.getNameList().add(0,fieldPlayerName1.getText());
                fieldPlayerName1.clear();
                System.out.println("Player1"+Game.option.getNameList().get(0));
                areAllNameCompleted=true;
            }else {
                labelError.setText("Veuillez renseigner 1 noms !");

            }
        }
        else if (Game.option.getNbPlayer()==2){
            if (!fieldPlayerName1.getText().isEmpty()&&!fieldPlayerName2.getText().isEmpty()){
                Game.option.getNameList().add(0,fieldPlayerName1.getText());
                Game.option.getNameList().add(1,fieldPlayerName2.getText());
                fieldPlayerName1.clear();
                fieldPlayerName2.clear();
                System.out.println("Player1"+Game.option.getNameList().get(0));
                System.out.println("Player2"+Game.option.getNameList().get(1));
                areAllNameCompleted=true;
            }else {
                labelError.setText("Veuillez renseigner 2 noms !");

            }
        } else if (Game.option.getNbPlayer()==3) {
            if (!fieldPlayerName1.getText().isEmpty()&&!fieldPlayerName2.getText().isEmpty()&&!fieldPlayerName3.getText().isEmpty()){
                Game.option.getNameList().add(0,fieldPlayerName1.getText());
                Game.option.getNameList().add(1,fieldPlayerName2.getText());
                Game.option.getNameList().add(2,fieldPlayerName3.getText());
                fieldPlayerName1.clear();
                fieldPlayerName2.clear();
                fieldPlayerName3.clear();
                System.out.println("Player1"+Game.option.getNameList().get(0));
                System.out.println("Player2"+Game.option.getNameList().get(1));
                System.out.println("Player3"+Game.option.getNameList().get(2));
                areAllNameCompleted=true;
            }
            else {
                labelError.setText("Veuillez renseigner 3 noms !");

            }
        }else if (Game.option.getNbPlayer()==4) {
            if (!fieldPlayerName1.getText().isEmpty()&&!fieldPlayerName2.getText().isEmpty()&&!fieldPlayerName3.getText().isEmpty()){
                Game.option.getNameList().add(0,fieldPlayerName1.getText());
                Game.option.getNameList().add(1,fieldPlayerName2.getText());
                Game.option.getNameList().add(2,fieldPlayerName3.getText());
                Game.option.getNameList().add(3,fieldPlayerName4.getText());
                fieldPlayerName1.clear();
                fieldPlayerName2.clear();
                fieldPlayerName3.clear();
                fieldPlayerName4.clear();
                System.out.println("Player1"+Game.option.getNameList().get(0));
                System.out.println("Player2"+Game.option.getNameList().get(1));
                System.out.println("Player3"+Game.option.getNameList().get(2));
                System.out.println("Player4"+Game.option.getNameList().get(3));
                areAllNameCompleted=true;
            }
            else {
                labelError.setText("Veuillez renseigner 4 noms !");

            }
        }
    }
    public void initializeNbBeeftoLoose(){
        Game.option.setNbBeefToLoose((int) sliderNbeef.getValue());
    }
}
