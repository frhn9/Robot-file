package com.enigma.main;

import com.enigma.constant.Constant;

import java.io.*;
import java.util.Locale;

public class Robot {

    private Position position;
    private Direction direction;

    private String path = "C:\\Users\\admin\\IdeaProjects\\Robot\\log\\log robot.txt";

    private Direction lastDirection;
    private int lastSavedX = 0;
    private int lastSavedY = 0;

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
                addFile(commandArr);
                System.out.println(this);
            } catch (ArrayIndexOutOfBoundsException e){
                viewCommandError();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void addFile(char[] commandAr) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true));

        for(int i = 0; i < commandAr.length; i++){
            if(commandAr.length == i+1){
                bufferedWriter.write(String.valueOf(this));
                bufferedWriter.newLine();

                bufferedWriter.close();
            }
        }
    }

    public void addMovetoExisting(String command){
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            while(true){
                String text = bufferedReader.readLine();
                if(text == null) break;
                System.out.println(text);
                for (int i = 0; i < text.length(); i++) {
                    String[] part = text.split("->");
                    String[] nextCoordinatePart = part[1].split("\t");
                    String[] lastCoordinatePart = nextCoordinatePart[1].split(",");
                    String[] nextCoordinatePartY = lastCoordinatePart[1].split("\\)");
                    String[] lastX = lastCoordinatePart[0].split("\\(");
                    String[] lastY = nextCoordinatePartY[0].split(" ");
                    String[] nextDirectionPart = part[0].split("\t");
                    lastDirection = Direction.valueOf(nextDirectionPart[0]);
                    lastSavedX = Integer.parseInt(lastX[1]);
                    lastSavedY = Integer.parseInt(lastY[1]);
                }
            }
            addMovetoExisting(lastDirection, lastSavedX, lastSavedY, command);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void addMovetoExisting(Direction lastDirection, int lastSavedX, int lastSavedY, String command) {
        direction = lastDirection;
        position.setCoordinateX(lastSavedX);
        position.setCoordinateY(lastSavedY);
        System.out.println("Last Direction : "+lastDirection.toString()+ " "+lastSavedX+" "+lastSavedY);
        moves(command);
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
