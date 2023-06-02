package com.example.sixquiprend;

import com.example.sixquiprend.Items.Card;

import java.util.ArrayList;
import java.util.List;

public class CardMergeSorter {
    public static List<Card> mergeSortByValue(List<Card> cards) {
        if (cards.size() <= 1) {
            return cards;
        }

        int middle = cards.size() / 2;
        List<Card> left = new ArrayList<>(cards.subList(0, middle));
        List<Card> right = new ArrayList<>(cards.subList(middle, cards.size()));

        mergeSortByValue(left);
        mergeSortByValue(right);

        merge(cards, left, right);
        return cards;
    }

    private static void merge(List<Card> cards, List<Card> left, List<Card> right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int cardsIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex).getValue() <= right.get(rightIndex).getValue()) {
                cards.set(cardsIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                cards.set(cardsIndex, right.get(rightIndex));
                rightIndex++;
            }
            cardsIndex++;
        }

        while (leftIndex < left.size()) {
            cards.set(cardsIndex, left.get(leftIndex));
            leftIndex++;
            cardsIndex++;
        }

        while (rightIndex < right.size()) {
            cards.set(cardsIndex, right.get(rightIndex));
            rightIndex++;
            cardsIndex++;
        }

    }

    public static void main(String[] args) {
        // Exemple d'utilisation du tri fusion
        //Game.startNewGame();
        List<Card> deck = Game.option.getDeck();

        System.out.println("Avant le tri :");
        for (Card card : deck) {
            System.out.println("Value: " + card.getValue());
        }

        //mergeSortByValue(deck);

        System.out.println("Après le tri :");
        for (Card card : deck) {
            System.out.println("Value: " + card.getValue());
        }
        List<Player> nbtest = new ArrayList<>();
        nbtest.add(new Player("michel", 1, new ArrayList<>()));
        nbtest.add(new Player("michel", 2, new ArrayList<>()));
        nbtest.add(new Player("michel", 3, new ArrayList<>()));
        Game.option.setPlayerList(nbtest);
        Game.option.dealCards();
        Game.option.shorthand();
        System.out.println(nbtest);
    }


}




