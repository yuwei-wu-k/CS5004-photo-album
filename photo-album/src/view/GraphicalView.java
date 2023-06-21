package view;

import shape.IShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

/**
 * graphicalView class extends JFrame.
 */
public class GraphicalView extends JFrame {
  private HashMap<String, List<IShape>> snapshots;
  private List<String> snapshotIds;
  private List<String> description;
  private JButton prev;
  private JButton select;
  private JButton next;
  private JButton quit;
  private JPanel north;
  private JPanel south;
  private JPanel center;
  private int width;
  private int height;
  private int currentShot;
  private static final String PREV_BTN_LABEL = "<< Prev <<";
  private static final String SELECT_BTN_LABEL = "^^ Select ^^";
  private static final String NEXT_BTN_LABEL = ">> Next >>";
  private static final String QUIT_BTN_LABEL = "xx Quit xx";

  /**
   * graphicalView constructor.
   *
   * @param snapshots   the snapshots
   * @param snapshotIds the snapshot ids
   * @param description the description
   * @param xMax        the x max
   * @param yMax        the y max
   */
  public GraphicalView(HashMap<String, List<IShape>> snapshots, List<String> snapshotIds,
                       List<String> description, int xMax, int yMax) {
    this.snapshotIds = snapshotIds;
    this.snapshots = snapshots;
    this.description = description;
    this.currentShot = 0;
    this.width = xMax;
    this.height = yMax;

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(width, height);
    this.setTitle("cs5004 Shapes Photo Album Viewer");
    this.setLayout(new BorderLayout());

    this.north = new JPanel();
    this.add(north, BorderLayout.NORTH);
    this.drawNorth(north);

    this.south = new JPanel();
    this.add(south, BorderLayout.SOUTH);
    this.drawSouth(south);

    this.center = new Panel(this.snapshots.get((this.snapshotIds.get(this.currentShot))));
    this.add(center, BorderLayout.CENTER);
  }

  /**
   * draw north panel.
   *
   * @param north the north
   */
  public void drawNorth(JPanel north) {
    north.setPreferredSize(new Dimension(0, 40));
    north.setBackground(Color.ORANGE);
    north.add(new JLabel(this.snapshotIds.get(currentShot)));
    north.add(new JLabel(this.description.get(currentShot)));
  }

  /**
   * draw south panel.
   *
   * @param south the south
   */
  private void drawSouth(JPanel south) {
    south.setPreferredSize(new Dimension(0, 40));
    south.setBackground(Color.orange);

    prev = new JButton(PREV_BTN_LABEL);
    prev.setActionCommand("Prev");
    south.add(prev);

    select = new JButton(SELECT_BTN_LABEL);
    select.setActionCommand("Select");
    south.add(select);

    next = new JButton(NEXT_BTN_LABEL);
    next.setActionCommand("Next");
    south.add(next);

    quit = new JButton(QUIT_BTN_LABEL);
    quit.setActionCommand("Quit");
    south.add(quit);
  }

  /**
   * update north panel.
   */
  public void updateNorth() {
    this.north = new JPanel();
    this.north.setPreferredSize(new Dimension(0, 40));
    this.north.setBackground(Color.pink);
    this.north.add(new JLabel(this.snapshotIds.get(currentShot)));
    this.north.add(new JLabel(this.description.get(currentShot)));
    this.add(north, BorderLayout.NORTH);
  }

  /**
   * remove north panel.
   */
  public void removeNorth() {
    this.north.validate();
  }

  /**
   * update center panel.
   */
  public void updateCenter() {
    this.center = new Panel(this.snapshots.
        get(this.snapshotIds.get((this.currentShot))));
    this.add(center, BorderLayout.CENTER);
  }

  /**
   * remove center panel.
   */
  public void removeCenter() {
    this.center.revalidate();
  }

  /**
   * sets current shot.
   *
   * @param currentShot the current shot
   */
  public void setCurrentShot(int currentShot) {
    this.currentShot = currentShot;
  }

  /**
   * gets current shot.
   *
   * @return the current shot
   */
  public int getCurrentShot() {
    return this.currentShot;
  }

  /**
   * gets index of snapshots.
   *
   * @param id the id
   * @return the index of snapshots
   */
  public int getIndexOfSnapshots(String id) {
    return this.snapshotIds.indexOf(id);
  }

  /**
   * get snapshot ids object.
   *
   * @return the object
   */
  public Object[] getSnapshotIds() {
    return this.snapshotIds.toArray();
  }

  /**
   * sets action listener.
   *
   * @param listener the listener
   */
  public void setActionListener(ActionListener listener) {
    this.prev.addActionListener(listener);
    this.select.addActionListener(listener);
    this.next.addActionListener(listener);
    this.quit.addActionListener(listener);
  }
}