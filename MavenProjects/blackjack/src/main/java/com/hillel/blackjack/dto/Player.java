package com.hillel.blackjack.dto;

import java.util.ArrayList;
import java.util.List;

public class Player {

    public Player(String name, Integer startAmount) {
        this.name = name;
        this.startAmount = startAmount;
        this.amount = startAmount;
    }

    private String name;
    private int numberOfGames;
    private int numberOfWins;
    private Integer amount;
    private Integer startAmount;
    private List<Card> hand = new ArrayList<>();

    public void incrementNumberOfGames(){
        numberOfGames++;
    }

    public void incrementNumberOfWinGames(){
        numberOfWins++;
    }

    public void add(Integer add){
        amount += add;
    }

    public void sub(Integer sub){
        amount -= sub;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getPlayerResult(){
        return "Player " + name +  " win  " + numberOfWins + " games from " + numberOfGames +
                " \nplayer balance " + amount+ " and player earn " + (amount - startAmount) + " UAH";
    }
}
