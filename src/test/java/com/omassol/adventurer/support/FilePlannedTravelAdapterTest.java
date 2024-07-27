package com.omassol.adventurer.support;

import static com.omassol.adventurer.model.MovementCommand.SOUTH;
import static org.assertj.core.api.Assertions.assertThat;

import com.omassol.adventurer.model.PlannedTravel;
import com.omassol.adventurer.model.Position;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FilePlannedTravelAdapterTest {

    @Test
    @DisplayName("adapt ; with valid file ; planned travel returned")
    void adaptSimple() {
        var filePath = "";
        var result = new FilePlannedTravelAdapter().adapt(filePath);
        assertThat(result).isNotNull()
            .returns(new Position(1, 1), PlannedTravel::getStartingPosition)
            .returns(Stream.of(SOUTH), PlannedTravel::getSequenceOfMovements)
        ;
    }

}
