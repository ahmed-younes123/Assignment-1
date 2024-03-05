package peggame;

import java.io.IOException;
import java.util.Scanner;

public class Project1Main {
    /**
     * the main method that activate the program and take the filepath from the user
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in);){
            System.out.println("Enter filename");
            String filename = scanner.nextLine();
            PegGame squarePegGame = new BoardShape(filename).readFromFile();

            CLI.playPeg(squarePegGame);
        } catch(IOException e){
            System.out.println("file does not exist");
        } catch (PegGameException a){
            
        }
    }
}
