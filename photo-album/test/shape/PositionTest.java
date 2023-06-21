package shape;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test for Position class.
 */
public class PositionTest {
  IShape oval1;

  /**
   * set up test objects.
   */
  @Before
  public void setUp() {
    oval1 = new Oval("oval1", "oval", new Position(2, 3),
        5, 3, new Color(0, 0, 0));
  }

  /**
   * test get x.
   */
  @Test
  public void testGetX() {
    assertEquals(2.0, oval1.getPosition().getX());
  }

  /**
   * test get y.
   */
  @Test
  public void testGetY() {
    assertEquals(3.0, oval1.getPosition().getY());
  }

  /**
   * test toString.
   */
  @Test
  public void testToString() {
    assertEquals("(2,3)", this.oval1.getPosition().toString());
  }
}