package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.JLabel;


import math.MixedFraction;
/**
 * Allows for the user to cycle through the whole, numerator, and denominator portion of the mixed
 * fraction they are entering. If the button is pressed the focus will change to the next focus in
 * the cycle. If the user backspaces while the section of focus is empty it will return the focus to
 * the previous section.
 * 
 * @author ashdonhess
 */
public class Focus
{
  private String slashspace = "/ ";
  private String who = "";
  private String num = "";
  private String denom = slashspace;
  private int w = 0;
  private int n = 0;
  private int d = 0;
  private JLabel whole = new JLabel("");
  private JLabel numerator = new JLabel("");
  private JLabel denominator = new JLabel("");
  private MixedFraction fraction;
  private boolean isNegative;

  /**
   * Default Constructor for focus sets up the JLabels that will be cycled through one for whole,
   * numerator, and denominator. Adds a cycle for the focus so that it knows the order to 
   * go through.
   */
  public Focus()
  {
    ArrayList<JLabel> h = new ArrayList<>();
    h.add(whole);
    h.add(numerator);
    h.add(denominator);
    for (int i = 0; i < h.size(); i++)
    {
      h.get(i).setVisible(true);
      h.get(i).setFont(new Font("Calibri", Font.PLAIN, 20)); // Set fonts for the labels
      h.get(i).setOpaque(true); // If focus is on you will be able to see
      h.get(i).setFocusable(true); // Enable focus for each label
    }
    isNegative = false;
    // Whole begins with the focus
    whole.setFocusCycleRoot(true);
    addfocusListeners();
  }

  /**
   * Explicit constructor for focus so that each part of the fraction can be initialized.
   * 
   * @param whole the whole integer of the fraction as a string.
   * @param numerator the numerator of the fraction as a string.
   * @param denominator the denominator of the fraction as a string.
   */
  public Focus(final String whole, final String numerator, final String denominator)
  {
    this();
    this.who = whole;
    this.num = numerator;
    this.denom = denom + denominator;
    this.updateMixedFraction();
  }

  /**
   * Updates the focus object based on the changes being made to current text and where the focus 
   * of the fraction currently is. Assigning the new text to the correct location.
   * 
   * @param currentText the new changes to add to the fraction.
   * @param issNegative the fraction is positive or negative.
   * @param hasPressedPlusMinButton the plusMinus button has been pressed.
   */
  public void updateFocus(final String currentText, final boolean issNegative,
      final boolean hasPressedPlusMinButton)
  {
    this.isNegative = issNegative;
    // done to prevent adding addition #'s after button push
    if (hasPressedPlusMinButton)
    {
      if (isNegative)
        who = DisplayPanel.SUBTRACT + who;
      else if (!isNegative && who.length() > 0)
        who = who.substring(1);
      whole.setText(who);
      updateMixedFraction();
      return;
    }
    if (whole.hasFocus())
    {
      who += currentText.substring(currentText.length() - 1);
      whole.setText(who);
    } else if (numerator.hasFocus())
    {
      if (currentText.length() == 1 && who.equals(""))
      {
        num = currentText;
      } else if (currentText.equals(""))
      {
        num = currentText;
      } else
      {
        num += currentText.substring(currentText.length() - 1);
      }
      numerator.setText(num);
    }
    else if (denominator.hasFocus())
    {
      if (currentText.equals(""))
      {
        denom = "";
      } else if (denom.equals(slashspace) && currentText.length() == 1)
      {
        denom = currentText;
      } else
      {
        denom += currentText.substring(currentText.length() - 1);
      }
      denominator.setText(denom);
    }
    updateMixedFraction();
  }

  /**
   * When the focus button is pushed again the focus is changed to the next part of the fraction 
   * based on where the current index of the cycle is. Called in Observer when the AC = FOCUS.
   */
  public void changeFocusForward()
  {
    if (denominator.hasFocus())
    {
      whole.requestFocus();
      return;
    } else if (numerator.hasFocus())
    {
      denominator.requestFocus();
      return;
    } else if (whole.hasFocus())
    {
      numerator.requestFocus();
      return;
    }
  }

  /**
   * This is the changes that are made from current text on the string representation of whole, 
   * numerator, denominator. This is Called in the updateFraction method of this class.
   */
  public void updateMixedFraction()
  {
    if (!who.equals(""))
      w = Integer.parseInt(who);
    if (!num.equals(""))

      n = Integer.parseInt(num);

    if (!denom.equals(slashspace) && !denom.equals(""))
    {
      String sub = denom.substring(2);
      d = Integer.parseInt(sub);
    }
    this.fraction = new MixedFraction(w, n, d);
  }

  /**
   * Adds the focus listeners to each label of the fraction. This is a helper method used to clean 
   * up code. Called in the Default Constructor of this class.
   */
  public void addfocusListeners()
  {
    // Add focus listeners to each label
    whole.addFocusListener(new FocusAdapter()
    {
      @Override
      public void focusGained(final FocusEvent e)
      {
        whole.setBackground(Color.LIGHT_GRAY);
      }

      @Override
      public void focusLost(final FocusEvent e)
      {
        whole.setBackground(null);
      }
    });
    numerator.addFocusListener(new FocusAdapter()
    {
      @Override
      public void focusGained(final FocusEvent e)
      {
        numerator.setBackground(Color.LIGHT_GRAY);
      }

      @Override
      public void focusLost(final FocusEvent e)
      {
        numerator.setBackground(null);
      }
    });
    denominator.addFocusListener(new FocusAdapter()
    {
      @Override
      public void focusGained(final FocusEvent e)
      {
        denominator.setBackground(Color.LIGHT_GRAY);
      }

      @Override
      public void focusLost(final FocusEvent e)
      {
        denominator.setBackground(null);
      }
    });
  }

  /**
   * This is the method called when the user wants to backspace and clear a character in the 
   * current focus of the fraction. This is called in the observer class when AC = LeftArrow the 
   * display panel will then call the focus to backspace.
   */
  public void backspace()
  {
    if (whole.hasFocus())
    {
      if (who.length() > 0)
      {
        who = who.substring(0, who.length() - 1);
        whole.setText(who);
      } else
      {
        denominator.requestFocus();
      }
    } else if (numerator.hasFocus())
    {
      if (num.length() > 0)
      {
        num = num.substring(0, num.length() - 1);
        numerator.setText(num);
      } else
      {
        whole.requestFocus();
      }
    } else if (denominator.hasFocus())
    {
      if (denom.length() > 2)
      {
        denom = denom.substring(0, denom.length() - 1);
        denominator.setText(denom);
      } else
      {
        numerator.requestFocus();
      }
    }
    updateMixedFraction();
  }
  
  /**
   * Gets the fraction.
   * @return MixedFraction
   */
  public MixedFraction fraction()
  {
    return this.fraction;
  }
  
  
  /**
   * Gets the string whole.
   * @return STRING
   */
  public String who()
  {
    return this.who;
  }

  /**
   * Gets the string denom.
   * @return STRING
   */
  public String denom()
  {
    return this.denom;
  }

  /**
   * Gets the string num.
   * @return STRING
   */
  public String num()
  {
    return this.num;
  }
  
  /**
   * Returns whole.
   * @return JLabel.
   */
  public JLabel whole()
  {
    return this.whole;
  }
  
  /**
   * Returns denom.
   * @return JLabel
   */
  public JLabel denominator()
  {
    return this.denominator;
  }
  
  /**
   * Returns numerator.
   * @return JLabel
   */
  public JLabel numerator()
  {
    return this.numerator;
  }
 

  /**
   * This method clears all of the inputs currently in the focus for the mixed fraction. This method
   * is called from the Display panel when AC = Clear, and is also called when the focus is reset 
   * in DisplayPanel.
   */
  public void clear()
  {
    who = "";
    num = "";
    denom = slashspace;
    w = 0;
    n = 0;
    d = 0;
    whole.setText("");
    numerator.setText("");
    denominator.setText("");
    fraction = null;
    whole.requestFocus();
    w = 0;
  }
}
