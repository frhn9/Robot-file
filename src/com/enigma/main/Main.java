package com.enigma.main;

public class Main {

    public static void main(String[] args) {
        Position initialPosition = new Position(2, 3);
        Direction direction = Direction.EAST;

        Robot robot = new Robot(initialPosition, direction);

        robot.moves("AARAAAA");
    }
}
