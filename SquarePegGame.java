package peggame;

import java.util.ArrayList;
import java.util.Collection;

public class SquarePegGame implements PegGame {

    private Location[][] board;
    private GameState current_state;

    /**
     * constructor for square game where it take the number of rows and columns and make an instance with the an empty board and the current state which is game not started  
     * @param row the numbers of rows in the game board
     * @param col the number of columns in the game board
     */
    public SquarePegGame(int row, int col ) {
        this.current_state = GameState.NOT_STARTED;
        this.board = new Location[row][col];
    }
    
    /**
     * a getter that get the instance board, used when making the board in the class BoardShape
     * @return board
     */
    public Location[][] getBoard() {
        return board;
    }

    /**
     * a getter that get the instance current game state
     * @return current_state (game current state)
     */
    @Override
    public GameState getGameState() {
        return current_state;
    }
    
    
    /**
     * make a a list with collection interface that return all current possible moves in the game
     * @return collection of all possible moves
     */
    @Override
    public Collection<Move> getPossibleMoves() {
        Collection<Move> collection = new ArrayList<>();
        Location[][] temporaryBoard = board;
        for (int row = 0; row < temporaryBoard.length; row++) {
            for (int column = 0; column < temporaryBoard[row].length; column++) {
                if (temporaryBoard[row][column] != null) {

                    int[][] checkers = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, 1 }, { -1, -1 },
                            { 1, -1 } };
                    for (int[] checker : checkers) {
                        int middlePegRow = row + checker[0];
                        int middlePegColumn = column + checker[1];
                        int newPegRow = middlePegRow + checker[0];
                        int newPegColumn = middlePegColumn + checker[1];

                        if (middlePegRow >= 0 && middlePegColumn >= 0 && newPegRow >= 0 && newPegColumn >= 0&& middlePegRow < temporaryBoard.length && middlePegColumn < temporaryBoard[0].length && newPegRow < temporaryBoard.length && newPegColumn < temporaryBoard[0].length && temporaryBoard[middlePegRow][middlePegColumn] != null&& temporaryBoard[newPegRow][newPegColumn] == null) {
                            collection.add(new Move(temporaryBoard[row][column], new Location(newPegRow, newPegColumn)));
                        }
                    }
                }
            }
        }

        return collection;
    }

    /** take a move as a parameter and compare it with the moves in the all possible moves list, if a a match found, the peg is moved on the board and the middle space between the old and new location is emptied. then check if the game is won is won ar stalemate. and set won or stalemate if any of them happened. If the move is invalid an error is thrown and handled
     * @param move
     * 
     */
    @Override
    public void makeMove(Move move) throws PegGameException {
        try{
            if (getPossibleMoves().contains(move)) {
                int oldRow = move.getFrom().getRow();
                int oldCol = move.getFrom().getCol();
                int newRow = move.getTo().getRow();
                int newCol = move.getTo().getCol();  
                int middleRow = (newRow+oldRow)/2   ;
                int middleColumn= (newCol+oldCol)/2;
                board[oldRow][oldCol] = null;
                board[middleRow][middleColumn] = null;
                board[newRow][newCol] = move.getTo();

                if(getPossibleMoves().isEmpty() && pegCounter()> 1){
                    current_state=GameState.STALEMATE;
                    return;
                }
                current_state=GameState.IN_PROGRESS;
                System.out.println("test");
                return;
            }else if(getPossibleMoves().isEmpty() && pegCounter()> 1){
                current_state=GameState.STALEMATE;
                return;
            }else if (getPossibleMoves().isEmpty() && pegCounter()== 1){
                current_state=GameState.WON;
                return;
            } else {
                throw new PegGameException("invalid move");
            }
        } catch(PegGameException e){
            System.out.println(e);
        }
    }

    /**
     * count the number of pegs on the board and return them as an integer.
     * @return the numbers of peg
     */
    private int pegCounter(){
        int pegCount=0;
        for (Location[] row: board){
            for (Location column: row){
                if (column !=null){
                    pegCount++;
                }
            }
        }
        return pegCount;
    }

    /**
     * string representation of the board
     *  
     */
    @Override
    public String toString() {
        String stringBoard = "";
        for (Location[] row : board) {
            stringBoard += "\n";
            for (Location column : row) {
                if (column == null) {
                    stringBoard += ".";
                } else {
                    stringBoard += column;
                }
            }
        }
        return stringBoard;
    }

}
