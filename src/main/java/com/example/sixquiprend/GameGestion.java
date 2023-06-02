package com.example.sixquiprend;

import com.example.sixquiprend.Items.Card;

import java.util.ArrayList;
import java.util.List;

public class GameGestion {
    public static int inWichRow(Card cardToPlace, List<Card> cards) {
        //Deux sélections s'opère : une première qui élimine les colonnes qui sont impossible car la valeur de la carte
        //à placer est inférieur à la valuer de la dernière carte. La deuxième pour détemrminer avec laquelle des restantes
        //il y a la plus petite des marges
        List<Card> newListCard = firstSelection(cardToPlace, cards);
        Card cardRow;
        if (newListCard.size() == 1) {
            cardRow = newListCard.get(0);
        } else {
            cardRow = lastCardRow(cardToPlace, newListCard);
        }

        int indexCard = 0;
        for (Card card : cards) {
            if (card.equals(cardRow)) {
                indexCard = cards.indexOf(card);
            }
        }

        return indexCard;
    }

    private static List<Card> firstSelection(Card carteToPlace, List<Card> cards) {
        List<Card> listCards = new ArrayList<>();
        for (Card card : cards) {
            if (card.getValue() < carteToPlace.getValue()) {
                listCards.add(card);
            }
        }
        return listCards;
    }

    private static Card lastCardRow(Card carteToPlace, List<Card> newCards) {
        Card cardRow = newCards.get(0);
        int valDiff = carteToPlace.getValue() - cardRow.getValue();
        int posDiff = 0;

        for (int i = 1; i < newCards.size(); i++) {
            if (valDiff > carteToPlace.getValue() - newCards.get(i).getValue()) {
                valDiff = carteToPlace.getValue() - newCards.get(i).getValue();
                posDiff = i;
            }
        }

        return newCards.get(posDiff);
    }
}
