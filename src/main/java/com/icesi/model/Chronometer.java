package com.icesi.model;

import com.icesi.ui.BoardGUI;
import javafx.application.Platform;

/**
 * This class counts how long the game lasts
 */
public class Chronometer extends Thread{

    private boolean flag;
    private int seconds;
    private BoardGUI board;

    public Chronometer(boolean flag, BoardGUI board) {
        this.flag = flag;
        this.board = board;
    }

    @Override
    public void run() {
        while(flag){
            Platform.runLater(() -> {
                board.updateTimeLabel(seconds);
            });
            try{
                seconds++;
                Thread.sleep(1000);
            } catch (InterruptedException exception){
                exception.printStackTrace();
            }
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getSeconds() {
        return seconds;
    }
}
