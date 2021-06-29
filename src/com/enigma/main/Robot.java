package com.enigma.main;

public class Robot extends Position{

    Position position = new Position();
    Direction direction = Direction.NORTH;

    public Robot(int coordinateX, int coordinateY){
        super(coordinateX, coordinateY);
    }

    public Robot(Position position, Direction direction){
        this.position = position;
        this.direction = direction;
    }

    @Override
    public int getCoordinateX() {
        return coordinateX;
    }

    @Override
    public int getCoordinateY() {
        return coordinateY;
    }

    public int moves(Direction direction, Position position) {
        int currentPosition;
        if(direction == Direction.EAST || direction == Direction.WEST){
            currentPosition = position.getCoordinateX();
            return currentPosition;
        } else if (direction == Direction.NORTH || direction == Direction.SOUTH){
            currentPosition = position.getCoordinateY();
            return currentPosition;
        }
        return 0;
    }


}
