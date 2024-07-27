package com.omassol.adventurer.model;

import static org.assertj.core.api.Assertions.assertThat;

import com.omassol.adventurer.support.StaticMapProvider;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AdventuringMapTest {

    @Test
    @DisplayName("proceed ; with (1,1) map and (0,0,[]) planned travel ; (0,0) position returned")
    void proceedSimplest(){
        var map = new StaticMapProvider().smallestMap();
        var position = map.proceed(new PlannedTravel(new Position(0,0), Stream.empty()));
        assertThat(position).isEqualTo(new Position(0,0));
    }

    @Test
    @DisplayName("proceed ; with (2,2) map and (0,0,[S]) planned travel ; (0,1) position returned")
    void proceedOneMove(){
        var map = new StaticMapProvider().emptyMapOfSize2By2();
        var position = map.proceed(new PlannedTravel(new Position(0,0), Stream.of(MovementCommand.SOUTH)));
        assertThat(position).isEqualTo(new Position(0,1));
    }

    @Test
    @DisplayName("proceed ; with (2,2) map and (0,0,[SE]) planned travel ; (1,1) position returned")
    void proceedTwoMovesSouthEast(){
        var map = new StaticMapProvider().emptyMapOfSize2By2();
        var position = map.proceed(new PlannedTravel(new Position(0,0), Stream.of(MovementCommand.SOUTH, MovementCommand.EAST)));
        assertThat(position).isEqualTo(new Position(1,1));
    }

    @Test
    @DisplayName("proceed ; with (2,2) map and (1,1,[NW]) planned travel ; (0,0) position returned")
    void proceedTwoMovesNorthWest(){
        var map = new StaticMapProvider().emptyMapOfSize2By2();
        var position = map.proceed(new PlannedTravel(new Position(1,1), Stream.of(MovementCommand.NORTH, MovementCommand.WEST)));
        assertThat(position).isEqualTo(new Position(0,0));
    }

}
