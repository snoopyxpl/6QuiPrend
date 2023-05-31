package com.example.sixquiprend;

import com.example.sixquiprend.Items.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int nbBeefTot;
    private List<Card> hand=new ArrayList<>();
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

    public Player(String name,int numPlayer,List<Card> hand) {
        this.name = name;
        this.nbBeefTot = 0;
        this.numPlayer=numPlayer;
        this.hand=hand;

    }

    public List<Card> gethand() {
        return hand;
    }

    public void setDeckCard(List<Card> hand) {
        this.hand = hand;
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
    public void addtohand(Card card){
        this.hand.add(card);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hand=" + hand +
                ", numPlayer=" + numPlayer +
                '}';
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }
}
