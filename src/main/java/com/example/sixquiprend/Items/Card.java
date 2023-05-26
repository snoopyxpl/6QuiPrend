package com.example.sixquiprend.Items;

import javafx.scene.image.ImageView;

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
                '}';
    }
}
