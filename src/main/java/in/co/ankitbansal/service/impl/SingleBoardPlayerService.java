package in.co.ankitbansal.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import in.co.ankitbansal.model.Board;
import in.co.ankitbansal.model.Ladder;
import in.co.ankitbansal.model.Player;
import in.co.ankitbansal.model.Snake;
import in.co.ankitbansal.service.DiceService;

public class SingleBoardPlayerService {

    private Board board;
    private Player player;
    private DiceService diceService;

    private static final int DEFAULT_BOARD_SIZE = 100;

    public SingleBoardPlayerService(int boardSize, String playerName, List<Snake> snakes, List<Ladder> ladders,
            DiceService service) {
        this.board = new Board(boardSize, snakes, ladders);
        this.player = new Player(playerName);
        this.board.getPlayerPieces().put(this.player.getId(), 0);
        this.diceService = service;
    }

    public SingleBoardPlayerService() {
        List<Snake> snakes = new ArrayList<>();
        snakes.add(new Snake(14, 7));
        this.board = new Board(DEFAULT_BOARD_SIZE, snakes, new ArrayList<>());
        this.player = new Player(UUID.randomUUID().toString());
        this.board.getPlayerPieces().put(this.player.getId(), 0);
        this.diceService = new SingleDiceServiceImpl();
    }

    public SingleBoardPlayerService(DiceService service) {
        List<Snake> snakes = new ArrayList<>();
        snakes.add(new Snake(14, 7));
        this.board = new Board(DEFAULT_BOARD_SIZE, snakes, new ArrayList<>());
        this.player = new Player(UUID.randomUUID().toString());
        this.board.getPlayerPieces().put(this.player.getId(), 0);
        this.diceService = service;
    }

    public int getNewPositionAfterGoingThroughSnakesAndLadders(int newPosition) {

        for (Snake snake : board.getSnakes()) {
            if (snake.getStart() == newPosition) {
                newPosition = snake.getEnd();
            }
        }

        for (Ladder ladder : board.getLadders()) {
            if (ladder.getStart() == newPosition) {
                newPosition = ladder.getEnd();
            }
        }
        return newPosition;
    }

    public Board movePlayer(Player player, int positions) {
        int oldPosition = board.getPlayerPieces().get(player.getId());
        int newPosition = oldPosition + positions;

        if (newPosition > board.getSize()) {
            newPosition = oldPosition;
        } else {
            newPosition = getNewPositionAfterGoingThroughSnakesAndLadders(newPosition);
        }

        board.getPlayerPieces().put(player.getId(), newPosition);

        return board;
    }

    public int getTotalValueAfterDiceRolls() {
        // Can use noOfDices and setShouldAllowMultipleDiceRollOnSix here to get total value (Optional requirements)
        return diceService.roll();
    }

    public boolean hasPlayerWon(Player player) {
        int playerPosition = board.getPlayerPieces().get(player.getId());
        int winningPosition = board.getSize();
        return playerPosition == winningPosition;
    }

    public Board getBoard(){
        return board;
    }

    public Player getCurrentPlayer(){
        return player;
    }

    public Board playGame(Player player){
        int rollDice = getTotalValueAfterDiceRolls();
        return movePlayer(player,rollDice);
    }

    public int getPosition(Player player){
        return this.board.getPlayerPieces().get(player.getId());
    }
}