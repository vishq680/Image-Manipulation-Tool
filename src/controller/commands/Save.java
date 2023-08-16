package controller.commands;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import controller.ImageCommands;
import model.ImageInterfaceV2;
import view.InputCmd;

/**
 * This class represents the data and the associated functions required to invoke the save
 * functionality in model.
 */
public class Save implements ImageCommands {


  private boolean result = true;
  private final String[] arrOfStr;
  int[][][] t;

  /**
   * This constructor is used to declare and initialise save class objects with the given
   * values as parameters.
   *
   * @param arrOfStr input parameters given to be given when calling model function.
   */
  public Save(String[] arrOfStr) {
    this.arrOfStr = arrOfStr;
  }


  @Override
  public void cmdFunction(ImageInterfaceV2 iInt, InputCmd iIpt) throws IOException {

    if (arrOfStr.length != 3) {
      iIpt.invalidCmd();
    } else {

      try {
        t = iInt.saveImage(arrOfStr[2]);
      } catch (Exception e) {
        iIpt.invalidCmd();
        return;
      }
      t = iInt.saveImage(arrOfStr[2]);
      int height = t[0].length;
      int width = t[0][0].length;
      int max_val = 0;
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          int r = t[0][i][j];
          int g = t[1][i][j];
          int b = t[2][i][j];
          if (max_val < r) {
            max_val = r;
          }
          if (max_val < g) {
            max_val = g;
          }
          if (max_val < b) {
            max_val = b;
          }
        }
      }

      if (arrOfStr[1].substring(arrOfStr[1].length() - 3).equals("ppm")) {
        File output = new File(arrOfStr[1]);
        try (FileOutputStream out = new FileOutputStream(output)) {

          StringBuilder builder = new StringBuilder();
          int[][][] pixels = t;
          builder.append("P3").append(System.lineSeparator());
          builder.append("#").append(System.lineSeparator());
          builder.append(width).append(" ").append(height)
                  .append(System.lineSeparator());
          builder.append(max_val).append(System.lineSeparator());

          for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
              for (int k = 0; k < 3; k++) {
                builder.append(pixels[k][i][j]).append(System.lineSeparator());
              }
            }
          }

          out.write(builder.toString().getBytes());
        } catch (Exception e) {
          result = false;
          iIpt.outputDisplay(result, "save");
          return;
        }


      } else {
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        int[][] rgb = new int[height][width];
        int rgb1;
        for (int i = 0; i < height; i++) {
          for (int j = 0; j < width; j++) {
            int r = t[0][i][j];
            int g = t[1][i][j];
            int b = t[2][i][j];

            int value = (r << 16) | (g << 8) | b;
            image.setRGB(j, i, value);

          }
        }

        File output = new File(arrOfStr[1]);
        String type = arrOfStr[1].substring(arrOfStr[1].length() - 3);
        if (type.equals("peg")) {
          type = arrOfStr[1].substring(arrOfStr[1].length() - 4);
        }
        try {
          ImageIO.write(image, type, output);

        } catch (Exception e) {
          iIpt.invalidCmd();
        }
      }
    }
    iIpt.outputDisplay(result, "save");


  }
}
