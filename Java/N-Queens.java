public class NQueens {

    public static void printBoard(int[][] board, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print((board[i][j] == 1 ? "Q " : ". "));
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isSafe(int[][] board, int row, int col, int N) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static boolean solveNQueens(int[][] board, int col, int N) {
        if (col >= N) {
            return true;
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col, N)) {
                board[i][col] = 1;

                if (solveNQueens(board, col + 1, N)) {
                    return true;
                }

                board[i][col] = 0;
            }
        }

        return false;
    }

    public static void solve(int N) {
        int[][] board = new int[N][N];

        if (!solveNQueens(board, 0, N)) {
            System.out.println("Solution does not exist.");
            return;
        }

        printBoard(board, N);
    }

    public static void main(String[] args) {
        int N = 8;
        solve(N);
    }
}
