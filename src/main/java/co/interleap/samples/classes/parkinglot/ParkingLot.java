package co.interleap.samples.classes.parkinglot;

import java.util.ArrayList;
import java.util.List;

class ParkingLot {

  private final int capacity;
  private int numberOfCars = 0;
  private List<DisplayBoard> displayBoards = new ArrayList<DisplayBoard>();


  public ParkingLot(int capacity) {
    this.capacity = capacity;
    notifyparkingspacechange();
  }

  public boolean park() {
    if (isFull())  return false;
    numberOfCars++;
    notifyparkingspacechange();
    return true;
  }

  public void addNotificationReceiver(DisplayBoard displayBoard){
    displayBoards.add(displayBoard);
  }

  public void unpark() {
    numberOfCars--;
    notifyparkingspacechange();
  }

  private void notifyparkingspacechange() {
    for(DisplayBoard displayBoard : displayBoards)
      displayBoard.notify(numberOfCars);
  }

  public boolean isFull() {
    return capacity == numberOfCars;
  }
}

