package com.enigma.main;

public class Position {

    protected int coordinateX;
    protected int coordinateY;

    public Position(){

    }

    public Position(int coordinateX, int coordinateY){
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

}
