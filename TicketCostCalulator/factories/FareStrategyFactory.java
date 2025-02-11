package factories;

import models.BusType;
import strategies.fareStrategies.ComfortFareStrategy;
import strategies.fareStrategies.EconomyFareStrategy;
import strategies.fareStrategies.IFareStrategy;
import strategies.fareStrategies.PremiumFareStrategy;

public class FareStrategyFactory {
    public static IFareStrategy getFareStrategy(BusType busType) {
        return switch (busType) {
            case Comfort -> new ComfortFareStrategy();
            case Premium -> new PremiumFareStrategy();
            case Economy -> new EconomyFareStrategy();
        };
    }
}
