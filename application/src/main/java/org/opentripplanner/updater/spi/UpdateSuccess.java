package org.opentripplanner.updater.spi;

import java.util.Collection;
import java.util.List;
import org.opentripplanner.utils.collection.ListUtils;

/**
 * The result of a successful application of a realtime update, for example for trips or
 * vehicle positions. Its extra information is a collection of possible warnings that
 * ought to be looked at but didn't prevent the application of the update and the provider of the
 * update.
 */
public record UpdateSuccess(List<WarningType> warnings, String producer) {
  /**
   * Create an instance with no warnings and no provider.
   */
  public static UpdateSuccess noWarnings() {
    return new UpdateSuccess(List.of(), null);
  }

  /**
   * Create an instance with no warnings, but a provider.
   */
  public static UpdateSuccess noWarnings(String producer) {
    return new UpdateSuccess(List.of(), producer);
  }

  /**
   * Return a copy of the instance with the provided warnings added.
   */
  public UpdateSuccess addWarnings(Collection<WarningType> addedWarnings) {
    return new UpdateSuccess(ListUtils.combine(this.warnings, addedWarnings), this.producer);
  }

  public enum WarningType {
    /**
     * An added trip contained references to stops that are not in the static data. These
     * stops have been removed.
     */
    UNKNOWN_STOPS_REMOVED_FROM_ADDED_TRIP,
  }
}
