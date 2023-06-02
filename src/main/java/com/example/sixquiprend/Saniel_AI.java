package com.example.sixquiprend;

import com.example.sixquiprend.Items.Card;

import java.util.List;

public class Saniel_AI extends Player {
    private final Game game;
    private int maxDiff;
    private int minBulls;

    public Saniel_AI(String name, int numPlayer, Game game) {
        super(name, numPlayer);
        this.game = game;
        this.maxDiff = 105;
        this.minBulls = 30;
    }
    // Joue un tour
    public int PlayTurn() {
        List<Card> hand = this.getHand();
        List<Card>[] table = this.game.getTable();
        Card optimalCard = null;
        // Analyse de la main
        for (Card card : hand) {
            int maxCardInRow = 0; //
            // Analyse du jeu en cours
            for (List<Card> row : table) {
                maxCardInRow = Math.max(maxCardInRow, row.get(row.size() - 1).getValue()); // Valeur de la carte la plus haute dans la ligne
                int bullsInRow = countBulls(row); // Nombre de têtes de boeufs dans la ligne
                int cardsInRow = row.size(); // Nombre de cartes dans la ligne

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

            // Ajouter la logique pour décider et prendre la ligne ici.
            int rowToTake = decideRowToTake();
            takeRow(rowToTake);
        }
        return maxDiff;
    }
    // décider quelle ligne prendre
    private int decideRowToTake(){
        List<Card>[] table = this.game.getTable();
        int minBulls = Integer.MAX_VALUE;  // Utiliser Integer.MAX_VALUE pour initialiser
        int rowToTake = -1;  // Initialiser à -1 pour s'assurer qu'une ligne est bien choisie
        for (int i = 0; i < table.length; i++) {
            List<Card> row = table[i];
            int bullsInRow = countBulls(row);
            if (bullsInRow < minBulls) {
                minBulls = bullsInRow;
                rowToTake = i;
            }
        }
        return rowToTake;
    }
    // prendre une ligne
    // prendre une ligne
    private void takeRow(int rowToTake) {
        List<Card>[] table = this.game.getTable();
        List<Card> row = table[rowToTake];
        this.getHand().addAll(row);  // Ajouter les cartes de la ligne à la main
        row.clear();  // Effacer la ligne sur la table
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
