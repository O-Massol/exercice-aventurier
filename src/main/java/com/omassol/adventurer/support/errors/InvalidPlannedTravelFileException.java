package com.omassol.adventurer.support.errors;

public class InvalidPlannedTravelFileException extends Exception {

    public InvalidPlannedTravelFileException(String message) {
        super(message);
    }

    public InvalidPlannedTravelFileException(String message, Exception e) {
        super(message,e);
    }
}
