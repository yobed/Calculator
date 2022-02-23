package gui;

import java.awt.Color;
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
 * The CompositeButtons hold the buttons to be displayed in the GUI.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author team05
 * @version V1
 */
public class RightButtons extends JPanel
{

  
  private static final long serialVersionUID = 1L;
  private ActionListener listener;
  private GridBagConstraints gbc = new GridBagConstraints();
  private ArrayList<JButton> listOfButtons = new ArrayList<JButton>();
  
  

  /**
   * CompositeButtons constructor.
   * 
   * @param listener
   */
  public RightButtons(final ActionListener listener)
  {

    this.listener = listener;
    setLayout(new GridBagLayout());

    // examples for buttons (may need change on whether we do it this way)
    JButton buttonReset = new JButton(DisplayPanel.RESET);
    buttonReset.setForeground(new Color(0, 191, 255));
    listOfButtons.add(buttonReset);
    buttonReset.addActionListener(listener);

    //
    JButton buttonSUBTRACT = new JButton(DisplayPanel.SUBTRACT);
    buttonSUBTRACT.setForeground(new Color(0, 191, 255));
    listOfButtons.add(buttonSUBTRACT);
    buttonSUBTRACT.addActionListener(listener);

    InputMap im = buttonSUBTRACT.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    ActionMap am = buttonSUBTRACT.getActionMap();
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0), DisplayPanel.SUBTRACT);
    am.put(DisplayPanel.SUBTRACT, new AbstractAction()
    {
      @Override
      public void actionPerformed(final ActionEvent e)
      {
        buttonSUBTRACT.doClick();
      }
    });
    // multiply
    JButton buttonMULTIPLY = new JButton(DisplayPanel.MULTIPLY);
    buttonMULTIPLY.setForeground(new Color(0, 191, 255));
    listOfButtons.add(buttonMULTIPLY);
    buttonMULTIPLY.addActionListener(listener);

    im = buttonMULTIPLY.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    am = buttonMULTIPLY.getActionMap();
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_8, KeyEvent.SHIFT_DOWN_MASK), DisplayPanel.MULTIPLY);
    am.put(DisplayPanel.MULTIPLY, new AbstractAction()
    {
      @Override
      public void actionPerformed(final ActionEvent e)
      {
        buttonMULTIPLY.doClick();
      }
    });
    // divide
    JButton buttonDIVIDE = new JButton(DisplayPanel.DIVIDE);
    buttonDIVIDE.setForeground(new Color(0, 191, 255));
    listOfButtons.add(buttonDIVIDE);
    buttonDIVIDE.addActionListener(listener);

    im = buttonDIVIDE.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    am = buttonDIVIDE.getActionMap();
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SLASH, 0), DisplayPanel.DIVIDE);
    am.put(DisplayPanel.DIVIDE, new AbstractAction()
    {
      @Override
      public void actionPerformed(final ActionEvent e)
      {
        buttonDIVIDE.doClick();
      }
    });

    // equals button
    String tempString = "=";
    JButton buttonEQUALS = new JButton(DisplayPanel.EQUALS);
    buttonEQUALS.setForeground(new Color(0, 191, 255));
    listOfButtons.add(buttonEQUALS);
    buttonEQUALS.addActionListener(listener);
    im = buttonEQUALS.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    am = buttonEQUALS.getActionMap();
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), tempString);
    am.put(tempString, new AbstractAction()
    {
      @Override
      public void actionPerformed(final ActionEvent e)
      {
        buttonEQUALS.doClick();
      }
    });
    

    // inv button
    JButton buttonInv = new JButton(DisplayPanel.INV);
    buttonInv.setForeground(new Color(0, 191, 255));
    listOfButtons.add(buttonInv);
    buttonInv.addActionListener(listener);
    
    // power button
    JButton buttonPow = new JButton("Pow");
    buttonPow.setForeground(new Color(0, 191, 255));
    listOfButtons.add(buttonPow);
    buttonPow.addActionListener(listener);
    
    // mediant button
    JButton buttonMed = new JButton(DisplayPanel.MED);
    buttonMed.setForeground(new Color(0, 191, 255));
    listOfButtons.add(buttonMed);
    buttonMed.addActionListener(listener);

    // add button
    JButton buttonADD = new JButton(DisplayPanel.ADD);
    buttonADD.setForeground(new Color(0, 191, 255));
    listOfButtons.add(buttonADD);
    buttonADD.addActionListener(listener);
    im = buttonADD.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    am = buttonADD.getActionMap();
    tempString = "+";
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, KeyEvent.SHIFT_DOWN_MASK), tempString);
    am.put(tempString, new AbstractAction()
    {
      @Override
      public void actionPerformed(final ActionEvent e)
      {
        buttonADD.doClick();
      }
    });
    
    // IntermediateSteps Button
    JButton buttonISteps= new JButton (DisplayPanel.L_CARROT);
    buttonISteps.setForeground(new Color(0, 191, 255));
    listOfButtons.add(buttonISteps);
    buttonISteps.addActionListener(listener);
    
    // Remove focus of buttons
    buttonADD.setFocusable(false);
    buttonDIVIDE.setFocusable(false);
    buttonMULTIPLY.setFocusable(false);
    buttonSUBTRACT.setFocusable(false);
    buttonInv.setFocusable(false);
    buttonPow.setFocusable(false);
    buttonEQUALS.setFocusable(false);
    buttonReset.setFocusable(false);
    buttonISteps.setFocusable(false);
    
    
    
    gbc.insets = new Insets(0, 5, 5, 5);
    gbc.fill = GridBagConstraints.BOTH;
    gbc.gridx = 0;
    gbc.gridy = 0;
    add(buttonADD, gbc);
    gbc.gridx = 0;
    gbc.gridy = 1;
    add(buttonSUBTRACT, gbc);
    gbc.gridx = 0;
    gbc.gridy = 2;
    add(buttonMULTIPLY, gbc);
    gbc.gridx = 0;
    gbc.gridy = 3;
    add(buttonDIVIDE, gbc);
    gbc.gridx = 0;
    gbc.gridy = 4;
    add(buttonEQUALS, gbc);
    gbc.gridx = 1;
    gbc.gridy = 0;
    add(buttonReset, gbc);
    gbc.gridx = 1;
    gbc.gridy = 1;
    add(buttonMed, gbc);
    gbc.gridx = 1;
    gbc.gridy = 2;
    add (buttonISteps, gbc);
  }

  
  /**
   * Returns the list of buttons.
   * @return ArrayList
   */
  public ArrayList<JButton> listOfButtons() 
  {
    return this.listOfButtons;
  }
}
