package com.omassol.adventurer.support;

import com.omassol.adventurer.model.AdventuringMap;
import com.omassol.adventurer.model.Position;
import com.omassol.adventurer.model.TerrainType;
import com.omassol.adventurer.support.errors.InvalidAdventuringMapFileException;
import com.omassol.adventurer.support.errors.InvalidPlannedTravelFileException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;

public class FileAdventuringMapAdapter {

    public AdventuringMap adapt(Path filePath) throws InvalidAdventuringMapFileException {
        try {
            var lines = Files.readAllLines(filePath);
            return new AdventuringMap(Map.of(new Position(0, 0), TerrainType.MOVEABLE));
        } catch (IOException ioe) {
            throw new InvalidAdventuringMapFileException("File was not readable", ioe);
        }
    }
}
