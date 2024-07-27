package com.omassol.adventurer.support;

import static com.omassol.adventurer.model.MovementCommand.SOUTH;
import static com.omassol.adventurer.model.MovementCommand.WEST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.omassol.adventurer.model.PlannedTravel;
import com.omassol.adventurer.model.Position;
import com.omassol.adventurer.support.errors.InvalidPlannedTravelFileException;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FilePlannedTravelAdapterTest {

    @SneakyThrows
    @Test
    @DisplayName("adapt ; with file that does not exist ; exception thrown")
    void adaptFileDoesNotExist() {
        var filePath = Path.of("datasets/plannedTravel/doesNotExist.txt");
        assertThatThrownBy(() -> new FilePlannedTravelAdapter().adapt(filePath)).isInstanceOf(InvalidPlannedTravelFileException.class);
    }

    @SneakyThrows
    @Test
    @DisplayName("adapt ; with invalid file having one line ; exception thrown")
    void adaptLineNumberError() {
        var filePath = Path.of(this.getClass().getClassLoader().getResource("datasets/plannedTravel/lineNumberError.txt").toURI());
        assertThatThrownBy(() -> new FilePlannedTravelAdapter().adapt(filePath)).isInstanceOf(InvalidPlannedTravelFileException.class);
    }

    @SneakyThrows
    @Test
    @DisplayName("adapt ; with invalid file having first line 1,1,1 ; exception thrown")
    void adaptLineOneError() {
        var filePath = Path.of(this.getClass().getClassLoader().getResource("datasets/plannedTravel/lineOneError.txt").toURI());
        assertThatThrownBy(() -> new FilePlannedTravelAdapter().adapt(filePath)).isInstanceOf(InvalidPlannedTravelFileException.class);
    }

    @SneakyThrows
    @Test
    @DisplayName("adapt ; with invalid file having first line a,5 ; exception thrown")
    void adaptLineOneFormatError() {
        var filePath = Path.of(this.getClass().getClassLoader().getResource("datasets/plannedTravel/lineOneFormatError.txt").toURI());
        assertThatThrownBy(() -> new FilePlannedTravelAdapter().adapt(filePath)).isInstanceOf(InvalidPlannedTravelFileException.class);
    }

    @SneakyThrows
    @Test
    @DisplayName("adapt ; with valid file (1,1)S ; planned travel returned")
    void adaptSimple() {
        var filePath = Path.of(this.getClass().getClassLoader().getResource("datasets/plannedTravel/simple.txt").toURI());
        var result = new FilePlannedTravelAdapter().adapt(filePath);
        assertThat(result).isNotNull()
            .returns(new Position(1, 1), PlannedTravel::getStartingPosition)
            .returns(Stream.of(SOUTH).toList(), plannedTravel -> plannedTravel.getSequenceOfMovements().toList())
        ;
    }

    @SneakyThrows
    @Test
    @DisplayName("adapt ; with valid file (1,1)SW ; planned travel returned")
    void adaptTwoDifferentMoves() {
        var filePath = Path.of(this.getClass().getClassLoader().getResource("datasets/plannedTravel/twoDifferentMoves.txt").toURI());
        var result = new FilePlannedTravelAdapter().adapt(filePath);
        assertThat(result).isNotNull()
            .returns(new Position(1, 1), PlannedTravel::getStartingPosition)
            .returns(Stream.of(SOUTH, WEST).toList(), plannedTravel -> plannedTravel.getSequenceOfMovements().toList())
        ;
    }

}
