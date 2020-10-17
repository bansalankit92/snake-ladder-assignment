package in.co.ankitbansal.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private int size;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private Map<String, Integer> playerPieces;

    public Board(int size) {
        this.size = size;
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
        this.playerPieces = new HashMap<>();
    }

    public int getSize() {
        return size;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public Map<String, Integer> getPlayerPieces() {
        return playerPieces;
    }

}