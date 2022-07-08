package com.icesi.model;

import java.util.Random;

/**
 * This class contains the data and actions of a board
 * @author alexanderecheverry
 * @version 1.0
 */
public class Board {

    public enum Size{
        SMALL, MEDIUM, LARGE
    }

    private Box head;
    private Box tail;
    private int dimension;
    private int rows;
    private int columns;
    private int portalNumber;
    private int seedNumber;
    private final String RICK_PLAYER = "R";
    private final String MORTY_PLAYER = "M";
    private int rickPosition;
    private int mortyPosition;

    /**
     * This method fill the board, it calls the methods to create the box linked list, the seeds and the portals
     */
    public void fillBoard(){
        createLinkedList(1);
        createSeeds(0);
        createPortals(0);

        assignPlayersInitialPosition();
    }

    /**
     * This method manage the links between boxes
     * @see com.icesi.model.Board#createLink(Box, Box)
     * @see com.icesi.model.Board#createLinkedList(int)
     * @param previous This is the previous box of the recursion
     * @param i This is the position of the current box
     */
    private void createLinkedList(Box previous, int i){
        Box current = new Box(i);
        if(i < dimension){
            createLink(current, previous);
            createLinkedList(current, i+1);
        } else {
            tail = current;
            createLink(tail, previous);
            tail.setNextBox(head);
            head.setPreviousBox(tail);
        }
    }

    /**
     * This method creates the head of the board
     * @param i This is the position of head
     */
    private void createLinkedList(int i){
        if(i == 1){
            head = new Box(1);
            createLinkedList(head, i+1);
        }
    }

    /**
     * This method creates the link between two boxes
     * @param current Contains the actual box to linked
     * @param previous Contains the previous box to linked
     */
    public void createLink(Box current, Box previous){
        current.setPreviousBox(previous);
        previous.setNextBox(current);
    }

    /**
     * This method gets a random number, generate a link between two boxes and assign a character id to the portal
     * @param i This is the iterator variable of the recursion
     */
    public void createPortals(int i){
        Box portalBox1 = getBox(head, generateRandomNumber(), 1);
        Box portalBox2 = getBox(head, generateRandomNumber(), 1);

        if(i < portalNumber){
            if(portalBox1.getPortal() == null && portalBox2.getPortal() == null && portalBox1 != portalBox2){
                portalBox1.setPortal(portalBox2);
                portalBox2.setPortal(portalBox1);
                portalBox1.setPortalSignature((char) (i+65));
                portalBox2.setPortalSignature((char) (i+65));
                createPortals(i+1);
            } else {
                createPortals(i);
            }
        }
    }

    /**
     * This method generate a random number between the range of the board
     * @return random number
     */
    public int generateRandomNumber(){
        return new Random().nextInt(dimension)+1;
    }

    /**
     * This method put the seeds in a random box
     * @param i This is the iterator variable and contains the number of seeds to create
     */
    public void createSeeds(int i){
        Box seedBox = getBox(head, generateRandomNumber(), 1);

        if(!seedBox.isSeed() && i < seedNumber){
            seedBox.setSeed(true);
            createSeeds(i+1);
        } else if(i < seedNumber){
            createSeeds(i);
        }
    }

    /**
     * This method searched a required box
     * @see com.icesi.model.Board#getBox(int)
     * @param current Contains the actual box in the loop
     * @param positionBoxSearched Contains the position of the box searched
     * @param i This is the iterator variable
     * @return The box searched or null if the box isn't found out
     */
    private Box getBox(Box current ,int positionBoxSearched, int i){
        if(positionBoxSearched == i){
            return current;
        } else {
            current = current.getNextBox();
            return getBox(current, positionBoxSearched, i+1);
        }
    }

    /**
     * This method return a required box
     * @see com.icesi.model.Board#getBox(Box current, int positionBoxSearched, int i)
     * @param positionBoxSearched
     * @return
     */
    public Box getBox(int positionBoxSearched){
        return getBox(head, positionBoxSearched, 1);
    }

    /**
     * This method creates a board for a fast game
     */
    public void createSmallBoard() {
        this.rows = 3;
        this.columns = 4;
        this.dimension = rows*columns;
        this.portalNumber = 3;
        this.seedNumber = 3;

        createLinkedList(1);
        createSeeds(0);
        createPortals(0);

        assignPlayersInitialPosition();
    }

    /**
     * This method creates a board for a medium time game
     */
    public void createMediumBoard() {
        this.rows = 4;
        this.columns = 5;
        this.dimension = rows*columns;
        this.portalNumber = 4;
        this.seedNumber = 4;

        createLinkedList(1);
        createSeeds(0);
        createPortals(0);

        assignPlayersInitialPosition();
    }

    /**
     * This method creates a board for a long game
     */
    public void createLargeBoard() {
        this.rows = 5;
        this.columns = 6;
        this.dimension = rows*columns;
        this.portalNumber = 5;
        this.seedNumber = 5;

        createLinkedList(1);
        createSeeds(0);
        createPortals(0);

        assignPlayersInitialPosition();
    }

    /**
     * This method get two random number to assign the initial position of the two players in the board
     */
    private void assignPlayersInitialPosition() {
        Box firstBox;
        Box secondBox;
        do {
            //A random box is chosen to assign the letter of the first player
            firstBox = getBox(head, generateRandomNumber(), 1);
            //A random box is chosen to assign the letter of the second player
            secondBox = getBox(head, generateRandomNumber(), 1);
        }while (firstBox.isSeed() || secondBox.isSeed());

        firstBox.setContent(RICK_PLAYER);
        secondBox.setContent(MORTY_PLAYER);
        rickPosition = firstBox.getPosition();
        mortyPosition = secondBox.getPosition();
    }

    /**
     * This class simulates when someone rolls a dice and returns its value
     * @return An integer between 1 and 6
     */
    public int rollDice(){
        return new Random().nextInt(6)+1;
    }

    /**
     * This class change the player position and change the content of the box where the players will be
     * @param turn This contains player turns to move
     * @param resultDice This is the result of the dice
     * @param side This is the side which player will move
     * @return true if the box where the player will move to have a seed or false if the box doesn't contain a seed
     */
    public boolean movePlayer(Game.Turn turn, int resultDice, Game.SideToMove side){
        Box current;
        Box next;
        if(turn == Game.Turn.RICK){
            next = assignNextBox(rickPosition, side, resultDice);
            current = getBox(rickPosition);
            current.setContentToPosition(MORTY_PLAYER);
            next.setContent(RICK_PLAYER);
            rickPosition = assignNewPosition(rickPosition,resultDice,side);
        } else {
            next = assignNextBox(mortyPosition, side, resultDice);
            current = getBox(mortyPosition);
            current.setContentToPosition(RICK_PLAYER);
            next.setContent(MORTY_PLAYER);
            mortyPosition = assignNewPosition(mortyPosition, resultDice, side);
        }
        return changeSeedState(next);
    }

    /**
     * This class assess if a box contains one seed, and change the box seed state to false if the box contains it
     * @param box This contains the box to assess
     * @return true if the box was containing one seed or false if wasn't containing any seed
     */
    private boolean changeSeedState(Box box){
        if(box.isSeed()){
            box.setSeed(false);
            seedNumber--;
            return true;
        }

        return false;
    }

    /**
     * This method assigns the next box, it depends on the side to move
     * @param current This contains the current player position
     * @param side This contains the side where the player must move
     * @param resultDice This contains the result of the dice
     * @return The box where the player will move
     */
    private Box assignNextBox(int current, Game.SideToMove side, int resultDice){
        if(side == Game.SideToMove.FORWARD){
            return getBox(current+resultDice);
        } else {
            return getBox(current-resultDice);
        }
    }

    /**
     * This method assigns the new player position, it depends on the side to move
     * @param current This contains the current player position
     * @param resultDice This contains the result of the dice
     * @param side This contains the side where the player must move
     * @return The new player position
     */
    private int assignNewPosition(int current, int resultDice, Game.SideToMove side){
        if(side == Game.SideToMove.FORWARD){
            return movePositionToForward(current, resultDice);
        } else {
            return movePositionToBack(current, resultDice);
        }
    }

    /**
     * This method change the player position ahead
     * @param current This contains the current player position
     * @param resultDice This contains the result of the dice
     * @return The new player position
     */
    private int movePositionToForward(int current, int resultDice){
        if(current + resultDice > dimension){
            return current += (resultDice-dimension);
        } else {
            return current += resultDice;
        }
    }

    /**
     * This method change the player position to back
     * @param current This contains the current player position
     * @param resultDice This contains the result of the dice
     * @return The new player position
     */
    private int movePositionToBack(int current, int resultDice){
        if(current - resultDice < 1){
            return current -= (resultDice+dimension);
        } else {
            return current -= resultDice;
        }
    }

    public Box getHead() {
        return head;
    }

    public Box getTail() {
        return tail;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public void setSeedNumber(int seedNumber) {
        this.seedNumber = seedNumber;
    }

    public int getRickPosition() {
        return rickPosition;
    }

    public int getMortyPosition() {
        return mortyPosition;
    }

    public int getSeedNumber() {
        return seedNumber;
    }
}
