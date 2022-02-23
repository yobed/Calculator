package gui;

import math.*;
import javax.swing.*;

import formating.FragileDelegatingPrintable;
import formating.FragileSaveFile;
import formating.TypeSettingStyle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The DisplayPanel displayed the current MixedFraction(s) (with any operator(s)).
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author team05
 * @version V1
 */
public class DisplayPanel extends JPanel
{
  public static final String R_CARROT = ">";
  public static final String L_CARROT = "<";
  public static final String START = "Start";
  public static final String SAVE = "Save";
  public static final String STOP = "Stop";
  public static final String LOAD = "Load";
  public static final String WEBSITE = "Website";
  public static final String PRINT = "Print Screen";
  public static final String ABOUT = "About";
  public static final String BGCOLORS = "Background Colors";
  public static final String BCOLORS = "Button Colors";
  public static final String TCOLOR = "Text Color";
  public static final String REDUCE = "Reduced";
  public static final String IRREDUCE = "Irreduced";
  public static final String BAR = "Bar";
  public static final String ADD = "\u002B";
  public static final String SUBTRACT = "\u002D";
  public static final String MULTIPLY = "\u00D7";
  public static final String DIVIDE = "\u00F7";
  public static final String RESET = "R";
  public static final String CLEAR = "C";
  public static final String INV = "Inv";
  public static final String MED = "Med";
  public static final String POW = "Pow";
  public static final String EQUALS = "\u003D";
  public static final String PLUSMINUS = "\u00B1";
  public static final String LEFTARROW = "\u2190";
  public static final String HISTORY = "Show History";
  public static final String SPACE = " ";
  public static final String SLASH = "/";
  public static final String FOCUS = "<html><div class=\"top\">&#9605;</div><div clas="
      + "\\\"middle\\\"" + ">&#9472;<div<div class=\"bottom\">&#9605;</div><html>";
  public static final String ONE = "1";
  public static final String TWO = "2";
  public static final String THREE = "3";
  public static final String FOUR = "4";
  public static final String FIVE = "5";
  public static final String SIX = "6";
  public static final String SEVEN = "7";
  public static final String EIGHT = "8";
  public static final String NINE = "9";
  public static final String ZERO = "0";

  private static String slash = "Slash";
  private static final long serialVersionUID = 1L;
  private static boolean toReduce;
  private static boolean toIrreduce;
  private JLabel text; // a
  private Focus focus;
  private String foc1 = "";
  private String foc2 = "";
  private String currentText;
  private ActionListener listener;
  private String operand;
  private String who = "";
  private String num = "";
  private String denom = "";
  private String style = slash;

  // dynamic list of fracs/ ops, is changed / deleted from
  private ArrayList<String> operands;
  private ArrayList<MixedFraction> fractions;

  // dynamic list of fracs/ops, should NEVER! be deleted from, only added too
  private ArrayList<MixedFraction> allFractions;
  private ArrayList<String> allOperands;

  // list of recorded fracs / ops
  private ArrayList<MixedFraction> recordedFractions;
  private ArrayList<String> recordedOperands;

  // set of flags for internal operation
  private boolean isNegative;
  private boolean hasPressedPlusMinButton;

  private boolean toRecord;

  /**
   * The constructor for DisplayPanel.
   */
  public DisplayPanel()
  {

    allFractions = new ArrayList<MixedFraction>();
    allOperands = new ArrayList<String>();

    fractions = new ArrayList<MixedFraction>(3);
    operands = new ArrayList<String>();

    recordedFractions = new ArrayList<MixedFraction>();
    recordedOperands = new ArrayList<String>();

    isNegative = false;

    toReduce = false;
    toIrreduce = false;

    this.setPreferredSize(new Dimension(150, 105));
    this.setBackground(new Color(173, 216, 230));
    text = new JLabel("");
    text.setFont(new Font("Calibri", Font.PLAIN, 20));
    this.setLayout(new FlowLayout(FlowLayout.LEFT));
    setBorder(BorderFactory.createEtchedBorder());
    setForeground(Color.BLUE);
    currentText = "";
    operand = "";
    createFocus();
    updateDisplay();

  }

  /**
   * Updates the display text.
   */
  public void updateDisplay()
  {
    if (currentText.equals(""))
    {
      setForeground(Color.BLUE);
      text.setText("Enter Numbers Now... or else :)");
    } else if (fractions.size() == 0)
    {
      focus.updateFocus(currentText, isNegative, hasPressedPlusMinButton);
    } else
    {
      focus.updateFocus(currentText.substring(currentText.indexOf(operand) + 2), isNegative,
          hasPressedPlusMinButton);
    }
    hasPressedPlusMinButton = false;
  }

  /**
   * Updates the operand within display.
   * 
   * @param ac
   */
  public void updateOperand(final String ac)
  {
    updateAllOperand(ac);
    add(text);
    if (operands.size() > 1 && !ac.equals(EQUALS))
    {
      updateAnswer(ac);
      text.setText(currentText);
      operands.clear();
      operands.add(ac);
      resetFocus();
      return;
    }
    if (operand.length() == 0)
    {
      operand = ac;
      foc1 = focus.fraction().toString() + SPACE + ac + SPACE;
      currentText = foc1;
      operands.add(ac);
    } else if (ac.equals(EQUALS))
    {
      foc2 = focus.fraction().toString() + SPACE + EQUALS + SPACE;
      currentText = foc1 + foc2;
      operands.add(ac);
    }
    isNegative = false;
    MixedFraction hold = focus.fraction();
    fractions.add(hold);
    updateAllFractions(hold);
    text.setText(currentText);
    resetFocus();
  }

  /**
   * adds operand to current allOperand array.
   * 
   * @param op
   */
  private void updateAllOperand(final String op)
  {
    allOperands.add(op);
    if (toRecord)
      recordedOperands.add(op);
  }

  /**
   * adds fraction f to all internal arrays which need it, always add to allFractions.
   * 
   * @param f
   */
  public void updateAllFractions(final MixedFraction f)
  {
    allFractions.add(f);
    if (toRecord)
      recordedFractions.add(f);
  }

  /**
   * Switches to correct style based on attribute style.
   */
  public void switchToStyle()
  {
    if (this.style.equals("Solidus"))
    {
      if (fractions.size() != 0)
      {
        if (fractions.size() == 1)
        {
          this.currentText = TypeSettingStyle.setSolidus(fractions.get(0)) + operand;
        }
        if (fractions.size() == 2)
        {
          this.currentText = TypeSettingStyle.setSolidus(fractions.get(0)) + operand
              + TypeSettingStyle.setSolidus(fractions.get(1));
        }
        if (fractions.size() == 3)
        {
          this.currentText = TypeSettingStyle.setSolidus(fractions.get(0)) + operand
              + TypeSettingStyle.setSolidus(fractions.get(1)) + EQUALS
              + TypeSettingStyle.setSolidus(fractions.get(2));
        }
        updateCurrent();
      }
    }
    if (this.style.equals(slash))
    {
      if (fractions.size() != 0)
      {
        if (fractions.size() == 1)
        {
          this.currentText = fractions.get(0).toString() + operand;
        }
        if (fractions.size() == 2)
        {
          this.currentText = fractions.get(0).toString() + operand + fractions.get(1).toString();
        }
        if (fractions.size() == 3)
        {
          this.currentText = fractions.get(0).toString() + operand + fractions.get(1).toString()
              + EQUALS + fractions.get(2).toString();
        }
        updateCurrent();
      }
    }
    if (this.style.equals(BAR))
    {
      setBarStyle();
      updateCurrent();
    }
  }

  /**
   * Sets the currentText to the JLabel.
   */
  public void updateCurrent()
  {
    text.setText(currentText);
  }

  /**
   * Updates the display when a user presses equals.
   */
  public void updateEquals()
  {
    MixedFraction result = calculate();

    fractions.add(result);
    updateAllFractions(result);

    // i don't .get(2) is doing
    // fractions stores the result at index 2 so this adds the fraction to the current text
    // so that it can be displayed.
    currentText += fractions.get(2);
    updateCurrent();
  }

  /**
   * Updates the answer.
   * 
   * @param ac
   */
  public void updateAnswer(final String ac)
  {
    // Removes the previous two fractions entered. Stores the answer.
    fractions.remove(0);
    fractions.remove(0);
    MixedFraction frac = fractions.get(0);

    int w;
    int n;
    int d;
    // tests if the display is set to irreduced.
    if (toIrreduce)
    {
      w = 0;
      n = frac.getIrreducedNum();
      d = frac.getDenominator();
    } else
    {
      w = frac.getWhole();
      n = frac.getNumerator();
      d = frac.getDenominator();
    }

    remove(focus.whole());
    remove(focus.numerator());
    remove(focus.denominator());
    focus = new Focus(Integer.toString(w), Integer.toString(n), Integer.toString(d));
    add(focus.whole());
    add(focus.numerator());
    add(focus.denominator());
    foc1 = focus.fraction().toString() + SPACE + ac + SPACE;
    foc2 = "";
    currentText = foc1;
    isNegative = false;

  }

  /**
   * Calculate the answer.
   * 
   * @return MixedFraction
   */
  public MixedFraction calculate()
  {
    MixedFraction result = null; // will never be null!
    switch (operand) 
    {
      case ADD:
        result = MixedFractionOperations.add(fractions.get(0), fractions.get(1));
        break;
      case SUBTRACT:
        result = MixedFractionOperations.subtract(fractions.get(0), fractions.get(1));
        break;
      case MULTIPLY:
        result = MixedFractionOperations.multiply(fractions.get(0), fractions.get(1));
        break;
      case DIVIDE:
        result = MixedFractionOperations.divide(fractions.get(0), fractions.get(1));
        break;
      case INV:
        result = OtherMixedFractionOperations.multiplicativeInverse(fractions.get(0));
        break;
      case MED:
        result = OtherMixedFractionOperations.mediant(fractions.get(0), fractions.get(1));
        break;
      case POW:
        result = OtherMixedFractionOperations.integerPower(fractions.get(0),
          fractions.get(1).getWhole());
        break;
      default:
        break;
    }

    return result;
  }

  /**
   * Sets the current style to n.
   * 
   * @param n String
   */
  public void setStyle(final String n)
  {
    this.style = n;
  }

  /**
   * Adds the string to the currentText.
   * 
   * @param n
   */
  public void addToCurrentText(final String n)
  {
    this.currentText += n;
  }

  /**
   * Returns the CurrentText String.
   * 
   * @return String
   */
  public String getCurrentText()
  {
    return this.currentText;
  }

  /**
   * Returns the current focus.
   * 
   * @return Focus
   */
  public Focus getFocus()
  {
    return this.focus;
  }

  /**
   * Sets current text to bar style.
   */
  public void setBarStyle()
  {
    if (fractions.size() != 0)
    {
      if (fractions.size() == 1)
      {
        this.currentText = TypeSettingStyle.setBar(fractions.get(0), operand);
      }

      if (fractions.size() >= 2)
      {
        this.currentText = TypeSettingStyle.setBar(fractions.get(0), operand, fractions.get(1),
            fractions.get(2));
      }
    }
  }

  /**
   * Resets the entire display of anything that has been typed.
   */
  public void updateReset()
  {
    focus.clear();
    fractions.clear();
    this.currentText = "";
    this.operand = "";
    operands.clear();
    foc1 = "";
    foc2 = "";
    updateCurrent();
  }

  /**
   * Changes current fraction display to a reducedFraction. TODO. waiting on proper display
   * formating.
   */
  public void reduceFractionDisplay()
  {
    toIrreduce = false;
    toReduce = true;
  }

  /**
   * Changes current fraction display to a reducedFraction. TODO. waiting on proper display
   * formating.
   */
  public void irreducedFractionDisplay()
  {
    toIrreduce = true;
    toReduce = false;
  }

  /**
   * Used to backspace according to where the focus is currently at in the mixed fraction.
   */
  public void backpace()
  {
    focus.backspace();
    currentText = focus.who() + focus.num() + focus.denom();
  }

  /**
   * Used to clear the focus and make the current mixed fraction completely blank.
   */
  public void clear()
  {
    focus.clear();
  }

  /**
   * Creates the focus for the Display panel so that fractions can be entered. This happens in the
   * DisplayPanel Constructor.
   */
  public void createFocus()
  {
    focus = new Focus();
    add(focus.whole());
    add(focus.numerator());
    add(focus.denominator());
  }

  /**
   * This method removes the focus from the first fraction and switches it to the second fraction
   * after an operand is input. This method is called in update operand of the Display Panel Class.
   */
  public void resetFocus()
  {
    remove(focus.whole());
    remove(focus.numerator());
    remove(focus.denominator());
    focus.clear();
    add(focus.whole());
    add(focus.numerator());
    add(focus.denominator());
  }

  /**
   * Returns all operands used in current equation.
   * 
   * @return array of operands
   */
  public ArrayList<String> getOperands()
  {
    return operands;
  }

  /**
   * returns allOperands Array.
   * 
   * @return allOperands
   */
  public ArrayList<String> getAllOperands()
  {
    return allOperands;
  }

  /**
   * Returns array of all currently used mixedFractions.
   * 
   * @return fractions
   */
  public ArrayList<MixedFraction> getFractions()
  {
    return fractions;
  }

  /**
   * returns allFractions array.
   * 
   * @return allFractions
   */
  public ArrayList<MixedFraction> getAllFractions()
  {
    return allFractions;
  }

  /**
   * Sets the current mixedFraction.
   */
  public void setPlusMinus()
  {
    isNegative = !isNegative;
    hasPressedPlusMinButton = true;
    updateDisplay();
  }

  /**
   * Sets record flag and if record is false, wipe arrays.
   * 
   * @param record
   */
  public void setRecord(final boolean record)
  {
    toRecord = record;
    if (!toRecord)
      stopRecord();
  }

  /**
   * wipes recorded info in arrays.
   */
  private void stopRecord()
  {
    recordedFractions.clear();
    recordedOperands.clear();
  }

  /**
   * recordFractions getter.
   * 
   * @return recordedFractions arr
   */
  public ArrayList<MixedFraction> getRecordedFracs()
  {
    return recordedFractions;
  }

  /**
   * recordOperands getter.
   * 
   * @return recordOperands arr
   */
  public ArrayList<String> recordOperands()
  {
    return recordedOperands;
  }

  /**
   * Loads in information from saveFile to display. TODO. Make work, someone NEEDS to rewrite
   * focus/make it easier to work with display.
   * 
   * @param saveFile input saveFile object
   */
  public void loadSave(final FragileSaveFile saveFile)
  {
    ArrayList<MixedFraction> loadedFractions = saveFile.getFractions();
    ArrayList<String> loadedOperands = saveFile.getOperands();

    allFractions = (ArrayList<MixedFraction>) loadedFractions.clone();
    allOperands = (ArrayList<String>) loadedOperands.clone();
    recordedFractions.clear();
    recordedOperands.clear();
    // Todo. Nonfunctioning?
    // if (false)
    
    if (allFractions.size() > 0 && allOperands.size() > 0)
    {
      MixedFraction answer = allFractions.get(allFractions.size() - 1);
      String ac = allOperands.get(allOperands.size() - 1);

      operand = ac;
      focus = new Focus("" + answer.getWhole(), "" + answer.getNumerator(),
          "" + answer.getDenominator());
      foc1 = focus.fraction().toString() + SPACE + ac + SPACE;
      currentText = foc1;
      operands.add(ac);
      isNegative = false;
      MixedFraction hold = focus.fraction();
      fractions.add(hold);
      updateDisplay();
    }
  }

  /**
   * Used to interact with the ColorScheme Menu.
   * 
   * @return the text, so that the color can be changed.
   */
  public JLabel getText()
  {
    return this.text;
  }

  /**
   * If the print button is pressed, gets printableObject for parent window.
   * 
   * @return the delegatingPrintable
   */
  public FragileDelegatingPrintable printScreenHelper()
  {
    return new FragileDelegatingPrintable(this.getRootPane());
  }

  /**
   * Clears the focus.
   */
  public void clearFocus()
  {
    this.focus.clear();
  }

  /**
   * gets the parent frame of display, used for printing purposes.
   * 
   * @return parent Frame.
   */
  public JFrame getParentFrame()
  {
    return (JFrame) SwingUtilities.getWindowAncestor(this);
  }

  /**
   * RunningCalculations.
   * 
   * @param ac
   */
  public void runningCalculation(final String ac)
  {
    add(text);

    MixedFraction answer = fractions.get(2);
    fractions.remove(0);
    fractions.remove(0);
    updateReset();
    operand = ac;
    operands.add(ac);
    if (toRecord)
      recordedOperands.add(ac);
    foc1 = answer.toString() + SPACE + ac + SPACE;
    currentText = foc1;
    isNegative = false;
    fractions.add(answer);
    text.setText(currentText);
    resetFocus();
  }

  /**
   * Returns toReduce boolean.
   * 
   * @return boolean
   */
  public static boolean toReduce()
  {
    return toReduce;
  }

  /**
   * Returns toIrreduce boolean.
   * 
   * @return boolean
   */
  public static boolean toIrreduce()
  {
    return toIrreduce;
  }

  /**
   * Returns toReduce boolean.
   * 
   * @param n boolean
   */
  public static void settoReduce(final boolean n)
  {
    toReduce = n;
  }

  /**
   * Returns toIrreduce boolean.
   * 
   * @param n boolean
   */
  public static void settoIrreduce(final boolean n)
  {
    toIrreduce = n;
  }

}
