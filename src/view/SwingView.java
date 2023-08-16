package view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.Font;


import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Dictionary;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


/**
 * This class is implements the methods in the IView interface and builds the GUI.
 */
public class SwingView extends JFrame implements IView {

  private String loadPath;
  private JButton fileOpenButton;


  private JButton blurButton;
  private JButton brightenButton;
  private JButton hozFlipButton;
  private JButton vertFlipButton;
  private JButton greyscaleButton;
  private JButton rgbSplitButton;
  private JButton rgbCombineButton;
  private String savePath;
  private JButton sharpenButton;

  private JButton sepiaButton;
  private JButton ditherButton;

  private JButton saveButton;

  private JScrollPane imageScrollPane;
  private JPanel imagePanel;

  private ChartPanel chartPanel;


  /**
   * This constructor creates the GUI and gets the input from the user.
   */
  public SwingView() {
    super();

    JPanel mainPanel;
    JScrollPane mainScrollPane;
    JPanel rgbCombinePanel;

    setTitle("ImageManipulation");
    setPreferredSize(new Dimension(1200, 1000));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    mainPanel = new JPanel();
    //for elements to be arranged vertically within this panel
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
    //scroll bars around this main panel
    mainScrollPane = new JScrollPane(mainPanel);
    add(mainScrollPane);


    JPanel openPanel = new JPanel();
    openPanel.setBorder(BorderFactory.createTitledBorder("Open an Image"));
    openPanel.setLayout(new BoxLayout(openPanel, BoxLayout.PAGE_AXIS));
    mainPanel.add(openPanel);


    JPanel fileopenPanel = new JPanel();
    fileopenPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    openPanel.add(fileopenPanel);
    fileOpenButton = new JButton("Load an Image");
    fileOpenButton.setActionCommand("Open file");
    fileopenPanel.add(fileOpenButton);


    JPanel dialogBoxesPanel = new JPanel();
    dialogBoxesPanel.setBorder(BorderFactory.createTitledBorder("Commands"));
    dialogBoxesPanel.setLayout(new BoxLayout(dialogBoxesPanel, BoxLayout.PAGE_AXIS));
    mainPanel.add(dialogBoxesPanel);


    JPanel blurPanel = new JPanel();
    blurPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    dialogBoxesPanel.add(blurPanel);
    blurButton = new JButton("Blur Image");
    blurButton.setActionCommand("blrImg");
    blurPanel.add(blurButton);


    JPanel brightenPanel = new JPanel();
    brightenPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    dialogBoxesPanel.add(brightenPanel);
    brightenButton = new JButton("Brighten Image");
    brightenButton.setActionCommand("brtImg");
    brightenPanel.add(brightenButton);


    JPanel hozFlipPanel = new JPanel();
    hozFlipPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    dialogBoxesPanel.add(hozFlipPanel);
    hozFlipButton = new JButton("Horizontal Flip Image");
    hozFlipButton.setActionCommand("hozImg");
    hozFlipPanel.add(hozFlipButton);


    JPanel vertFlipPanel = new JPanel();
    vertFlipPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    dialogBoxesPanel.add(vertFlipPanel);
    vertFlipButton = new JButton("Vertical Flip Image");
    vertFlipButton.setActionCommand("vertImg");
    vertFlipPanel.add(vertFlipButton);


    JPanel greyscalePanel = new JPanel();
    greyscalePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    dialogBoxesPanel.add(greyscalePanel);
    greyscaleButton = new JButton("Greyscale Image");
    greyscaleButton.setActionCommand("greyImg");
    greyscalePanel.add(greyscaleButton);


    JPanel rgbSplitPanel = new JPanel();
    rgbSplitPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    dialogBoxesPanel.add(rgbSplitPanel);
    rgbSplitButton = new JButton("RGB Split Image");
    rgbSplitButton.setActionCommand("rgbSplitImg");
    rgbSplitPanel.add(rgbSplitButton);


    rgbCombinePanel = new JPanel();
    rgbCombinePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    dialogBoxesPanel.add(rgbCombinePanel);
    rgbCombineButton = new JButton("RGB Combine Image");
    rgbCombineButton.setActionCommand("rgbCombImg");
    rgbCombinePanel.add(rgbCombineButton);


    JPanel sharpenPanel = new JPanel();
    sharpenPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    dialogBoxesPanel.add(sharpenPanel);
    sharpenButton = new JButton("Sharpen Image");
    sharpenButton.setActionCommand("sharpImg");
    sharpenPanel.add(sharpenButton);


    JPanel sepiaPanel = new JPanel();
    sepiaPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    dialogBoxesPanel.add(sepiaPanel);
    sepiaButton = new JButton("Sepia Image");
    sepiaButton.setActionCommand("sepiaImg");
    sepiaPanel.add(sepiaButton);


    JPanel ditherPanel = new JPanel();
    ditherPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    dialogBoxesPanel.add(ditherPanel);
    ditherButton = new JButton("Dither Image");
    ditherButton.setActionCommand("ditherImg");
    ditherPanel.add(ditherButton);


    JPanel savePanel = new JPanel();
    savePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    dialogBoxesPanel.add(savePanel);
    saveButton = new JButton("Save Image");
    saveButton.setActionCommand("saveImg");
    savePanel.add(saveButton);


    imagePanel = new JPanel();
    //a border around the panel with a caption
    imagePanel.setBorder(BorderFactory.createTitledBorder("Image & Histogram"));
    imagePanel.setLayout(new GridLayout(2, 1, 10, 10));
    //imagePanel.setMaximumSize(null);
    mainPanel.add(imagePanel);

    pack();
    setVisible(true);

  }

  @Override
  public String[] rgbCombine() {


    JOptionPane.showMessageDialog(SwingView.this, "Enter " +
            "Red Component Image Location", "Message", JOptionPane.PLAIN_MESSAGE);
    String[] rgbLoc = new String[3];
    JFileChooser fileChooser1 = new JFileChooser(".");
    int result = fileChooser1.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
      File selectedFile = fileChooser1.getSelectedFile();
      rgbLoc[0] = selectedFile.getAbsolutePath();

    }

    JOptionPane.showMessageDialog(SwingView.this, "Enter Green" +
            " Component Image Loaction ", "Message", JOptionPane.PLAIN_MESSAGE);
    JFileChooser fileChooser2 = new JFileChooser(".");
    int result1 = fileChooser2.showOpenDialog(this);
    if (result1 == JFileChooser.APPROVE_OPTION) {
      File selectedFile = fileChooser2.getSelectedFile();
      rgbLoc[1] = selectedFile.getAbsolutePath();
    }

    JOptionPane.showMessageDialog(SwingView.this, "Enter Blue " +
            "Component Image Location ", "Message", JOptionPane.PLAIN_MESSAGE);
    JFileChooser fileChooser3 = new JFileChooser(".");
    int result2 = fileChooser3.showOpenDialog(this);
    if (result2 == JFileChooser.APPROVE_OPTION) {
      File selectedFile = fileChooser3.getSelectedFile();
      rgbLoc[2] = selectedFile.getAbsolutePath();
    }

    return rgbLoc;
  }

  @Override
  public String getLoadPath() {
    final JFileChooser fchooser = new JFileChooser(".");
    int retValue = fchooser.showOpenDialog(SwingView.this);
    if (retValue == JFileChooser.APPROVE_OPTION) {
      File f = fchooser.getSelectedFile();
      loadPath = f.getAbsolutePath();
    }
    return loadPath;
  }


  @Override
  public void setImage(int[][][] t, Dictionary<String, int[]> d1) {

    BufferedImage image1;
    JLabel imageLabel;
    ImageIcon imageIcon;

    int height = t[0].length;
    int width = t[0][0].length;
    image1 = new BufferedImage(width, height,
            BufferedImage.TYPE_INT_RGB);
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int r = t[0][i][j];
        int g = t[1][i][j];
        int b = t[2][i][j];
        int value = (r << 16) | (g << 8) | b;
        image1.setRGB(j, i, value);
      }
    }


    if (imageScrollPane != null) {
      imagePanel.remove(imageScrollPane);
    }

    imageLabel = new JLabel();
    imageScrollPane = new JScrollPane(imageLabel);
    imageIcon = new ImageIcon(image1);
    imageLabel.setIcon(imageIcon);
    imageScrollPane.setPreferredSize(new Dimension(300, 100));
    imagePanel.add(imageScrollPane);


    XYDataset dataset = createDataset(d1);
    JFreeChart chart = createChart(dataset);


    if (chartPanel != null) {
      imagePanel.remove(chartPanel);
    }

    chartPanel = new ChartPanel(chart);
    chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
    chartPanel.setBackground(Color.white);
    imagePanel.add(chartPanel);
    revalidate();


  }


  @Override
  public void addActionListener(ActionListener actionListener) {

    fileOpenButton.addActionListener(actionListener);
    blurButton.addActionListener(actionListener);
    hozFlipButton.addActionListener(actionListener);
    vertFlipButton.addActionListener(actionListener);
    ditherButton.addActionListener(actionListener);
    sepiaButton.addActionListener(actionListener);
    brightenButton.addActionListener(actionListener);
    saveButton.addActionListener(actionListener);
    sharpenButton.addActionListener(actionListener);
    rgbSplitButton.addActionListener(actionListener);
    rgbCombineButton.addActionListener(actionListener);
    greyscaleButton.addActionListener(actionListener);

  }

  private String getRGBLocation(String color) {
    JOptionPane.showMessageDialog(SwingView.this,
            "Location to Save" + color + "Component", "Message",
            JOptionPane.PLAIN_MESSAGE);

    JFileChooser fileChooser1 = new JFileChooser(".");
    int retValue = fileChooser1.showSaveDialog(SwingView.this);
    if (retValue == JFileChooser.APPROVE_OPTION) {
      File f = fileChooser1.getSelectedFile();
      return f.getAbsolutePath();
    }
    return "";
  }

  @Override
  public String[] showSplit() {

    String[] rgbLoc = new String[3];

    rgbLoc[0] = getRGBLocation("Red");
    rgbLoc[1] = getRGBLocation("Green");
    rgbLoc[2] = getRGBLocation("Blue");

    return rgbLoc;

  }

  @Override
  public String getGreyscaleComponent() {
    String[] options = {"red", "green", "blue", "luma", "value", "intensity", "Nothing"};
    int retvalue = JOptionPane.showOptionDialog(SwingView.this,
            "Choose the Greyscale Component", "Options", JOptionPane.YES_OPTION,
            JOptionPane.INFORMATION_MESSAGE, null, options, options[6]);
    String s = options[retvalue];
    if (s.equals("Nothing")) {
      s = "";
    } else {
      s += "-component";
    }
    return s;
  }


  @Override
  public String getBrightenValue() {
    return JOptionPane.showInputDialog("Enter Brighten Intensity ");
  }


  @Override
  public String getSavePath() {
    final JFileChooser fchooser = new JFileChooser(".");
    int retvalue = fchooser.showSaveDialog(SwingView.this);
    if (retvalue == JFileChooser.APPROVE_OPTION) {
      File f = fchooser.getSelectedFile();
      savePath = f.getAbsolutePath();
    }

    return savePath;
  }


  /**
   * This method is used for building the histogram.
   *
   * @param d1 The dictionary containing the table for histogram.
   * @return The dataset for populating the chart.
   */
  private XYDataset createDataset(Dictionary<String, int[]> d1) {
    var series1 = new XYSeries("Red");
    int[] r = d1.get("red");
    for (int i = 0; i < 256; i++) {
      series1.add(i, r[i]);
    }
    var series2 = new XYSeries("Green");
    int[] g = d1.get("green");
    for (int i = 0; i < 256; i++) {
      series2.add(i, g[i]);
    }
    var series3 = new XYSeries("Blue");
    int[] b = d1.get("blue");
    for (int i = 0; i < 256; i++) {
      series3.add(i, b[i]);
    }

    var series4 = new XYSeries("Intensity");
    int[] intensity = d1.get("intensity");
    for (int i = 0; i < 256; i++) {
      series4.add(i, intensity[i]);
    }


    var dataset = new XYSeriesCollection();
    dataset.addSeries(series1);
    dataset.addSeries(series2);
    dataset.addSeries(series3);
    dataset.addSeries(series4);


    return dataset;
  }


  /**
   * To display the histogram as a line chart.
   *
   * @param dataset The data to be shown on the chart.
   * @return The chart after adding the values.
   */
  private JFreeChart createChart(XYDataset dataset) {

    JFreeChart chart = ChartFactory.createXYLineChart(
            "Image Histogram",
            "Pixel",
            "Frequency",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
    );

    XYPlot plot = chart.getXYPlot();

    var renderer = new XYLineAndShapeRenderer();
    renderer.setSeriesPaint(0, Color.RED);
    renderer.setSeriesStroke(0, new BasicStroke(2.0f));

    renderer.setSeriesPaint(1, Color.GREEN);
    renderer.setSeriesStroke(1, new BasicStroke(2.0f));

    renderer.setSeriesPaint(2, Color.BLUE);
    renderer.setSeriesStroke(2, new BasicStroke(2.0f));

    renderer.setSeriesPaint(3, Color.YELLOW);
    renderer.setSeriesStroke(3, new BasicStroke(2.0f));

    plot.setRenderer(renderer);
    plot.setBackgroundPaint(Color.white);

    plot.setRangeGridlinesVisible(false);
    plot.setRangeGridlinePaint(Color.BLACK);

    plot.setDomainGridlinesVisible(true);
    plot.setDomainGridlinePaint(Color.BLACK);

    chart.setTitle(new TextTitle("Image Histogram",
                    new Font("Serif", java.awt.Font.BOLD, 18)
            )
    );

    return chart;
  }


  @Override
  public String inputReceived() throws IOException {
    return null;
  }

  /**
   * This method is part of the InputCmd interface and is not used in the GUI implementation.
   *
   * @param t True if the model has been successfully called and false otherwise.
   * @param s Represents the exact method that was called initially.
   */
  @Override
  public void outputDisplay(boolean t, String s) {
    return;
  }

  @Override
  public void invalidCmd() {
    JOptionPane.showMessageDialog(SwingView.this,
            "Cannot perform operation without loading an image ", "Message",
            JOptionPane.PLAIN_MESSAGE);

  }
}
