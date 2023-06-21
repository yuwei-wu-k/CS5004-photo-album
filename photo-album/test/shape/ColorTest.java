package shape;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test for Color class.
 */
public class ColorTest {

  Color color1;
  Color color8;
  private static final double DELTA = 0.001;

  /**
   * set up test objects.
   */
  @Before
  public void setUp() {
    this.color1 = new Color(10, 100, 200);
    this.color8 = new Color(1, 1, 1);
  }

  /**
   * Test bad color 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBadColor1() {
    new Color(-1, 100, 200);
  }

  /**
   * Test bad color 2.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBadColor2() {
    new Color(300, 100, 200);
  }

  /**
   * Test bad color 3.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBadColor3() {
    new Color(10, -10, 200);
  }

  /**
   * Test bad color 4.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBadColor4() {
    new Color(10, 500, 200);
  }

  /**
   * Test bad color 5.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBadColor5() {
    new Color(10, 100, -10);
  }

  /**
   * Test bad color 6.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBadColor6() {
    new Color(10, 100, 500);
  }

  /**
   * Test valid color.
   */
  @Test
  public void testGoodColor() {
    this.color8 = new Color(1, 1, 1);
  }

  /**
   * test getR.
   */
  @Test
  public void testGetR() {
    assertEquals(10, color1.getR(), DELTA);
  }

  /**
   * test getG.
   */
  @Test
  public void testGetG() {
    assertEquals(100, color1.getG(), DELTA);
  }

  /**
   * test getB.
   */
  @Test
  public void testGetB() {
    assertEquals(200, color1.getB(), DELTA);
  }

  /**
   * test toString.
   */
  @Test
  public void testToString() {
    assertEquals("(10.0, 100.0, 200.0)", this.color1.toString());
    assertEquals("(1.0, 1.0, 1.0)", this.color8.toString());
  }
}