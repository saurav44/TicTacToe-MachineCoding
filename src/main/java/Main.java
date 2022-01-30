import Model.Player;
import Service.PlayTicTacToe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final int NO_OF_PLAYERS = 2;
        final int SIZE_OF_BOARD = 3;

        System.out.println("Welcome to TicTacToe");

        Scanner scn = new Scanner(System.in);

        List<Player> players = new ArrayList<>();
        for(int i = 0; i < NO_OF_PLAYERS; i++) {
            String[] input = scn.nextLine().split(" ");
            Player player = new Player(i, input[1], input[0]);
            players.add(player);
        }

        PlayTicTacToe ticTacToe = new PlayTicTacToe(players, SIZE_OF_BOARD);
        ticTacToe.playGame();

    }
}
