package org.opentripplanner.standalone.config.configure;

import dagger.Module;
import dagger.Provides;
import java.time.Duration;
import javax.inject.Singleton;
import org.opentripplanner.routing.algorithm.raptoradapter.transit.TripSchedule;
import org.opentripplanner.standalone.config.BuildConfig;
import org.opentripplanner.standalone.config.ConfigModel;
import org.opentripplanner.standalone.config.OtpConfig;
import org.opentripplanner.standalone.config.RouterConfig;
import org.opentripplanner.standalone.config.api.StreetRoutingTimeout;
import org.opentripplanner.transit.raptor.configure.RaptorConfig;

@Module
public class ConfigModule {

  @Provides
  static OtpConfig provideOtpConfig(ConfigModel model) {
    return model.otpConfig();
  }

  @Provides
  static BuildConfig provideBuildConfig(ConfigModel model) {
    return model.buildConfig();
  }

  @Provides
  static RouterConfig provideRouterConfig(ConfigModel model) {
    return model.routerConfig();
  }

  @Provides
  @Singleton
  static RaptorConfig<TripSchedule> providesRaptorConfig(ConfigModel config) {
    return new RaptorConfig<>(config.routerConfig().raptorTuningParameters());
  }

  @Provides
  @StreetRoutingTimeout
  static Duration streetRoutingTimeout(ConfigModel config) {
    return config.routerConfig().streetRoutingTimeout();
  }
}
