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
public class AiDumb extends Player{
//    public static Scanner scan = new Scanner(System.in);
    public AiDumb(String inName){
        super(inName);
    }
    
    @Override
    public String takeTurn(Board inBoard){
//        String choice = "";
        String val;
        do{
            Random rand = new Random();
            int randNumber = rand.nextInt(inBoard.getBoard().length);
            char rowLetter = (char)randNumber;
            rowLetter += 97;
            randNumber = rand.nextInt(inBoard.getBoard().length) + 1;
            char colNumber = Integer.toString(randNumber).charAt(0);
            val = Character.toString(rowLetter) + Character.toString(colNumber);
//            System.out.println(val);
        }while (!inBoard.isSlotEmpty(val));
            System.out.println("HAL 9000 väljer: "+ val);
        return val;
    }
}
