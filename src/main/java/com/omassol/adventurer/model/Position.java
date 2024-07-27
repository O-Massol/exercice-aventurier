package com.omassol.adventurer.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Position {
    private final int x;
    private final int y;
}
