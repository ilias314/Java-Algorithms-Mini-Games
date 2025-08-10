public class TTT {
    int turn = 1;
    int[] board = new int[9];

    boolean makeMove(int pos) {
        if (pos < 0 || pos > 9) {
            return false;
        }
        if (board[pos] != 0) {
            return false;
        }
        board[pos] = turn;
        turn = -turn;
        System.out.println(this);
        return true;
        
    }

    

    int threeInARow() {
        int[][] winningPositions = {
                { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, { 0, 4, 8 }, { 2, 4, 6 }
        };
        for (int[] pos : winningPositions) {
            int sum = board[pos[0]] + board[pos[1]] + board[pos[2]];
            if (sum == 3) {
                return 1;
            } else if (sum == -3) {
                return -1;
            }
        }
        return 0;
    }
    
    public boolean isGameOver() {
        if (threeInARow() == 1 || threeInARow() == -1) {
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        String state = " ";
        for (int i = 0; i < board.length; i++) {
            if (board[i] == 1) {
                state += " X";
            } else if (board[i] == -1) {
                state += " O";
            } else
                state += " .";
            if ((i + 1) % 3 == 0 && i != board.length - 1) {
                state += "\n";
            }
        }if (isGameOver()) {
            return "GAME OVER: " + "player [" + turn + "] won";
        }
        return state;
        
    }
}


