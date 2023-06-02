package com.example.sixquiprend.Items;

import com.example.sixquiprend.Controller.BaseController;
import com.example.sixquiprend.Game;
import com.example.sixquiprend.HelloApplication;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Card {
    private int value;
    private int beefhead;
    private Image image;

    private Image backSide;

    public int getValue() {
        return value;
    }

    public Card(int value, int beefhead, Image image) throws IOException {
        this.value = value;
        this.beefhead = beefhead;
        this.image = image;
        this.backSide = new Image(Objects.requireNonNull(HelloApplication.class.getResource("cards/backside.png")).openStream());
    }

    public static List<Card> generateDeck() throws IOException {
        List<Card> deck = new ArrayList<>();
        for (int i = 1; i <= 104; i++) {
            if (i == 55) {
                deck.add(new Card(i, 7, setAnImage(i)));
            } else if (i % 11 == 0) {
                deck.add(new Card(i, 5, setAnImage(i)));
            } else if (i % 10 == 0) {
                deck.add(new Card(i, 3, setAnImage(i)));
            } else if ((i - 5) % 10 == 0) {
                deck.add(new Card(i, 2, setAnImage(i)));
            } else {
                deck.add(new Card(i, 1, setAnImage(i)));
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


    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", beefHead=" + beefhead +
                '}';
    }

    public static Image setAnImage(int num) {
        try {
            return new Image(Objects.requireNonNull(HelloApplication.class.getResource("cards/" + IntToString(num) + ".png")).openStream());
        } catch (IOException | NullPointerException | IllegalArgumentException ignored) {
            System.out.println("Erreur d'affichage : " + IntToString(num));
            return BaseController.setAnImage("Images/error.png");
        }
    }

    public static String IntToString(int number) {
        String nombreEnString = Integer.toString(number);
        return nombreEnString;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
