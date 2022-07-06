package com.icesi.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class BoardTest {

    Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board();
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
        Box box1 = board.createBox(1);
        Box box2 = board.createBox(2);

        board.createLink(box1, box2);

        assertEquals(box1, box2.getNextBox());
    }

    @Test
    public void get_last_box() {
        Box test = board.getBox(board.getHead(), board.getDimension(), 1);

        assertEquals(board.getDimension(), test.getPosition());
    }

    @Test
    public void get_any_box() {
        Box test = board.getBox(board.getHead(), board.getDimension()/2, 1);

        assertEquals(board.getDimension()/2, test.getPosition());
    }

    @Test
    public void assign_the_character_to_the_portal() {
        board = new Board();

        assertEquals('A', board.getHead().getPortalSignature());
    }

    @Test
    public void create_a_portal() {
        board = new Board();

        assertEquals(board.getHead(), board.getTail().getPortal());
    }
}