package shape;

/**
 * Rectangle class extends AbstractShape.
 */
public class Rectangle extends AbstractShape {
  private int width;
  private int height;
  private static final int MIN = 0;


  /**
   * Rectangle constructor.
   *
   * @param id       the id
   * @param type     the type
   * @param position the position
   * @param color    the color
   */
  public Rectangle(String id, String type, Position position,
                   int width, int height, Color color) {
    super(id, type, position, color);
    if (width < MIN || height < MIN) {
      throw new IllegalArgumentException("Invalid size!");
    }
    this.width = width;
    this.height = height;
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
      throw new IllegalArgumentException("Invalid size");
    }
    this.width = size1;
    this.height = size2;
  }

  /**
   * get width.
   *
   * @return the width
   */
  @Override
  public int getSize1() {
    return this.width;
  }

  /**
   * get height.
   *
   * @return the height
   */
  @Override
  public int getSize2() {
    return this.height;
  }

  /**
   * toString method.
   *
   * @return string
   */
  @Override
  public String toString() {
    return super.toString() + "Width: "
        + this.width + "\n" + "Height: "
        + this.height + "\n";
  }

  /**
   * clone method.
   *
   * @return new Oval object
   */
  @Override
  public IShape clone() {
    return new Rectangle(this.id, this.type, this.position,
        this.width, this.height, this.color);
  }
}
