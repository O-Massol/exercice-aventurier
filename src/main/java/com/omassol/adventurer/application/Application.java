package com.omassol.adventurer.application;

import com.omassol.adventurer.support.FileAdventuringMapAdapter;
import com.omassol.adventurer.support.FilePlannedTravelAdapter;
import com.omassol.adventurer.support.errors.InvalidAdventuringMapFileException;
import com.omassol.adventurer.support.errors.InvalidPlannedTravelFileException;
import java.nio.file.Path;
import java.text.MessageFormat;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Application {

    private final Path mapFile;
    private final Path plannedTravelFile;
    private final FileAdventuringMapAdapter adventuringMapAdapter = new FileAdventuringMapAdapter();
    private final FilePlannedTravelAdapter plannedTravelAdapter = new FilePlannedTravelAdapter();

    public String resolveTravel() throws InvalidAdventuringMapFileException, InvalidPlannedTravelFileException {
        var finalPosition = adventuringMapAdapter.adapt(mapFile).proceed(plannedTravelAdapter.adapt(plannedTravelFile));
        return MessageFormat.format("({0},{1})", finalPosition.getX(), finalPosition.getY());
    }
}
