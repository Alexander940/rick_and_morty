package com.icesi.model;

/**
 * @author alexanderecheverry
 * @version 1.0
 */
public class Game {

    private static Game instance;

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

    private final Board board = new Board();
    private User firstPlayer;
    private User secondPlayer;

    public void createBoard(Board.Size size){
        if(size == Board.Size.SMALL){
            board.createSmallBoard();
        } else if(size == Board.Size.MEDIUM){
            board.createMediumBoard();
        } else {
            board.createLargeBoard();
        }
    }

    public Board getBoard() {
        return board;
    }

    /*public void setBoard(Board board) {
        this.board = board;
    }*/

    public User getFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(User firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public User getSecondPlayer() {
        return secondPlayer;
    }

    public void setSecondPlayer(User secondPlayer) {
        this.secondPlayer = secondPlayer;
    }
}
