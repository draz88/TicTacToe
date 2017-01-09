/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author johanwejdenstolpe
 */
public class Board {
    private String[][] board;
    
    public Board(int numberOfRows){
        board = new String[numberOfRows][numberOfRows];
//        System.out.println(board.length);
        resetBoard();
    }
    
    public String[][] getBoard() {
        return board;
    }
    
    public void resetBoard(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                board[i][j] = "";      // Töm array inför nästa omgång
            }
        }
    }
    
    public boolean addChoice(String inChoice, String choice){
        int row = Character.getNumericValue(inChoice.charAt(0)) - 10;
        int col = Character.getNumericValue(inChoice.charAt(1)) - 1;
        board[row][col] = choice;
        return false;
    }
    
    public boolean checkIfBoardIsFull(){ // Kollar om brädet är fullt och med det att omgången är oavgjord.
        boolean isFull = false;
        int counter = 0;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j].equals("X") || board[i][j].equals("O")){
                    counter++;
                }
            }
        }
//        System.out.println(counter);
        if (counter >= board.length * board.length){
            isFull = true;
        }
        return isFull;
    }
    
    public void printBoard(){ // Skriver ut brädet
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
        
    public boolean checkFormatAndOccupiedBoardSlot(String inChoice){ // Kollar att det är rätt format och isåfall om den är tom.
//        boolean slotFree = true;
        char choiceChar = inChoice.charAt(0);
        char choiceInt = inChoice.charAt(1);
        int maxChar = 97 + board.length - 1;
        int maxInt = 49 + board.length - 1;
        if ((choiceChar >= 97 && choiceChar <= maxChar) && (choiceInt >= 49 && choiceInt <= maxInt)){
            int row = Character.getNumericValue(inChoice.charAt(0)) - 10;
            int col = Character.getNumericValue(inChoice.charAt(1)) - 1;
            if (board[row][col].equals("X") || board[row][col].equals("O")){
                System.out.println("Ogiltigt val, försök igen!");
                return false;
            }
        }else{
            System.out.println("Ogiltigt val, försök igen!");
            return false;
        }
        return true;
    }
    
    public boolean isSlotEmpty(String inChoice){
//        char choiceChar = inChoice.charAt(0);
//        char choiceInt = inChoice.charAt(1);
        int row = Character.getNumericValue(inChoice.charAt(0)) - 10;
        int col = Character.getNumericValue(inChoice.charAt(1)) - 1;
        if (board[row][col].equals("X") || board[row][col].equals("O")){
            return false;
        }
        return true;
    }
        
    public boolean checkForWinner(){ // Kollar om och vem som vunnitoch lägger till den onfon i game().
        String checkBoard = "";
        String checkForX = "";
        String checkForO = "";
        for (int i = 0; i < board.length; i++){
            checkForX = checkForX + "X";
            checkForO = checkForO + "O";
        }
        for (int i = 0; i < board.length; i++){ // Kollar horisontellt
            checkBoard = "";
            for (int j = 0; j < board[i].length; j++){
                checkBoard = checkBoard + board[i][j];
            }
//            System.out.println("checkBoard: " + checkBoard);
            if (checkBoard.equals(checkForX)){
//                players.get(0).addWin();
//                roundWinner = players.get(0).getName();
                return true;
            } else if (checkBoard.equals(checkForO)){
//                players.get(1).addWin();
//                roundWinner = players.get(1).getName();
                return true;
            }
        }
        
        for (int i = 0; i < board.length; i++){ // Kollar vertikalt
            checkBoard = "";
            for (int j = 0; j < board[i].length; j++){
                checkBoard = checkBoard + board[j][i];
            }
//            System.out.println("checkBoard: " + checkBoard);
            if (checkBoard.equals(checkForX)){
//                players.get(0).addWin();
//                roundWinner = players.get(0).getName();
                return true;
            } else if (checkBoard.equals(checkForO)){
//                players.get(1).addWin();
//                roundWinner = players.get(1).getName();
                return true;
            }
        }
        checkBoard = "";
        for (int i = 0; i < board.length; i++){ // Kollar diagonalt
            checkBoard = checkBoard + board[i][i];
//            System.out.println("diag: " + checkBoard);
        }
        
        if (checkBoard.equals(checkForX)){
//            players.get(0).addWin();
//            roundWinner = players.get(0).getName();
            return true;
            } else if (checkBoard.equals(checkForO)){
//                players.get(1).addWin();
//                roundWinner = players.get(1).getName();
                return true;
            }
        
        checkBoard = "";
        for (int i = 0, j = board.length - 1; i < board.length || j >= 0; i++, j--){ // Kollar inverterad diagonal
            checkBoard = checkBoard + board[i][j];
//            System.out.println("diag: " + checkBoard);
        }
        
        if (checkBoard.equals(checkForX)){
//            players.get(0).addWin();
//            roundWinner = players.get(0).getName();
            return true;
            } else if (checkBoard.equals(checkForO)){
//                players.get(1).addWin();
//                roundWinner = players.get(1).getName();
                return true;
            }
//        System.out.println("x: " + checkForX);
//        System.out.println("o: " + checkForO);
        return false;
    }
}
