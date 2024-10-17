import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameWon = false;
        int turns = 0;

        while (!gameWon && turns < 9) {
            printBoard();
            System.out.println("Player " + currentPlayer + "'s turn. Enter row and column (0, 1, or 2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                gameWon = checkWin(currentPlayer);
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                turns++;
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }

        printBoard();

        if (gameWon) {
            System.out.println("Player " + (currentPlayer == 'X' ? 'O' : 'X') + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("-----");
        }
    }

    public static boolean checkWin(char player) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player)
                return true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;

        return false;
    }
}
