package co.interleap.samples;

public class PointDataStructure {
  public double x;
  public double y;
}

interface PointObject {
  double getX();
  double getY();
  void setCartesian(double x, double y);
  double getR();
  double getTheta();
  void setPolar();

}
