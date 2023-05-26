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
    private TextField fieldPlayerName;
    @FXML
    private Label labelPlayerName;
    @FXML
    private Button okPlayerName;
    @FXML
    private Slider sliderNbeef;
    @FXML
    private Button quitter;
    public void onPlayButtonClick(){
        loadPage("GameBoard");
    }
    public void onLeafClick(){
        loadPage("Accueil");
    }
    public void onOkPlayerNameClick(){
        //boolean allNamesEntered = false;
//        for (int i=1;i<=Game.option.getNbPlayer() ;i++){
//            if (!fieldPlayerName.getText().isEmpty()){
//                Game.option.getNameList().add(i-1,fieldPlayerName.getText());
//                System.out.println(Game.option.getNameList().get(0));
//                labelPlayerName.setText("Player Name "+i);
//                fieldPlayerName.clear();
//            }else{
//                while(fieldPlayerName.getText().isEmpty()){
//                    labelPlayerName.setText("Veuillez entrer le nom du joueur "+i);
//                }
  //          }
       // }
        if (Game.option.getNbPlayer()==2){
            if (fieldPlayerName.getText().isEmpty()){
                Game.option.getNameList().add(0,fieldPlayerName.getText());
                System.out.println(Game.option.getNameList().get(0));
                labelPlayerName.setText("Player Name 2");
                fieldPlayerName.clear();
                if (fieldPlayerName.getText().isEmpty()){
                    Game.option.getNameList().add(1,fieldPlayerName.getText());
                    System.out.println(Game.option.getNameList().get(1));
                }else{
                    labelPlayerName.setText("Veuillez entrer un nom pour le joueur 2");
                }
            }else{
                labelPlayerName.setText("veuillez entrer un nom pour le joueur 1");
            }
            System.out.println(Game.option.getNameList().get(0));
            System.out.println(Game.option.getNameList().get(1));
            if (Game.option.getNbPlayer()==3){
                if (fieldPlayerName.getText().isEmpty()){
                    Game.option.getNameList().add(0,fieldPlayerName.getText());
                    System.out.println(Game.option.getNameList().get(0));
                    labelPlayerName.setText("Player Name 2");
                    fieldPlayerName.clear();
                    if (fieldPlayerName.getText().isEmpty()){
                        Game.option.getNameList().add(1,fieldPlayerName.getText());
                        System.out.println(Game.option.getNameList().get(1));
                        labelPlayerName.setText("Player Name 3");
                        if (fieldPlayerName.getText().isEmpty()){
                            Game.option.getNameList().add(2,fieldPlayerName.getText());
                        }else{
                            labelPlayerName.setText("Veuillez entrer un nom pour le joueur 3");
                        }
                    }else{
                        labelPlayerName.setText("Veuillez entrer un nom pour le joueur 2");
                    }
                }else{
                    labelPlayerName.setText("veuillez entrer un nom pour le joueur 1");
                }
                System.out.println(Game.option.getNameList().get(0));
                System.out.println(Game.option.getNameList().get(1));
                System.out.println(Game.option.getNameList().get(2));

            }
        }


    }
}
