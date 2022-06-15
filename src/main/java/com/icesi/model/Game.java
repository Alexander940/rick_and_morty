package com.icesi.model;

/**
 * @author alexanderecheverry
 * @version 1.0
 */
public class Game {

    public static Game instance;

    /**
     * This method is about architecture singleton
     * @return the instance of the same class
     */
    public static Game getInstance() {
        if(instance == null){
            instance = new Game();
        }
        return instance;
    }

    private Board board;

    public void createBoard(int rows, int columns, int portalNumber, int seedNumber){
        board = new Board(rows, columns, portalNumber, seedNumber);
    }
}
