package com.example.sixquiprend;

import com.example.sixquiprend.Items.Card;

import java.util.List;

public class Saniel_AI extends Player {
    private Game game;
    private int temoin;
    private int nbBeefHeads;

    public Saniel_AI(String name, int numPlayer, Game game) {
        super(name, numPlayer);
        this.game = game;
        this.temoin = 105;
        this.nbBeefHeads = 0;
    }

    public int PlayTurn(Game game) {
        // Analyse du jeu en cour
        List<Card> hand = this.getHand();
        List<List<Card>> table = null;
        for (List<Card> cards : this.game.table) {

        }


        // initialisation des variables temoin
        int maxDiff = 105;
        int minBulls = 30;
        int minCards = 6;
        Card optimalCard = null;

        //Essayer de jouer une carte sans ramasser une ligne
        for (Card card : hand) {
            for (List<Card> row : table) {
                if (!row.isEmpty() && card.getValue() > row.get(row.size() - 1).getValue()
                        && row.size() < 5) {
                    this.setLastCard(card); // on joue la carte
                    hand.remove(card); // on retire la carte de la main
                    row.add(card); // on ajoute la carte à la ligne
                    return maxDiff;
                }
            }
        }

        // si aucune carte ne peut être jouée sans risquer de prendre une ligne,
        // chercher la carte optimale

        for (Card card : hand) {
            for (List<Card> row : table) {
                Card lastCardInRow = row.get(row.size()-1);
                int diff = card.getValue() - lastCardInRow.getValue();
                // si la carte peut être placé dans cette ligne

                if (diff > 0) {
                    // Si cette rangée doit être prise, calculez le nombre de têtes de bœuf
                    int bull = row.size() ==5 ? countBulls(row):0;

                    // si la carte est meilleure que la carte optimale actuelle, mettre à jour carte optimal
                    if ((bull < minBulls) || (bull == minBulls && diff< maxDiff)) {
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


    private int countBulls (List<Card>row){
        int totalBulls=0;

        for (Card card : row){
            totalBulls += card.getBeefhead();
        }
        return totalBulls;
    }

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
