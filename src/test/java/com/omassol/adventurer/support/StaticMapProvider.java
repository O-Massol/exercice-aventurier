package com.omassol.adventurer.support;

import com.omassol.adventurer.model.AdventuringMap;
import com.omassol.adventurer.model.Position;
import java.util.Set;

public class StaticMapProvider {


    public AdventuringMap smallestMap() {
        return new AdventuringMap(Set.of(new Position(0,0)));
    }

    public AdventuringMap emptyMapOfSize2By2() {
        return new AdventuringMap(Set.of(
            new Position(0,0),
            new Position(1,0),
            new Position(0,1),
            new Position(1,1)
        ));
    }
}
