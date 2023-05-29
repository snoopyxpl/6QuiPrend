package com.example.sixquiprend;

import com.example.sixquiprend.Items.Card;
import javafx.scene.image.ImageView;

import java.util.*;

public class Game {
    private int nbPlayer;
    private int nbBeefToLoose;
    private boolean isBotActivated;
    private int currentPlayer;
    private boolean isGameClosed;
    //indique si la partie est terminé et qu'il ne reste plus qu'à compter les têtes de boeufs
    public static Game option;
    private Game() {}
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
    private List<Card> lastCardBoardList = new ArrayList<>();


    public void addPlayerToList(String name,int numPlayer){
        Player player = new Player(name,numPlayer);
        playerList.add(0,player);
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
        playerList = playerList;
    }
    public void initialization(){
        makeHashMapPlayer();

    }

    public void endTurnPlayer(Player lastPlayer, Card cardPlayed){
        isGameClosed = lastPlayer.isGameLoose();
        if (isGameClosed){
            //controller
        }
        lastPlayer.setLastCard(cardPlayed);
        currentPlayer++;
    }
    public void makeHashMapPlayer(){
        for (Player player : playerList){
            playerBaseNum.put(player.getNumPlayer(),player);
        }
    }

    public int getPlaceOfCardPlayed(Card cardPlayed){
        return gameGestion.inWichRow(cardPlayed,lastCardBoardList);
    }
}
