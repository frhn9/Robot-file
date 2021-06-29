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

    public String moves(String command){
        char[] commandNow = command.toCharArray();
        String commandPosition = null;

        for(int i = 0; i < commandNow.length; i++){
            if(String.valueOf(commandNow[i]).equals("a")){
                commandPosition = String.valueOf(commandNow[i]);
            } else if (String.valueOf(commandNow[i]).equals("r")){
                commandPosition = String.valueOf(commandNow[i]);
                try {
                    direction = Direction.values()[direction.ordinal() + 1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    direction = Direction.values()[direction.ordinal() - 3];
                }
            } else {
                commandPosition = String.valueOf(commandNow[i]);
                try {
                    direction = Direction.values()[direction.ordinal() - 1];
                } catch (ArrayIndexOutOfBoundsException e){
                    direction = Direction.values()[direction.ordinal() + 3];
                }
            }
            System.out.println(direction.toString());
        }
        return direction.toString();
    }
}
