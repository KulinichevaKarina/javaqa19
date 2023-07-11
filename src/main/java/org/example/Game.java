package org.example;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
        //добавить игрока в список players
    }

    private Player findByName(String name) {
        for (Player player : players) {
            if (name == player.getName()) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (player1 == null || player2 == null) {
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
