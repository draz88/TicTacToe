/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
import java.util.*;
/**
 *
 * @author johanwejdenstolpe
 */
public class Tictactoe {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Player> playerList = new ArrayList<>();
        String val;
        do{
            System.out.print("Hur många spelare (1-2): ");
            val = scan.nextLine();
        }while (checkNumberOfPlayers(val));
        int numberOfPlayers = Integer.parseInt(val);
        for (int i = 1; i <= numberOfPlayers; i++){
                System.out.print("Namn på spelare " + i + ": ");
                String name = scan.nextLine();
                Human newHuman = new Human(name);
                playerList.add(newHuman);
            
            if (numberOfPlayers == 1){
                System.out.println("Skapar datorspelare... HAL 9000");
//                AiDumb compPlayer = new AiDumb("HAL 9000");
                AiSmart compPlayer = new AiSmart("HAL 9000");
                playerList.add(compPlayer);
            }
        }
        String strRows;
        do{
            System.out.print("Hur många rader skall spelet ha? ");
            strRows = scan.nextLine();
        }while (checkStringForNumber(strRows));
        int numberOfRows = Integer.parseInt(strRows);
        Board board = new Board(numberOfRows);
        String strTurns;
        do{
            System.out.print("Hur många omgångar skall spelet ha? ");
            strTurns = scan.nextLine();
        }while (checkStringForNumber(strTurns));
        int intTurns = Integer.parseInt(strTurns);
        Game game = new Game(playerList, board, intTurns);
        
        String choice;
        do {
            boolean round = true;
            System.out.println("\n==============");
            System.out.println("== Omgång " + game.getCurrentTurn() + " ==");
            System.out.println("==============");
            while (round){
                
                for (int i = 0; i < game.getPlayers().size(); i++){
                    game.getBoard().printBoard();
                    do{
                        choice = game.getPlayers().get(i).takeTurn(game.getBoard());
                    }while (!game.getBoard().checkFormatAndOccupiedBoardSlot(choice));
                    if (i == 0){
                        game.getBoard().addChoice(choice, "X");
                    }else{
                        game.getBoard().addChoice(choice, "O");
                    }
                    
                    // Kolla om någon har vunnit
                    if (game.getBoard().checkForWinner()){
                        game.getBoard().printBoard();
                        game.addTurn();
                        game.getBoard().resetBoard();
                        game.getPlayers().get(i).addWin();
                        System.out.println("\n" + game.getPlayers().get(i).getName() + " vann denna runda!" + "\n");
                        round = false;
                        break;
                    }
                    // Kolla om spelplanen är full
                    if (game.getBoard().checkIfBoardIsFull()){
                        game.getBoard().printBoard();
                        game.addTurn();
                        game.getBoard().resetBoard();
                        System.out.println("\nRundan är oavgjord!\n");
                        round = false;
                        break;
                    }
                    
                }
                
            }
            for (int i = 0; i < game.getPlayers().size(); i++){
                System.out.println(game.getPlayers().get(i).getName() + " har: " + game.getPlayers().get(i).getWins() + " poäng.");
            }
        } while (game.getCurrentTurn() <= game.getTurns());
        
        if (game.getPlayers().get(0).getWins() == game.getPlayers().get(1).getWins()){
            System.out.println("\nDet blev oavgjort!");
        }else if (game.getPlayers().get(0).getWins() > game.getPlayers().get(1).getWins()){
            System.out.println("\n" + game.getPlayers().get(0).getName() + " vinner spelet!");
        }else if (game.getPlayers().get(0).getWins() < game.getPlayers().get(1).getWins()){
            System.out.println("\n" + game.getPlayers().get(1).getName() + " vinner spelet!");
        }
    }
    
    public static boolean checkNumberOfPlayers(String inNumberOfPlayers){
        if (inNumberOfPlayers.equals("1") || inNumberOfPlayers.equals("2")){
            return false;
        }else{
            System.out.println("Ogiltigt val, försök igen!");
            return true;
        }
    }
    
    public static boolean checkStringForNumber(String stringToTest){
        try{
            int test = Integer.parseInt(stringToTest);
            return false;
        }catch (NumberFormatException e){
            System.out.println("Ogiltigt val, försök igen!");
            return true;
        }
    }
    
}
