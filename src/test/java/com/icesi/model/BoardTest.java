package com.icesi.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board();
        board.setRows(3);
        board.setColumns(4);
        board.setDimension(12);
        board.fillBoard();
    }

    @Test
    public void when_it_creates_the_boxes_its_linked_circular() {
        assertEquals(board.getHead(), board.getTail().getNextBox());
    }

    @Test
    public void when_it_creates_the_boxes_there_is_all() {
        assertEquals(20, board.getTail().getPosition());
    }

    @Test
    public void when_it_creates_a_link() {
        Box box1 = new Box(1);
        Box box2 = new Box(2);

        board.createLink(box1, box2);

        assertEquals(box1, box2.getNextBox());
    }

    @Test
    public void get_last_box() {
        Box test = board.getBox(board.getDimension());

        assertEquals(board.getDimension(), test.getPosition());
    }

    @Test
    public void get_any_box() {
        Box test = board.getBox(board.getDimension()/2);

        assertEquals(board.getDimension()/2, test.getPosition());
    }

    @Test
    public void assign_the_character_to_the_portal() {
        assertEquals('A', board.getHead().getPortalSignature());
    }

    @Test
    public void create_a_portal() {
        assertEquals(board.getHead(), board.getTail().getPortal());
    }

    @Test
    public void create_seeds() {
        board.setSeedNumber(3);
        board.createSeeds(0);

        int count = 0;
        for (int i = 1; i < board.getDimension(); i++) {
            if(board.getBox(i).isSeed()){
                count++;
            }
        }

        assertEquals(3, count);
    }
}