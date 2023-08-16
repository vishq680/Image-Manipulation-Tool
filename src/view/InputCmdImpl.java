package view;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents the data and functions required to enable the application to perform
 * input and output operations.
 */
public class InputCmdImpl implements InputCmd {


  final Readable in;
  final Appendable out;

  /**
   * This function is responsible for declaring and initialising the class object with the
   * appropriate values.
   *
   * @param in  input type.
   * @param out output type.
   */
  public InputCmdImpl(Readable in, Appendable out) {
    this.in = in;
    this.out = out;
  }

  @Override
  public String inputReceived() throws IOException {
    this.out.append(String.format("Enter the command: "));
    Scanner sc = new Scanner(in);
    String str = sc.nextLine();
    return str;
  }

  @Override
  public void outputDisplay(boolean t, String s) throws IOException {
    if (t) {
      this.out.append(String.format(s + " is successful\n"));
    } else {
      this.out.append(String.format(s + " is unsuccessful\n"));
    }
  }


  @Override
  public void invalidCmd() throws IOException {
    this.out.append(String.format("Invalid command entered.\n"));
  }

}
