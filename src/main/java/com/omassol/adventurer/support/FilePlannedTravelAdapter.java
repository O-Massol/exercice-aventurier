package com.omassol.adventurer.support;

import com.omassol.adventurer.model.MovementCommand;
import com.omassol.adventurer.model.PlannedTravel;
import com.omassol.adventurer.model.Position;
import com.omassol.adventurer.support.errors.InvalidPlannedTravelFileException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class FilePlannedTravelAdapter {

    private static final Map<Character, Optional<MovementCommand>> MAPPING = Map.of(
        'N',Optional.of(MovementCommand.NORTH),
        'S',Optional.of(MovementCommand.SOUTH),
        'O',Optional.of(MovementCommand.WEST),
        'E',Optional.of(MovementCommand.EAST)
    );

    public PlannedTravel adapt(Path filePath) throws InvalidPlannedTravelFileException {
        try {
            var lines = Files.readAllLines(filePath);
            if(lines.size()!=2){
                throw new InvalidPlannedTravelFileException("File should have exactly two lines");
            }
            var positionAsInts = Arrays.stream(lines.getFirst().split(",")).map(s->Integer.valueOf(s.trim())).toList();
            if(positionAsInts.size()!=2){
                throw new InvalidPlannedTravelFileException("File should have a first line with two integers separated by a coma");
            }
            var commands = lines.getLast().chars().mapToObj(character->MAPPING.getOrDefault((char)character,Optional.empty())).filter(Optional::isPresent).map(Optional::get);
            return new PlannedTravel(new Position(positionAsInts.getFirst(), positionAsInts.getLast()), commands);
        } catch (NumberFormatException nfe) {
            throw new InvalidPlannedTravelFileException("File was not correctly formatted",nfe);
        } catch (IOException ioe) {
            throw new InvalidPlannedTravelFileException("File was not readable",ioe);
        }
    }
}
