package com.codemanship.marsrover;

import org.junit.Test;
import refactoring.Rover.Position;

import static org.junit.Assert.assertEquals;
import static refactoring.Rover.Heading.*;

public class Position_ {

    @Test
    public void should_calculate_forward_position() {
        assertEquals(new Position(-1, 0), new Position(0, 0).forward(North).forward(West).forward(South));
        assertEquals(new Position(0, -1), new Position(0, 0).forward(East).forward(West).forward(South));
    }

    @Test
    public void should_calculate_back_position() {
        assertEquals(new Position(1, 0), new Position(0, 0).back(North).back(West).back(South));
        assertEquals(new Position(0, 1), new Position(0, 0).back(East).back(West).back(South));
    }
}
