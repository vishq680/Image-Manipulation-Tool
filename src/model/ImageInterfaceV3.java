package model;

import java.util.Dictionary;


/**
 * This interface represents the updated version of the ImageInterfaceV2 where it contains functions
 * to get the current image pixels and the histogram for the same.
 */
public interface ImageInterfaceV3 extends ImageInterfaceV2 {

  /**
   * This function returns the pixel values of the current image that is loaded in the GUI.
   *
   * @return the pixel values of the image.
   */
  int[][][] getGUIImage();

  /**
   * This function is used to calculate the frequency of each channel of the current image.
   *
   * @return the frequency data of each channel.
   */
  Dictionary<String, int[]> getHistogram();
}
