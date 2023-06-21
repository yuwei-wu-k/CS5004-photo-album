package shape;

/**
 * The interface Shape.
 */
public interface IShape {

  /**
   * set position.
   *
   * @param position the position
   */
  void setPosition(Position position);

  /**
   * set color.
   *
   * @param color the color
   */
  void setColor(Color color);

  /**
   * set size.
   *
   * @param size1 the size 1
   * @param size2 the size 2
   */
  void setSize(int size1, int size2);

  /**
   * get id.
   *
   * @return the id
   */
  String getId();

  /**
   * get type.
   *
   * @return the type
   */
  String getType();

  /**
   * get position.
   *
   * @return the position
   */
  Position getPosition();

  /**
   * et color.
   *
   * @return the color
   */
  Color getColor();

  /**
   * get size1.
   *
   * @return the size 1
   */
  int getSize1();

  /**
   * get size2.
   *
   * @return the size 2
   */
  int getSize2();

  /**
   * Clone IShape.
   *
   * @return new IShape object
   */
  IShape clone();
}
