package shape;

import java.text.DecimalFormat;

/**
 * Position class.
 */
public class Position {
  private int x;
  private int y;

  /**
   * Position constructor.
   *
   * @param x x radius
   * @param y y radius
   */
  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Gets x.
   *
   * @return the x
   */
  public int getX() {
    return x;
  }

  /**
   * Gets y.
   *
   * @return the y
   */
  public int getY() {
    return y;
  }

  /**
   * toString method.
   *
   * @return string representation of the color
   */
  @Override
  public String toString() {
    DecimalFormat df = new DecimalFormat("0.0");
    return "(" + df.format(this.x) + "," + df.format(this.y) + ")";
  }
}
