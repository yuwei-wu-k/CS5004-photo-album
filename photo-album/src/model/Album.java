package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import shape.Color;
import shape.IShape;
import shape.Oval;
import shape.Position;
import shape.Rectangle;

/**
 * Album class implements IAlbum interface.
 */
public class Album implements IAlbum {
  private List<IShape> shapeList;//arraylist store shapes
  private List<String> snapshotIds;
  private List<String> timeStamp;
  private List<String> description;
  private HashMap<String, Integer> shapeIds;
  private HashMap<String, String> snapshots;
  private HashMap<String, List<IShape>> snapshotsForView;
  private static final int START = 0;
  private static final int OFFSET = 1;

  /**
   * Instantiates a new Model.
   */
  public Album() {
    this.shapeList = new ArrayList<>();
    this.snapshotIds = new ArrayList<>();
    this.timeStamp = new ArrayList<>();
    this.description = new ArrayList<>();
    this.shapeIds = new HashMap<>();
    this.snapshots = new HashMap<>();
    this.snapshotsForView = new HashMap<>();
  }

  /**
   * create shape.
   *
   * @param id       the id
   * @param position the position
   * @param color    the color
   * @param size1    the size 1
   * @param size2    the size 2
   * @param type     the type
   * @return IShape object
   */
  @Override
  public IShape createShape(String id, Position position,
                            Color color, int size1, int size2, String type) {
    if(type.equalsIgnoreCase("rectangle")) {
      return new Rectangle(id, type, position, size1, size2, color);
    }
    if(type.equalsIgnoreCase("oval")) {
      return new Oval(id, type, position, size1, size2, color);
    }
    return null;
  }

  /**
   * add shape.
   *
   * @param shape the shape
   * @throws IllegalArgumentException if the id already exists.
   */
  @Override
  public void addShape(IShape shape) throws IllegalArgumentException {
    if (shapeIds.containsKey(shape.getId())) {
      throw new IllegalArgumentException("Duplicate id.");
    }
    this.shapeList.add(shape);
    this.shapeIds.put(shape.getId(), shapeList.indexOf(shape));
  }

  /**
   * delete shape.
   *
   * @param id the id
   * @throws IllegalArgumentException if id is not valid
   */
  @Override
  public void deleteShape(String id) throws IllegalArgumentException {
    if (!shapeIds.containsKey(id)) {
      throw new IllegalArgumentException("Invalid id.");
    }
    this.shapeList.remove((int) this.shapeIds.get(id));
    this.shapeIds.remove(id);
    for (IShape shape : this.shapeList) {
      this.shapeIds.replace(shape.getId(), this.shapeList.indexOf(shape));
    }
  }

  /**
   * reset snapshot.
   */
  @Override
  public void resetSnapshots() {
    System.out.println("List of snapshots already taken reset: "
        + this.snapshotIds.toString());
    this.snapshotIds.clear();
    this.snapshots.clear();
  }

  /**
   * check if the shape exists.
   *
   * @param id the shape name
   * @throws IllegalArgumentException if shape doesn't exist
   */
  private void checkShapeExist(String id) throws IllegalArgumentException {
    if (!shapeIds.containsKey(id)) {
      throw new IllegalArgumentException("This shape does not exist.");
    }
  }

  /**
   * change color.
   *
   * @param id       the id
   * @param newColor the new color
   * @throws IllegalArgumentException if the shape doesn't exit
   */
  @Override
  public void changeColor(String id, Color newColor) throws IllegalArgumentException {
    checkShapeExist(id);
    this.shapeList.get(this.shapeIds.get(id)).setColor(newColor);
  }

  /**
   * change size.
   *
   * @param id    the id
   * @param size1 the size 1
   * @param size2 the size 2
   * @throws IllegalArgumentException if the shape doesn't exist.
   */
  @Override
  public void changeSize(String id, int size1, int size2) throws IllegalArgumentException {
    checkShapeExist(id);
    this.shapeList.get(this.shapeIds.get(id)).setSize(size1, size2);
  }

  /**
   * change position.
   *
   * @param id          the id
   * @param newPosition the new position
   * @throws IllegalArgumentException if the shape doesn't exist.
   */
  @Override
  public void changePosition(String id, Position newPosition) throws IllegalArgumentException {
    checkShapeExist(id);
    this.shapeList.get(this.shapeIds.get(id)).setPosition(newPosition);
  }

  /**
   * add snapshot.
   *
   * @param description description
   */
  @Override
  public void addSnapShot(String description) {
    StringBuilder snapshot = new StringBuilder("Snapshot ID: ");
    String snapshotId = LocalDateTime.now().toString();
    snapshot.append(snapshotId).append("\n").append("Timestamp: ");
    String timeStamp = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        .format(LocalDateTime.now());
    snapshot.append(timeStamp).append("\n").append("Description: ")
        .append(description).append("\n").append("Shape Information:");

    for (IShape shape : this.shapeList) {
      snapshot.append("\n" + "Name: ").append(shape.getId())
          .append("\n").append("Type: ").append(shape.getType()).append("\n");
      switch (shape.getType().toLowerCase()) {
        case "rectangle":
          snapshot.append("Min corner: (").append(shape.getPosition().getX()).append(",")
              .append(shape.getPosition().getY()).append("), Width: ")
              .append(shape.getSize1()).append(", Height: ")
              .append(shape.getSize2()).append(", Color: (")
              .append(shape.getColor().getR()).append(",")
              .append(shape.getColor().getG()).append(",")
              .append(shape.getColor().getB()).append(")").append("\n");
          break;
        case "oval":
          snapshot.append("Center: (").append(shape.getPosition().getX())
              .append(",").append(shape.getPosition().getY()).append("), X radius: ")
              .append(shape.getSize1()).append(", Y radius: ")
              .append(shape.getSize2()).append(", Color: (")
              .append(shape.getColor().getR()).append(",")
              .append(shape.getColor().getG()).append(",").
              append(shape.getColor().getB()).append(")").append("\n");
          break;
        default:
      }
    }

    this.snapshotIds.add(snapshotId);
    this.timeStamp.add(timeStamp);
    this.description.add(description);
    ArrayList<IShape> clonedList = new ArrayList<>();
    for (IShape shape : this.shapeList) {
      clonedList.add(shape.clone());
    }
    this.snapshotsForView.put(snapshotId, clonedList);

    this.snapshots.put(snapshotId, snapshot.substring(START, snapshot.length() - OFFSET));
  }

  /**
   * print shapes string.
   *
   * @return the string
   */
  @Override
  public String printShapes() {
    StringBuilder shapesString = new StringBuilder("Current Shapes\n");
    for (IShape shape : this.shapeList) {
      shapesString.append(shape.toString());
    }
    return shapesString.toString();
  }

  /**
   * print snapshots.
   *
   * @return the string
   */
  @Override
  public String printSnapshots() {
    StringBuilder snapshots = new StringBuilder("Printing Snapshots\n");
    for (String snapshotId : this.snapshotIds) {
      snapshots.append(this.snapshots.get(snapshotId)).append("\n\n");
    }
    return snapshots.toString();
  }

  /**
   * get timestamp.
   *
   * @return the time stamp
   */
  @Override
  public List<String> getTimeStamp() {
    return this.timeStamp;
  }

  /**
   * get snapshot ids.
   *
   * @return the snapshot ids
   */
  @Override
  public List<String> getSnapshotIds() {
    return this.snapshotIds;
  }

  /**
   * Gets snapshots.
   *
   * @return the snapshots
   */
  @Override
  public HashMap<String, List<IShape>> getSnapshotsForView() {
    return this.snapshotsForView;
  }

  /**
   * get description.
   *
   * @return the description
   */
  @Override
  public List<String> getDescription() {
    return this.description;
  }
}
