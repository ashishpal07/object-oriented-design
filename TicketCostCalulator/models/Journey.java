package models;

import java.time.DayOfWeek;
import java.time.LocalTime;


public class Journey {
  private LocalTime startTime;
  private LocalTime endTime;
  private DayOfWeek day;

  public Journey(LocalTime startTime, LocalTime endTime, DayOfWeek day) {
    this.startTime = startTime;
    this.endTime = endTime;
    this.day = day;
  }

  public LocalTime getStartTime() {
    return this.startTime;
  }

  public LocalTime getEndTime() {
    return this.endTime;
  }

  public void setStartTime(LocalTime startTime) {
    this.startTime = startTime;
  }

  public void setEndTime(LocalTime endTime) {
    this.endTime = endTime;
  }

  public DayOfWeek getDay() {
    return day;
  }

  public void setDay(DayOfWeek day) {
    this.day = day;
  }
}
