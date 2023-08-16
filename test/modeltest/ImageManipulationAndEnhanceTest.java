package modeltest;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.assertArrayEquals;

/**
 * This class represents the test class for the model. The images are converted and
 * checked with an already converted image pixel by pixel.
 */
public class ImageManipulationAndEnhanceTest {

  String cmd = "load res/dog.ppm dog";
  String[] arrOfStr = cmd.split(" ");
  boolean t;
  private TestInterface testMod = new TestModel();

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

  private int[][][] testHelper(String imgPath) {

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
      return null;
    }

    int width = sc.nextInt();
    int height = sc.nextInt();
    int maxValue = sc.nextInt();
    int[][][] t1 = new int[3][height][width];


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

  @Test
  public void testLoad() {
    String cmd = "load res/dog.ppm dog";
    TestInterface testImg = new TestModel();
    String[] arrOfStr = cmd.split(" ");
    int[][][] img = testHelper("res/dog.ppm");
    t = testImg.loadImage(img, img[0][0].length, img[0].length, arrOfStr[2]);
    int[][][] act = testImg.testFunc(arrOfStr[2]);
    assertArrayEquals(img, act);
  }

  @Test
  public void testBlur() {
    String cmd = "load res/dog.ppm dog";
    String[] arrOfStr = cmd.split(" ");
    TestInterface testImg = new TestModel();
    int[][][] img = testHelper("res/dog.ppm");
    assert img != null;
    testImg.loadImage(img, img[0][0].length, img[0].length, arrOfStr[2]);
    testImg.blur("dog", "dogblur");
    int[][][] act = testImg.testFunc("dogblur");
    img = testHelper("res/dogBlur.ppm");
    assertArrayEquals(act, img);
  }

  @Test
  public void testBrighten() throws IOException {
    String cmd = "load res/dog.ppm dog";
    String[] arrOfStr = cmd.split(" ");
    TestInterface testImg = new TestModel();
    int[][][] img = testHelper("res/dog.ppm");
    assert img != null;
    testImg.loadImage(img, img[0][0].length, img[0].length, arrOfStr[2]);
    t = testImg.brightenImage(50, "dog", "dogbrighten");
    int[][][] act = testImg.testFunc("dogbrighten");
    img = testHelper("res/dogBright.ppm");
    assertArrayEquals(act, img);
  }


  @Test
  public void testDither() {
    String cmd = "load res/dog.ppm dog";
    String[] arrOfStr = cmd.split(" ");
    TestInterface testImg = new TestModel();
    int[][][] img = testHelper("res/dog.ppm");
    assert img != null;
    testImg.loadImage(img, img[0][0].length, img[0].length, arrOfStr[2]);
    t = testImg.dither("dog", "dogdither");
    int[][][] act = testImg.testFunc("dogdither");
    img = testHelper("res/dogDither.ppm");
    assertArrayEquals(act, img);
  }

  @Test
  public void testGreyscale() {
    String cmd = "load res/dog.ppm dog";
    String[] arrOfStr = cmd.split(" ");
    TestInterface testImg = new TestModel();
    int[][][] img = testHelper("res/dog.ppm");
    assert img != null;
    testImg.loadImage(img, img[0][0].length, img[0].length, arrOfStr[2]);
    t = testImg.greyscale("dog", "doggrey");
    int[][][] act = testImg.testFunc("doggrey");
    img = testHelper("res/dogGreyscale.ppm");
    assertArrayEquals(act, img);
  }

  @Test
  public void testHozflip() throws IOException {

    String cmd = "load res/dog.ppm dog";
    String[] arrOfStr = cmd.split(" ");
    TestInterface testImg = new TestModel();
    int[][][] img = testHelper("res/dog.ppm");
    assert img != null;
    testImg.loadImage(img, img[0][0].length, img[0].length, arrOfStr[2]);
    t = testImg.horizontalFlip("dog", "doghoz");
    int[][][] act = testImg.testFunc("doghoz");
    img = testHelper("res/dogHoz.ppm");
    assertArrayEquals(act, img);
  }


  @Test
  public void testRGB() throws IOException {
    String cmd = "load res/dog.ppm dog";
    String[] arrOfStr = cmd.split(" ");
    TestInterface testImg = new TestModel();
    int[][][] img = testHelper("res/dog.ppm");
    assert img != null;
    testImg.loadImage(img, img[0][0].length, img[0].length, arrOfStr[2]);
    t = testImg.rgbSplit("dog", "dogred", "doggreen", "dogblue");
    int[][][] act = testImg.testFunc("dogred");
    img = testHelper("res/dogRed.ppm");
    assertArrayEquals(act, img);
    act = testImg.testFunc("doggreen");
    img = testHelper("res/dogGreen.ppm");
    assertArrayEquals(act, img);
    act = testImg.testFunc("dogblue");
    img = testHelper("res/dogBlue.ppm");
    assertArrayEquals(act, img);
    t = testImg.rgbCombine("dogcomb", "dogred", "doggreen", "dogblue");
    act = testImg.testFunc("dogcomb");
    img = testHelper("res/dogCombine.ppm");
    assertArrayEquals(act, img);
  }


  @Test
  public void testSepia() {
    String cmd = "load res/dog.ppm dog";
    String[] arrOfStr = cmd.split(" ");
    TestInterface testImg = new TestModel();
    int[][][] img = testHelper("res/dog.ppm");
    assert img != null;
    testImg.loadImage(img, img[0][0].length, img[0].length, arrOfStr[2]);
    t = testImg.sepia("dog", "dogsep");
    int[][][] act = testImg.testFunc("dogsep");
    img = testHelper("res/dogsepia.ppm");
    assertArrayEquals(act, img);
  }


  @Test
  public void testSharpen() {
    String cmd = "load res/dog.ppm dog";
    String[] arrOfStr = cmd.split(" ");
    TestInterface testImg = new TestModel();
    int[][][] img = testHelper("res/dog.ppm");
    assert img != null;
    testImg.loadImage(img, img[0][0].length, img[0].length, arrOfStr[2]);
    t = testImg.sharpen("dog", "dogsharp");
    int[][][] act = testImg.testFunc("dogsharp");
    img = testHelper("res/dogSharp.ppm");
    assertArrayEquals(act, img);
  }


  @Test
  public void testVertFlip() throws IOException {
    String cmd = "load res/dog.ppm dog";
    String[] arrOfStr = cmd.split(" ");
    TestInterface testImg = new TestModel();
    int[][][] img = testHelper("res/dog.ppm");
    assert img != null;
    testImg.loadImage(img, img[0][0].length, img[0].length, arrOfStr[2]);
    t = testImg.verticalFlip("dog", "dogvert");
    int[][][] act = testImg.testFunc("dogvert");
    img = testHelper("res/dogVert.ppm");
    assertArrayEquals(act, img);
  }


}