import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printBoard(board);

            // Player's move
            makeMove(board, 'X');

            // Check for a win or a draw
            if (checkWin(board, 'X')) {
                printBoard(board);
                System.out.println("You win!");
                break;
            } else if (isBoardFull(board)) {
                printBoard(board);
                System.out.println("It's a draw!");
                break;
            }

            // AI's move
            makeAIMove(board);

            // Check for a win or a draw
            if (checkWin(board, 'O')) {
                printBoard(board);
                System.out.println("AI wins!");
                break;
            } else if (isBoardFull(board)) {
                printBoard(board);
                System.out.println("It's a draw!");
                break;
            }
        }
    }

    // Print the Tic-Tac-Toe board
    private static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Make a move for the player (human)
    private static void makeMove(char[][] board, char player) {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        do {
            System.out.print("Enter row (0-2) and column (0-2) separated by space: ");
            row = scanner.nextInt();
            col = scanner.nextInt();
        } while (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ');
        board[row][col] = player;
    }

    // Make a move for the AI using the minimax algorithm
    private static void makeAIMove(char[][] board) {
        int[] bestMove = minimax(board, 'O');
        board[bestMove[0]][bestMove[1]] = 'O';
    }

    // Check for a win for the specified player
    private static boolean checkWin(char[][] board, char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }

        // Check diagonals
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    // Check if the board is full (a draw)
    private static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // Minimax algorithm for AI move
    private static int[] minimax(char[][] board, char player) {
        // TODO: Implement the minimax algorithm for AI move
        // This function should return the row and column of the best move for the AI player
        // You may need to create a recursive helper function for the minimax algorithm
        // Reference: https://en.wikipedia.org/wiki/Minimax
        return new int[]{0, 0}; // Placeholder
    }
}
