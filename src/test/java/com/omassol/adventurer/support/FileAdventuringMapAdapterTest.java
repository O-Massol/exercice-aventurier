package com.omassol.adventurer.support;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.omassol.adventurer.model.AdventuringMap;
import com.omassol.adventurer.model.Position;
import com.omassol.adventurer.model.TerrainType;
import com.omassol.adventurer.support.errors.InvalidAdventuringMapFileException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

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
    void adaptFileBlank1By1(@TempDir Path tempDir) {
        var filePath = tempDir.resolve("blank1by1.txt");
        Files.write(filePath, List.of(" "));
        var result = new FileAdventuringMapAdapter().adapt(filePath);
        assertThat(result).isEqualTo(new AdventuringMap(Map.of(new Position(0,0), TerrainType.MOVEABLE)));
    }

    @SneakyThrows
    @Test
    @DisplayName("adapt ; with blank file 2 by 2 ; map returned")
    void adaptFileBlank2By2(@TempDir Path tempDir) {
        var filePath = tempDir.resolve("blank2by2.txt");
        Files.write(filePath, List.of("  ", "  "));
        var result = new FileAdventuringMapAdapter().adapt(filePath);
        assertThat(result).isEqualTo(new AdventuringMap(Map.of(
            new Position(0, 0), TerrainType.MOVEABLE,
            new Position(0, 1), TerrainType.MOVEABLE,
            new Position(1, 0), TerrainType.MOVEABLE,
            new Position(1, 1), TerrainType.MOVEABLE
        )));
    }

    @SneakyThrows
    @Test
    @DisplayName("adapt ; with file 2 by 2 having (1,1) as woods ; map returned")
    void adaptFileBlank2By2WithWoods(@TempDir Path tempDir) {
        var filePath = tempDir.resolve("wooded2by2.txt");
        Files.write(filePath, List.of("  ", " #"));
        var result = new FileAdventuringMapAdapter().adapt(filePath);
        assertThat(result).isEqualTo(new AdventuringMap(Map.of(
            new Position(0, 0), TerrainType.MOVEABLE,
            new Position(0, 1), TerrainType.MOVEABLE,
            new Position(1, 0), TerrainType.MOVEABLE,
            new Position(1, 1), TerrainType.WOODS
        )));
    }

    @SneakyThrows
    @Test
    @DisplayName("adapt ; with file 2 by 2 having (0,1) and (1,1) as woods ; map returned")
    void adaptFileBlank2By2WithTwoWoods(@TempDir Path tempDir) {
        var filePath = tempDir.resolve("moreWoods2by2.txt");
        Files.write(filePath, List.of(" #", " #"));
        var result = new FileAdventuringMapAdapter().adapt(filePath);
        assertThat(result).isEqualTo(new AdventuringMap(Map.of(
            new Position(0, 0), TerrainType.MOVEABLE,
            new Position(0, 1), TerrainType.MOVEABLE,
            new Position(1, 0), TerrainType.WOODS,
            new Position(1, 1), TerrainType.WOODS
        )));
    }

}
