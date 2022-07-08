package com.icesi.model;

import com.icesi.ui.BoardGUI;

/**
 * This class contains the actions of a game
 * @author alexanderecheverry
 * @version 1.0
 */
public class Game {

    public enum SideToMove{
        FORWARD, BACK
    }

    public enum Turn{
        MORTY, RICK
    }

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
     * @param boardGUI This is the GUI board to apply changes
     */
    public void createBoard(Board.Size size, BoardGUI boardGUI){
        if(size == Board.Size.SMALL){
            board.createSmallBoard();
            chronometer = new Chronometer(true, boardGUI);
            play(boardGUI);
        } else if(size == Board.Size.MEDIUM){
            board.createMediumBoard();
            chronometer = new Chronometer(true, boardGUI);
            play(boardGUI);
        } else {
            board.createLargeBoard();
            chronometer = new Chronometer(true, boardGUI);
            play(boardGUI);
        }
    }

    /**
     * This method starts the chronometer, and it assigns the value of each box to its respective label
     * @param boardGUI This contains the board to apply changes
     */
    private void play(BoardGUI boardGUI){
        chronometer.start();
        for (int i = 0; i < board.getDimension(); i++) {
            Box box = board.getBox(i+1);
            if(box.isSeed()){
                boardGUI.addImageLabel(box.getPosition());
            } else {
                boardGUI.updateBoardLabel(box.getContent(), box.getPosition());
            }
        }
    }

    /**
     * This method manage the movement of a player
     * @param turn This contains who is turns
     * @param resultDice This contains the result of the dice
     * @param boardGUI This contains the board to apply changes
     * @param side This is the side which player will move
     */
    public void movePlayer(Turn turn, int resultDice, BoardGUI boardGUI, SideToMove side){
        if(turn == Turn.RICK){
            //Updating the box where the player was
            int position = board.getRickPosition();
            boolean isSeed = updatePositions(turn, resultDice, boardGUI, position, side);

            //Updating the box where the player will go
            position = board.getRickPosition();
            assessSeedState(isSeed, boardGUI, position);
        } else {
            //Updating the box where the player was
            int position = board.getMortyPosition();
            boolean isSeed = updatePositions(turn, resultDice, boardGUI, position, side);

            //Updating the box where the player will go
            position = board.getMortyPosition();
            assessSeedState(isSeed, boardGUI, position);
        }
    }

    /**
     * This method calls the logical to move players in board, and change the content of the label where the player was
     * @see com.icesi.model.Board#movePlayer(Turn, int, SideToMove)
     * @param turn This contains player turns to move
     * @param resultDice This is the result of the dice
     * @param boardGUI This contains the board to apply changes
     * @param position This contains the position where the player is
     * @param side This is the side which player will move
     * @return true if the box where the player will move to contain a seed, false if the box doesn't contain a seed
     */
    private boolean updatePositions(Turn turn, int resultDice, BoardGUI boardGUI, int position, SideToMove side){
        boolean isSeed = board.movePlayer(turn, resultDice, side);

        boardGUI.updateBoardLabel(board.getBox(position).getContent(),position);

        return isSeed;
    }

    /**
     * This method assess if the box where the player will move to contain a seed
     * for in case that box contains it, it removes the image and changes to the position, or in case
     * that it doesn't contain a seed, it only changes the content to the position
     * @param isSeed This contains a boolean value, if it's true, it contains a seed and if it's false, it doesn't contain a seed
     * @param boardGUI This contains the board to apply changes
     * @param position This contains the position of the label to set content
     */
    private void assessSeedState(boolean isSeed, BoardGUI boardGUI, int position){
        String character = board.getBox(position).getContent();
        if(isSeed){
            boardGUI.removeImageLabel(character, position);
        } else {
            boardGUI.updateBoardLabel(character, position);
        }
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
