package com.icesi.model;

public class Box {

    private int position;
    private Box nextBox;
    private Box previousBox;
    private Box portal;
    private char portalSignature;
    private boolean seed;

    public Box(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Box getNextBox() {
        return nextBox;
    }

    public void setNextBox(Box nextBox) {
        this.nextBox = nextBox;
    }

    public Box getPreviousBox() {
        return previousBox;
    }

    public void setPreviousBox(Box previousBox) {
        this.previousBox = previousBox;
    }

    public Box getPortal() {
        return portal;
    }

    public void setPortal(Box portal) {
        this.portal = portal;
    }

    public char getPortalSignature() {
        return portalSignature;
    }

    public void setPortalSignature(char portalSignature) {
        this.portalSignature = portalSignature;
    }

    public boolean isSeed() {
        return seed;
    }

    public void setSeed(boolean seed) {
        this.seed = seed;
    }
}
