package gui;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.*;

import formating.FragileSaveFileRecorder;

/**
 * The main Fragile class.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author team05
 * @version V1
 */
public class Fragile implements Runnable
{
  /**
   * Main args (runs the program).
   * 
   * @param args
   * @throws InterruptedException
   * @throws InvocationTargetException
   */
  public static void main(final String[] args)
      throws InterruptedException, InvocationTargetException
  {
    Path path = Paths.get(FragileSaveFileRecorder.SAVE);
    if (!Files.exists(path))
      try
      {
        Files.createDirectory(path);
      } catch (IOException e)
      {
        // TODO Auto-generated catch block
        System.out.println("Failure in creating saves folder.");
      }
    SwingUtilities.invokeAndWait(new Fragile());
  }

  @Override
  public void run()
  {
    FragileWindow window = new FragileWindow();
    window.setTitle("Fragile");
    window.setVisible(true);

  }
}
