package com.omassol.adventurer.model;

import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PlannedTravel {

    private final Position startingPosition;
    private final Stream<MovementCommand> sequenceOfMovements;

}
