package formating;

import java.awt.print.*;
import javax.swing.*;

/**
 * A utility class for controlling the printing process.
 * - minor edits to work in project by Max.
 * @author Prof. David Bernstein, James Madison University
 * @author Max 
 * @version 1.0
 */
public class FragilePrinterController
{
  /**
   * Print the given Printable (displaying any error messages in
   * a JOptionPane).
   * 
   * @param printable  The Printable to print
   * @param parent     The parent JFrame
   */
  public static void print(final Printable printable, final JFrame parent)
  {
    PrinterJob job = PrinterJob.getPrinterJob();

    job.setPrintable(printable);
    boolean shouldPrint = job.printDialog();
    if (shouldPrint)
      try
      {
        job.print();
      } catch (PrinterException e)
      {
        // TODO Auto-generated catch block
        JOptionPane.showMessageDialog(parent, "Unable to print!", "Error",
            JOptionPane.ERROR_MESSAGE);
      }

  }
}
