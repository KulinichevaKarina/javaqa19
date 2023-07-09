package org.example;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
        //добавить игрока в список players
    }

    private Player findById(int id) {
        for (Player player : players) {
            if (id == player.getId()) {
                return player;
            }
        }
        return null;
    }

    public int round(Player player1, Player player2) throws NotRegisteredException {
        if (findById(player1.getId()) == null || findById(player2.getId()) == null) {
            throw new NotRegisteredException("One of the players is not registered");
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else {
            return 0;
        }
    }
}
