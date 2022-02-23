package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import java.util.concurrent.TimeUnit;

import javax.swing.*;

/**
 * Displays History Steps in a new separate window from the the main JFrame.
 * 
 * @author Max & Ashdon
 *
 */
public class FragileHistoryWindow extends JWindow implements ComponentListener
{
  private static final int LENGTH_Y = 175;
  private static final int SPACE = 50;
  private static final int NUM_ELEMENTS = 8;
  private static final int NUM_INCREMENTS = 1000;
  private static final int BEHIND_OFFSET = 25;

  // size of frame x / y
  private int displayX, displayY;

  // offset for labels in dialog
  private int historySizeX;
  private int historySizeY;

  private JFrame f;

  // number of elements that can fit on a row

  private int calculationCount = 0;
  private int startX;

  private JButton closeButton;
  private JPanel centerPanel;
  private String calibri = "Calibri";

  private ArrayList<JLabel> historyTextList;

  /**
   * Constructor for History Steps dialog.
   * 
   * @param f parent frame
   * @param displayX size of frame f
   * @param displayY size of frame f
   */
  public FragileHistoryWindow(final JFrame f, final int displayX, final int displayY)
  {
    // super(f);
    historyTextList = new ArrayList<JLabel>();

    closeButton = new JButton(DisplayPanel.R_CARROT);
    centerPanel = new JPanel();
    centerPanel.setLayout(new GridLayout(8, 1));
    this.f = f;

    f.addComponentListener(this);
    setLayout(new BorderLayout());
    // num elements set a baseline of 8.
    historySizeX = NUM_ELEMENTS * SPACE + BEHIND_OFFSET;

    // setUndecorated(true);

    setAlwaysOnTop(false);
    //
    historySizeY = 0;
    setSize(0, LENGTH_Y);
    this.displayX = displayX;
    this.displayY = displayY;
    this.setVisible(false);
    setLocationRelativeTo(f);
    int centerY = (displayY - LENGTH_Y) / 2;
    this.startX = BEHIND_OFFSET;
    this.setLocation(startX, centerY);
    add(centerPanel, BorderLayout.CENTER);
  }

  /**
   * Creates a new formated JLabel offset a set position from x and y. TODO.
   * @param text String
   */
  public void createLabel(final String text)
  {
    if (calculationCount == -1) 
    {
      calculationCount = 7;
    }
    JLabel current = historyTextList.get(calculationCount);
    calculationCount--;
    current.setFont(new Font(calibri, Font.PLAIN, 12));
    current.setVisible(true);
    current.setText(text);
    current.setSize(current.getPreferredSize());
    repaint();
  }

  /**
   * Creates a new formated JLabel offset a set position from x and y.
   * @param amount
   */
  public void createLabels(final int amount)
  {
    for (int i = 0; i < amount; i++)
    {
      JLabel current = new JLabel();
      current.setFont(new Font(calibri, Font.PLAIN, 12));
      current.setVisible(true);
      current.setSize(current.getPreferredSize());
      historyTextList.add(current);
      centerPanel.add(current, i, 0);
      calculationCount++;
    }
    calculationCount = amount - 1;
    repaint();
  }

  /**
   * adds a close > button to dialog.
   */
  private void addButton()
  {
    closeButton.setForeground(new Color(0, 191, 255));
    closeButton.setVisible(true);
    closeButton.setPreferredSize(new Dimension(SPACE, 20));
    closeButton.setSize(closeButton.getPreferredSize());
    add(closeButton, BorderLayout.LINE_START);
    repaint();
  }

  /**
   * Done to fit with observer patter, used exclusively to add actionListener to button.
   * 
   * @return close button
   */
  public JButton getCloseButton()
  {
    return closeButton;
  }

  /**
   * Removes all current components of HistoryDialog and sets it to be invisible.
   */
  public void shutDown()
  {
    closeButton = new JButton(DisplayPanel.R_CARROT);
    setVisible(false);
    repaint();
    setLocation((int) f.getLocation().getX() + BEHIND_OFFSET,
        (int) f.getLocation().getY() + displayY / 4);
  }

  /**
   * clears text.
   */
  public void clearText()
  {
    for (int i = 0; i < historyTextList.size(); i++)
    {
      historyTextList.get(i).setText("");
    }
  }

  /**
   * Done to set up dialog.
   */
  public void startUp()
  {
    setVisible(true);
    addButton();
    startUpAnimation(getLocation().x, getLocation().x - historySizeX, historySizeX, LENGTH_Y,
        getLocation().y);
    repaint();
  }

  /**
   * Animates dialog on startup.
   * 
   * @param startLocationX starting size of window
   * @param endLocationX
   * @param endSizeX ending size of window
   * @param endSizeY
   * @param yLocation
   */
  private void startUpAnimation(final int startLocationX, final int endLocationX,
      final int endSizeX, final int endSizeY, final int yLocation)
  {
    double incX = (historySizeX + 0.0) / NUM_INCREMENTS;
    SwingWorker worker = new SwingWorker()
    {
      @Override
      protected Object doInBackground() throws Exception
      {
        setSize(endSizeX, endSizeY);
        for (int i = NUM_INCREMENTS; i >= 0; i--)
        {
          int x = (int) Math.round(incX * i);
          int y = yLocation;

          if (x >= endLocationX)
          {
            setLocation(x, y);
          } else
          {
            setLocation(endLocationX, yLocation);
          }

          try
          {
            TimeUnit.MILLISECONDS.sleep(1);
          } catch (InterruptedException e)
          {
          }
          repaint();
        }
        return null;
      }
    };
    worker.execute();
  }

  @Override
  public void componentResized(final ComponentEvent e)
  {
  }

  /**
   * Done to move current window with main window.
   */
  @Override
  public void componentMoved(final ComponentEvent e)
  {
    if (!this.isVisible())
    {
      setLocation((int) e.getComponent().getLocation().getX() + BEHIND_OFFSET,
          (int) e.getComponent().getLocation().getY() + displayY / 4);
    } else
    {
      setLocation((int) e.getComponent().getLocation().getX() - historySizeX + BEHIND_OFFSET,
          (int) e.getComponent().getLocation().getY() + displayY / 4);
    }
    int a = 0;
  }

  @Override
  public void componentShown(final ComponentEvent e)
  {
  }

  @Override
  public void componentHidden(final ComponentEvent e)
  {
  }

}
