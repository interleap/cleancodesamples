package co.interleap.samples.classes.parkinglot;

public class DisplayBoard  implements NotificationReceiver {

  public void notify(int c)
  {
    //This method is intentionally left blank, and is present only to help explain the concept.
    //While doing this assignment, assume that the implementationis present.
    System.out.println("Display board now displays:" + c);
  }
}