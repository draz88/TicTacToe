/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
import java.util.*;
import javafx.scene.input.KeyCode;
/**
 *
 * @author johanwejdenstolpe
 */
public class AiSmart extends Player{
    
    public AiSmart(String inName){
        super(inName);
    }
    
    public String takeTurn(Board inBoard){
        Scanner scan = new Scanner(System.in);
        String choice = "";
//        int rowSum = 0;
        int[][] aiMoves = new int[inBoard.getBoard().length][inBoard.getBoard().length];
        int[][] opponentsMoves = new int[inBoard.getBoard().length][inBoard.getBoard().length];
        for (int i = 0; i < aiMoves.length; i++){
            for (int j = 0; j < aiMoves[i].length; j++){
                aiMoves[i][j] = 0;
                opponentsMoves[i][j] = 0;
            }
        }
        int inRow = 0;
        for (int i = 0; i < inBoard.getBoard().length; i++){
            for (int j = 0; j < inBoard.getBoard()[i].length; j++){
                inRow = 0;
                if (inBoard.getBoard()[i][j].isEmpty()){
                    inBoard.getBoard()[i][j] = "O";
//                    printBoard(inBoard.getBoard());
                    for (int k = 0; k < inBoard.getBoard().length; k++){ // Kolla horisontellt
                        if (inBoard.getBoard()[i][k].equals("O")){
                            inRow++;
//                            if (rowSum < inRow){
//                                rowSum = inRow;
//                            }
                                if (aiMoves[i][j] < inRow){
                                    aiMoves[i][j] = inRow;
                                }
                            }else{
                                inRow = 0;
                            }
                    }
                    inRow = 0;
                    for (int k = 0; k < inBoard.getBoard().length; k++){ // Kolla verikalt
                        if (inBoard.getBoard()[k][j].equals("O")){
                            inRow++;
//                            if (rowSum < inRow){
//                                rowSum = inRow;
//                            }
                                if (aiMoves[i][j] < inRow){
                                    aiMoves[i][j] = inRow;
                                }
                            }else{
                                inRow = 0;
                            }
                    }
                    inRow = 0;
                    if (i == j){
                        
                        for (int k = 0; k < inBoard.getBoard().length; k++){
                            if (inBoard.getBoard()[k][k].equals("O")){
                                inRow++;
                            
                                if (aiMoves[i][j] < inRow){
                                    aiMoves[i][j] = inRow;
                                }
                            }else{
                                inRow = 0;
                            }
                        }
                        
                    }
                    inRow = 0;
                    if (i + j == inBoard.getBoard().length - 1){
//                        System.out.println(i + " " + j);
                        for (int k = inBoard.getBoard().length - 1, l = 0; k >= 0; k--, l++){
                            if (inBoard.getBoard()[k][l].equals("O")){
                                inRow++;
                            
                                if (opponentsMoves[i][j] < inRow){
                                    opponentsMoves[i][j] = inRow;
                                }
                            }else{
                                inRow = 0;
                            }
                        }
                    }
                    
//                    printBoard(inBoard.getBoard());
                    inBoard.getBoard()[i][j] = "";
//                    System.out.println("Summa: " + rowSum);
                }
                inRow = 0;
                if (inBoard.getBoard()[i][j].isEmpty()){
                    inBoard.getBoard()[i][j] = "X";
//                    printBoard(inBoard.getBoard());
                    for (int k = 0; k < inBoard.getBoard().length; k++){ // Kolla horisintalt
                        if (inBoard.getBoard()[i][k].equals("X")){
                            inRow++;
                            if (opponentsMoves[i][j] < inRow){
                                opponentsMoves[i][j] = inRow;
                            }
                        }else{
                            inRow = 0;
                        }
                    }
                    inRow = 0;
                    for (int k = 0; k < inBoard.getBoard().length; k++){ // Kolla verikalt
                        if (inBoard.getBoard()[k][j].equals("X")){
                            inRow++;
//                            if (rowSum < inRow){
//                                rowSum = inRow;
//                            }
                            if (opponentsMoves[i][j] < inRow){
                                opponentsMoves[i][j] = inRow;
                            }
                        }else{
                            inRow = 0;
                        }
                    }
                    inRow = 0;
                    if (i == j){ // Kolla diagonalt
                        
                        for (int k = 0; k < inBoard.getBoard().length; k++){
                            if (inBoard.getBoard()[k][k].equals("X")){
                                inRow++;
                            
                                if (opponentsMoves[i][j] < inRow){
                                    opponentsMoves[i][j] = inRow;
                                }
                            }else{
                                inRow = 0;
                            }
                        }
                        
                    }
                    inRow = 0;
                    if (i + j == inBoard.getBoard().length - 1){
//                        System.out.println(i + " " + j);
                        for (int k = inBoard.getBoard().length - 1, l = 0; k >= 0; k--, l++){
                            if (inBoard.getBoard()[k][l].equals("X")){
                                inRow++;
                            
                                if (opponentsMoves[i][j] < inRow){
                                    opponentsMoves[i][j] = inRow;
                                }
                            }else{
                                inRow = 0;
                            }
                        }
                    }
                    
//                    printBoard(inBoard.getBoard());
                    inBoard.getBoard()[i][j] = "";
//                    System.out.println("Summa: " + rowSum);
                }
//                printBoard(inBoard.getBoard());
//                inBoard.getBoard()[i][j] = "";
//                System.out.println("inrow: " + rowSum);
                inRow = 0;
//                rowSum = 0;
            }
            
        }
        System.out.println("Ai moves:");
        printBoard(aiMoves);
        System.out.println("Opponent moves:");
        printBoard(opponentsMoves);
        
        for (int m = aiMoves.length; m > 1; m--){
            for (int i = 0; i < opponentsMoves.length; i++){
                for (int j = 0; j < opponentsMoves[i].length; j++){
                    if (aiMoves[i][j] == m){
                        choice = translateMove(i, j);
                        System.out.println("HAL 9000 väljer: : " + choice);
                        return choice;
                    }
//                    else if (opponentsMoves[i][j] == m){
//                        
//                    }
                }
            }
            for (int i = 0; i < opponentsMoves.length; i++){
                for (int j = 0; j < opponentsMoves[i].length; j++){
                    if (opponentsMoves[i][j] == m){
                        choice = translateMove(i, j);
                        System.out.println("HAL 9000 väljer: : " + choice);
                        return choice;
                    }
                }
            }
        }
        if (choice.equals("")){
            System.out.print(super.getName() + " välj (ex: a1): ");
            choice = scan.next();
        }
        System.out.println("HAL 9000 väljer: : " + choice);
        return choice;
    }
    
    public String translateMove(int inRow, int inCol){
        String choice;
        char rowLetter = (char)inRow;
        rowLetter += 97;
        inCol++;
        choice = Character.toString(rowLetter) + Integer.toString(inCol);
        return choice;
    }
    
    
    public void printBoard(int [][] board){ // Skriver ut moves
        /*
            Endast till för att demostrera hur mitt Ai fungerar.
        */
        
        char list = 'a';
        System.out.print("\n");
        System.out.printf("%-2s", " ");
        for (int i = 0; i < board.length; i++){
            System.out.printf("%-4s", i + 1);
        }
        System.out.print("\n");
        for (int i = 0; i < board.length; i++){
            System.out.printf("%-2s", list);
            for (int j = 0; j < board[i].length; j++){
                System.out.printf("%-2s", board[i][j]);
                if (j < board.length - 1){
                    System.out.printf("%-2s", "|");
                }else{
                    System.out.print("\n");
                }
            }
            System.out.printf("%-2s", " ");
            for (int k = 0; k < board.length * 2 - 1; k++){
//                System.out.println("B");
                if (i < board.length - 1){
                    System.out.printf("%-2s", "-");
                }
            }
            System.out.print("\n");
            list++;
        }
    }
    
}
