package com.icesi.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void create_small_board() {
        //Game.getInstance().createBoard(Board.Size.SMALL, smallBoardGUI);

        assertEquals(12, Game.getInstance().getBoard().getTail().getPosition());
    }

    @Test
    public void create_medium_board() {
        //Game.getInstance().createBoard(Board.Size.MEDIUM, smallBoardGUI);

        assertEquals(20, Game.getInstance().getBoard().getTail().getPosition());
    }

    @Test
    public void create_large_board() {
        //Game.getInstance().createBoard(Board.Size.LARGE, smallBoardGUI);

        assertEquals(30, Game.getInstance().getBoard().getTail().getPosition());
    }
}