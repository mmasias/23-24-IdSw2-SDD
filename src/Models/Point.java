package Models;

public class Point {
  int x, y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int[] getLocation() {
    return new int[] { this.x, this.y };
  }

  public void setLocation(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
