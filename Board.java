public class Board {
    /* A class representation of a TicTacToe board.
    The board is a 9 element array. The constructor (provided)
    initializes these values to the strings "1", "2", ... "9".
    When a player makes a move on the board, that element in the
    array should be replaced by "X" or "O" respectively.
    https://en.wikipedia.org/wiki/Tic-tac-toe

    Complete the isEmptyPosition(pos), displayBoard(), winner(),
    and applyMove(move) methods.
    */
    public String[] board = new String[9];

    /**
    * The board is initialized to hold strings containing numbers
    * ["1" "2" "3" "4" "5" "6" "7" "8" "9"]
    */
    public Board() {
        for (int a = 0; a < 9; a++) {
            this.board[a] = String.valueOf(a + 1);
        }
    }

    /**
     * // TODO: Return if the desired position has not been filled yet.
     * @param pos the desired position 1-9
     * @return true if an X or O has already been placed at the position,
     *         or false a number is at the position.
     */
    public boolean isEmptyPosition(int pos) {

        if(board[pos-1].equals("X") || board[pos-1].equals("O")) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * TODO: Display the current board in the console.
     */

    public void displayBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");
    }

    /**
     * TODO: Return the winner of the game or null.
     * @return "X" or "O" if a respective player has achieved 3 in a row,
     *         "draw" if the board is full and no player won,
     *         or null if there is no winner.
     */

    public boolean draw(){
        for(int i = 1; i < 10; i++){
            if(isEmptyPosition(i)){
                return false;
            }
        }
        return true;
    }
    public String winner() {

        // Check rows
        for(int i = 0; i < 9; i += 3) {
            if(board[i].equals(board[i+1]) && board[i].equals(board[i+2])) {
                return board[i];
            }
        }

        // Check columns
        for(int i = 0; i < 3; i++) {
            if(board[i].equals(board[i+3]) && board[i].equals(board[i+6])) {
                return board[i];
            }
        }

        // Check diagonals
        if(board[0].equals(board[4]) && board[0].equals(board[8])) {
            return board[0];
        }
        if(board[2].equals(board[4]) && board[2].equals(board[6])) {
            return board[2];
        }

        if(draw()){
            return "draw";
        }



        // No winner

        return null;

    }

    /**
     * TODO: Apply a given move to the board.
     * @param move contains the player's symbol (move.player.symbol)
     *             and the location they'd like to place it (move.pos).
     */
    public void applyMove(Move move) {
        if(!isEmptyPosition(move.pos)) {
            System.out.println("Position already occupied!");
            return;
        }

        board[move.pos-1] = move.player.symbol;
    }
}
