package com.omassol.adventurer.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Path;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationAcceptanceTest {

    @SneakyThrows
    @Test
    @DisplayName("Case 1")
    void case1() {
        // GIVEN A map is provided from a file F1
        var mapFile = Path.of(this.getClass().getClassLoader().getResource("datasets/adventuringMap/carte.txt").toURI());
        // AND A planned travel is provided from a file F2
        var plannedTravelFile = Path.of(this.getClass().getClassLoader().getResource("datasets/plannedTravel/case1.txt").toURI());
        var application = new Application(mapFile, plannedTravelFile);
        // WHEN The adventurer proceeds with his planned travel on the map
        var result = application.resolveTravel();
        // THEN The adventurer is in a resulting position RP
        assertThat(result).isEqualTo("(9,2)");
    }

    @SneakyThrows
    @Test
    @DisplayName("Case 2")
    void case2() {
        // GIVEN A map is provided from a file F1
        var mapFile = Path.of(this.getClass().getClassLoader().getResource("datasets/adventuringMap/carte.txt").toURI());
        // AND A planned travel is provided from a file F2
        var plannedTravelFile = Path.of(this.getClass().getClassLoader().getResource("datasets/plannedTravel/case2.txt").toURI());
        var application = new Application(mapFile, plannedTravelFile);
        // WHEN The adventurer proceeds with his planned travel on the map
        var result = application.resolveTravel();
        // THEN The adventurer is in a resulting position RP
        assertThat(result).isEqualTo("(7,5)");
    }

}
