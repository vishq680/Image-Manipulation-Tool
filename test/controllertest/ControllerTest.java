package controllertest;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import controller.ImgController;
import controller.ImgControllerImpl;
import model.ImageInterfaceV3;
import view.InputCmd;
import view.InputCmdImpl;


/**
 * This class represents the test class for the controller.
 * The mock model is invoked and the right method is called and verified.
 */
public class ControllerTest {


  /**
   * Test method for load.
   */
  @Test
  public void testLoad() throws IOException {
    String[] args = {"-file", "cmd_script.txt"};
    ImageInterfaceV3 imgMdl = new MockModel();
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("load res/dog.ppm doogg1\nquit");


    InputCmd inpt = new InputCmdImpl(in, out);
    ImgController c = new ImgControllerImpl(imgMdl, inpt, args);
    c.prog();
    Assert.assertEquals("true", imgMdl.toString());
  }


  /**
   * Test method for save.
   */

  @Test
  public void testSave() throws IOException {
    String[] args = {"-file", "cmd_script.txt"};
    ImageInterfaceV3 imgMdl = new MockModel();
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("load res/dog.ppm doogg1\nsave res/dogg.ppm doogg");


    InputCmd inpt = new InputCmdImpl(in, out);
    ImgController c = new ImgControllerImpl(imgMdl, inpt, args);
    c.prog();
    Assert.assertEquals("true", imgMdl.toString());
  }


  /**
   * Test method for RGBSplit.
   */
  @Test
  public void testRGB() throws IOException {
    String[] args = {"-file", "cmd_script.txt"};
    ImageInterfaceV3 imgMdl = new MockModel();
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("load res/dog.ppm doogg1\nrgb-slpit doogg "
            + "res/dogred res/dpggreen res/dogblue");


    InputCmd inpt = new InputCmdImpl(in, out);
    ImgController c = new ImgControllerImpl(imgMdl, inpt, args);
    c.prog();
    Assert.assertEquals("true", imgMdl.toString());
  }

  /**
   * Test method for Vertical-Flip.
   */
  @Test
  public void testVert() throws IOException {
    String[] args = {"-file", "cmd_script.txt"};
    ImageInterfaceV3 imgMdl = new MockModel();
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("load res/dog.ppm doogg1\nvertical-flip doogg res/dogVert"
            + "\nsave res/dogg.ppm dogVert");


    InputCmd inpt = new InputCmdImpl(in, out);
    ImgController c = new ImgControllerImpl(imgMdl, inpt, args);
    c.prog();
    Assert.assertEquals("true", imgMdl.toString());
  }


  /**
   * Test method for Brighten.
   */
  @Test
  public void testBrighten() throws IOException {
    String[] args = {"-file", "cmd_script.txt"};
    ImageInterfaceV3 imgMdl = new MockModel();
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("load res/dog.ppm doogg1\nvertical-flip doogg res/dogBright"
            + "\nsave res/dogg.ppm doogg");


    InputCmd inpt = new InputCmdImpl(in, out);
    ImgController c = new ImgControllerImpl(imgMdl, inpt, args);
    c.prog();
    Assert.assertEquals("true", imgMdl.toString());
  }


  /**
   * Test method for Horizontal flip.
   */
  @Test
  public void testHorz() throws IOException {
    String[] args = {"-file", "cmd_script.txt"};
    ImageInterfaceV3 imgMdl = new MockModel();
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("load res/dog.ppm doogg1\nhorizontal-flip doogg res/dogVert"
            + "\nsave res/dogg.ppm doogg");


    InputCmd inpt = new InputCmdImpl(in, out);
    ImgController c = new ImgControllerImpl(imgMdl, inpt, args);
    c.prog();
    Assert.assertEquals("true", imgMdl.toString());
  }

  /**
   * Test method for blur.
   */
  @Test
  public void testBlur() throws IOException {
    String[] args = {"-file", "cmd_script.txt"};
    ImageInterfaceV3 imgMdl = new MockModel();
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("load res/dog.ppm doogg1\nblur doogg dogblur\n"
            + "save res/dogg.ppm dogblur");

    InputCmd inpt = new InputCmdImpl(in, out);
    ImgController c = new ImgControllerImpl(imgMdl, inpt, args);
    c.prog();
    Assert.assertEquals("true", imgMdl.toString());
  }


}
