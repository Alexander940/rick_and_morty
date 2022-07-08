package com.icesi.ui;

public interface BoardGUI {
    void updateTimeLabel(int i);
    void updateBoardLabel(String character, int position);
    void addImageLabel(int position);
    void removeImageLabel(String character, int position);
}
