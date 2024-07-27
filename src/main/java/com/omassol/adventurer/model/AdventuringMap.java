package com.omassol.adventurer.model;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class AdventuringMap {

    private final Map<Position,TerrainType> positions;

    public AdventuringMap(Map<Position,TerrainType> positions) {
        this.positions = positions;
    }

    public Position proceed(PlannedTravel plannedTravel) {
        AtomicReference<Position> result = new AtomicReference<>(plannedTravel.getStartingPosition());
        plannedTravel.getSequenceOfMovements().forEach(cmd -> result.set(resolveResultingPosition(result.get(),cmd)));
        return result.get();
    }

    private Position resolveResultingPosition(Position from, MovementCommand direction){
        var intendedPosition = new Position(from.getX() + direction.getX(), from.getY() + direction.getY());
        return positions.getOrDefault(intendedPosition,TerrainType.OUT_OF_MAP) == TerrainType.MOVEABLE ? intendedPosition : from;
    }
}
