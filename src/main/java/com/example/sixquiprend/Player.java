package com.example.sixquiprend;

import com.example.sixquiprend.Items.Card;

import java.util.List;

public class Player {
    private String name;
    private int nbBeefTot;
    List<Card> deckCard;
    private Card lastCard;
    private int numPlayer;

    public int getNumPlayer() {
        return numPlayer;
    }

    public void setNumPlayer(int numPlayer) {
        this.numPlayer = numPlayer;
    }

    public Card getLastCard() {
        return lastCard;
    }

    public void setLastCard(Card lastCard) {
        this.lastCard = lastCard;
    }

    public Player(String name,int numPlayer) {
        this.name = name;
        this.nbBeefTot = 0;
        this.numPlayer=numPlayer;
    }

    public List<Card> getDeckCard() {
        return deckCard;
    }

    public void setDeckCard(List<Card> deckCard) {
        this.deckCard = deckCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNbBeefTot() {
        return nbBeefTot;
    }

    public void setNbBeefTot(int nbBeefTot) {
        this.nbBeefTot = nbBeefTot;
    }
    public boolean isGameLoose(){
        if (nbBeefTot>=Game.option.getNbBeefToLoose()){
            return true;
        }else{
            return false;
        }
    }
}
