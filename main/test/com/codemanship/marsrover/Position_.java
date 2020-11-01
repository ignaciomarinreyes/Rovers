package com.codemanship.marsrover;

import org.junit.Test;
import refactoring.Rover.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static refactoring.Rover.Heading.*;

public class Position_ {

    @Test
    public void should_calculate_forward_position() {
        assertThat(new Position(1,1).forward(North)).isEqualTo(new Position(1, 2));
        assertThat(new Position(1,1).forward(South)).isEqualTo(new Position(1, 0));
        assertThat(new Position(1,1).forward(East)).isEqualTo(new Position(2, 1));
        assertThat(new Position(1,1).forward(North).forward(East)).isEqualTo(new Position(2, 2));
    }

    @Test
    public void should_calculate_backward_position() {
        assertThat(new Position(1,1).backward(North)).isEqualTo(new Position(1, 0));
        assertThat(new Position(1,1).backward(South)).isEqualTo(new Position(1, 2));
        assertThat(new Position(1,1).backward(East)).isEqualTo(new Position(0, 1));
        assertThat(new Position(1,1).backward(North).backward(East)).isEqualTo(new Position(0, 0));
    }
}
