package com.example.sixquiprend;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private int nbPlayer;
    Random random = new Random();
    List<String> nameList=new ArrayList<>();

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public static Game option;
    private Game() {}
    public static void startNewGame() {
        // A chaque fois qu''on retourne sur le menu principal, on remet les options du jeu à zero
        Game.option = null;
        Game.option = new Game();
    }

    public int getNbPlayer() {
        return nbPlayer;
    }

    public void setNbPlayer(int nbPlayer) {
        this.nbPlayer = nbPlayer;
    }

    public int giveCardRandom(){
        //for (int i=1;i<=4;i++){
        int firstCard = random.nextInt(104)+1;
        return firstCard;
    }
    public String IntToString(int number){
        String nombreEnString = Integer.toString(number);
        return nombreEnString;
    }
}
