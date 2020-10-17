package in.co.ankitbansal.service.impl;

import java.util.List;
import in.co.ankitbansal.model.Board;
import in.co.ankitbansal.model.Ladder;
import in.co.ankitbansal.model.Player;
import in.co.ankitbansal.model.Snake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleBoardPlayerServiceTest {

    private SingleBoardPlayerService service = new SingleBoardPlayerService();
    private List<Snake> snakes;
    private List<Ladder> ladders;

    @BeforeEach
    void setup() {
        snakes = List.of(new Snake(14, 7));
        ladders = List.of(new Ladder(20, 24));
        service = new SingleBoardPlayerService(100, "Sample", snakes, ladders, new SingleDiceServiceImpl());
    }

    @Test
    void getNewPositionAfterGoingThroughSnakes() {
        Board board = service.getBoard();
        Player player = service.getCurrentPlayer();
        board.getPlayerPiecesPosition().put(player.getId(), snakes.get(0).getStart());
        assertEquals(snakes.get(0).getEnd(),
                service.getNewPositionAfterGoingThroughSnakesAndLadders(snakes.get(0).getStart()));
        board.getPlayerPiecesPosition().put(player.getId(), ladders.get(0).getStart());
        assertEquals(ladders.get(0).getEnd(),
                service.getNewPositionAfterGoingThroughSnakesAndLadders(ladders.get(0).getStart()));

        board.getPlayerPiecesPosition().put(player.getId(), 21);
        assertEquals(21, service.getNewPositionAfterGoingThroughSnakesAndLadders(21));
    }

    @Test
    void getNewPositionAfterGoingThroughLadder() {
        Board board = service.getBoard();
        Player player = service.getCurrentPlayer();
        board.getPlayerPiecesPosition().put(player.getId(), ladders.get(0).getStart());
        assertEquals(ladders.get(0).getEnd(),
                service.getNewPositionAfterGoingThroughSnakesAndLadders(ladders.get(0).getStart()));
    }

    @Test
    void movePlayerWinPosition() {
        Board board = service.getBoard();
        Player player = service.getCurrentPlayer();
        board.getPlayerPiecesPosition().put(player.getId(), board.getSize() - 2);
        service.movePlayer(player, 2);
        assertEquals(board.getSize(), service.getPosition(player));

    }

    @Test
    void movePlayerNotWinPosition() {
        Board board = service.getBoard();
        Player player = service.getCurrentPlayer();
        board.getPlayerPiecesPosition().put(player.getId(), board.getSize() - 2);
        service.movePlayer(player, 3);
        assertEquals(board.getSize() - 2, service.getPosition(player));

    }

    @Test
    void movePlayerMiddlePosition() {
        Board board = service.getBoard();
        Player player = service.getCurrentPlayer();
        board.getPlayerPiecesPosition().put(player.getId(), board.getSize() - 4);
        service.movePlayer(player, 3);
        assertEquals(board.getSize() - 1, service.getPosition(player));

    }

    @Test
    void getTotalValueAfterDiceRolls() {
        assertTrue(service.getTotalValueAfterDiceRolls() > 0);
        assertTrue(service.getTotalValueAfterDiceRolls() <= 6);
        assertTrue(service.getTotalValueAfterDiceRolls() < 7);
    }

    @Test
    void hasPlayerWon() {
        Board board = service.getBoard();
        Player player = service.getCurrentPlayer();
        board.getPlayerPiecesPosition().put(player.getId(), board.getSize());
        assertTrue(service.hasPlayerWon(player));
    }

    @Test
    void hasPlayerNotWon() {
        Board board = service.getBoard();
        Player player = service.getCurrentPlayer();
        service.playGame(player);
        assertFalse(service.hasPlayerWon(player));
    }

    @Test
    void getBoard() {
        service = new SingleBoardPlayerService();
        Board board = service.getBoard();
        assertEquals(1, board.getSnakes().size());
        assertEquals(0, board.getLadders().size());
        assertEquals(100, board.getSize());
    }

    @Test
    void getCurrentPlayer() {
        Board board = service.getBoard();
        Player player = service.getCurrentPlayer();
        assertTrue(board.getPlayerPiecesPosition().containsKey(player.getId()));
    }

    @Test
    void playGame() {
        Board board = service.getBoard();
        Player player = service.getCurrentPlayer();
        int oldPosition = board.getPlayerPosition(player.getId());

        board = service.playGame(player);
        assertNotEquals(oldPosition, board.getPlayerPosition(player.getId()));
    }

    @Test
    void playCrookedGame() {
        service = new SingleBoardPlayerService(new SingleCrookedDiceServiceImpl());
        Player player = service.getCurrentPlayer();
        assertEquals(0, service.playGame(player).getPlayerPosition(player.getId()) % 2);
        assertEquals(0, service.getTotalValueAfterDiceRolls() % 2);
        assertEquals(0, service.getTotalValueAfterDiceRolls() % 2);
        assertEquals(0, service.getTotalValueAfterDiceRolls() % 2);

    }

    @Test
    void getPosition() {
        Board board = service.getBoard();
        Player player = service.getCurrentPlayer();
        assertEquals(board.getPlayerPiecesPosition().get(player.getId()), service.getPosition(player));
        board = service.playGame(player);
        assertEquals(board.getPlayerPiecesPosition().get(player.getId()), service.getPosition(player));
    }

}