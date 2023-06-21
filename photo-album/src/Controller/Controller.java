package Controller;

import model.IAlbum;
import view.GraphicalView;
import view.SVGView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Controller implements ActionListener.
 */
public class Controller implements ActionListener {
  private GraphicalView graphicalView;
  private SVGView svgView;
  private IAlbum album;

  /**
   * Controller constructor1.
   *
   * @param album the album
   * @param xMax  the x max
   * @param yMax  the y max
   */
  public Controller(IAlbum album, int xMax, int yMax) {
    this.album = album;
    this.graphicalView = new GraphicalView(this.album.getSnapshotsForView(),
        this.album.getSnapshotIds(), this.album.getDescription(), xMax, yMax);
    this.graphicalView.setActionListener(this);
  }

  /**
   * Controller constructor2.
   *
   * @param album    the album
   * @param fileName the file name
   * @param xMax     the x max
   * @param yMax     the y max
   */
  public Controller(IAlbum album, String fileName, int xMax, int yMax) {
    this.album = album;
    this.svgView = new SVGView(this.album.getSnapshotsForView(),
        this.album.getSnapshotIds(), this.album.getDescription(), fileName, xMax, yMax);
  }

  /**
   * Visible.
   *
   * @throws IOException the io exception
   */
  public void visible() throws IOException {
    this.graphicalView.setVisible(true);
  }

  /**
   * Go svg view.
   *
   * @throws IOException the io exception
   */
  public void goSVGView() throws IOException {
    this.svgView.outputFile();
  }

  /**
   * actionPerformed method.
   *
   * @param e the event to be processed
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "Prev" -> {
        if (this.graphicalView.getCurrentShot() == 0) {
          JOptionPane.showMessageDialog(this.graphicalView, "First snapshot.");
          break;
        }
        this.graphicalView.setCurrentShot(this.graphicalView.getCurrentShot() - 1);
        updateView();
      }
      case "Select" -> {
        String selection = (String) JOptionPane.showInputDialog(
            this.graphicalView, "Choose", "Menu", JOptionPane.QUESTION_MESSAGE,
            null, this.graphicalView.getSnapshotIds(), this.graphicalView.getSnapshotIds()[0]);
        if (selection != null) {
          int indexOfSnapshots = this.graphicalView.getIndexOfSnapshots(selection);
          this.graphicalView.setCurrentShot(indexOfSnapshots);
          updateView();
        }
      }
      case "Next" -> {
        if (this.graphicalView.getCurrentShot() == this.album.getSnapshotIds().size() - 1) {
          JOptionPane.showMessageDialog(this.graphicalView, "End of the photo album, no snapshot.");
          break;
        }
        this.graphicalView.setCurrentShot(this.graphicalView.getCurrentShot() + 1);
        updateView();
      }
      case "Quit" -> System.exit(0);
      default -> {
      }
    }

  }

  /**
   * update view.
   */
  private void updateView() {
    this.graphicalView.removeNorth();
    this.graphicalView.removeCenter();
    this.graphicalView.updateNorth();
    this.graphicalView.updateCenter();
  }
}
