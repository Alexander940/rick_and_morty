package com.icesi.model;

public class Box {

    private int position;
    private Box nextBox;
    private Box previousBox;
    private Box portal;
    private char portalSignature;
    private boolean seed;
    private String content;

    public Box(int position) {
        this.position = position;
        this.content = String.valueOf(position);
        this.seed = false;
    }

    /**
     * This method set the value of the content of box to the box position, this is used
     * to change the character of the player to the position of the box when the player move on the box
     */
    public void setContentToPosition(String character) {
        if ((content.equals("M-R") || content.equals("R-M"))) {
            content = character;
        } else {
            content = String.valueOf(position);
        }
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        if(this.content.equals("R") || this.content.equals("M")){
            this.content = this.content + "-" + content;
        } else {
            this.content = content;
        }
    }
}
