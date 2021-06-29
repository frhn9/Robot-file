package com.enigma.test;

import com.enigma.main.Position;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class RobotTest {

    int x = 2;
    int y = 3;
    Position position = new Position(x, y);

    // Test for return init position
    @Test
    public void initialPosition_should_return_xIs2_yIs3_when_initialXIs2_initialYIs3(){
        assertEquals(2, position.getCoordinateX());
        assertEquals(3, position.getCoordinateY());
    }

    @Test
    public void initialPosition_should_notReturn_xIs4_yIs4_when_initialXIs2_initialYIs3(){
        assertFalse(4 == position.getCoordinateX());
        assertFalse(4 == position.getCoordinateY());
    }


}
