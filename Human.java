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
public class Human extends Player{
    
    public Human(String inName){
        super(inName);
    }
    
    public String takeTurn(Board inBoard){
        Scanner scan = new Scanner(System.in);
        String choice = "";
            System.out.print(super.getName() + " välj (ex: a1): ");
            choice = scan.next();
        return choice;
    }
    
}
