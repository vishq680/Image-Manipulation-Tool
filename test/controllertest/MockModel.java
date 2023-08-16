package controllertest;

import java.io.IOException;
import java.util.Dictionary;

import model.ImageInterfaceV3;


/**
 * This class represents a mock model which is used for testing the controller.
 * The basic function is to check if the right method in the model has been invoked.
 */
public class MockModel implements ImageInterfaceV3 {


  boolean t;

  public MockModel() {
    t = false;
  }

  @Override
  public boolean loadImage(int[][][] pixels, int width, int height, String imgName) {
    t = true;
    return true;
  }

  @Override
  public int[][][] saveImage(String imgName) throws IOException {
    int[][][] t = new int[3][3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          t[i][j][k] = 1;
        }
      }
    }
    return new int[0][][];
  }

  @Override
  public boolean greyScaleRed(String imgName, String destImgName) throws IOException {
    t = true;
    return true;
  }

  @Override
  public boolean greyScaleGreen(String imgName, String destImgName) throws IOException {
    t = true;
    return true;
  }

  @Override
  public boolean greyScaleBlue(String imgName, String destImgName) throws IOException {
    t = true;
    return true;
  }

  @Override
  public boolean greyScaleValue(String imgName, String destImgName) throws IOException {
    t = true;
    return true;
  }

  @Override
  public boolean greyScaleLuma(String imgName, String destImgName) throws IOException {
    t = true;
    return true;
  }

  @Override
  public boolean greyScaleIntensity(String imgName, String destImgName) throws IOException {
    t = true;
    return true;
  }

  @Override
  public boolean horizontalFlip(String imgName, String destImgName) throws IOException {
    t = true;
    return true;
  }

  @Override
  public boolean verticalFlip(String imgName, String destImgName) throws IOException {
    t = true;
    return true;
  }

  @Override
  public boolean brightenImage(int increment, String imgName,
                               String destImgName) throws IOException {
    t = true;
    return true;
  }

  @Override
  public boolean rgbSplit(String imgName, String redDestImgName, String greenDestImgName,
                          String blueDestImgName) throws IOException {
    t = true;
    return true;
  }

  @Override
  public boolean rgbCombine(String imgName, String redImgName, String greenImgName,
                            String blueImgName) throws IOException {
    t = true;
    return true;
  }

  @Override
  public boolean blur(String imgName, String destImgName) {
    t = true;
    return true;
  }

  @Override
  public boolean sharpen(String imgName, String destImgName) {
    t = true;
    return true;
  }

  @Override
  public boolean greyscale(String imgName, String destImgName) {
    t = true;
    return true;
  }

  @Override
  public boolean sepia(String imgName, String destImgName) {
    t = true;
    return true;
  }

  @Override
  public boolean dither(String imgName, String destImgName) {

    t = true;
    return true;
  }

  @Override
  public String toString() {
    if (t) {
      return "true";
    } else {
      return "false";
    }
  }

  @Override
  public int[][][] getGUIImage() {
    return new int[0][][];
  }

  @Override
  public Dictionary<String, int[]> getHistogram() {
    return null;
  }
}
