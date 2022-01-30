package Model;

public class Board {

    private final String[][] board;

    public Board(int n) {
        board = new String[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = "-";
            }
        }
    }

    public void printBoard() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public String[][] getBoard() {
        return board;
    }

    public void setPosition(int x, int y, String symbol) {
        board[x][y] = symbol;
    }

    public String getPosition(int x, int y) {
        return board[x][y];
    }


}
