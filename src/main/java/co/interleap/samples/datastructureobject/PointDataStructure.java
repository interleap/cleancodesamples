package co.interleap.samples.datastructureobject;

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
