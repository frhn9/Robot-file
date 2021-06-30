package com.enigma.main;

public class Position {

    private int coordinateX;
    private int coordinateY;

    public Position(int coordinateX, int coordinateY){
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public Position getEast(){
        return new Position(coordinateX+1, this.coordinateY);
    }

    public Position getWest() {
        return new Position(coordinateX-1, this.coordinateY);
    }

    public Position getNorth() {
        return new Position(coordinateX, this.coordinateY+1);
    }

    public Position getSouth() {
        return new Position(coordinateX, this.coordinateY-1);
    }

    public Direction turnRight(Direction direction){
        try {
            return Direction.values()[direction.ordinal() + 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            return Direction.values()[direction.ordinal() - Direction.values().length];
        }
    }

    public Direction turnLeft(Direction direction){
        try {
            return Direction.values()[direction.ordinal() - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            return Direction.values()[direction.ordinal() + Direction.values().length];
        }
    }

    @Override
    public String toString() {
        return "(" + coordinateX +
                ", " + coordinateY+")";
    }
}
