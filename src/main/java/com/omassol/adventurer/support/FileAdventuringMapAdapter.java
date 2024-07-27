package com.omassol.adventurer.support;

import com.omassol.adventurer.model.AdventuringMap;
import com.omassol.adventurer.model.Position;
import com.omassol.adventurer.model.TerrainType;
import com.omassol.adventurer.support.errors.InvalidAdventuringMapFileException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.stream.IntStream;

public class FileAdventuringMapAdapter {

    public static final char WOODS_CHARACTER = '#';

    public AdventuringMap adapt(Path filePath) throws InvalidAdventuringMapFileException {
        try {
            var map = new HashMap<Position, TerrainType>();
            var lines = Files.readAllLines(filePath);
            IntStream.range(0, lines.size()).forEach(
                i -> {
                    var line = lines.get(i);
                    IntStream.range(0, line.length()).forEach(
                        j -> map.put(new Position(j, i), line.charAt(j) == WOODS_CHARACTER ? TerrainType.WOODS : TerrainType.MOVEABLE)
                    );
                }
            );
            return new AdventuringMap(map);
        } catch (IOException ioe) {
            throw new InvalidAdventuringMapFileException("File was not readable", ioe);
        }
    }
}
