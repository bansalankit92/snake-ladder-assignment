package in.co.ankitbansal;

import in.co.ankitbansal.model.Board;
import in.co.ankitbansal.model.Player;
import in.co.ankitbansal.service.impl.SingleBoardPlayerService;
import in.co.ankitbansal.service.impl.SingleCrookedDiceServiceImpl;

public class SnakeLadderApplication {

    public static void main(String[] args) {
        System.out.println("Playing with normal dice");
        playSinglePlayerGame();
        System.out.println("\n\nPlaying with crooked dice");
        playSinglePlayerCrookedGame();
    }

    private static void playSinglePlayerGame() {
        SingleBoardPlayerService service = new SingleBoardPlayerService();
        Player player = service.getCurrentPlayer();
        Board board = service.getBoard();
        for (int i = 0; i < 10; i++) {
            System.out.println();
            System.out.print("Player " + player.getName() + " is at position " + service.getPosition(player));
            board = service.playGame(player);
            System.out.print(" and has moved to position " + service.getPosition(player));
        }
    }

    private static void playSinglePlayerCrookedGame() {
        SingleBoardPlayerService service = new SingleBoardPlayerService(new SingleCrookedDiceServiceImpl());
        Player player = service.getCurrentPlayer();
        Board board = service.getBoard();
        for (int i = 0; i < 10; i++) {
            System.out.println();
            System.out.print("Player " + player.getName() + " is at position " + service.getPosition(player));
            board = service.playGame(player);
            System.out.print(" and has moved to position " + service.getPosition(player));
        }
    }

}
