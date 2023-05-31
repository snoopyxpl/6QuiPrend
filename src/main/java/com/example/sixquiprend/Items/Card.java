package com.example.sixquiprend.Items;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private int value ;
    private int beefhead;
    private ImageView image;


    public int getValue() {
        return value;
    }

    public Card(int value, int beefhead) {
        this.value = value;
        this.beefhead = beefhead;
    }
    public static List<Card> generateDeck() {
        List<Card> deck = new ArrayList<>();
        for (int i = 1; i <= 104; i++) {
            if (i == 55) {
                deck.add(new Card(i, 7));
            } else if (i % 11 == 0) {
                deck.add(new Card(i, 5));
            } else if (i % 10 == 0) {
                deck.add(new Card(i, 3));
            } else if ((i - 5) % 10 == 0) {
                deck.add(new Card(i, 2));
            } else {
                deck.add(new Card(i, 1));
            }
        }
        return deck;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getBeefhead() {
        return beefhead;
    }

    public void setBeefhead(int beefhead) {
        this.beefhead = beefhead;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", beefHead=" + beefhead +
                '}';
    }
}
