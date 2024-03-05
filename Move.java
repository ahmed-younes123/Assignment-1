package peggame;
public class Move {
    private Location from;
    private Location to;

    /** */
    public Move(Location from, Location to) {
        this.from = from ;
        this.to = to;
    }

    public Location getFrom() {
        return from;
    }

    
    public Location getTo() {
        return to;
    }

    /**
     * 
     * 
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Move){
            Move other = (Move) obj;
            return from.getRow()== other.from.getRow() && from.getCol() == other.from.getCol() && to.getRow() == other.to.getRow() && to.getCol() == other.to.getCol(); 
        } else {
            return false;
        }
    }
}
