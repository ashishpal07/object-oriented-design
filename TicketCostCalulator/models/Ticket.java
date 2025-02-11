package models;

import factories.FareStrategyFactory;

import java.time.DayOfWeek;

public class Ticket {
  private User user;
  private Journey journey;
  private BusType busType;
  private static final int ECONOMY_PASS = 250;
  private static final int COMFORT_PASS = 300;
  private static final int PREMIUM_PASS = 450;

  public Ticket(User user, Journey journey, BusType busType) {
    this.user = user;
    this.journey = journey;
    this.busType = busType;
  }

  public User getUser() {
    return user;
  }

  public Journey getJourney() {
    return journey;
  }

  public BusType getBusType() {
    return busType;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void setJourney(Journey journey) {
    this.journey = journey;
  }

  public void setBusType(BusType busType) {
    this.busType = busType;
  }

  public double calculateMinCost() {
    double totalCost = FareStrategyFactory
            .getFareStrategy(this.busType)
            .calculateFare(journey.getStartTime(), journey.getEndTime(), journey.getDay());

    double passCost = 0.0;
    if (busType.equals(BusType.Comfort)) {
      passCost = COMFORT_PASS;
    } else if (busType.equals(BusType.Economy)) {
      passCost = ECONOMY_PASS;
    } else if (busType.equals(BusType.Premium)) {
      passCost = PREMIUM_PASS;
    }

    return Math.min(totalCost, passCost);
  }
}
