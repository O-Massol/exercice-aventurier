# Analysis

## Domain

- Map (collection of Positions and TerrainTypes)
- Position
- TerrainType
- MovementCommand
- PlannedTravel (aggregates a Position and a stream of MovementCommands)

## Support

- FileBasedMapAdapter
- FileBasedPlannedTravelAdapter

## Acceptance test template
GIVEN A map is provided from a file F1
AND A planned travel is provided from a file F2
WHEN The adventurer proceeds with his planned travel on the map 
THEN The adventurer is in a resulting position RP
