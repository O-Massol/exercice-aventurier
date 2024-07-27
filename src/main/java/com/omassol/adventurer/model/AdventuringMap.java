package com.omassol.adventurer.model;

import java.util.Set;

public class AdventuringMap {

    private final Set<Position> positions;

    public AdventuringMap(Set<Position> positions) {
        this.positions = positions;
    }

    public Position proceed(PlannedTravel plannedTravel) {
        return new Position(0,0);
    }
}
