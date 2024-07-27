package com.omassol.adventurer.model;

import static org.assertj.core.api.Assertions.assertThat;

import com.omassol.adventurer.support.StaticMapProvider;
import com.omassol.adventurer.support.StaticPlannedTravelProvider;
import org.junit.jupiter.api.Test;

class AdventuringMapTest {

    @Test
    void proceed_withSmallestMapAndSmallestPlannedTravel_positionReturned(){
        var map = new StaticMapProvider().smallestMap();
        var position = map.proceed(new StaticPlannedTravelProvider().smallestTravel(new Position(0,0)));
        assertThat(position).isEqualTo(new Position(0,0));
    }

}
