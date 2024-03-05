package peggame;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;


public class Junit_testing {
    @Test
    public void locationCreation(){

        int expecterRow =10;
        int expectedCol =5;
        Location location = new Location(10, 5);
        assertEquals(expecterRow, location.getRow());
        assertEquals(expectedCol, location.getCol());
    }
    
    @Test
    public void moveEquals(){

        Location location1= new Location(3,4);
        Location location2= new Location(3,4);
        Move move1 = new Move(location1, location2);

        Location location3= new Location(3,4);
        Location location4= new Location(3,4);

        Move move2 = new Move(location3, location4);

        assertEquals(true, move1.equals(move2));
    }

    @Test
    public void exceptionTest()throws PegGameException{
        try{
            throw new PegGameException("this is an error");
        }catch (PegGameException e){
            assertEquals("this is an error", e.getMessage());
        }
    }

    @SuppressWarnings("deprecation")
    @Test
    
    public void boardCreation() throws IOException{
        Location[][] arr = new Location[5][5];
        for (int row=0;row< arr.length; row++){
            for(int column =0; column<arr.length; column++){
                arr[row][column]= new Location(row, column);
            }
        }
        PegGame square_1 = new BoardShape("null").readFromFile();
        SquarePegGame actual=(SquarePegGame)square_1;
        assertEquals(arr,actual.getBoard());

    }

    public void movesTest() throws IOException{

        PegGame square_1 = new BoardShape("null").readFromFile();

        assertEquals(arr,actual.getBoard());

    }

}
