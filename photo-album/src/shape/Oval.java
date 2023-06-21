package shape;

/**
 * Oval class extends AbstractShape.
 */
public class Oval extends AbstractShape {
  private int x;
  private int y;
  private static final int MIN = 0;

  /**
   * Oval constructor.
   *
   * @param id       the id
   * @param type     the type
   * @param position the position
   * @param x        the x
   * @param y        the y
   * @param color    the color
   */
  public Oval(String id, String type, Position position, int x, int y, Color color) {
    super(id, type, position, color);
    if (x < MIN || y < MIN) {
      throw new IllegalArgumentException("Invalid size");
    }
    this.x = x;
    this.y = y;
  }

  /**
   * set size.
   *
   * @param size1 the size 1
   * @param size2 the size 2
   */
  @Override
  public void setSize(int size1, int size2) {
    if (size1 < MIN || size2 < MIN) {
      throw new IllegalArgumentException("Invalid size.");
    }
    this.x = size1;
    this.y = size2;
  }

  /**
   * get x radius.
   *
   * @return the x radius
   */
  @Override
  public int getSize1() {
    return this.x;
  }

  /**
   * get y radius.
   *
   * @return the x radius
   */
  @Override
  public int getSize2() {
    return this.y;
  }

  /**
   * toString method.
   *
   * @return string
   */
  @Override
  public String toString() {
    return super.toString() + "X radius: "
        + this.x + "\n" + "Y radius: "
        + this.y + "\n";
  }

  /**
   * clone method.
   *
   * @return new Oval object
   */
  @Override
  public IShape clone() {
    return new Oval(this.id, this.type, this.position,
        this.x, this.y, this.color);
  }
}
