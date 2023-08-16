package model;

/**
 * This class represents the improved version of ImageManipulationAndEnhance class that has
 * the extra additional functionalities implemented in this class.
 */
public class ImageManipulationAndEnhanceV2 extends ImageManipulationAndEnhance
        implements ImageInterfaceV2 {

  @Override
  public boolean blur(String imgName, String destImgName) {

    try {
      FilterInterface blur = new BlurFilter(images, imgName, destImgName);
      blur.filter();
    } catch (Exception e) {
      return false;
    }

    return true;

  }

  @Override
  public boolean sharpen(String imgName, String destImgName) {

    try {
      FilterInterface sharpen = new SharpenFilter(images, imgName, destImgName);
      sharpen.filter();
    } catch (Exception e) {
      return false;
    }

    return true;

  }

  @Override
  public boolean greyscale(String imgName, String destImgName) {

    try {
      TransformationInterface greyscale = new GreyscaleTransformation(images, imgName, destImgName);
      greyscale.transform();
    } catch (Exception e) {
      return false;
    }
    return true;

  }

  @Override
  public boolean sepia(String imgName, String destImgName) {

    try {
      TransformationInterface sepia = new SepiaTransformation(images, imgName, destImgName);
      sepia.transform();
    } catch (Exception e) {
      return false;
    }

    return true;

  }

  @Override
  public boolean dither(String imgName, String destImgName) {

    try {
      DitherInterface obj = new Dither(images, imgName, destImgName, this);
      obj.dither();
    } catch (Exception e) {
      return false;
    }

    return true;


  }


}
