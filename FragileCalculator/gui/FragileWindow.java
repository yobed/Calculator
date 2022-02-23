package gui;

import java.awt.*;


import javax.swing.*;

/**
 * The Fragile Window (holds everything).
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author team05
 * @version V1
 */
public class FragileWindow extends JFrame
{
  private static DisplayPanel display;
  private static FragileInterWindow intermediateDisplay;
  private static final long serialVersionUID = 1L;
  private FragileHistoryWindow historyDisplay;
  private AboutWindow about;
  private int displaySizeX = 400;
  private int displaySizeY = 300;


  /**
   * FragileWindow constructor.
   */
  public FragileWindow()
  { 
    super();
    setupLayout();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  /**
   * Sets up the layout for the fragile window.
   */
  private void setupLayout()
  {
    Container contentPane;
    setSize(displaySizeX, displaySizeY);
    
    setTitle("Fragile");
    contentPane = getContentPane();
    contentPane.setLayout(new BorderLayout());
    // sets up the Frame
    JLabel imgLabel = new JLabel(new ImageIcon(getClass().getResource("Fragile_Logo.png")));
    imgLabel.setPreferredSize(new Dimension(300, 100));
    
    contentPane.add(imgLabel, BorderLayout.NORTH);
    display = new DisplayPanel();
    contentPane.add(display, BorderLayout.CENTER);
    setAlwaysOnTop(true);
    
    // set up intermediatepanel
    intermediateDisplay = new FragileInterWindow (this, displaySizeX, displaySizeY);
    // set up historypanel
    historyDisplay = new FragileHistoryWindow (this, getLocation().x, displaySizeY);
    // contentPane.add(intermediateDisplay, BorderLayout.EAST);
    about = new AboutWindow();
    //
    Observer obs = new Observer(display, intermediateDisplay, historyDisplay, about);

    LeftButtons leftbuttons = new LeftButtons(obs);
    RightButtons rightbuttons = new RightButtons(obs);
    obs.addButtons(rightbuttons, leftbuttons);
    JPanel compositeButtons = new JPanel(new GridLayout(1, 1));
    compositeButtons.add(leftbuttons);
    compositeButtons.add(rightbuttons);
    contentPane.add(compositeButtons, BorderLayout.SOUTH);
    this.setIconImage(new ImageIcon(getClass().getResource("Fragile_Icon_32x32.png")).getImage());
    FragileMenuBar menuBar = new FragileMenuBar(obs);
    setJMenuBar(menuBar);
    setResizable(true);
    pack();
  }

}
