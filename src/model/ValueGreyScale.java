package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.List;


/**
 * This class represents the data and the functionalities required to perform greyscale on value
 * component of the given image.
 */
public class ValueGreyScale extends GreyScaleAbstract {

  /**
   * This constructor is used to declare and initialise ValueGreyScale class objects with the
   * appropriate values.
   *
   * @param images      image repository in the form of a dictionary that holds all the images.
   * @param imgName     name of the image to be dithered.
   * @param destImgName name of the dithered image.
   */
  public ValueGreyScale(Dictionary<String, Image> images, String imgName, String destImgName) {
    super(images, imgName, destImgName);
  }

  private int getMax(int a, int b, int c) {
    List<Integer> t = new ArrayList<>();
    t.add(a);
    t.add(b);
    t.add(c);
    return Collections.max(t);
  }

  @Override
  double getComponentValue(int i, int j) {
    int[][][] pixels = images.get(imgName).getPixels();
    return getMax(pixels[0][i][j], pixels[1][i][j], pixels[2][i][j]);
  }
}
