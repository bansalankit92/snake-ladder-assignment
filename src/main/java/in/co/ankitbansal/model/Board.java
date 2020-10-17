package in.co.ankitbansal.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    private int size;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private Map<String, Integer> playerPiecesPosition;

    public Board(int size, List<Snake> snakes, List<Ladder> ladders) {
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
        this.playerPiecesPosition = new HashMap<>();
    }

    public int getSize() {
        return size;
    }

    public int getPlayerPosition(String playerId) {
        return playerPiecesPosition.get(playerId);
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public Map<String, Integer> getPlayerPiecesPosition() {
        return playerPiecesPosition;
    }

}