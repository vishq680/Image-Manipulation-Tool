package model;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * This class represents the extra functionalities that is required by the controller to perform
 * operations in GUI.
 */
public class ImageManipulationAndEnhanceV3 extends ImageManipulationAndEnhanceV2
        implements ImageInterfaceV3 {
  @Override
  public int[][][] getGUIImage() {
    if (images.get("guiImg") == null) {
      return null;
    }
    return images.get("guiImg").getPixels();
  }

  @Override
  public Dictionary<String, int[]> getHistogram() {

    int[][][] pixelsRGB = getGUIImage();
    Dictionary<String, int[]> hist = new Hashtable<>();

    greyScaleIntensity("guiImg", "internal_hist_intensity");
    int[][][] intensityPixels = images.get("internal_hist_intensity").getPixels();

    int width = images.get("guiImg").getWidth();
    int height = images.get("guiImg").getHeight();
    hist.put("red", getFrequency(pixelsRGB[0], width, height));
    hist.put("green", getFrequency(pixelsRGB[1], width, height));
    hist.put("blue", getFrequency(pixelsRGB[2], width, height));
    hist.put("intensity", getFrequency(intensityPixels[0], width, height));
    return hist;
  }

  private int[] getFrequency(int[][] pixelMatrix, int width, int height) {

    int[] frequency = new int[256];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        frequency[pixelMatrix[i][j]]++;
      }
    }

    return frequency;
  }

}
