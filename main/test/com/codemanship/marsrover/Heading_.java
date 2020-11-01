package com.codemanship.marsrover;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.junit.Test;
import refactoring.Rover.Heading;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static refactoring.Rover.Heading.*;

public class Heading_ {

    @Test
    public void should_be_created_from_string() {
        assertThat(Heading.of("N")).isEqualTo(North);
        assertThat(Heading.of("S")).isEqualTo(South);
        assertThat(Heading.of("E")).isEqualTo(East);
        assertThat(Heading.of("W")).isEqualTo(West);
    }

    @Test
    public void should_be_created_from_char() {
        assertThat(Heading.of('N')).isEqualTo(North);
        assertThat(Heading.of('S')).isEqualTo(South);
        assertThat(Heading.of('E')).isEqualTo(East);
        assertThat(Heading.of('W')).isEqualTo(West);
    }

    @Test
    public void should_be_able_turn_right() {
        assertThat(North.turnRight()).isEqualTo(East);
        assertThat(East.turnRight()).isEqualTo(South);
        assertThat(South.turnRight()).isEqualTo(West);
        assertThat(West.turnRight()).isEqualTo(North);
    }

    @Test
    public void should_be_able_turn_left() {
        assertThat(North.turnLeft()).isEqualTo(West);
        assertThat(East.turnLeft()).isEqualTo(North);
        assertThat(South.turnLeft()).isEqualTo(East) ;
        assertThat(West.turnLeft()).isEqualTo(South);
    }

    @Test
    public void should_be_able_opposite_direction() {
        assertThat(West.opposite()).isEqualTo(East);
        assertThat(South.opposite()).isEqualTo(North);
        assertThat(North.opposite()).isEqualTo(South);
        assertThat(East.opposite()).isEqualTo(West);
    }
}
