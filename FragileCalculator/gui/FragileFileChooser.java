package gui;

import javax.swing.JFileChooser;

import formating.FragileSaveFileRecorder;

/**
 * custom JFileChooser class.
 * 
 * @author Max
 *
 */
public class FragileFileChooser extends JFileChooser
{

  /**
   * Constructor sets default directory to save folder.
   */
  public FragileFileChooser()
  {
    // name of save folder
    super(FragileSaveFileRecorder.SAVE);

  }
}
