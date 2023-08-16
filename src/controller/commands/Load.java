package controller.commands;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

import controller.ImageCommands;

import model.ImageInterfaceV2;
import view.InputCmd;

/**
 * This class represents the data and the associated functions required to invoke the load
 * functionality in model.
 */
public class Load implements ImageCommands {

  private final String[] arrOfStr;
  private final int[] properties = new int[2];

  /**
   * This constructor is used to declare and initialise Load class objects with the given values
   * as parameters.
   *
   * @param arrOfStr input parameters given to be given when calling model function.
   */
  public Load(String[] arrOfStr) {
    this.arrOfStr = arrOfStr;
  }


  private StringBuilder getFileData(Scanner sc) {
    StringBuilder builder = new StringBuilder();

    while (sc.hasNextLine()) {
      String s = sc.nextLine();

      if (s.charAt(0) != '#') {
        builder.append(s).append(System.lineSeparator());
      }
    }

    return builder;
  }

  private int[][][] ppmLoad(String imgPath) {

    Scanner sc = null;

    try {
      sc = new Scanner(new FileInputStream(imgPath));
    } catch (FileNotFoundException e) {
      //System.out.println("file " + imgPath + " not found.");
      return null;
    }


    sc = new Scanner(getFileData(sc).toString());

    String token = sc.next();

    if (!token.equals("P3")) {
      //System.out.println("Invalid PPM file: plain RAW file should begin with P3");
      return null;
    }

    int width = sc.nextInt();
    int height = sc.nextInt();
    int maxValue = sc.nextInt();
    int[][][] t1 = new int[3][height][width];
    properties[0] = width;
    properties[1] = height;


    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        t1[0][i][j] = r;
        t1[1][i][j] = g;
        t1[2][i][j] = b;
      }
    }

    return t1;
  }


  @Override
  public void cmdFunction(ImageInterfaceV2 iInt, InputCmd iIpt) throws IOException {
    if (arrOfStr.length != 3) {
      iIpt.invalidCmd();
    } else {
      int[][][] t;
      boolean result;
      if (arrOfStr[1].substring(arrOfStr[1].length() - 3).equals("ppm")) {
        t = ppmLoad(arrOfStr[1]);

        if (t == null) {
          iIpt.invalidCmd();
        } else {
          result = iInt.loadImage(t, properties[0], properties[1], arrOfStr[2]);
          iIpt.outputDisplay(result, "load");
        }

      } else {

        BufferedImage image = ImageIO.read(new File(arrOfStr[1]));
        int width = image.getWidth();
        int height = image.getHeight();
        int[][] res = new int[height][width];

        for (int row = 0; row < height; row++) {
          for (int col = 0; col < width; col++) {
            res[row][col] = image.getRGB(col, row);
          }
        }
        t = new int[3][height][width];


        for (int i = 0; i < height; i++) {
          for (int j = 0; j < width; j++) {
            int r = (res[i][j] & 0xff0000) >> 16;
            int g = (res[i][j] & 0xff00) >> 8;
            int b = res[i][j] & 0xff;
            t[0][i][j] = r;
            t[1][i][j] = g;
            t[2][i][j] = b;
          }
        }
        result = iInt.loadImage(t, width, height, arrOfStr[2]);
        iIpt.outputDisplay(result, "load");

      }
    }

  }


}
