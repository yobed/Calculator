package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;


/**
 * Separate class to deal with color scheme and configuration. The user can select
 * to change the colors of the buttons and their text on the main GUI. This will
 * allow them to open a new window to do that.
 * 
 * @author team05
 * @version 12/3/2021
 */
public class ColorScheme extends JPanel implements ChangeListener
{
 
  private static final long serialVersionUID = 1L;
  private JColorChooser chooser;
  private JLabel label;
  private Color color;
  private boolean whichColor;
  private ArrayList<JButton> numbuttons;
  private ArrayList<JButton> funcbuttons;
  private ArrayList<JButton> opbuttons;
  private ArrayList<JButton> selectedArray;
  private int lang;
  
  /**
   * Constructs a ColorScheme pane. Takes in the different button sections to change the color of. 
   * @param numbuttons the buttons with numbers of them (i.e. 0-9).
   * @param funcbuttons the buttons that deal with operations (i.e. Focus button)
   * @param opbuttons buttons that deal with operations on the calculator (i.e. +)
   * @param whichColor boolean that deals with which option was selected, 
   * the color of the foreground or background.
   * @param lang the language selected by the user. 
   */
  public ColorScheme(final ArrayList<JButton> numbuttons, final ArrayList<JButton> funcbuttons,
      final ArrayList<JButton> opbuttons, final boolean whichColor, final int lang) 
  {
    super(new BorderLayout());
    
    this.numbuttons = numbuttons;
    this.funcbuttons = funcbuttons;
    this.opbuttons = opbuttons;
    this.whichColor = whichColor;
    selectedArray = numbuttons;
    
    // Establishes the language option for ColorScheme.
    this.lang = lang;
    label = new JLabel("Color Scheme Chooser");
    if (this.lang == 1) label.setText(MultipleLanguages.SPANISHCOLORTHEMECHOOSER);
    if (this.lang == 2) label.setText(MultipleLanguages.FRENCHCOLORTHEMECHOOSER);
    
    JPanel bannerPanel = new JPanel(new BorderLayout());
    bannerPanel.add(label, BorderLayout.CENTER);
    if (this.lang == 0) bannerPanel.setBorder(BorderFactory.createTitledBorder("Label"));
    if (this.lang == 1)
      bannerPanel.setBorder(BorderFactory.createTitledBorder(MultipleLanguages.SPANISHLABEL));
    if (this.lang == 2)
      bannerPanel.setBorder(BorderFactory.createTitledBorder(MultipleLanguages.FRENCHLABEL));
    chooser = new JColorChooser(label.getForeground());
    chooser.getSelectionModel().addChangeListener(this);
    if (this.lang == 0) chooser.setBorder(BorderFactory.createTitledBorder("Choose Color"));
    if (this.lang == 1)
      chooser.setBorder(BorderFactory.createTitledBorder(MultipleLanguages.SPANISHCHOOSECOLOR));
    if (this.lang == 2)
      chooser.setBorder(BorderFactory.createTitledBorder(MultipleLanguages.FRENCHCHOOSECOLOR));
    chooser.setPreviewPanel(setPreviewPanel());
    
    add(bannerPanel, BorderLayout.CENTER);
    add(chooser, BorderLayout.PAGE_END);
  }
  
  /**
   * Opens the colorWindow from the main Fragile GUI.
   * @param type the type the user selected on the main menu. 
   */
  public void openColorWindow(final String type)
  {
    JFrame frame = new JFrame("ColorSchemeChooser");
    if (this.lang == 1) frame.setTitle(MultipleLanguages.SPANISHCOLORTHEMECHOOSER);
    if (this.lang == 2) frame.setTitle(MultipleLanguages.FRENCHCOLORTHEMECHOOSER);
    frame.setSize(getPreferredSize());
    
    JComponent newContentPane = new ColorScheme(numbuttons, funcbuttons, opbuttons, whichColor,
        this.lang);
    newContentPane.setOpaque(true);
    frame.setContentPane(newContentPane);

    frame.pack();
    frame.setVisible(true);
  }

  @Override
  public void stateChanged(final ChangeEvent e)
  {
    // will change the color of the selected section of buttons.
    // some code taken from Oracle about ColorChooser: 
    // https://docs.oracle.com/javase/tutorial/uiswing/components/colorchooser.html
    Color newColor = chooser.getColor();
    label.setForeground(newColor);
    color = newColor;
    // changes either the foreground or background.
    if (whichColor) 
    {
      changeColorArray(selectedArray);
    } else 
    {
      changeBackGroundColor(selectedArray);
    }
    
  }

  /**
   * Changes the foregound of the selected button section.
   * @param buttons the section of buttons to be changed.
   */
  public void changeColorArray(final ArrayList<JButton> buttons)
  {
    for(JButton button: buttons)
    {
      button.setForeground(color);
    }
  }
  
  private JPanel setPreviewPanel()
  {
    JLabel labelTemp = null;
    JButton g1 = null; // both will never be null
    JButton g2;
    JButton g3;
    if (this.lang == 0)
    {
      labelTemp = new JLabel("Select Button Group");
      g1 = new JButton("Functions");
      g2 = new JButton("Numbers");
      g3 = new JButton("Operators");
    } else if (this.lang == 2)
    {
      labelTemp = new JLabel(MultipleLanguages.FRENCHSELECTBTN);
      g1 = new JButton(MultipleLanguages.FRENCHFUNCTIONS);
      g2 = new JButton(MultipleLanguages.FRENCHNUMBERS);
      g3 = new JButton(MultipleLanguages.FRENCHOPERATORS);
    } else
    {
      labelTemp = new JLabel(MultipleLanguages.SPANISHSELECTBTN);
      g1 = new JButton(MultipleLanguages.SPANISHFUNCTIONS);
      g2 = new JButton(MultipleLanguages.SPANISHNUMBERS);
      g3 = new JButton(MultipleLanguages.SPANISHOPERATORS);
    } 
    
    // Creates the buttons in the "Preview" section. The user chooses the section
    // of buttons they want changed based off of these. 
    g1.addActionListener(new ActionListener() 
    { 
      public void actionPerformed(final ActionEvent e) 
      {
        changeSelectedArray(funcbuttons);
      } 
    });
    
    g2.addActionListener(new ActionListener() 
    { 
      public void actionPerformed(final ActionEvent e)
      { 
        changeSelectedArray(numbuttons);
      } 
    });
    
    g3.addActionListener(new ActionListener() 
    { 
      public void actionPerformed(final ActionEvent e)
      { 
        changeSelectedArray(opbuttons);
      } 
    });
     
    
    g3.addActionListener(new ActionListener() 
    { 
      public void actionPerformed(final ActionEvent e)
      { 
        changeSelectedArray(opbuttons);
      } 
    });
    JPanel preview = new JPanel();
    preview.add(labelTemp);
    preview.add(g1);
    preview.add(g2);
    preview.add(g3);
    
    return preview;
  }
  
  /**
   * Changes the selected array based off of what preview the user chooses. 
   * @param buttons the selected array of buttons.
   */
  public void changeSelectedArray(final ArrayList<JButton> buttons) 
  {
    selectedArray = buttons;
  }
  
  /**
   * Changes the backgound of the selected button section.
   * @param bgSelectedArray the section of buttons to be changed. 
   */
  public void changeBackGroundColor(final ArrayList<JButton> bgSelectedArray)
  {
    for(JButton button: bgSelectedArray) 
    {
      button.setBackground(color);
    }
  }
  
  /**
   * Sets the BCOLOR vs BGCOLOR value. (Foreground vs Background)
   * @param colorValue the boolean value. 
   */
  public void setWhichColor(final boolean colorValue)
  {
    whichColor = colorValue;
  }
  
}
