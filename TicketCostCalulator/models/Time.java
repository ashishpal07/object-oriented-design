package models;

import java.time.LocalTime;

public class Time {
  private LocalTime start;
  private LocalTime end;

  public Time(LocalTime start, LocalTime end) {
    this.start = start;
    this.end = end;
  }

  public LocalTime getStart() {
    return start;
  }

  public LocalTime getEnd() {
    return end;
  }

  public void setStart(LocalTime start) {
    this.start = start;
  }

  public void setEnd(LocalTime end) {
    this.end = end;
  }

  public boolean isWithinRange(LocalTime time) {
    return !time.isBefore(start) && !time.isAfter(end);
  }
}
