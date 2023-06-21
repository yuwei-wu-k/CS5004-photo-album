package model;

import org.junit.Before;
import org.junit.Test;
import shape.Color;
import shape.IShape;
import shape.Position;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test for IAlbum.
 */
public class IAlbumTest {
  IAlbum album;
  IShape rectangle;
  IShape rectangle1;
  IShape oval;

  /**
   * set up test object.
   */
  @Before
  public void setUp() {
    album = new Album();
    rectangle = album.createShape("rectangle", new Position(50, 50),
        new Color(10, 10, 15), 200, 50, "rectangle");
    oval = album.createShape("oval", new Position(30, 30),
        new Color(2, 2, 2), 40, 60, "oval");
    album.addShape(rectangle);
    album.addShape(oval);
  }

  /**
   * Test create shape.
   */
  @Test
  public void testCreateShape() {
    IShape shape = album.createShape("rectangle", new Position(30, 30),
        new Color(2, 2, 2), 3, 3, "rectangle");
    assertEquals("rectangle", shape.getType());
  }

  /**
   * Test add shape.
   */
  @Test
  public void testAddShape() {
    assertEquals("Current Shapes\n" +
        "ID: rectangle\n" +
        "Type: RECTANGLE\n" +
        "Position: (50.0,50.0)\n" +
        "Color: (10.0, 10.0, 15.0)\n" +
        "Width: 200.0\n" +
        "Height: 50.0\n" +
        "ID: oval\n" +
        "Type: OVAL\n" +
        "Position: (30.0,30.0)\n" +
        "Color: (2.0, 2.0, 2.0)\n" +
        "X radius: 40.0\n" +
        "Y radius: 60.0\n", album.printShapes());
  }

  /**
   * Test add two shapes with same id.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddTwoShapesWithSameId() {
    rectangle1 = album.createShape("rectangle1", new Position(150, 150),
        new Color(120, 120, 125), 30, 50, "rectangle");
    album.addShape(rectangle);
    album.addShape(rectangle1);
  }

  /**
   * Test delete shape.
   */
  @Test
  public void testDeleteShape() {
    assertEquals("Current Shapes\n" +
        "ID: rectangle\n" +
        "Type: RECTANGLE\n" +
        "Position: (50.0,50.0)\n" +
        "Color: (10.0, 10.0, 15.0)\n" +
        "Width: 200.0\n" +
        "Height: 50.0\n" +
        "ID: oval\n" +
        "Type: OVAL\n" +
        "Position: (30.0,30.0)\n" +
        "Color: (2.0, 2.0, 2.0)\n" +
        "X radius: 40.0\n" +
        "Y radius: 60.0\n", album.printShapes());
    album.deleteShape("rectangle");

    assertEquals("Current Shapes\n" +
        "ID: oval\n" +
        "Type: OVAL\n" +
        "Position: (30.0,30.0)\n" +
        "Color: (2.0, 2.0, 2.0)\n" +
        "X radius: 40.0\n" +
        "Y radius: 60.0\n", album.printShapes());
  }

  /**
   * Test delete shape not existed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDeleteShapeNotExisted() {
    album.addShape(rectangle);
    album.addShape(oval);
    album.deleteShape("circle");
  }

  /**
   * Test change color.
   */
  @Test
  public void testChangeColor() {
    assertEquals("Current Shapes\n" +
        "ID: rectangle\n" +
        "Type: RECTANGLE\n" +
        "Position: (50.0,50.0)\n" +
        "Color: (10.0, 10.0, 15.0)\n" +
        "Width: 200.0\n" +
        "Height: 50.0\n" +
        "ID: oval\n" +
        "Type: OVAL\n" +
        "Position: (30.0,30.0)\n" +
        "Color: (2.0, 2.0, 2.0)\n" +
        "X radius: 40.0\n" +
        "Y radius: 60.0\n", album.printShapes());

    album.changeColor("rectangle", new Color(0, 0, 0));
    assertEquals("Current Shapes\n" +
        "ID: rectangle\n" +
        "Type: RECTANGLE\n" +
        "Position: (50.0,50.0)\n" +
        "Color: (0.0, 0.0, 0.0)\n" +
        "Width: 200.0\n" +
        "Height: 50.0\n" +
        "ID: oval\n" +
        "Type: OVAL\n" +
        "Position: (30.0,30.0)\n" +
        "Color: (2.0, 2.0, 2.0)\n" +
        "X radius: 40.0\n" +
        "Y radius: 60.0\n", album.printShapes());
  }

  /**
   * Test change color of shape not existed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorOfShapeNotExisted() {
    album.addShape(rectangle);
    album.addShape(oval);
    album.changeColor("circle", new Color(0, 0, 0));
  }

  /**
   * Test change size.
   */
  @Test
  public void testChangeSize() {
    assertEquals("Current Shapes\n" +
        "ID: rectangle\n" +
        "Type: RECTANGLE\n" +
        "Position: (50.0,50.0)\n" +
        "Color: (10.0, 10.0, 15.0)\n" +
        "Width: 200.0\n" +
        "Height: 50.0\n" +
        "ID: oval\n" +
        "Type: OVAL\n" +
        "Position: (30.0,30.0)\n" +
        "Color: (2.0, 2.0, 2.0)\n" +
        "X radius: 40.0\n" +
        "Y radius: 60.0\n", album.printShapes());

    album.changeSize("rectangle", 0, 0);
    assertEquals("Current Shapes\n" +
        "ID: rectangle\n" +
        "Type: RECTANGLE\n" +
        "Position: (50.0,50.0)\n" +
        "Color: (10.0, 10.0, 15.0)\n" +
        "Width: 0.0\n" +
        "Height: 0.0\n" +
        "ID: oval\n" +
        "Type: OVAL\n" +
        "Position: (30.0,30.0)\n" +
        "Color: (2.0, 2.0, 2.0)\n" +
        "X radius: 40.0\n" +
        "Y radius: 60.0\n", album.printShapes());
  }

  /**
   * Test change size of shape not existed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangeSizeOfShapeNotExisted() {
    album.addShape(rectangle);
    album.addShape(oval);
    album.changeSize("circle", 40, 60);
  }

  /**
   * Test change position.
   */
  @Test
  public void testChangePosition() {
    assertEquals("Current Shapes\n" +
        "ID: rectangle\n" +
        "Type: RECTANGLE\n" +
        "Position: (50.0,50.0)\n" +
        "Color: (10.0, 10.0, 15.0)\n" +
        "Width: 200.0\n" +
        "Height: 50.0\n" +
        "ID: oval\n" +
        "Type: OVAL\n" +
        "Position: (30.0,30.0)\n" +
        "Color: (2.0, 2.0, 2.0)\n" +
        "X radius: 40.0\n" +
        "Y radius: 60.0\n", album.printShapes());
    album.changePosition("rectangle", new Position(0, 0));

    assertEquals("Current Shapes\n" +
        "ID: rectangle\n" +
        "Type: RECTANGLE\n" +
        "Position: (0.0,0.0)\n" +
        "Color: (10.0, 10.0, 15.0)\n" +
        "Width: 200.0\n" +
        "Height: 50.0\n" +
        "ID: oval\n" +
        "Type: OVAL\n" +
        "Position: (30.0,30.0)\n" +
        "Color: (2.0, 2.0, 2.0)\n" +
        "X radius: 40.0\n" +
        "Y radius: 60.0\n", album.printShapes());
  }

  /**
   * Test change position of shape not existed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangePositionOfShapeNotExisted() {
    album.addShape(rectangle);
    album.addShape(oval);
    album.changePosition("circle", new Position(20, 34));
  }

  /**
   * Test add snapshot.
   */
  @Test
  public void testAddSnapShot() {
    album.addSnapShot("a");
    List<String> snapshotIds = album.getSnapshotIds();
    List<String> timeStamps = album.getTimeStamp();
    assertEquals("Printing Snapshots\n" +
        "Snapshot ID: " + snapshotIds.get(0) + "\n" +
        "Timestamp: " + timeStamps.get(0) + "\n" +
        "Description: a\n" +
        "Shape Information:\n" +
        "Name: rectangle\n" +
        "Type: rectangle\n" +
        "Min corner: (50.0,50.0), Width: 200.0, Height: 50.0, Color: (10.0,10.0,15.0)\n" +
        "\n" +
        "Name: oval\n" +
        "Type: oval\n" +
        "Center: (30.0,30.0), X radius: 40.0, Y radius: 60.0, Color: (2.0,2.0,2.0)\n" +
        "\n", album.printSnapshots());
  }

  /**
   * Test print snapshots.
   */
  @Test
  public void testPrintSnapshots() {
    album.addSnapShot("a");
    List<String> snapshotIds = album.getSnapshotIds();
    List<String> timeStamps = album.getTimeStamp();
    assertEquals("Printing Snapshots\n" +
        "Snapshot ID: " + snapshotIds.get(0) + "\n" +
        "Timestamp: " + timeStamps.get(0) + "\n" +
        "Description: a\n" +
        "Shape Information:\n" +
        "Name: rectangle\n" +
        "Type: rectangle\n" +
        "Min corner: (50.0,50.0), Width: 200.0, Height: 50.0, Color: (10.0,10.0,15.0)\n" +
        "\n" +
        "Name: oval\n" +
        "Type: oval\n" +
        "Center: (30.0,30.0), X radius: 40.0, Y radius: 60.0, Color: (2.0,2.0,2.0)\n" +
        "\n", album.printSnapshots());
  }

  /**
   * Test reset snapshots.
   */
  @Test
  public void testResetSnapshots() {
    album.addSnapShot("a");
    List<String> snapshotIds = album.getSnapshotIds();
    List<String> timeStamps = album.getTimeStamp();
    assertEquals("Printing Snapshots\n" +
        "Snapshot ID: " + snapshotIds.get(0) + "\n" +
        "Timestamp: " + timeStamps.get(0) + "\n" +
        "Description: a\n" +
        "Shape Information:\n" +
        "Name: rectangle\n" +
        "Type: rectangle\n" +
        "Min corner: (50.0,50.0), Width: 200.0, Height: 50.0, Color: (10.0,10.0,15.0)\n" +
        "\n" +
        "Name: oval\n" +
        "Type: oval\n" +
        "Center: (30.0,30.0), X radius: 40.0, Y radius: 60.0, Color: (2.0,2.0,2.0)\n" +
        "\n", album.printSnapshots());
    album.resetSnapshots();
    assertEquals("Printing Snapshots\n", album.printSnapshots());
  }
}