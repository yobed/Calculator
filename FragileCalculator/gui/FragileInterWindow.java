package gui;

import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import java.util.concurrent.TimeUnit;

import math.MixedFraction;
import javax.swing.*;

/**
 * Displays Intermediate Steps in a new seperate window from the the main JFrame.
 * 
 * @author Max
 *
 */
public class FragileInterWindow extends JWindow implements ComponentListener
{
  public static final String ENGLISH = "English";
  public static final String SPANISH = "Spanish";
  public static final String FRENCH = "French";
  
  private static final int LENGTH_Y = 175;
  private static final int NUM_ELEMENTS = 8;
  private static final int NUM_INCREMENTS = 1000;
  private static final int BEHIND_OFFSET = 25;
  private static final int SPACING = 50;

  private static final String NEWLINE = "\n";
  private static final String SPACE = " ";
  private static final String SLASH = "\\";
  private static final String MULT = "X";
  private static final String MULT2 = "*";
  private static final String ADD = "+";
  private static final String DIVIDE = "/";
  private static final String SUBTRACT = "-";

  
  // size of frame x / y
  private int displayX, displayY;

  private String langauge;

  // offset for labels in dialog
  private int intermediateSizeX;
  private int intermediateSizeY;
  // number of elements that can fit on a row

  private JButton closeButton;
  private JPanel centerPanel;
  private JTextArea textArea;
  private JScrollPane scrollPane;

  private ArrayList<JLabel> intermediateTextList;
  private LinkedList<MixedFraction> intermediateStepsFrac;
  private LinkedList<String> intermediateStepsOps;

  /**
   * Constructor for Intermediate Steps dialog.
   * 
   * @param f parent frame
   * @param displayX size of frame f
   * @param displayY size of frame f
   */
  public FragileInterWindow(final JFrame f, final int displayX, final int displayY)
  {
    // super(f);
    intermediateStepsFrac = new LinkedList<MixedFraction>();
    intermediateStepsOps = new LinkedList<String>();
    intermediateTextList = new ArrayList<JLabel>();

    langauge = ENGLISH;

    closeButton = new JButton(DisplayPanel.R_CARROT);
    centerPanel = new JPanel();
    // scrollPane = new JScrollPane();
    f.addComponentListener(this);

    setLayout(new BorderLayout());
    centerPanel.setLayout(new BorderLayout());
    setAlwaysOnTop(true);
    // num elements set a baseline of 8.
    for (int i = 0; i < NUM_ELEMENTS; i++)
    {
      intermediateTextList.add(new JLabel());
    }
    intermediateSizeX = NUM_ELEMENTS * SPACING + BEHIND_OFFSET;

    // setUndecorated(true);

    setAlwaysOnTop(false);
    //
    intermediateSizeY = 0;
    setSize(0, LENGTH_Y);
    this.displayX = displayX;
    this.displayY = displayY;
    this.setVisible(false);
    this.setLocationRelativeTo(f);
    int centerY = (displayY - LENGTH_Y) / 2;
    // 0
    this.setLocation(displayX + BEHIND_OFFSET, centerY);
    add(centerPanel, BorderLayout.CENTER);
  }

  /**
   * Adds in in order of precedence list of operations to internal list.
   * 
   * @param operations
   */
  public void enterOps(final List<String> operations)
  {
    intermediateStepsOps.addAll(operations);
  }

  /**
   * adds an in order of precedence mixedfractions to internal list.
   * 
   * @param frac
   */
  public void enterMixedFractions(final List<MixedFraction> frac)
  {
    intermediateStepsFrac.addAll(frac);
    while (intermediateTextList.size() < intermediateStepsFrac.size())
    {
      intermediateTextList.add(new JLabel());
    }
  }

  /**
   * Creates steps of mixedFraction for display in window. loops through current fractions /
   * operators. if possible it gets the fraction to left of operator the operator, and frac to
   * right. Then it shoots them to getExplaintion, gets the explanation math / text, then adds it to
   * a textarea for display.
   */
  public void interSteps()
  {
    while (!intermediateStepsFrac.isEmpty())
    {
      MixedFraction currentFrac = intermediateStepsFrac.poll();
      MixedFraction nextFrac = null;
      String currentOp = null;
      if (!intermediateStepsOps.isEmpty())
        currentOp = intermediateStepsOps.poll();
      // now check if op is equals
      if (!intermediateStepsFrac.isEmpty() && !DisplayPanel.EQUALS.equals(currentOp))
        nextFrac = intermediateStepsFrac.poll();

      addToScrollPane(getExplanination(currentFrac, nextFrac, currentOp));
      if (DisplayPanel.EQUALS.equals(currentOp))
      {
        intermediateStepsFrac.push(currentFrac);
      }
      repaint();
    }

    addButton();
  }

  /**
   * adds text to scrollPane.
   * 
   * @param text
   */
  private void addToScrollPane(final String text)
  {
    textArea.setText(textArea.getText() + text);
  }

  /**
   * Takes an input IE subtraction / addition and explains the operation on the fraction in plain
   * text. its big, its awful, but I don't know a better way of doing it than this.
   * 
   * @param left fraction to the left of operand
   * @param right null or fraction to right of operand
   * @param operand null or operand for fractions
   * @return the output String
   */
  public String getExplanination(final MixedFraction left, final MixedFraction right,
      final String operand)
  {
    if (operand == null)
      return "";
    // equals case
    if (right == null)
      return NEWLINE + operand + SPACE + left.toString() + NEWLINE;

    String explainationString = "";
    if (langauge.equals(ENGLISH))
    {

      if (operand.equals(DisplayPanel.SUBTRACT) || operand.equals(DisplayPanel.ADD)
          || operand.equals(ADD))
      {
        explainationString += "First multiple the fraction to the left of the " + operand
            + " sign by" + NEWLINE + "the denominator of the fraction to the right." + NEWLINE;
        explainationString += "So " + left.toString() + SPACE + "becomes " + left.getWhole() + SPACE
            + left.getNumerator() * right.getDenominator() + SLASH
            + left.getDenominator() * right.getDenominator();
        explainationString += NEWLINE + " And the fraction the right does the same," + NEWLINE
            + " so " + right.toString() + " becomes ";
        explainationString += right.getWhole() + SPACE
            + right.getNumerator() * left.getDenominator() + SLASH
            + right.getDenominator() * left.getDenominator();
        explainationString += " So you then are able to simply " + operand + " the whole " + NEWLINE
            + "numbers and the numerators and get";
      } else if (operand.equals(DisplayPanel.DIVIDE) || operand.equals(DIVIDE))
      {
        explainationString += "To divide, flip the irreduced right fraction, "
            + "and multiple as normal." + NEWLINE;
        explainationString += getExplanination(left,
            new MixedFraction(right.getWhole(), right.getDenominator(), right.getNumerator()),
            DisplayPanel.MULTIPLY);
      } else if (operand.equals(DisplayPanel.MULTIPLY) || operand.equals(MULT2))
      {
        explainationString += "First get the irreduced numerators of both the "
            + "left and the right fraction" + NEWLINE + "and multiply them together.";
        explainationString += "so now you have " + left.getIrreducedNum() + MULT
            + right.getIrreducedNum() + NEWLINE;
        explainationString += "do the same with the denominators so you get "
            + left.getDenominator() + MULT + right.getDenominator();
        explainationString += NEWLINE + "now you have "
            + left.getIrreducedNum() * right.getIrreducedNum() + SLASH
            + right.getDenominator() * left.getDenominator();
        explainationString += NEWLINE + "so all you have to do is get the simplify and get";
      }
    } else if (langauge.equals(FRENCH))
    {
      if (operand.equals(DisplayPanel.SUBTRACT) || operand.equals(DisplayPanel.ADD)
          || operand.equals(ADD))
      {
        explainationString += "Multipliez d'abord la fraction à gauche de " + operand
            + " signer par" + NEWLINE + "le dénominateur de la fraction à droite." + NEWLINE;
        explainationString += "Donc " + left.toString() + SPACE + "devient " + left.getWhole()
            + SPACE + left.getNumerator() * right.getDenominator() + SLASH
            + left.getDenominator() * right.getDenominator();
        explainationString += NEWLINE + " Et la fraction de droite fait de même," + NEWLINE
            + " alors " + right.toString() + " devient ";
        explainationString += right.getWhole() + SPACE
            + right.getNumerator() * left.getDenominator() + SLASH
            + right.getDenominator() * left.getDenominator();
        explainationString += " Ainsi, vous pouvez simplement " + operand + " la totalité "
            + NEWLINE + "les nombres et les numérateurs et obtenez";
      } else if (operand.equals(DisplayPanel.DIVIDE) || operand.equals(DIVIDE))
      {
        explainationString += "Pour diviser, retournez la fraction droite irréduite, "
            + "et multiple comme d'habitude." + NEWLINE;
        explainationString += getExplanination(left,
            new MixedFraction(right.getWhole(), right.getDenominator(), right.getNumerator()),
            DisplayPanel.MULTIPLY);
      } else if (operand.equals(DisplayPanel.MULTIPLY) || operand.equals(MULT2))
      {
        explainationString += "Obtenez d'abord les numérateurs irréductibles des deux"
            + "fraction gauche et droite" + NEWLINE + "et multipliez-les ensemble.";
        explainationString += "alors maintenant tu as " + left.getIrreducedNum() + " x "
            + right.getIrreducedNum() + NEWLINE;
        explainationString += "faire de même avec les dénominateurs pour obtenir "
            + left.getDenominator() + MULT + right.getDenominator();
        explainationString += NEWLINE + "maintenant vous avez "
            + left.getIrreducedNum() * right.getIrreducedNum() + SLASH
            + right.getDenominator() * left.getDenominator();
        explainationString += NEWLINE
            + "donc tout ce que vous avez à faire est de simplifier et d'obtenir";
      }
    } else if (langauge.equals(SPANISH))
    {
      if (operand.equals(DisplayPanel.SUBTRACT) || operand.equals(DisplayPanel.ADD)
          || operand.equals(ADD))
      {
        explainationString += "Primero multiplica la fracción a la izquierda del " + operand
            + " firmado por" + NEWLINE + "el denominador de la fracción de la derecha." + NEWLINE;
        explainationString += "Entonces " + left.toString() + SPACE + "se convierte en "
            + left.getWhole() + SPACE + left.getNumerator() * right.getDenominator() + SLASH
            + left.getDenominator() * right.getDenominator();
        explainationString += NEWLINE + " Y la fracción de la derecha hace lo mismo," + NEWLINE
            + " Entonces " + right.toString() + " se convierte en ";
        explainationString += right.getWhole() + SPACE
            + right.getNumerator() * left.getDenominator() + SLASH
            + right.getDenominator() * left.getDenominator();
        explainationString += " Entonces puedes simplemente " + operand + " El conjunto " + NEWLINE
            + "números y numeradores y obtén";
      } else if (operand.equals(DisplayPanel.DIVIDE) || operand.equals(DIVIDE))
      {
        explainationString += "Para dividir, voltea la fracción derecha irreducida, "
            + "y múltiples como de costumbre." + NEWLINE;
        explainationString += getExplanination(left,
            new MixedFraction(right.getWhole(), right.getDenominator(), right.getNumerator()),
            DisplayPanel.MULTIPLY);
      } else if (operand.equals(DisplayPanel.MULTIPLY) || operand.equals(MULT2))
      {
        explainationString += "Primero obtenga los numeradores irreducidos de ambos "
            + "fracción izquierda y derecha" + NEWLINE + "y multiplicarlos juntos.";
        explainationString += "así que ahora tienes " + left.getIrreducedNum() + MULT
            + right.getIrreducedNum() + NEWLINE;
        explainationString += "haz lo mismo con los denominadores para que obtengas "
            + left.getDenominator() + MULT + right.getDenominator();
        explainationString += NEWLINE + "ahora tu tienes "
            + left.getIrreducedNum() * right.getIrreducedNum() + SLASH
            + right.getDenominator() * left.getDenominator();
        explainationString += NEWLINE
            + "así que todo lo que tienes que hacer es simplificar y obtener";
      }
    }
    return explainationString;
  }
  
  /**
   * sets language of intermediateWindow.
   * @param s
   */
  public void setLanguage (final String s) 
  {
    langauge = s;
  }

  /**
   * adds a close > button to dialog. default color value and hardcoded closeButton size
   */
  private void addButton()
  {
    closeButton.setForeground(new Color(0, 191, 255));
    closeButton.setVisible(true);
    closeButton.setPreferredSize(new Dimension(50, 20));
    closeButton.setSize(closeButton.getPreferredSize());
    add(closeButton, BorderLayout.LINE_END);
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
   * Removes all current components of InterDialog and sets it to be invisible.
   */
  public void shutDown()
  {
    clearText();
    for (int i = 0; i < intermediateTextList.size(); i++)
    {
      intermediateTextList.get(i).setVisible(false);
      remove(intermediateTextList.get(i));
    }
    textArea.setText("");
    centerPanel.remove(scrollPane);
    closeButton.setVisible(false);
    remove(closeButton);
    setVisible(false);
    repaint();
  }

  /**
   * enter single op.
   * 
   * @param op
   */
  public void enterOp(final String op)
  {
    intermediateStepsOps.add(op);
  }

  /**
   * clears text.
   */
  public void clearText()
  {
    for (int i = 0; i < intermediateTextList.size(); i++)
    {
      intermediateTextList.get(i).setText("");
    }
  }

  /**
   * Done to set up dialog. Also sets up textArea/scrollPane
   */
  public void startUp()
  {
    setVisible(true);
    clearText();
    startUpAnimation(0, 0, intermediateSizeX, LENGTH_Y);
    // now set up text
    textArea = new JTextArea();
    // max size roughly
    // textArea.setMaximumSize(new Dimension(intermediateSizeX - BEHIND_OFFSET * 5, LENGTH_Y));
    scrollPane = new JScrollPane(textArea);
    textArea.setEditable(false);
    scrollPane.setVisible(true);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    centerPanel.add(scrollPane, BorderLayout.CENTER);
  }

  /**
   * Animates dialog on startup.
   * 
   * @param startSizeX starting size of window
   * @param startSizeY
   * @param endSizeX ending size of window
   * @param endSizeY
   */
  private void startUpAnimation(final int startSizeX, final int startSizeY, final int endSizeX,
      final int endSizeY)
  {

    double incX = (endSizeX - startSizeX + 0.0) / NUM_INCREMENTS;

    SwingWorker worker = new SwingWorker()
    {

      @Override
      protected Object doInBackground() throws Exception
      {
        for (int i = 0; i <= NUM_INCREMENTS; i++)
        {
          setSize((int) Math.round(incX * i + startSizeX), endSizeY);
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
    // TODO Auto-generated method stub

  }

  /**
   * Done to move current window with main window.
   */
  @Override
  public void componentMoved(final ComponentEvent e)
  {
    setLocation((int) e.getComponent().getLocation().getX() + displayX,
        (int) e.getComponent().getLocation().getY() + displayY / 4);
  }

  @Override
  public void componentShown(final ComponentEvent e)
  {
    this.repaint();
  }

  @Override 
  public void componentHidden(final ComponentEvent e)
  {
    // TODO Auto-generated method stub

  }

}
