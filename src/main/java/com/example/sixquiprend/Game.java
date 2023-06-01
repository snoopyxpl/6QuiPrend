package com.example.sixquiprend;

import com.example.sixquiprend.Items.Card;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.*;

public class Game {
    private int nbPlayer;
    private int nbBeefToLoose;
    private boolean isBotActivated;
    private int currentPlayer;
    private boolean isGameClosed;

    private List<Card> deck,listlastcard,listlastcardontable;

    private List<List<Card>> table = new ArrayList<>(Arrays.asList(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));


    //indique si la partie est terminé et qu'il ne reste plus qu'à compter les têtes de boeufs
    public List<Card> shuffle() {
        deck = Card.generateDeck();
        Collections.shuffle(deck);
        return deck;
    }
    public void dealCards() {
        for (int i = 0; i < 10; i++) {
            for (Player player : playerList) {
                Card card = deck.remove(0);
                player.addtohand(card);
            }
        }
    }
    public void shorthand(){
        for (Player player : playerList) {
           List<Card> hand= player.getHand();
           CardMergeSorter.mergeSortByValue(hand);
           player.setHand(hand);
        }
    }

    public List<Card> getDeck() {
        return deck;
    }

    public static Game option;
    public Game() {
        this.deck = shuffle();
    }
    public boolean isBotActivated() {
        return isBotActivated;
    }

    public void setBotActivated(boolean botActivated) {
        isBotActivated = botActivated;
    }
    public static void startNewGame() {
        // A chaque fois qu''on retourne sur le menu principal, on remet les options du jeu à zero
        Game.option = null;
        Game.option = new Game();
    }

    public int getNbPlayer() {
        return nbPlayer;
    }

    public void setNbPlayer(int nbPlayer) {
        this.nbPlayer = nbPlayer;
    }

    public int giveCardRandom(){
        //for (int i=1;i<=4;i++){
        int firstCard = random.nextInt(104)+1;
        return firstCard;
    }
    public String IntToString(int number){
        String nombreEnString = Integer.toString(number);
        return nombreEnString;
    }
    public int getNbBeefToLoose() {
        return nbBeefToLoose;
    }

    public void setNbBeefToLoose(int nbBeefToLoose) {
        this.nbBeefToLoose = nbBeefToLoose;
    }

    Random random = new Random();
    GameGestion gameGestion = new GameGestion();
    private List<Player> playerList=new ArrayList<>();
    private Map<Integer , Player> playerBaseNum = new HashMap<>();
    private Map<Image,Card> cardBaseImage = new HashMap<>();

    public Map<Image, Card> getCardBaseImage() {
        return cardBaseImage;
    }

    public void setCardBaseImage(Map<Image, Card> cardBaseImage) {
        this.cardBaseImage = cardBaseImage;
    }

    public void makeHashMapCardImage(){
        for (Card card : deck){
            cardBaseImage.put(card.getImage(),card);
        }
    }



    public Map<Integer, Player> getPlayerBaseNum() {
        return playerBaseNum;
    }

    public void setPlayerBaseNum(Map<Integer, Player> playerBaseNum) {
        this.playerBaseNum = playerBaseNum;
    }

    private List<Card> lastCardBoardList = new ArrayList<>();


    public void addPlayerToList(String name,int numPlayer, List<Card> hand){
        Player player = new Player(name,numPlayer,hand);
        playerList.add(player);
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public List<Card> getLastCardBoardList() {
        return lastCardBoardList;
    }

    public void setLastCardBoardList(List<Card> lastCardBoardList) {
        this.lastCardBoardList = lastCardBoardList;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean isGameClosed() {
        return isGameClosed;
    }

    public void setGameClosed(boolean gameClosed) {
        isGameClosed = gameClosed;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
    public void initialization(){
        makeHashMapPlayer();

    }


    public void endTurnPlayer(Card cardPlayed){
        Player lastPlayer = playerList.get(currentPlayer);
        isGameClosed = lastPlayer.isGameLoose();
        if (isGameClosed){
            //controller
        }
        lastPlayer.setLastCard(cardPlayed);
        lastPlayer.playACard(cardPlayed);
        System.out.println("taille main "+playerBaseNum.get(currentPlayer).getHand().size());
        if (currentPlayer<nbPlayer-1){
            currentPlayer++;
        }else{
            currentPlayer=0;
        }
    }
    public void makeHashMapPlayer(){
        for (Player player : playerList){
            playerBaseNum.put(player.getNumPlayer(),player);
        }
    }

    public int getPlaceOfCardPlayed(Card cardPlayed){
        return gameGestion.inWichRow(cardPlayed,lastCardBoardList);
    }
    public void addfirscardtotable(){
        for (List<Card> row : table) {
            Card card = deck.remove(0);
            row.add(card);
            listlastcardontable.add(card);
        }

    }
    public void  getPlayerWithMatchingLastCardValue() {
        for (List<Card> row : table) {
            if (row.size() == 6) {
                int sixthElementValue = row.get(5).getValue(); // Récupère la valeur du sixième élément de la liste
                int columnSum = 0; // Variable pour stocker la somme des valeurs des cartes de la colonne
                for (List<Card> column : table) {
                    if (column.size() >= 6) {
                        columnSum += column.get(5).getBeefhead(); // Ajoute la valeur du sixième élément de la colonne à la somme
                    }
                }
                for (Player player : playerList) {
                    if (player.getLastCard().getValue() == sixthElementValue) {
                        player.setNbBeefTot(player.getNbBeefTot() - columnSum); // Soustrait la somme des valeurs de la colonne du score du joueur
                        row.clear();
                        row.add(0, player.getLastCard());
                    }
                }
            }
        }
    }

    public void setplayerlastcard(Player player,Card card){
        player.setLastCard(card);
        listlastcard.add(card);
    }
    public void setOrderToPlaceCardOnTable() {
        List<Card> shortlistlastcard = CardMergeSorter.mergeSortByValue(listlastcard);
        if (!shortlistlastcard.isEmpty()) {
            while (!shortlistlastcard.isEmpty()) {
                Card firstCard = shortlistlastcard.remove(0); // Prend le premier élément et le retire de la liste
               int  i=GameGestion.inWichRow(firstCard,listlastcardontable);
               listlastcardontable.set(i,firstCard);
            }
        }
    }
}
