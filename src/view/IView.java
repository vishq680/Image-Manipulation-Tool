package view;

import java.awt.event.ActionListener;
import java.util.Dictionary;

/**
 * This interface represents the GUI for image manipulation.
 */

public interface IView extends InputCmd {

  /**
   * This function is used to return the path from where the image is to be loaded.
   *
   * @return This represents the path as a string.
   */
  String getLoadPath();


  /**
   * This method is used to update the image and histogram after every command.
   *
   * @param img Represents the image pixel matrix.
   * @param d1  Represents histogram table values.
   */
  void setImage(int[][][] img, Dictionary<String, int[]> d1);

  /**
   * This is to force the view to have a method to set up actions for buttons.
   * All the buttons must be given this action listener.
   * Thus, our Swing-based implementation of this interface will already have such a method.
   *
   * @param listener It represents the actionListener object that is to be used for all buttons.
   */
  void addActionListener(ActionListener listener);

  /**
   * This method is used to get the component of the greyscale to be found.
   *
   * @return The component as a string.
   */
  String getGreyscaleComponent();

  /**
   * This method is used to return the value for brighten as a string.
   *
   * @return The value for brighten.
   */
  String getBrightenValue();

  /**
   * This method is used to get the path for saving the image.
   *
   * @return The path as a string.
   **/
  String getSavePath();


  /**
   * This method is used to get the path for saving the split images.
   *
   * @return The path for saving images.
   */
  String[] showSplit();

  /**
   * This method is used for getting the path of the red,green,blue images separately.
   *
   * @return The path of each image as an array of string.
   */
  String[] rgbCombine();


}
