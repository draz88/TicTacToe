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
public class Game {
    private ArrayList<Player> players = new ArrayList<>();
    private Board board;
    private int turns;
    private int currentTurn;
    private String roundWinner = "";
    
    public Game(){
        
    }
    
    public Game(ArrayList<Player> inPlayers, Board inBoard, int inTurns){
        players = inPlayers;
        board = inBoard;
        turns = inTurns;
        currentTurn = 1;
    }

    public Board getBoard() {
        return board;
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public String getRoundWinner() {
        return roundWinner;
    }

    public int getTurns() {
        return turns;
    }
    
    public void addTurn(){
        currentTurn++;
    }
    
    
}
