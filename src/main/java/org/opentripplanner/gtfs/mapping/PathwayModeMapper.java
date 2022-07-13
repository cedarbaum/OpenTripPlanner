package org.opentripplanner.gtfs.mapping;

import org.opentripplanner.model.PathwayMode;

public class PathwayModeMapper {

  public static PathwayMode map(int pathwayMode) {
    return switch (pathwayMode) {
      case 1 -> PathwayMode.WALKWAY;
      case 2 -> PathwayMode.STAIRS;
      case 3 -> PathwayMode.MOVING_SIDEWALK;
      case 4 -> PathwayMode.ESCALATOR;
      case 5 -> PathwayMode.ELEVATOR;
      case 6 -> PathwayMode.FARE_GATE;
      case 7 -> PathwayMode.EXIT_GATE;
      default -> throw new IllegalArgumentException("Invalid pathway mode: " + pathwayMode);
    };
  }
}
