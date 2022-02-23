package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 * The LeftButtons hold the buttons to be displayed in the GUI.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author team05
 * @version V1
 */
public class LeftButtons extends JPanel
{
  
  private static final long serialVersionUID = 1L;
  private ActionListener listener;
  private GridBagConstraints gbc = new GridBagConstraints();
  private ArrayList<JButton> listOfNumButtons = new ArrayList<JButton>();
  private ArrayList<JButton> listOfFuncButtons = new ArrayList<JButton>();


  /**
   * CompositeButtons constructor.
   * 
   * @param listener
   */
  public LeftButtons(final ActionListener listener)
  {
    this.listener = listener;
    setLayout(new GridBagLayout());
    setuplayout();
  }

  /**
   * Sets up the layout by calling button methods in order.
   */
  public void setuplayout()
  {
    gbc.insets = new Insets(0, 5, 5, 5);
    gbc.fill = GridBagConstraints.BOTH;
    String tempString = "1";
    // one button
    JButton one = new JButton(tempString);

    one.addActionListener(listener);
    gbc.gridx = 0;
    gbc.gridy = 1;
    add(one, gbc);
    InputMap im = one.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    ActionMap am = one.getActionMap();
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_1, 0), tempString);
    am.put(tempString, new AbstractAction()
    {
      @Override
      public void actionPerformed(final ActionEvent e)
      {
        one.doClick();
      }
    });

    // Plus minus button
    JButton buttonPLUSMINUS = new JButton(DisplayPanel.PLUSMINUS);
    buttonPLUSMINUS.addActionListener(listener);
    buttonPLUSMINUS.setForeground(Color.ORANGE);
    gbc.gridx = 0;
    gbc.gridy = 0;
    add(buttonPLUSMINUS, gbc);

    // Clear button
    JButton buttonClear = new JButton(DisplayPanel.CLEAR);
    buttonClear.setForeground(Color.ORANGE);
    buttonClear.addActionListener(listener);
    gbc.gridx = 1;
    gbc.gridy = 0;
    add(buttonClear, gbc);
    tempString = "C";
    im = one.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    am = one.getActionMap();
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), tempString);
    am.put(tempString, new AbstractAction()
    {
      @Override
      public void actionPerformed(final ActionEvent e)
      {
        buttonClear.doClick();
      }
    });

    // To the left (left arrow) button
    JButton buttonLEFT = new JButton(DisplayPanel.LEFTARROW);
    buttonLEFT.setForeground(Color.ORANGE);
    buttonLEFT.addActionListener(listener);
    gbc.gridx = 2;
    gbc.gridy = 0;
    tempString = "\u2190";
    add(buttonLEFT, gbc);
    im = one.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    am = one.getActionMap();
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), tempString);
    am.put(tempString, new AbstractAction()
    {
      @Override
      public void actionPerformed(final ActionEvent e)
      {
        buttonLEFT.doClick();
      }
    });


    // two button
    tempString = "2";
    JButton two = new JButton(tempString);

    two.addActionListener(listener);
    gbc.gridx = 1;
    gbc.gridy = 1;
    add(two, gbc);

    im = one.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    am = one.getActionMap();
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_2, 0), tempString);
    am.put(tempString, new AbstractAction()
    {
      @Override
      public void actionPerformed(final ActionEvent e)
      {
        two.doClick();
      }
    });

    // three button
    tempString = "3";
    JButton three = new JButton(tempString);

    three.addActionListener(listener);
    gbc.gridx = 2;
    gbc.gridy = 1;
    add(three, gbc);

    im = one.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    am = one.getActionMap();
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_3, 0), tempString);
    am.put(tempString, new AbstractAction()
    {
      @Override
      public void actionPerformed(final ActionEvent e)
      {
        three.doClick();
      }
    });

    // four button
    tempString = "4";
    JButton four = new JButton(tempString);

    four.addActionListener(listener);
    gbc.gridx = 0;
    gbc.gridy = 2;
    add(four, gbc);

    im = one.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    am = one.getActionMap();
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_4, 0), tempString);
    am.put(tempString, new AbstractAction()
    {
      @Override
      public void actionPerformed(final ActionEvent e)
      {
        four.doClick();
      }
    });
    // five button
    tempString = "5";
    JButton five = new JButton(tempString);

    five.addActionListener(listener);
    gbc.gridx = 1;
    gbc.gridy = 2;
    add(five, gbc);

    im = one.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    am = one.getActionMap();
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_5, 0), tempString);
    am.put(tempString, new AbstractAction()
    {
      @Override
      public void actionPerformed(final ActionEvent e)
      {
        five.doClick();
      }
    });
    // six button
    tempString = "6";
    JButton six = new JButton(tempString);

    six.addActionListener(listener);
    gbc.gridx = 2;
    gbc.gridy = 2;
    add(six, gbc);

    im = one.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    am = one.getActionMap();
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_6, 0), tempString);
    am.put(tempString, new AbstractAction()
    {
      @Override
      public void actionPerformed(final ActionEvent e)
      {
        six.doClick();
      }
    });

    // seven button
    tempString = "7";
    JButton seven = new JButton(tempString);

    seven.addActionListener(listener);
    gbc.gridx = 0;
    gbc.gridy = 3;
    add(seven, gbc);

    im = one.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    am = one.getActionMap();
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_7, 0), tempString);
    am.put(tempString, new AbstractAction()
    {
      @Override
      public void actionPerformed(final ActionEvent e)
      {
        seven.doClick();
      }
    });

    // eight button
    tempString = "8";
    JButton eight = new JButton(tempString);

    eight.addActionListener(listener);
    gbc.gridx = 1;
    gbc.gridy = 3;
    add(eight, gbc);

    im = one.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    am = one.getActionMap();
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_8, 0), tempString);
    am.put(tempString, new AbstractAction()
    {
      @Override
      public void actionPerformed(final ActionEvent e)
      {
        eight.doClick();
      }
    });

    // nine button
    tempString = "9";
    JButton nine = new JButton(tempString);

    nine.addActionListener(listener);
    gbc.gridx = 2;
    gbc.gridy = 3;
    add(nine, gbc);

    im = one.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    am = one.getActionMap();
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_9, 0), tempString);
    am.put(tempString, new AbstractAction()
    {
      @Override
      public void actionPerformed(final ActionEvent e)
      {
        nine.doClick();
      }
    });

    // zero button
    tempString = "0";
    JButton zero = new JButton(tempString);

    zero.addActionListener(listener);
    gbc.gridx = 0;
    gbc.gridy = 4;
    gbc.gridwidth = 2;
    add(zero, gbc);
    gbc.gridwidth = 0;

    im = one.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    am = one.getActionMap();
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_0, 0), tempString);
    am.put(tempString, new AbstractAction()
    {
      @Override
      public void actionPerformed(final ActionEvent e)
      {
        zero.doClick();
      }
    });
    
    // focus button
    
    JButton focus = new JButton(DisplayPanel.FOCUS);
    focus.addActionListener(listener);
    focus.setFont(new Font("Default", 0, 6));
    gbc.gridx = 2;
    gbc.gridy = 4;
    add(focus, gbc);
    tempString = "F";
    im = one.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    am = one.getActionMap();
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_PERIOD, 0), tempString);
    am.put(tempString, new AbstractAction()
    {
      @Override
      public void actionPerformed(final ActionEvent e)
      {
        focus.doClick();
      }
    });
    
    // remove focus of buttons
    buttonPLUSMINUS.setFocusable(false);
    one.setFocusable(false);
    two.setFocusable(false);
    three.setFocusable(false);
    four.setFocusable(false);
    five.setFocusable(false);
    six.setFocusable(false);
    seven.setFocusable(false);
    eight.setFocusable(false);
    nine.setFocusable(false);
    zero.setFocusable(false);
    buttonLEFT.setFocusable(false);
    buttonClear.setFocusable(false);
    focus.setFocusable(false);
    
    listOfNumButtons.add(zero);
    listOfNumButtons.add(one);
    listOfNumButtons.add(two);
    listOfNumButtons.add(three);
    listOfNumButtons.add(four);
    listOfNumButtons.add(five);
    listOfNumButtons.add(six);
    listOfNumButtons.add(seven);
    listOfNumButtons.add(eight);
    listOfNumButtons.add(nine);

    listOfFuncButtons.add(buttonPLUSMINUS);
    listOfFuncButtons.add(buttonLEFT);
    listOfFuncButtons.add(buttonClear);
    listOfFuncButtons.add(focus);
    
    
    
    
  }
  
  /**
   * Returns list of number buttons.
   * @return ArrayList
   */
  public ArrayList<JButton> listOfNumButtons()
  {
    return this.listOfNumButtons;
  }
  
  /**
   * Returns list of number buttons.
   * @return ArrayList
   */
  public ArrayList<JButton> listOfFuncButtons()
  {
    return this.listOfFuncButtons;
  }
}
