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

    public enum Turn{
        MORTY, RICK
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
     * This method manage the links between boxes
     * @see com.icesi.model.Board#createLink(Box, Box)
     * @see com.icesi.model.Board#fillBoard(int)
     * @param previous This is the previous box of the recursion
     * @param i This is the position of the current box
     */
    public void fillBoard(Box previous, int i){
        Box current = createBox(i);
        if(i < dimension){
            createLink(current, previous);
            fillBoard(current, i+1);
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
    public void fillBoard(int i){
        if(i == 1){
            head = createBox(1);
            fillBoard(head, i+1);
        }
    }

    /**
     * This method creates a box
     * @param pos This is the box position
     */
    public Box createBox(int pos){
        return new Box(pos);
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
     * This method return a required box
     * @param current Contains the actual box in the loop
     * @param positionBoxSearched Contains the position of the box searched
     * @param i This is the iterator variable
     * @return The box searched or null if the box isn't found out
     */
    public Box getBox(Box current ,int positionBoxSearched, int i){
        if(positionBoxSearched == i){
            return current;
        } else if(i == dimension){
            return null;
        } else {
            current = current.getNextBox();
            return getBox(current, positionBoxSearched, i+1);
        }
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

        fillBoard(1);
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

        fillBoard(1);
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

        fillBoard(1);
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

    public Box getHead() {
        return head;
    }

    public void setHead(Box head) {
        this.head = head;
    }

    public Box getTail() {
        return tail;
    }

    public void setTail(Box tail) {
        this.tail = tail;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getSeedNumber() {
        return seedNumber;
    }

    public void setSeedNumber(int seedNumber) {
        this.seedNumber = seedNumber;
    }
}
