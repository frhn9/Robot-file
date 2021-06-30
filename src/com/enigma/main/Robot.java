package com.enigma.main;

import com.enigma.constant.Constant;

import java.util.Locale;

public class Robot {

    private Position position;
    private Direction direction;

    public Robot(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public void moves(String command) {
        char[] commandArr = command.toCharArray();
        move(commandArr);
    }

    public void move(char[] commandArr){
        for (int i = 0; i < commandArr.length; i++) {
            try{
                Command command = Command.valueOf(String.valueOf(commandArr[i]).toUpperCase(Locale.ROOT));
                switch (command){
                    case A:
                        forward();
                        break;
                    case R :
                        direction = position.turnRight(direction);
                        break;
                    case L :
                        direction = position.turnLeft(direction);
                        break;
                }
                System.out.println(this);
            } catch (Exception e){
                viewCommandError();
            }
        }
    }

    private void viewCommandError() {
        System.out.println(Constant.LABEL_COMMAND_NOT_FOUND);
    }

    private void forward() {
        if(direction == Direction.EAST){
            position = position.getEast();
        } else if (direction == Direction.WEST){
            position = position.getWest();
        } else if (direction == Direction.NORTH){
            position = position.getNorth();
        } else if (direction == Direction.SOUTH){
            position = position.getSouth();
        }
    }

    @Override
    public String toString() {
        return direction+"\t->\t"+position;
    }
}
