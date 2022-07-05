package com.icesi.model;

/**
 * @author alexanderecheverry
 * @version 1.0
 */
public class Game {

    public static Game instance;

    /**
     * This method is about architecture singleton
     * @return the instance of the class
     */
    public static Game getInstance() {
        if(instance == null){
            instance = new Game();
        }
        return instance;
    }

    private Board board;
    private User principalPlayer;
    private User secondPlayer;

    public void createBoard(int rows, int columns, int portalNumber, int seedNumber){
        board = new Board(rows, columns, portalNumber, seedNumber);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public User getPrincipalPlayer() {
        return principalPlayer;
    }

    public void setPrincipalPlayer(User principalPlayer) {
        this.principalPlayer = principalPlayer;
    }

    public User getSecondPlayer() {
        return secondPlayer;
    }

    public void setSecondPlayer(User secondPlayer) {
        this.secondPlayer = secondPlayer;
    }
}
