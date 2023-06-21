package shape;

import java.text.DecimalFormat;

/**
 * The type Color.
 */
public class Color {
  private int r;
  private int g;
  private int b;
  private static final int MIN = 0;
  private static final int MAX = 255;

  /**
   * Color constructor.
   *
   * @param r the r
   * @param g the g
   * @param b the b
   * @throws IllegalArgumentException if rgb values are invalid
   */
  public Color(int r, int g, int b) throws IllegalArgumentException {
    if (checkBound(r, g, b)) {
      throw new IllegalArgumentException("RGB should be between 0 and 255.");
    }
    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * check the rgb values are within the bounds.
   *
   * @param r the r
   * @param g the g
   * @param b the b
   * @return boolean if the values are valid
   */
  private boolean checkBound(int r, int g, int b) {
    return r < MIN || r > MAX
        || g < MIN || g > MAX
        || b < MIN || b > MAX;
  }

  /**
   * Gets r.
   *
   * @return the r
   */
  public int getR() {
    return this.r;
  }

  /**
   * Gets g.
   *
   * @return the g
   */
  public int getG() {
    return this.g;
  }

  /**
   * Gets b.
   *
   * @return the b
   */
  public int getB() {
    return this.b;
  }

  /**
   * toString method.
   *
   * @return string representation of the color
   */
  @Override
  public String toString() {
    DecimalFormat df = new DecimalFormat("0.0");
    return "("
        + df.format(this.r) + ", "
        + df.format(this.g) + ", "
        + df.format(this.b)
        + ")";
  }
}
