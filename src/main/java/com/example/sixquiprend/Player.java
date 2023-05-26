package com.example.sixquiprend;

import com.example.sixquiprend.Items.Card;

import java.util.List;

public class Player {
    private String name;
    private int nbBeefTot;
    List<Card> deckCard;

    public Player(String name, int nbBeefTot) {
        this.name = name;
        this.nbBeefTot = nbBeefTot;
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
}
