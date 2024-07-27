package com.omassol.adventurer.support;

import static com.omassol.adventurer.model.MovementCommand.SOUTH;
import static com.omassol.adventurer.model.MovementCommand.WEST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.omassol.adventurer.model.AdventuringMap;
import com.omassol.adventurer.model.PlannedTravel;
import com.omassol.adventurer.model.Position;
import com.omassol.adventurer.model.TerrainType;
import com.omassol.adventurer.support.errors.InvalidAdventuringMapFileException;
import com.omassol.adventurer.support.errors.InvalidPlannedTravelFileException;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Stream;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FileAdventuringMapAdapterTest {

    @SneakyThrows
    @Test
    @DisplayName("adapt ; with file that does not exist ; exception thrown")
    void adaptFileDoesNotExist() {
        var filePath = Path.of("datasets/adventuringMap/doesNotExist.txt");
        assertThatThrownBy(() -> new FileAdventuringMapAdapter().adapt(filePath)).isInstanceOf(InvalidAdventuringMapFileException.class);
    }

    @SneakyThrows
    @Test
    @DisplayName("adapt ; with blank file 1 by 1 ; map returned")
    void adaptFileBlank1By1() {
        var filePath = Path.of(this.getClass().getClassLoader().getResource("datasets/adventuringMap/blank1by1.txt").toURI());
        var result = new FileAdventuringMapAdapter().adapt(filePath);
        assertThat(result).isEqualTo(new AdventuringMap(Map.of(new Position(0,0), TerrainType.MOVEABLE)));
    }

}
