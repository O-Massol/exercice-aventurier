package com.omassol.adventurer.model;

import static org.assertj.core.api.Assertions.assertThat;

import com.omassol.adventurer.support.StaticMapProvider;
import com.omassol.adventurer.support.StaticPlannedTravelProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AdventuringMapTest {

    @Test
    @DisplayName("proceed ; with (1,1) map and (0,0,[]) planned travel ; (0,0) position returned")
    void proceedSimplest(){
        var map = new StaticMapProvider().smallestMap();
        var position = map.proceed(new StaticPlannedTravelProvider().smallestTravel(new Position(0,0)));
        assertThat(position).isEqualTo(new Position(0,0));
    }

//    @Test
//    @DisplayName("proceed ; with (2,2) map and (0,0,[S]) planned travel ; (0,1) position returned")
//    void proceedOneMove(){
//    }

}
