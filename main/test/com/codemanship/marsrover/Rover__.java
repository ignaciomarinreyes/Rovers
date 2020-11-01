package com.codemanship.marsrover;

import org.junit.Test;
import refactoring.Rover;

import static org.assertj.core.api.Assertions.assertThat;
import static refactoring.Rover.Heading.*;
import static refactoring.Rover.Order.*;

public class Rover__ {

    @Test
    public void should_be_initialized_with_facing_as_string() {
        assertThat(new Rover("N", 5, 5).heading()).isEqualTo(North);
        assertThat(new Rover("North", 5, 5).heading()).isEqualTo(North);
        assertThat(new Rover("North", 5, 5).position()).isEqualTo(new Rover.Position(5, 5));
    }

    @Test
    public void should_be_initialized() {
        assertThat(new Rover(North, new Rover.Position(5, 5)).position()).isEqualTo(new Rover.Position(5, 5));
        assertThat(new Rover(North, 5, 5).position()).isEqualTo(new Rover.Position(5, 5));
    }

    @Test
    public void should_turn_right() {
        Rover rover = new Rover(North, new Rover.Position(4, 4));
        rover.go(Right);
        assertThat(rover.heading()).isEqualTo(East);
        assertThat(rover.position()).isEqualTo(new Rover.Position(4, 4));
    }

    @Test
    public void should_turn_left() {
        Rover rover = new Rover(North, new Rover.Position(4, 4));
        rover.go(Left);
        assertThat(rover.heading()).isEqualTo(West);
        assertThat(rover.position()).isEqualTo(new Rover.Position(4, 4));
    }

    @Test
    public void should_go_forward() {
        Rover rover = new Rover(North, new Rover.Position(4, 4));
        rover.go(Forward);
        assertThat(rover.heading()).isEqualTo(North);
        assertThat(rover.position()).isEqualTo(new Rover.Position(4, 5));
    }

    @Test
    public void should_go_backward() {
        Rover rover = new Rover(North, new Rover.Position(4, 4));
        rover.go(Backward);
        assertThat(rover.heading()).isEqualTo(North);
        assertThat(rover.position()).isEqualTo(new Rover.Position(4, 3));
    }

    @Test
    public void should_execute_many_orders() {
        Rover rover = new Rover(North, new Rover.Position(4, 4));
        rover.go(Backward, Right, Forward, Left);
        assertThat(rover.heading()).isEqualTo(North);
        assertThat(rover.position()).isEqualTo(new Rover.Position(5, 3));
    }

    @Test
    public void should_execute_many_orders_as_string() {
        Rover rover = new Rover(North, new Rover.Position(4, 4));
        rover.go("BRFL");
        assertThat(rover.heading()).isEqualTo(North);
        assertThat(rover.position()).isEqualTo(new Rover.Position(5, 3));
    }

    @Test
    public void should_execute_many_orders_as_string_with_error() {
        Rover rover = new Rover(North, new Rover.Position(4, 4));
        rover.go("BR*FL");
        assertThat(rover.heading()).isEqualTo(North);
        assertThat(rover.position()).isEqualTo(new Rover.Position(5, 3));
    }

}
