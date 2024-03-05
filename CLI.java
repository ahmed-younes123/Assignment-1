package peggame;

import java.util.Scanner;

public class CLI {

    /**
     * takes an instance of peggame and activate a command line interface that loops and takes one command 'move'. it loop until you win or a stalemate
     * @param pegGame
     * @throws PegGameException
     */
    static void playPeg(PegGame pegGame) throws PegGameException{
       
        try(Scanner scanner = new Scanner(System.in);){
            System.out.println("note the top left corner is r0 c0");
            while (true) {
                GameState state =pegGame.getGameState();

                if (state==GameState.WON){
                    System.out.println(pegGame);
                    System.out.println("You won");
                    break;
                } else if(state==GameState.STALEMATE){
                    System.out.println(pegGame);
                    System.out.println("Stalemate");
                    break;
                } else if (state==GameState.NOT_STARTED || state==GameState.IN_PROGRESS){
                    System.out.println(pegGame);
                    System.out.println("write command hint 'move ra cb rc cd' where a b c and d are numbers");
                    String command = scanner.next();
                    if (command.equalsIgnoreCase("move") ){
                        String oldPositionRow= scanner.next();
                        String oldPositionColumn= scanner.next();
                        String newPositionRow= scanner.next();
                        String newPositionColumn= scanner.next();
                        
                        if (oldPositionRow.charAt(0)=='r' && oldPositionColumn.charAt(0)=='c' && newPositionRow.charAt(0)=='r' && newPositionColumn.charAt(0)=='c'){
                            Location oldLocation =new Location(Integer.parseInt(oldPositionRow.substring(1)),Integer.parseInt(oldPositionColumn.substring(1)));
                            Location newLocation =new Location(Integer.parseInt(newPositionRow.substring(1)),Integer.parseInt(newPositionColumn.substring(1)));
                            Move move =new Move(oldLocation, newLocation);
                            pegGame.makeMove(move);
                        } else{
                            System.out.println("invalid letters,use format 'rw cx ry cz' where w, x, y, z are numbers");
                        }
                    } else {
                        System.out.println("invalid command, use the keyword 'move'");
                    }

            
                
                }
            }
        }
    }


}
