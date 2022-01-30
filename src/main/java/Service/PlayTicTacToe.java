package Service;

import Model.Board;
import Model.Player;

import java.util.List;
import java.util.Scanner;

public class PlayTicTacToe {

    Board board;
    List<Player> players;

    public PlayTicTacToe(List<Player> players, int n) {
        this.board = new Board(n);
        this.players = players;
    }

    public void playGame() {
        board.printBoard();
        int playersTurn = 0;
        int cellsFilled = 0;
        boolean gotWinner = false;
        Scanner scn = new Scanner(System.in);
        Player player;
        while (true) {

            player = players.get(playersTurn);
            String input = scn.nextLine();
            int row, col;
            if(input.equals("exit")) {
                board.printBoard();
                break;
            }
            else {
                String[] rowCol = input.split(" ");
                row = Integer.parseInt(rowCol[0])-1;
                col = Integer.parseInt(rowCol[1])-1;
            }

            if(checkValidPosition(row, col) && checkEmptyPosition(row, col)) {
                board.setPosition(row, col, player.getSymbol());
                board.printBoard();

                if(checkRow(row, player.getSymbol()) || checkColumn(col, player.getSymbol()) ||
                        checkLeftDiagonal(row, col, player.getSymbol()) || checkRightDiagonal(row, col, player.getSymbol())) {
                    gotWinner = true;
                    break;
                }

                cellsFilled++;
                if(cellsFilled == board.getBoard().length * board.getBoard().length) {
                    System.out.println("Game Over");
                    break;
                }

                playersTurn = (playersTurn + 1) % players.size();

            }
            else {
                System.out.println("Invalid move");
            }
        }

        if(gotWinner)
            System.out.println(player.getName() + " won the game");

    }

    private boolean checkValidPosition(int row, int col) {
            return (row >= 0 && row < board.getBoard().length && col >= 0 && col < board.getBoard().length );
    }

    private boolean checkEmptyPosition(int row, int col) {
        if(!board.getPosition(row, col).equals("-")) {
            System.out.println("This cell is already filled");
            return  false;
        }
        return true;
    }

    private boolean checkRow(int row, String symbol) {
        for(int j = 0; j < board.getBoard().length; j++) {
            if(!board.getPosition(row, j).equals(symbol))
                return false;
        }
        return true;
    }

    private boolean checkColumn(int col, String symbol) {
        for(int i = 0; i < board.getBoard().length; i++) {
            if(!board.getPosition(i, col).equals(symbol))
                return false;
        }
        return true;
    }

    private boolean checkRightDiagonal(int row, int col, String symbol) {
        if(row != col)
            return false;

        for(int i = 0; i < board.getBoard().length; i++) {
            if(!board.getPosition(i, i).equals(symbol))
                return false;
        }
        return true;
    }

    private boolean checkLeftDiagonal(int row, int col, String symbol) {
        if(row + col != board.getBoard().length - 1)
            return false;

        for(int i = 0; i < board.getBoard().length; i++) {
            if(!board.getPosition(i, board.getBoard().length-1-i).equals(symbol))
                return false;
        }
        return true;
    }

}
