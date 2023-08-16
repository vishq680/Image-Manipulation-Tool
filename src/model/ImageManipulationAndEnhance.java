package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents all the data and functions that are reuired to perform all the
 * operations on a given image.
 */
public class ImageManipulationAndEnhance implements ImageInterface {

  protected Dictionary<String, Image> images;

  /**
   * This function is a constructor that is used to declare and initialise this class objects with
   * the given values.
   */
  public ImageManipulationAndEnhance() {
    images = new Hashtable<>();
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

  @Override
  public boolean loadImage(int[][][] pixels, int width, int height, String imgName) {


    try {
      images.put(imgName, new Image(pixels, width, height, imgName));

    } catch (Exception ex) {
      return false;
    }

    return true;
  }

  @Override
  public int[][][] saveImage(String imgName) {

    try {
      return images.get(imgName).getPixels();
    } catch (Exception e) {
      throw new IllegalArgumentException(e);
    }


  }

  @Override
  public boolean greyScaleRed(String imgName, String destImgName) {

    try {
      GreyScaleInterface red = new RedGreyScale(images, imgName, destImgName);
      red.greyScale();
    } catch (Exception e) {
      return false;
    }

    return true;
  }

  @Override
  public boolean greyScaleGreen(String imgName, String destImgName) {

    try {
      GreyScaleInterface green = new GreenGreyScale(images, imgName, destImgName);
      green.greyScale();
    } catch (Exception e) {
      return false;
    }

    return true;

  }

  @Override
  public boolean greyScaleBlue(String imgName, String destImgName) {

    try {
      GreyScaleInterface blue = new BlueGreyScale(images, imgName, destImgName);
      blue.greyScale();
    } catch (Exception e) {
      return false;
    }
    return true;

  }


  @Override
  public boolean greyScaleValue(String imgName, String destImgName) {

    try {
      GreyScaleInterface value = new ValueGreyScale(images, imgName, destImgName);
      value.greyScale();
    } catch (Exception e) {
      return false;
    }
    return true;

  }


  @Override
  public boolean greyScaleLuma(String imgName, String destImgName) {

    try {
      GreyScaleInterface luma = new LumaGreyScale(images, imgName, destImgName);
      luma.greyScale();
    } catch (Exception e) {
      return false;
    }
    return true;

  }

  @Override
  public boolean greyScaleIntensity(String imgName, String destImgName) {

    try {
      GreyScaleInterface intensity = new IntensityGreyScale(images, imgName, destImgName);
      intensity.greyScale();
    } catch (Exception e) {
      return false;
    }
    return true;

  }

  @Override
  public boolean horizontalFlip(String imgName, String destImgName) {

    try {
      FlipInterface hozFlip = new HorizontalFlip(images, imgName, destImgName);
      hozFlip.flip();
    } catch (Exception e) {
      return false;
    }
    return true;

  }

  @Override
  public boolean verticalFlip(String imgName, String destImgName) {
    try {
      FlipInterface vertFlip = new VerticalFlip(images, imgName, destImgName);
      vertFlip.flip();
    } catch (Exception e) {
      return false;
    }
    return true;


  }

  @Override
  public boolean brightenImage(int increment, String imgName, String destImgName) {

    try {
      Image img = images.get(imgName);
      int[][][] pixels = img.getPixels();
      int[][][] brightenedPixels = new int[3][img.getHeight()][img.getWidth()];

      for (int i = 0; i < img.getHeight(); i++) {
        for (int j = 0; j < img.getWidth(); j++) {
          for (int k = 0; k < 3; k++) {
            if (pixels[k][i][j] + increment > 255) {
              brightenedPixels[k][i][j] = 255;
            } else if (pixels[k][i][j] + increment < 0) {
              brightenedPixels[k][i][j] = 0;
            } else {
              brightenedPixels[k][i][j] = pixels[k][i][j] + increment;
            }
          }
        }
      }


      images.put(destImgName, new Image(brightenedPixels, img.getWidth(), img.getHeight(),
              destImgName));
    } catch (Exception e) {

      return false;
    }

    return true;


  }

  @Override
  public boolean rgbSplit(String imgName, String destImgNameRed, String destImgNameGreen,
                          String destImgNameBlue) {

    try {
      greyScaleRed(imgName, destImgNameRed);
      greyScaleGreen(imgName, destImgNameGreen);
      greyScaleBlue(imgName, destImgNameBlue);
    } catch (Exception e) {
      return false;
    }
    return true;

  }

  private int getMax(int a, int b, int c) {
    List<Integer> t = new ArrayList<>();
    t.add(a);
    t.add(b);
    t.add(c);
    return Collections.max(t);
  }

  @Override
  public boolean rgbCombine(String imgName, String imgNameRed, String imgNameGreen,
                            String imgNameBlue) {

    try {
      int height = images.get(imgNameRed).getHeight();
      int width = images.get(imgNameRed).getWidth();
      int[][][] redPixels = images.get(imgNameRed).getPixels();
      int[][][] bluePixels = images.get(imgNameBlue).getPixels();
      int[][][] greenPixels = images.get(imgNameGreen).getPixels();
      int[][][] combinedPixels = new int[3][height][width];

      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          combinedPixels[0][i][j] = redPixels[0][i][j];
          combinedPixels[1][i][j] = greenPixels[1][i][j];
          combinedPixels[2][i][j] = bluePixels[2][i][j];
        }
      }
      images.put(imgName, new Image(combinedPixels, width, height, imgName));
    } catch (Exception e) {
      return false;
    }

    return true;


  }


}


