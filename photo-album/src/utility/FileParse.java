package utility;

import model.IAlbum;
import shape.Color;
import shape.Position;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * FileParse class.
 */
public class FileParse {
  /**
   * read file.
   *
   * @param fileName the file name
   * @param album    the album
   * @throws FileNotFoundException the file not found exception
   */
  public static void read(String fileName, IAlbum album) throws FileNotFoundException {
    java.io.File file = new java.io.File(fileName);

    Scanner input = new Scanner(file);

    while (input.hasNext()) {
      String command = input.next().toLowerCase();
      switch (command) {
        case "#" -> input.nextLine();
        case "shape" -> {
          String id = input.next();
          String type = input.next();
          int x = Integer.parseInt(input.next());
          int y = Integer.parseInt(input.next());
          int width = Integer.parseInt(input.next());
          int height = Integer.parseInt(input.next());
          int r = Integer.parseInt(input.next());
          int g = Integer.parseInt(input.next());
          int b = Integer.parseInt(input.next());
          if (type.equalsIgnoreCase("rectangle")) {
            album.addShape(album.createShape(id, new Position(x, y),
                new Color(r, g, b), width, height, "rectangle"));
          } else {
            album.addShape(album.createShape(id, new Position(x, y),
                new Color(r, g, b), width, height, "oval"));
          }
        }
        case "move" -> {
          String idMove = input.next();
          int xMove = Integer.parseInt(input.next());
          int yMove = Integer.parseInt(input.next());
          album.changePosition(idMove, new Position(xMove, yMove));
        }
        case "color" -> {
          String idColor = input.next();
          int rColor = Integer.parseInt(input.next());
          int gColor = Integer.parseInt(input.next());
          int bColor = Integer.parseInt(input.next());
          album.changeColor(idColor, new Color(rColor, gColor, bColor));
        }
        case "resize" -> {
          String idSize = input.next();
          int widthSize = Integer.parseInt(input.next());
          int heightSize = Integer.parseInt(input.next());
          album.changeSize(idSize, widthSize, heightSize);
        }
        case "remove" -> {
          String idRemove = input.next();
          album.deleteShape(idRemove);
        }
        case "snapshot" -> {
          String description = input.nextLine().trim();
          album.addSnapShot(description);
        }
        default -> {
        }
      }
    }

    input.close();
  }
}
