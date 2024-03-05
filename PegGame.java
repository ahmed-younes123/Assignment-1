package peggame;
import java.util.Collection;

public interface PegGame {
    
    /**
     * get all the possible moves that can be made on the board
     * @return collection arraylist of all the possible moves
     */
    public Collection <Move> getPossibleMoves();

    /**
     * getter that return game currents tate (won, stalemate, not_started, in_progress )
     * @return game current state
     */
    public GameState getGameState();

    /**
     * take a move as a parameter and compare it with the moves in the all possible moves list, if a a match found, the peg is moved on the board and the middle space between the old and new location is emptied. then check if the game is won is won ar stalemate. and set won or stalemate if any of them happened. If the move is invalid an error is thrown and handled
     * @param move
     * @throws PegGameException
     */
    public void makeMove (Move move) throws PegGameException;
}


