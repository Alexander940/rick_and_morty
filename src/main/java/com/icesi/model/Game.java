package com.icesi.model;

import com.icesi.ui.BoardGUI;
import com.icesi.ui.SmallBoardGUI;

/**
 * This class contains the actions of a game
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
    private Chronometer chronometer;

    /**
     * This method assign the size of the board, and it stars the game
     * @param size This contains the size of the board between SMALL, MEDIUM OR LARGE
     * @param smallBoardGUI
     */
    public void createBoard(Board.Size size, SmallBoardGUI smallBoardGUI){
        if(size == Board.Size.SMALL){
            board.createSmallBoard();
            chronometer = new Chronometer(true, smallBoardGUI);
            play(smallBoardGUI);
        } else if(size == Board.Size.MEDIUM){
            board.createMediumBoard();
        } else {
            board.createLargeBoard();
        }
    }

    public void play(BoardGUI boardGUI){
        chronometer.start();
        for (int i = 0; i < board.getDimension(); i++) {
            Box box = board.getBox(board.getHead(),i+1,1);
            if(box.isSeed()){
                boardGUI.updateBoardLabel(box.getPosition());
            } else {
                boardGUI.updateBoardLabel(box.getContent(), box.getPosition());
            }
        }

        boolean flag = true;
        Board.Turn turn = Board.Turn.MORTY;

        /*while(flag){
            if(turn == Board.Turn.MORTY){

            } else {

            }
        }*/
    }

    public Board getBoard() {
        return board;
    }

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
