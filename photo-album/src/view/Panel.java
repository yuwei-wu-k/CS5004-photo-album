package view;

import shape.IShape;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Panel class.
 */
public class Panel extends JPanel {
  private List<IShape> shapes;

  /**
   * panel constructor.
   *
   * @param shapes the shapes
   */
  public Panel(List<IShape> shapes) {
    this.shapes = shapes;
  }

  /**
   * paintComponent.
   *
   * @param g the <code>Graphics</code> object to protect
   */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    setBackground(Color.white);

    for (IShape shape : this.shapes) {
      if (shape.getType().equalsIgnoreCase("rectangle")) {
        g.setColor(new Color(shape.getColor().getR(), shape.getColor().getG(), shape.getColor().getB()));
        g.fillRect(shape.getPosition().getX(), shape.getPosition().getY(), shape.getSize1(), shape.getSize2());
      }
      if (shape.getType().equalsIgnoreCase("oval")) {
        g.setColor(new Color(shape.getColor().getR(), shape.getColor().getG(), shape.getColor().getB()));
        g.fillOval(shape.getPosition().getX(), shape.getPosition().getY(), shape.getSize1(), shape.getSize2());
      }
    }
  }
}
