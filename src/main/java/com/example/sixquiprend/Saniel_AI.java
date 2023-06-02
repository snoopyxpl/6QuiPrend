package com.example.sixquiprend;

import com.example.sixquiprend.Items.Card;

import java.util.List;

public class Saniel_AI extends Player {
    private Game game;
    private int maxDiff;
    private int minBulls;

    public Saniel_AI(String name, int numPlayer, Game game) {
        super(name, numPlayer);
        this.game = game;
        this.maxDiff = 105;
        this.minBulls = 30;
    }

    public int PlayTurn(Game game) {
        List<Card> hand = this.getHand();
        List<Card>[] table = this.game.getTable();
        Card optimalCard = null;

        for (Card card : hand) {
            int maxCardInRow = 0;
            // Analyse du jeu en cours
            for (List<Card> row : table) {
                maxCardInRow = Math.max(maxCardInRow, row.get(row.size() - 1).getValue());
                int bullsInRow = countBulls(row);
                int cardsInRow = row.size();

                // Essayer de jouer une carte sans ramasser une ligne
                if (card.getValue() > maxCardInRow && cardsInRow < 5) {
                    this.setLastCard(card); // on joue la carte
                    hand.remove(card); // on retire la carte de la main
                    row.add(card); // on ajoute la carte à la ligne
                    return maxDiff;
                }

                // Mettre à jour les variables temoins
                maxDiff = Math.min(maxDiff, card.getValue() - maxCardInRow);
                minBulls = Math.min(minBulls, bullsInRow);
            }

            // Si aucune carte ne peut être jouée sans risquer de prendre une ligne, chercher la carte optimale
            for (List<Card> row : table) {
                Card lastCardInRow = row.get(row.size() - 1);
                int diff = card.getValue() - lastCardInRow.getValue();
                if (diff > 0) {
                    int bull = row.size() == 5 ? countBulls(row) : 0;
                    if ((bull < minBulls) || (bull == minBulls && diff < maxDiff)) {
                        maxDiff = diff;
                        minBulls = bull;
                        optimalCard = card;
                    }
                }
            }
        }

        // Jouer la carte optimale, ou la carte de valeur la plus basse en cas d'égalité
        if (optimalCard != null) {
            this.setLastCard(optimalCard);
            hand.remove(optimalCard);
        } else {
            Card lowestCard = getLowestCard();
            this.setLastCard(lowestCard);
            hand.remove(lowestCard);
        }
        return maxDiff;
    }
    // Retourne le nombre de tete de boeuf dans une ligne
    private int countBulls(List<Card> row) {
        int totalBulls = 0;
        for (Card card : row) {
            totalBulls += card.getBeefhead();
        }
        return totalBulls;
    }
    // Retourne la carte de valeur la plus basse de la main
    private Card getLowestCard() {
        List<Card> hand = this.getHand();
        Card lowestCard = hand.get(0);
        for (Card card : hand) {
            if (card.getValue() < lowestCard.getValue()) {
                lowestCard = card;
            }
        }
        return lowestCard;
    }
}