package com.enigma.test;

import com.enigma.main.Direction;
import com.enigma.main.Position;
import com.enigma.main.Robot;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class RobotTest {

    int x = 2;
    int y = 3;
    Position position = new Position(x, y);
    Robot robot = new Robot(position.getCoordinateX(), position.getCoordinateY());

    // Test for return init position
    @Test
    public void initialPosition_should_return_xIs2_yIs3_when_initialXIs2_initialYIs3(){
        assertEquals(2, robot.getCoordinateX());
        assertEquals(3, robot.getCoordinateY());
    }

    @Test
    public void initialPosition_should_notReturn_xIs4_yIs4_when_initialXIs2_initialYIs3(){
        assertFalse(4 == robot.getCoordinateX());
        assertFalse(4 == robot.getCoordinateY());
    }

    // Test for to know direction changing actually works or not
    @Test
    public void moves_should_return_north_when_commandIs_aaaa(){
        assertEquals("NORTH", robot.moves("aaaa"));
    }

    @Test
    public void moves_should_return_east_when_commandIs_lll(){
        assertEquals("EAST", robot.moves("lll"));
    }

    @Test
    public void moves_should_return_west_when_commandIs_rrr(){
        assertEquals("WEST", robot.moves("rrr"));
    }
}
