import Controller.Controller;
import model.Album;
import model.IAlbum;
import utility.FileParse;

import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * PhotoAlbumMain class.
 */
public class PhotoAlbumMain {
  /**
   * The entry point of application.
   *
   * @param args the input arguments
   * @throws IOException the io exception
   */
  public static void main(String[] args) throws IOException {
    int xMax = 1000;
    int yMax = 1000;

    String inputFile = "hoops.txt";
    String choiceOfView = "graphical";
    String outputFile = "buildingsOut.html";

    for (int i = 0; i < args.length; i++) {
      if (isInteger(args[i]) && xMax == 1000 && yMax == 1000) {
        xMax = Integer.parseInt(args[i]);
        yMax = Integer.parseInt(args[i + 1]);
      } else {
        switch (args[i].toLowerCase()) {
          case "-in" -> inputFile = args[i + 1];
          case "-view" -> choiceOfView = args[i + 1];
          case "-v", "-out" -> outputFile = args[i + 1];
          default -> {
          }
        }
      }
    }

    if (inputFile == null || choiceOfView == null) {
      throw new FileNotFoundException();
    }

    if (choiceOfView.equalsIgnoreCase("web") && (outputFile == null)) {
      System.exit(1);
    }

    IAlbum album = new Album();

    FileParse.read(inputFile, album);

    if (choiceOfView.equalsIgnoreCase("graphical")) {
      Controller controller = new Controller(album, xMax, yMax);
      controller.visible();
    } else {
      Controller controller = new Controller(album, outputFile, xMax, yMax);
      controller.goSVGView();
    }
  }

  /**
   * isInteger.
   *
   * @param string the string
   * @return the boolean
   */
  public static boolean isInteger(String string) {
    try {
      Integer.parseInt(string);
      return true;
    } catch (NumberFormatException nfe) {
      return false;
    }
  }

}
