package com.enigma.main;

public class Robot extends Position {

    Position position = new Position();
    Direction direction = Direction.NORTH;

    public Robot(int coordinateX, int coordinateY) {
        super(coordinateX, coordinateY);
    }

    public Robot(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public String moves(String command) {
        char[] commandNow = command.toCharArray();
        int currentCoordinateX = position.getCoordinateX();
        int currentCoordinateY = position.getCoordinateY();

        for (int i = 0; i < commandNow.length; i++) {
            if (String.valueOf(commandNow[i]).equalsIgnoreCase("a")) {
                if(direction == Direction.EAST){
                    currentCoordinateX += 1;
                } else if (direction == Direction.WEST){
                    currentCoordinateX -= 1;
                } else if (direction == Direction.NORTH){
                    currentCoordinateY += 1;
                } else if (direction == Direction.SOUTH){
                    currentCoordinateY -= 1;
                }
            } else if (String.valueOf(commandNow[i]).equalsIgnoreCase("r")) {
                try {
                    direction = Direction.values()[direction.ordinal() + 1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    direction = Direction.values()[direction.ordinal() - 3];
                }
            } else {
                try {
                    direction = Direction.values()[direction.ordinal() - 1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    direction = Direction.values()[direction.ordinal() + 3];
                }
            }
            System.out.println(direction.toString() + "\t-> " + "Position " + "{coordinatesX="+currentCoordinateX+"}"+" {coordinatesY="+currentCoordinateY+"}");
        }
        return direction.toString();
    }
}
