package shape;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test for IShape.
 */
public class IShapeTest {
  IShape rectangle;
  IShape oval;

  /**
   * set up test objects.
   */
  @Before
  public void setUp() {
    Position positionRec = new Position(20, 50);
    Position positionOval = new Position(150, 100);
    Color colorRec = new Color(120, 120, 120);
    Color colorOval = new Color(20, 30, 40);
    rectangle = new Rectangle("Rec1", "rectangle",
        positionRec, 30, 30, colorRec);
    oval = new Oval("Oval1", "oval", positionOval, 100, 100, colorOval);
  }

  /**
   * Test set position.
   */
  @Test
  public void testSetPosition() {
    assertEquals(20, rectangle.getPosition().getX());
    assertEquals(50, rectangle.getPosition().getY());

    rectangle.setPosition(new Position(88, 99));
    assertEquals(88, rectangle.getPosition().getX());
    assertEquals(99, rectangle.getPosition().getY());
  }

  /**
   * Test set color.
   */
  @Test
  public void testSetColor() {
    assertEquals(120, rectangle.getColor().getR());
    assertEquals(120, rectangle.getColor().getG());
    assertEquals(120, rectangle.getColor().getB());

    rectangle.setColor(new Color(1, 1, 1));
    assertEquals(1, rectangle.getColor().getR());
    assertEquals(1, rectangle.getColor().getG());
    assertEquals(1, rectangle.getColor().getB());
  }

  /**
   * Test set size.
   */
  @Test
  public void testSetSize() {
    assertEquals(30, rectangle.getSize1());
    assertEquals(30, rectangle.getSize2());

    rectangle.setSize(66, 77);
    assertEquals(66, rectangle.getSize1());
    assertEquals(77, rectangle.getSize2());
  }

  /**
   * Test null id.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullId() {
    IShape rec1 = new Rectangle(null, "rectangle",
        new Position(20, 50), 30, 30, new Color(2, 2, 2));
  }

  /**
   * Test empty id.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyId() {
    IShape rec1 = new Rectangle("", "rectangle",
        new Position(20, 50), 30, 30,
        new Color(120, 120, 120));
  }

  /**
   * Test get type.
   */
  @Test
  public void testGetType() {
    assertEquals("rectangle", rectangle.getType());
    assertEquals("oval", oval.getType());
  }

  /**
   * Test get position.
   */
  @Test
  public void testGetPosition() {
    assertEquals(20, rectangle.getPosition().getX());
    assertEquals(50, rectangle.getPosition().getY());
    assertEquals(150, oval.getPosition().getX());
    assertEquals(100, oval.getPosition().getY());
  }

  /**
   * Test negative position.
   */
  @Test
  public void testNegativePosition() {
    Position positionRec1 = new Position(-20, -50);
    Color colorRec = new Color(120, 120, 120);
    rectangle = new Rectangle("Rec2", "rectangle",
        positionRec1, 30, 30, colorRec);
    assertEquals(-20, rectangle.getPosition().getX());
    assertEquals(-50, rectangle.getPosition().getY());
  }

  /**
   * Test big position.
   */
  @Test
  public void testLargerPosition() {
    Position positionRec1 = new Position(999999999, 888888888);
    rectangle = new Rectangle("Rec2", "rectangle", positionRec1,
        30, 30, new Color(2, 2, 1));
    assertEquals(999999999, rectangle.getPosition().getX());
    assertEquals(888888888, rectangle.getPosition().getY());
  }

  /**
   * Test zero position.
   */
  @Test
  public void testZeroPosition() {
    Position positionRec1 = new Position(0, 0);
    rectangle = new Rectangle("Rec2", "rectangle", positionRec1,
        30, 30, new Color(2, 2, 1));
    assertEquals(0, rectangle.getPosition().getX());
    assertEquals(0, rectangle.getPosition().getY());
  }

  /**
   * Test get color.
   */
  @Test
  public void testGetColor() {
    assertEquals(120, rectangle.getColor().getR());
    assertEquals(120, rectangle.getColor().getG());
    assertEquals(120, rectangle.getColor().getB());

    assertEquals(20, oval.getColor().getR());
    assertEquals(30, oval.getColor().getG());
    assertEquals(40, oval.getColor().getB());
  }

  /**
   * Test invalid color.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidColor() {
    IShape rec1 = new Rectangle("rec", "rectangle",
        new Position(20, 50), 30, 30,
        new Color(256, 256, 256));
  }

  /**
   * Test negative rbg color.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeRBGColor() {
    IShape rec1 = new Rectangle("rec", "rectangle",
        new Position(20, 50), 30, 30,
        new Color(-1, -2, -3));
  }

  /**
   * Test get size 1.
   */
  @Test
  public void testGetSize1() {
    assertEquals(30, rectangle.getSize1());
    assertEquals(100, oval.getSize1());
  }

  /**
   * Test get size 2.
   */
  @Test
  public void testGetSize2() {
    assertEquals(30, rectangle.getSize2());
    assertEquals(100, oval.getSize2());
  }

  /**
   * Test negative sizes.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeSizes() {
    IShape rectangle1 = new Rectangle("rec", "rectangle",
        new Position(20, 50), -30, 30,
        new Color(1, 2, 3));
  }

}