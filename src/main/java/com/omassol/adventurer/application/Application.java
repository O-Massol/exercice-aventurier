package com.omassol.adventurer.application;

import com.omassol.adventurer.support.FileAdventuringMapAdapter;
import com.omassol.adventurer.support.FilePlannedTravelAdapter;
import com.omassol.adventurer.support.errors.InvalidAdventuringMapFileException;
import com.omassol.adventurer.support.errors.InvalidPlannedTravelFileException;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.logging.Logger;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Application {

    private static final Logger log = Logger.getLogger(Application.class.getName());
    private final Path mapFile;
    private final Path plannedTravelFile;
    private final FileAdventuringMapAdapter adventuringMapAdapter = new FileAdventuringMapAdapter();
    private final FilePlannedTravelAdapter plannedTravelAdapter = new FilePlannedTravelAdapter();

    public String resolveTravel() throws InvalidAdventuringMapFileException, InvalidPlannedTravelFileException {
        var finalPosition = adventuringMapAdapter.adapt(mapFile).proceed(plannedTravelAdapter.adapt(plannedTravelFile));
        return MessageFormat.format("({0},{1})", finalPosition.getX(), finalPosition.getY());
    }

    public static void main(String[] args) {
        if (args == null || args.length != 2) {
            log.warning("usage: first argument = path to map file, second argument = path to travel file");
        } else {
            try {
                var application = new Application(Path.of(args[0]), Path.of(args[1]));
                log.info("result: " + application.resolveTravel());
            } catch (Exception e) {
                log.severe("Error while processing the inputs: " + e.getMessage());
            }
        }
    }
}
