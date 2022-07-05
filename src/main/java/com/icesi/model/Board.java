package com.icesi.model;

import java.util.Random;

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

    public Board(int rows, int columns, int portalNumber, int seedNumber) {
        this.rows = rows;
        this.columns = columns;
        this.dimension = rows*columns;
        this.portalNumber = portalNumber;
        this.seedNumber = seedNumber;
        fillBoard(1);
        createPortals(0);
        createSeeds(0);
    }

    /**
     * This method manage the links between boxes
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
     * This method creates the head
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
     * @param current
     * @param previous
     */
    public void createLink(Box current, Box previous){
        current.setPreviousBox(previous);
        previous.setNextBox(current);
    }

    /**
     * This method create the Links to the portals
     * @param i This is the iterator of the recursion
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

    public void createSeeds(int i){
        Box seedBox = getBox(head, generateRandomNumber(), 1);

        if(seedBox.isSeed() == false && i < seedNumber){
            seedBox.setSeed(true);
            createSeeds(i+1);
        }
    }

    /**
     * This method return a required box
     * @param current
     * @param positionBoxSearched
     * @param i
     * @return
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
}
