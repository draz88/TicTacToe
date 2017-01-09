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
public abstract class Player {
    private String name;
    private int wins;
    
    public Player(String inName){
        name = inName;
        wins = 0;
    }
    
    public void addWin(){
        wins += 1;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }
    
    abstract public String takeTurn(Board inBoard);
}
