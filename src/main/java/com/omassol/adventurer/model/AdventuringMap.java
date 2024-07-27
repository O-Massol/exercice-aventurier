package com.omassol.adventurer.model;

import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class AdventuringMap {

    private final Set<Position> positions;

    public AdventuringMap(Set<Position> positions) {
        this.positions = positions;
    }

    public Position proceed(PlannedTravel plannedTravel) {
        AtomicReference<Position> result = new AtomicReference<>(plannedTravel.getStartingPosition());
        plannedTravel.getSequenceOfMovements().forEach(cmd -> result.set(resolveResultingPosition(result.get(),cmd)));
        return result.get();
    }

    private Position resolveResultingPosition(Position from, MovementCommand direction){
        return new Position(from.getX()+direction.getX(), from.getY()+direction.getY());
    }
}
