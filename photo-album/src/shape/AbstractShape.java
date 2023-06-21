package shape;

/**
 * The type Abstract shape.
 */
public abstract class AbstractShape implements IShape {
  protected String id;
  protected String type;
  protected Position position;
  protected Color color;

  /**
   * AbstractShape constructor.
   *
   * @param id       the id
   * @param type     the type
   * @param position the position
   * @param color    the color
   */
  public AbstractShape(String id, String type, Position position, Color color) {
    if (id == null || id.isEmpty()) {
      throw new IllegalArgumentException("Invalid id.");
    }
    this.id = id;
    this.type = type;
    this.position = position;
    this.color = color;
  }

  /**
   * set position.
   *
   * @param position the position
   */
  @Override
  public void setPosition(Position position) {
    this.position = position;
  }

  /**
   * set color.
   *
   * @param color the color
   */
  @Override
  public void setColor(Color color) {
    this.color = color;
  }

  /**
   * set id.
   *
   * @return id
   */
  @Override
  public String getId() {
    return this.id;
  }

  /**
   * get object type.
   *
   * @return type
   */
  @Override
  public String getType() {
    return this.type;
  }

  /**
   * get position.
   *
   * @return position
   */
  @Override
  public Position getPosition() {
    return this.position;
  }

  /**
   * get color.
   *
   * @return color
   */
  @Override
  public Color getColor() {
    return this.color;
  }

  /**
   * toString method.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "ID: " + this.id + "\n"
        + "Type: " + this.type + "\n"
        + "Position: " + this.position + "\n"
        + "Color: " + this.color + "\n";
  }

  /**
   * clone method.
   *
   * @return IShape object
   */
  @Override
  public abstract IShape clone();
}
