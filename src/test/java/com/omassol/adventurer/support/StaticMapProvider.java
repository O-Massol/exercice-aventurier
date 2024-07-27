package com.omassol.adventurer.support;

import static com.omassol.adventurer.model.TerrainType.MOVEABLE;

import com.omassol.adventurer.model.AdventuringMap;
import com.omassol.adventurer.model.Position;
import java.util.Map;
import java.util.Set;

public class StaticMapProvider {


    public AdventuringMap smallestMap() {
        return new AdventuringMap(Map.of(new Position(0,0),MOVEABLE));
    }

    public AdventuringMap emptyMapOfSize2By2() {
        return new AdventuringMap(Map.of(
            new Position(0,0),MOVEABLE,
            new Position(1,0),MOVEABLE,
            new Position(0,1),MOVEABLE,
            new Position(1,1),MOVEABLE
        ));
    }
}
