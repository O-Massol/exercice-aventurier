package com.omassol.adventurer.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MovementCommand {
    SOUTH(0,1);

    private final int x;
    private final int y;
}
